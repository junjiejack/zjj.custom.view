package com.kevin.app.base.presenter;

import com.kevin.app.base.view.MvpBaseView;

import java.lang.ref.WeakReference;

/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class MvpBasePresenter<V extends MvpBaseView> implements BasePresenter<V> {

    private WeakReference<V> weakReference;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
    }

    @Override
    public void detachView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
}
