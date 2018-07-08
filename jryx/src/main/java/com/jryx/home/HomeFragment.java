package com.jryx.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jryx.R;
import com.jryx.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends LazyLoadFragment {


    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.titleBar)
    LinearLayout titleBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<String> titleList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initUi() {
        titleList.add("dd");
        titleList.add("dffff");
        HomeAdpter homeAdpter = new HomeAdpter(getChildFragmentManager(),titleList);
        viewPager.setAdapter(homeAdpter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void loadData() {

    }

}
