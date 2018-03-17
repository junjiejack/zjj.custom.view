package com.kevin.app.base.presenter;

import com.kevin.app.base.view.MvpBaseView;

/**
 * presenter的基类;每个Presenter必须绑定view和解除绑定view(activity)
 * Created by zhoujunjie on 2018/3/17.
 */
public interface BasePresenter<V extends MvpBaseView> {

    void attachView(V view);    // 绑定activity

    void detachView();          // 解除绑定activity
}
