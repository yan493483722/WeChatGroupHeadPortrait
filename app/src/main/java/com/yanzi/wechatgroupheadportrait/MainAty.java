package com.yanzi.wechatgroupheadportrait;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.yanzi.wechatgroupheadportrait.adapter.HeadPortraitAdapter;
import com.yanzi.wechatgroupheadportrait.entity.GroupHeaderPortraitEntity;
import com.yanzi.wechatgroupheadportrait.utils.RecyclerListDiv;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAty extends AppCompatActivity {


    @BindView(R.id.main_tv)
    TextView mainTv;
    @BindView(R.id.main_recycler_view)
    RecyclerView mainRecyclerView;

    private HeadPortraitAdapter headPortraitAdapter;

    private List<GroupHeaderPortraitEntity> groupHeaderPortraitEntityList;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        ButterKnife.bind(this);
        mContext = this;
        initComponents();
        initData();
        headPortraitAdapter.notifyDataSetChanged(groupHeaderPortraitEntityList);

//        mEntityList = getBitmapEntitys(7);

//        mImageView = (ImageView) findViewById(R.id.imageView1);
//        Bitmap[] mBitmaps = {
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.second), (int) mEntityList
//                        .get(0).width, (int) mEntityList.get(0).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.second), (int) mEntityList
//                        .get(0).width, (int) mEntityList.get(0).width),
////				ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
////						getResources(), R.drawable.second), (int) mEntityList
////						.get(0).width, (int) mEntityList.get(0).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.second), (int) mEntityList
//                        .get(0).width, (int) mEntityList.get(0).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.meinv), (int) mEntityList
//                        .get(1).width, (int) mEntityList.get(1).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.meinv), (int) mEntityList
//                        .get(1).width, (int) mEntityList.get(1).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.meinv), (int) mEntityList
//                        .get(1).width, (int) mEntityList.get(1).width),
//                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//                        getResources(), R.drawable.fourth), (int) mEntityList
//                        .get(2).width, (int) mEntityList.get(2).width)};
//        Bitmap combineBitmap = BitmapUtil.getCombineBitmaps(mEntityList, mBitmaps);
//        mImageView.setImageBitmap(combineBitmap);
//        try {
//            BitmapUtil.saveMyBitmap(this, combineBitmap, "flyfly");
//        } catch (IOException e) {
//            Logger.e("save png accur error");
//            e.printStackTrace();
//        }
    }

    /**
     * 初始化数据
     */
    private void initData() {
        if (groupHeaderPortraitEntityList == null) {
            groupHeaderPortraitEntityList = new ArrayList<>();
        }
        for (int i = 0; i < 9; i++) {

            GroupHeaderPortraitEntity entity = new GroupHeaderPortraitEntity();

            List<Integer> entityList = new ArrayList<>();
            entityList.add(R.drawable.a);

            switch (i) {
                case 0:
                    entity.setName("one chat ");
                    entity.setDesc("one by one chat ");
                    break;
                case 1:
                    entity.setName("two chat ");
                    entity.setDesc("two chat content");
                    entityList.add(R.drawable.b);
                    break;
                case 2:
                    entity.setName("three chat ");
                    entity.setDesc("three chat content");
                    entityList.add(R.drawable.c);
                    break;
                case 3:
                    entity.setName("four chat ");
                    entity.setDesc("four chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    break;
                case 4:
                    entity.setName("five chat ");
                    entity.setDesc("five chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    entityList.add(R.drawable.f);
                    break;
                case 5:
                    entity.setName("six chat ");
                    entity.setDesc("six chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    entityList.add(R.drawable.f);
                    entityList.add(R.drawable.g);
                    break;
                case 6:
                    entity.setName("seven chat ");
                    entity.setDesc("seven chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    entityList.add(R.drawable.f);
                    entityList.add(R.drawable.g);
                    entityList.add(R.drawable.h);
                    break;
                case 7:
                    entity.setName("eight chat ");
                    entity.setDesc("eight chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    entityList.add(R.drawable.f);
                    entityList.add(R.drawable.g);
                    entityList.add(R.drawable.h);
                    entityList.add(R.drawable.i);
                    break;
                case 8:
                    entity.setName("nine chat ");
                    entity.setDesc("nine chat content");
                    entityList.add(R.drawable.c);
                    entityList.add(R.drawable.e);
                    entityList.add(R.drawable.f);
                    entityList.add(R.drawable.g);
                    entityList.add(R.drawable.h);
                    entityList.add(R.drawable.i);
                    entityList.add(R.drawable.j);
                    break;

            }

            entity.setLocalPortraitUrls(entityList);
            groupHeaderPortraitEntityList.add(entity);
        }
    }


    /**
     * 实例化组件
     */
    private void initComponents() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecyclerView.setLayoutManager(linearLayoutManager);
        groupHeaderPortraitEntityList = new ArrayList<>();
        headPortraitAdapter = new HeadPortraitAdapter(this, groupHeaderPortraitEntityList);
        mainRecyclerView.setAdapter(headPortraitAdapter);

        RecyclerListDiv dividerItemDecoration = new RecyclerListDiv(mContext,
                RecyclerListDiv.HORIZONTAL);
        mainRecyclerView.addItemDecoration(dividerItemDecoration);
    }


//    private List<MyBitmapEntity> getBitmapEntitys(int count) {
//        List<MyBitmapEntity> mList = new LinkedList<>();
//        String value = PropertiesUtil.readData(this, String.valueOf(count),
//                R.raw.data);
//        Logger.d("value=>" + value);
//        String[] arr1 = value.split(";");
//        int length = arr1.length;
//        for (int i = 0; i < length; i++) {
//            String content = arr1[i];
//            String[] arr2 = content.split(",");
//            MyBitmapEntity entity = null;
//            for (int j = 0; j < arr2.length; j++) {
//                entity = new MyBitmapEntity();
//                entity.x = Float.valueOf(arr2[0]);
//                entity.y = Float.valueOf(arr2[1]);
//                entity.width = Float.valueOf(arr2[2]);
//                entity.height = Float.valueOf(arr2[3]);
//            }
//            mList.add(entity);
//        }
//        return mList;
//    }
}
