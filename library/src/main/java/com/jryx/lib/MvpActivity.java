package com.jryx.lib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jryx.lib.mvp.BaseModel;
import com.jryx.lib.mvp.BasePresenter;
import com.jryx.lib.mvp.BaseView;
import com.jryx.lib.mvp.TUtil;

/**
 * Activity基类
 * Created by sunsh on 2018/5/29.
 */
public abstract class MvpActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayoutID());
        initIntentData(getIntent());
        initListener();
    }

    protected void init() {
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) mPresenter.setVM(this, mModel);
    }

    protected void initIntentData(Intent intent) {

    }

    public abstract int getLayoutID();


    protected abstract void initListener();


}
