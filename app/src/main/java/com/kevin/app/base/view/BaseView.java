package com.kevin.app.base.view;

/**
 * mvp模式的baseview 主要是让activity去实现此接口,去展示界面
 * 基类接口 主要实现每个activity都要展示的界面
 * 这个接口为网络接口
 * 1. 每个界面都要去请求网络加载loading框
 * 2. 请求成功的数据
 * 3. 请求失败的数据
 * 4. 隐藏loading框(可以在请求成功或者失败添加,不是必须的)
 * Created by zhoujunjie on 2018/3/17.
 */
public interface BaseView {

    void showLoading();

    void showDataSuccessful(Object data);

    void showMsg(String msg);

    void hideLoading();
}
