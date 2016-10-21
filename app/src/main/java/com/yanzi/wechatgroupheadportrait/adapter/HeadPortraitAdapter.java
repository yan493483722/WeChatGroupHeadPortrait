package com.yanzi.wechatgroupheadportrait.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanzi.wechatgroupheadportrait.R;
import com.yanzi.wechatgroupheadportrait.entity.GroupHeaderPortraitEntity;
import com.yanzi.wechatgroupheadportrait.utils.BitmapUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/19.
 */

public class HeadPortraitAdapter extends RecyclerView.Adapter<HeadPortraitAdapter.ViewHolder> {


    private List<GroupHeaderPortraitEntity> list;

    Context mContext;

    private LayoutInflater mLayoutInflater;

    public HeadPortraitAdapter(Context mContext, List<GroupHeaderPortraitEntity> list) {

        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.list = list;
    }

    public void notifyDataSetChanged(List<GroupHeaderPortraitEntity> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_group_portrait, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GroupHeaderPortraitEntity entity=   list.get(position);
        holder.itemGroupPortraitName.setText(entity.getName());
        holder.itemGroupPortraitDesc.setText(entity.getDesc());
        switch (position) {
            case 1:
//                BitmapUtil.getScreenWidthAndHeight();
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;

        }
    }

    @Override
    public int getItemCount() {
        return (list == null || list.isEmpty()) ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_group_portrait_image)
        ImageView itemGroupPortraitImage;
        @BindView(R.id.item_group_portrait_desc)
        TextView itemGroupPortraitDesc;
        @BindView(R.id.item_group_portrait_name)
        TextView itemGroupPortraitName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
