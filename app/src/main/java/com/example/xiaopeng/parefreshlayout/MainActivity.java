package com.example.xiaopeng.parefreshlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.xiaopeng.parefreshlayout.api.RefreshLayout;
import com.example.xiaopeng.parefreshlayout.listener.OnLoadmoreListener;
import com.example.xiaopeng.parefreshlayout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BaseQuickAdapter<String, BaseViewHolder> adapter;
    private List<String> list = new ArrayList<>();
    private PARefreshLayout parefreshlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parefreshlayout = (PARefreshLayout) findViewById(R.id.parefreshlayout);
        parefreshlayout.setEnableAutoLoadmore(false);//开启自动加载功能（非必须）

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_view, list) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.item_text, item + ":第" + helper.getPosition() + "条");
            }
        };

        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();


        parefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        for (int i = 0; i < 10; i++) {
                            list.add(i + "");
                        }
                        adapter.setNewData(list);
                        refreshlayout.finishRefresh();
                        refreshlayout.resetNoMoreData();
                    }
                }, 2000);
            }
        });
        parefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            list.add(i + "");
                        }
                        adapter.setNewData(list);
                        if (adapter.getItemCount() > 50) {
                            Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            refreshlayout.finishLoadmoreWithNoMoreData();//将不会再次触发加载更多事件
                        } else {
                            refreshlayout.finishLoadmore();
                        }
                    }

                }, 2000);
            }
        });

        //触发自动刷新
        parefreshlayout.autoRefresh();

    }
}
