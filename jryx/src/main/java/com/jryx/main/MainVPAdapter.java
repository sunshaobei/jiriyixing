package com.jryx.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainVPAdapter extends FragmentPagerAdapter {

    private MainTab[] mainTabs = MainTab.values();


    public MainVPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Class<? extends Fragment> fragmentClass = mainTabs[position].getFragmentClass();
        try {
            return fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new Fragment();
    }

    @Override
    public int getCount() {
        return mainTabs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mainTabs[position].getName();
    }
}
