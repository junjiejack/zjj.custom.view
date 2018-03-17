package com.kevin.app.base.presenter;

import com.kevin.app.base.view.MvpBaseView;

import java.lang.ref.WeakReference;

/**
 * Created by zhoujunjie on 2018/3/17.
 * 泛型V代表不同的activity去要展示的界面
 */
public class MvpBasePresenter<V extends MvpBaseView> implements BasePresenter<V> {

    protected WeakReference<V> weakReference;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
    }

    public V getView() {        // weakReference.get() 可以获得继承的泛型
        return weakReference == null ? null : weakReference.get();
    }

    @Override
    public void detachView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
}
