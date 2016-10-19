package com.yanzi.wechatgroupheadportrait;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.yanzi.wechatgroupheadportrait.model.MyBitmapEntity;
import com.yanzi.wechatgroupheadportrait.utils.BitmapUtil;
import com.yanzi.wechatgroupheadportrait.utils.PropertiesUtil;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainAty extends AppCompatActivity {

    private ImageView mImageView;
    private List<MyBitmapEntity> mEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        if (BuildConfig.DEBUG) {//debug打开，preview 也是打开的 debuggable 为true release 关闭
            //StrictMode 解析
            // http://blog.csdn.net/brokge/article/details/8543145
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
            Logger.init("yan")                                  // default PRETTYLOGGER or use just init()
                    .methodCount(2)                             // default 2
                    .logLevel(LogLevel.FULL)                    // default LogLevel.FULL
                    .methodOffset(0)                            // default 0
                    .logTool(new AndroidLogTool());             // custom log tool, optional
        }else{
            Logger.init("yan").logLevel(LogLevel.NONE);
        }
        mEntityList = getBitmapEntitys(7);

        mImageView = (ImageView) findViewById(R.id.imageView1);
        Bitmap[] mBitmaps = {
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.second), (int) mEntityList
                        .get(0).width, (int) mEntityList.get(0).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.second), (int) mEntityList
                        .get(0).width, (int) mEntityList.get(0).width),
//				ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
//						getResources(), R.drawable.second), (int) mEntityList
//						.get(0).width, (int) mEntityList.get(0).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.second), (int) mEntityList
                        .get(0).width, (int) mEntityList.get(0).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.meinv), (int) mEntityList
                        .get(1).width, (int) mEntityList.get(1).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.meinv), (int) mEntityList
                        .get(1).width, (int) mEntityList.get(1).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.meinv), (int) mEntityList
                        .get(1).width, (int) mEntityList.get(1).width),
                ThumbnailUtils.extractThumbnail(BitmapUtil.getScaleBitmap(
                        getResources(), R.drawable.fourth), (int) mEntityList
                        .get(2).width, (int) mEntityList.get(2).width)};
        Bitmap combineBitmap = BitmapUtil.getCombineBitmaps(mEntityList, mBitmaps);
        mImageView.setImageBitmap(combineBitmap);
        try {
            BitmapUtil.saveMyBitmap(this, combineBitmap, "flyfly");
        } catch (IOException e) {
            Logger.e("save png accur error");
            e.printStackTrace();
        }
    }


    private List<MyBitmapEntity> getBitmapEntitys(int count) {
        List<MyBitmapEntity> mList = new LinkedList<>();
        String value = PropertiesUtil.readData(this, String.valueOf(count),
                R.raw.data);
        Logger.d("value=>" + value);
        String[] arr1 = value.split(";");
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            String content = arr1[i];
            String[] arr2 = content.split(",");
            MyBitmapEntity entity = null;
            for (int j = 0; j < arr2.length; j++) {
                entity = new MyBitmapEntity();
                entity.x = Float.valueOf(arr2[0]);
                entity.y = Float.valueOf(arr2[1]);
                entity.width = Float.valueOf(arr2[2]);
                entity.height = Float.valueOf(arr2[3]);
            }
            mList.add(entity);
        }
        return mList;
    }
}
