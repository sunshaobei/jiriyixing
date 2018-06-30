package com.jryx.main;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jryx.R;
import com.jryx.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
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
    @BindView(R.id.cl_main_bottom)
    ConstraintLayout clMainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {

    }

    @Override
    public boolean isStatusBarTextDackColor() {
        return false;
    }


}
