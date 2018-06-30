package com.jryx.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class LazyLoadFragment extends BaseFragment {

    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;

    //是否首次加载
    private boolean isFirstLoad = true;

    private View rootView;
    private Unbinder bind;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), null);
            bind = ButterKnife.bind(this.rootView);
            isViewCreated = true;
            lazyLoad();
        }
        return rootView;
    }



    protected View getRootView(){
        return rootView;
    }

    /**
     * setUserVisibleHint(boolean isVisibleToUser) 在Fragment OnCreateView()方法之前调用的
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        if (isViewCreated && isUIVisible && isFirstLoad) {
            isFirstLoad = false;
            initUi();
            loadData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    protected abstract int getLayoutId();

    protected abstract void initUi();

    protected abstract void loadData();
}
