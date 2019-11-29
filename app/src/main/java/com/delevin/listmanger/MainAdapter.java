package com.delevin.listmanger;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private List<String> datas;
    private Context cxt;
    private OnItemOnClickListener onItemOnClickListener;
    public MainAdapter(Context cxt) {
        this.cxt = cxt;
    }

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainHolder(LayoutInflater.from(cxt).inflate(R.layout.item_main,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHoLder, int i) {
        mainHoLder.bindData(datas.get(i),i);
    }

    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }

    class MainHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_main_tv_title)
        TextView tvTitle;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(String str,final int pos){
            tvTitle.setText(str);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemOnClickListener.Onclick(pos);
                }
            });
        }
    }
    interface OnItemOnClickListener{
        void Onclick(int pos);
    }
    public void setOnItemOnClickListener(OnItemOnClickListener onItemOnClickListener){
        this.onItemOnClickListener = onItemOnClickListener;
    }
}
