package com.yanzi.wechatgroupheadportrait.model;

/**
 * Created by Administrator on 2016/10/18.
 */

public class MyBitmapEntity {

    public float x;
    public float y;
    public float width;
    public float height;
    public static int devide = 1;
    public int index = -1;

    @Override
    public String toString() {
        return "MyBitmap [x=" + x + ", y=" + y + ", width=" + width
                + ", height=" + height + ", devide=" + devide + ", index="
                + index + "]";
    }
}
