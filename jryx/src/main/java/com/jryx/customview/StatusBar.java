package com.jryx.customview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jryx.lib.utils.ScreenUtils;


public class StatusBar extends View {

    public StatusBar(Context context) {
        super(context);
    }

    public StatusBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        if (Build.VERSION.SDK_INT >= 19)
            height = ScreenUtils.getStatusBarHeight();
        setMeasuredDimension(widthMeasureSpec, height);
    }
}
