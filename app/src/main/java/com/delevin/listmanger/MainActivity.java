package com.delevin.listmanger;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delevin.listmanger.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_recuclerView)
    RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    List<String> datas = new ArrayList<>();
    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }
    @Override
    protected void init() {
        initRecyclerView();
    }

    @Override
    protected void initData() {
        datas.add("自定义滑动尺度");
        mainAdapter.setDatas(datas);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mainAdapter);
    }

}
