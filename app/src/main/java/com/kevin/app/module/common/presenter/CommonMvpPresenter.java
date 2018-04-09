package com.kevin.app.module.common.presenter;

import android.content.Context;

import com.kevin.app.api.Api;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.module.common.contract.CommonMvpView;
import com.kevin.app.module.common.view.CommonMvpActivity;


/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class CommonMvpPresenter extends MvpBasePresenter<CommonMvpView> {

    private CommonMvpActivity commonMvpActivity;
    private Api mApi;

    public CommonMvpPresenter(Context context, Api api) {
        commonMvpActivity = (CommonMvpActivity) context;
        mApi = api;
    }

}
