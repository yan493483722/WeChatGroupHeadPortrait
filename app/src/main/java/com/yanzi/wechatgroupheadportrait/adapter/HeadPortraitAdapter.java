package com.yanzi.wechatgroupheadportrait.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yanzi.wechatgroupheadportrait.entity.GroupHeaderPortraitEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */

public class HeadPortraitAdapter extends RecyclerView.Adapter<HeadPortraitAdapter.ViewHolder> {


    private List<GroupHeaderPortraitEntity> list;

    Context mContext;

    public HeadPortraitAdapter(Context mContext, List<GroupHeaderPortraitEntity> list) {

        this.mContext = mContext;
        this.list = list;
    }

    public void notifyDataSetChanged(List<GroupHeaderPortraitEntity> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
