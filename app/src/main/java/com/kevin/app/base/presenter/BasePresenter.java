package com.kevin.app.base.presenter;

/**
 * presenter的基类;每个Presenter必须绑定view和解除绑定view(activity)
 * Created by zhoujunjie on 2018/3/17.
 */
public interface BasePresenter<T> {

    void attachView(T view);    // 绑定activity

    void detachView();          // 解除绑定activity
}
