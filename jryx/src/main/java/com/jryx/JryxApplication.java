package com.jryx;

import android.support.multidex.MultiDexApplication;

import com.jryx.lib.utils.AppContextUtil;

public class JryxApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this);

    }
}
