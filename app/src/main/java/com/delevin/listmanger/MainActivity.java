package com.delevin.listmanger;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delevin.listmanger.base.BaseActivity;
import com.delevin.listmanger.rxjava.coustom.DialActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainAdapter.OnItemOnClickListener{


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
        mainAdapter.setOnItemOnClickListener(this);
        recyclerView.setAdapter(mainAdapter);
    }
    @Override
    public void Onclick(int pos) {
        switch (pos) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, DialActivity.class));
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    default:
                    break;
                }
    }
}
