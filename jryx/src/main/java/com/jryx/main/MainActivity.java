package com.jryx.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.jryx.R;
import com.jryx.base.BaseActivity;
import com.jryx.lib.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements StatubarDarkService, ViewPager.OnPageChangeListener {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.activity_view)
    DrawerLayout drawerLayout;
    @BindView(R.id.cl_main_release)
    ConstraintLayout clMainRelease;
    @BindView(R.id.cl_main_home)
    ConstraintLayout clMainHome;
    @BindView(R.id.cl_main_collection)
    ConstraintLayout clMainCollection;
    @BindView(R.id.cl_main_circle)
    ConstraintLayout clMainCircle;
    @BindView(R.id.cl_main_video)
    ConstraintLayout clMainVideo;


    private boolean isStatubarDark;

    private List<ViewGroup> menuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    protected void initView() {
        menuList.add(clMainHome);
        menuList.add(clMainCollection);
        menuList.add(clMainCircle);
        menuList.add(clMainVideo);
        for (int i = 0; i < menuList.size(); i++) {
            int tag = i;
            menuList.get(i).setOnClickListener(v -> update(tag));
        }
        viewPager.setAdapter(new MainVPAdapter(getSupportFragmentManager()));
        update(0);
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(this);
        clMainRelease.setOnClickListener(this::publish);
    }

    private void update(int position) {
        viewPager.setCurrentItem(position);
        for (int i = 0; i < menuList.size(); i++) {
            if (i == position) {
                menuList.get(i).setSelected(true);
                for (int j = 0; j < menuList.get(i).getChildCount(); j++) {
                    tabAnimation(menuList.get(i).getChildAt(j));
                }
            } else {
                menuList.get(i).setSelected(false);
            }
        }

        if (position == 0) {
            if (isStatubarDark) {
                isStatubarDark = false;
                dark(false);
            }

        } else {
            if (!isStatubarDark) {
                isStatubarDark = true;
                dark(true);
            }
        }
    }

    private void publish(View view) {
        //TODO 发布
    }


    /******tab animation\*********/
    private Map<View, AnimationSet> animationMap = new HashMap<>();

    private void tabAnimation(View view) {
        AnimationSet animationSet = animationMap.get(view);
        if (animationSet == null) {
            animationSet = new AnimationSet(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(
                    0.8f, 1f, 0.8f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
            );
            scaleAnimation.setDuration(200);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1);
            alphaAnimation.setDuration(200);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationMap.put(view, animationSet);
        }
        view.startAnimation(animationSet);
    }

    @Override
    public boolean isStatusBarTextDackColor() {
        return false;
    }


    @Override
    public void dark(boolean isDark) {
        StatusBarUtil.darkMode(this, Color.TRANSPARENT, 0.2f, isDark);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        update(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
