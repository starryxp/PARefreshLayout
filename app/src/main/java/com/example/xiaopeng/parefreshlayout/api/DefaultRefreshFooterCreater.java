package com.example.xiaopeng.parefreshlayout.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认Footer创建器
 * Created by xiaopeng on 2017/12/25.
 */

public interface DefaultRefreshFooterCreater {
    @NonNull
    RefreshFooter createRefreshFooter(Context context, RefreshLayout layout);
}
