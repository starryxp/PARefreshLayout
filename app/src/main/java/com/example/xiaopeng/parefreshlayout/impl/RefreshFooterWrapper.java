package com.example.xiaopeng.parefreshlayout.impl;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaopeng.parefreshlayout.PARefreshLayout;
import com.example.xiaopeng.parefreshlayout.api.RefreshFooter;
import com.example.xiaopeng.parefreshlayout.api.RefreshKernel;
import com.example.xiaopeng.parefreshlayout.api.RefreshLayout;
import com.example.xiaopeng.parefreshlayout.constant.RefreshState;
import com.example.xiaopeng.parefreshlayout.constant.SpinnerStyle;


/**
 * 刷新底部包装
 * Created by xiaopeng on 2017/12/25.
 */

public class RefreshFooterWrapper implements RefreshFooter {

    private View mWrapperView;
    private SpinnerStyle mSpinnerStyle;

    public RefreshFooterWrapper(View wrapper) {
        this.mWrapperView = wrapper;
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public int onFinish(@NonNull RefreshLayout layout, boolean success) {
		return 0;
	}

    @Override
    @Deprecated
    public void setPrimaryColors(@ColorInt int ... colors) {

    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof PARefreshLayout.LayoutParams) {
            mSpinnerStyle = ((PARefreshLayout.LayoutParams) params).spinnerStyle;
            if (mSpinnerStyle != null) {
                return mSpinnerStyle;
            }
        }
        if (params != null) {
            if (params.height == 0) {
                return mSpinnerStyle = SpinnerStyle.Scale;
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof PARefreshLayout.LayoutParams) {
            kernel.requestDrawBackgoundForFooter(((PARefreshLayout.LayoutParams) params).backgroundColor);
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onLoadmoreReleased(RefreshLayout layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout layout, int footerHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }
}
