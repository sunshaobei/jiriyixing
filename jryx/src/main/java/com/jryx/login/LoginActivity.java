package com.jryx.login;

import android.view.View;

import com.jryx.R;
import com.jryx.base.JryxActivity;

public class LoginActivity extends JryxActivity {
    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
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

    public void finish(View view) {
        onBackPressed();
    }
    public void register(View view) {
        onBackPressed();
    }
}
