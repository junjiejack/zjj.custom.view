package com.kevin.app.module.douban.presenter;

import android.content.Context;

import com.kevin.app.api.Api;
import com.kevin.app.api.ApiMethods;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.base.rxjava.BaseObserver;
import com.kevin.app.module.douban.contract.DouBanMvpView;
import com.kevin.app.module.douban.model.DouBanModel;
import com.kevin.app.module.douban.view.DouBanMvpActivity;


/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class DouBanMvpPresenter extends MvpBasePresenter<DouBanMvpView> {

    private DouBanMvpActivity douBanMvpActivity;
    private Api mApi;

    public DouBanMvpPresenter(Context context, Api api) {
        douBanMvpActivity = (DouBanMvpActivity) context;
        mApi = api;
    }

    public void get250() {
        douBanMvpActivity.showLoading();
        ApiMethods.get250(new BaseObserver<DouBanModel.SubjectsBean>(douBanMvpActivity, new BaseObserver.OnObserverListener<DouBanModel.SubjectsBean>() {
            @Override
            public void onNext(DouBanModel.SubjectsBean data) {
                douBanMvpActivity.showDataSuccessful(data);
            }

            @Override
            public void onError(String msg) {
                douBanMvpActivity.showMsg(msg);
            }
        }) {

        });
    }

}
