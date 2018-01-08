package com.example.xiaopeng.parefreshlayout.listener;


import com.example.xiaopeng.parefreshlayout.api.RefreshLayout;
import com.example.xiaopeng.parefreshlayout.constant.RefreshState;

/**
 * 刷新状态改变监听器
 * Created by xiaopeng on 2017/12/25.
 */

public interface OnStateChangedListener {
    /**
     * 状态改变事件 {@link RefreshState}
     * @param refreshLayout RefreshLayout
     * @param oldState 改变之前的状态
     * @param newState 改变之后的状态
     */
    void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState);
}
