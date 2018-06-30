package com.jryx;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.jryx.base.JryxActivity;

import butterknife.BindView;

public class MainActivity extends JryxActivity {


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
