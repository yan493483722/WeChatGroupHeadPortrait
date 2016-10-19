package com.yanzi.wechatgroupheadportrait.application;

import android.app.Application;
import android.os.StrictMode;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.yanzi.wechatgroupheadportrait.BuildConfig;

/**
 * Created by Administrator on 2016/10/19.
 */

public class YApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {//debug打开，preview 也是打开的 debuggable 为true release 关闭
            //StrictMode 解析
            // http://blog.csdn.net/brokge/article/details/8543145
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
            Logger.init("yan").logLevel(LogLevel.FULL).methodCount(3)
            ;
        } else {
            Logger.init("yan").logLevel(LogLevel.NONE);
        }
    }
}
