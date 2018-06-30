package com.jryx.collection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jryx.R;
import com.jryx.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends LazyLoadFragment {


    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void loadData() {

    }

}
