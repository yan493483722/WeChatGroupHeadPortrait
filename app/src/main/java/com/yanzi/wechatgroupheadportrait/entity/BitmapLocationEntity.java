package com.yanzi.wechatgroupheadportrait.entity;

/**
 * Created by Administrator on 2016/10/20.
 */
public class BitmapLocationEntity {

    //起始X点
    private int locationX;
    //起始Y点
    private int locationY;
    //图片宽
    private int width;
    //图片高
    private int height;
    //图标下标
    private int index;

    //GroupHeaderPortraitEntity
    private GroupHeaderPortraitEntity groupHeaderPortraitEntity;


    public BitmapLocationEntity(int locationX, int locationY, int width, int height, int index, GroupHeaderPortraitEntity groupHeaderPortraitEntity) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
        this.index = index;
        this.groupHeaderPortraitEntity = groupHeaderPortraitEntity;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GroupHeaderPortraitEntity getGroupHeaderPortraitEntity() {
        return groupHeaderPortraitEntity;
    }

    public void setGroupHeaderPortraitEntity(GroupHeaderPortraitEntity groupHeaderPortraitEntity) {
        this.groupHeaderPortraitEntity = groupHeaderPortraitEntity;
    }
}
