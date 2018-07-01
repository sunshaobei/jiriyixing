package com.jryx.customview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.jryx.lib.utils.ScreenUtils;


public class StatusBar extends View {

    public StatusBar(Context context) {
        super(context);
    }

    public StatusBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        if (Build.VERSION.SDK_INT >= 19)
            layoutParams.height = ScreenUtils.getStatusBarHeight();
        else layoutParams.height = 0;
        setLayoutParams(layoutParams);
    }
}
