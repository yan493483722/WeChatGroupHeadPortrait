package com.yanzi.wechatgroupheadportrait.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */

public class GroupHeaderPortraitEntity {

    String name;

    String desc;

    List<String> portraitUrls;

    List<Integer> localPortraitUrls;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getPortraitUrls() {
        return portraitUrls;
    }

    public void setPortraitUrls(List<String> portraitUrls) {
        this.portraitUrls = portraitUrls;
    }


    public List<Integer> getLocalPortraitUrls() {
        return localPortraitUrls;
    }

    public void setLocalPortraitUrls(List<Integer> localPortraitUrls) {
        this.localPortraitUrls = localPortraitUrls;
    }
}
