package com.jryx.base;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class JryxBarActivity extends BaseBarActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        bind = ButterKnife.bind(this);
        initIntentData(getIntent());
        initView();
        initListener();
        initData();
    }

    protected void initIntentData(Intent intent) {
    }

    public abstract int getLayoutID();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
