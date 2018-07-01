package com.jryx.main;


import android.support.v4.app.Fragment;

import com.jryx.circle.CircleFragment;
import com.jryx.collection.CollectionFragment;
import com.jryx.home.HomeFragment;
import com.jryx.video.VideoFragment;

public enum MainTab {
    HOME("首页", HomeFragment.class),
    COLLECTION("征集", CollectionFragment.class),
    CIRCLE("征集", CircleFragment.class),
    VIDEO("征集", VideoFragment.class);

    private String name;
    private Class<? extends Fragment> fragmentClass;

    MainTab(String name, Class<? extends Fragment> fragmentClass) {
        this.name = name;
        this.fragmentClass = fragmentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }
}
