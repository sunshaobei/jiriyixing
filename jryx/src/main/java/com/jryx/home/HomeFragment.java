package com.jryx.home;


import android.support.v4.app.Fragment;

import com.jryx.R;
import com.jryx.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends LazyLoadFragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void loadData() {

    }

}
