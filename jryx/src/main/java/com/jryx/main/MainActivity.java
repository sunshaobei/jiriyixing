package com.jryx.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jryx.R;
import com.jryx.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.nav)
    NavigationView navigationView;
    @BindView(R.id.activity_view)
    DrawerLayout drawerLayout;
    @BindView(R.id.titleBar)
    LinearLayout titleBar;
    @BindView(R.id.img_main_release)
    ImageView imgMainRelease;
    @BindView(R.id.cl_main_release)
    ConstraintLayout clMainRelease;
    @BindView(R.id.img_main_home)
    ImageView imgMainHome;
    @BindView(R.id.tv_main_home)
    TextView tvMainHome;
    @BindView(R.id.cl_main_home)
    ConstraintLayout clMainHome;
    @BindView(R.id.img_main_collection)
    ImageView imgMainCollection;
    @BindView(R.id.tv_main_collection)
    TextView tvMainCollection;
    @BindView(R.id.cl_main_collection)
    ConstraintLayout clMainCollection;
    @BindView(R.id.img_main_circle)
    ImageView imgMainCircle;
    @BindView(R.id.tv_main_circle)
    TextView tvMainCircle;
    @BindView(R.id.cl_main_circle)
    ConstraintLayout clMainCircle;
    @BindView(R.id.img_main_video)
    ImageView imgMainVideo;
    @BindView(R.id.tv_main_video)
    TextView tvMainVideo;
    @BindView(R.id.cl_main_video)
    ConstraintLayout clMainVideo;

    private List<TextView> tvList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        View headerView = navigationView.getHeaderView(0);//获取头布局
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //item.setChecked(true);
                //TODO

                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
        initBottom();
    }

    private void initBottom() {
        tvList.add(tvMainHome);
        tvList.add(tvMainCollection);
        tvList.add(tvMainCircle);
        tvList.add(tvMainVideo);
        initTab(0);
    }

    private void updateIc(int pos) {
    }

    private void updateTextColor(int pos) {

        for (TextView tv : tvList) {
            tv.setTextColor(getResources().getColor(R.color.text_color_gray));
        }
        tvList.get(pos).setTextColor(getResources().getColor(R.color.mainColor));
    }

    @OnClick({R.id.cl_main_home,R.id.cl_main_collection,R.id.cl_main_release,R.id.cl_main_circle,R.id.cl_main_video})
    public void clickBottom(View view) {
        switch (view.getId()) {
            case R.id.cl_main_home:
                initTab(0);
                break;
            case R.id.cl_main_collection:
                initTab(1);
                break;
            case R.id.cl_main_release:
                break;
            case R.id.cl_main_circle:
                initTab(2);
                break;
            case R.id.cl_main_video:
                initTab(3);
                break;
            default:
                break;
        }
    }

    private void initTab(int pos) {
        updateIc(pos);
        updateTextColor(pos);
    }

    @Override
    public boolean isStatusBarTextDackColor() {
        return false;
    }


}
