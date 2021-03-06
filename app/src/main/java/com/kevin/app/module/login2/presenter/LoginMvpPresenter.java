package com.kevin.app.module.login2.presenter;

import android.content.Context;

import com.kevin.app.api.Api;
import com.kevin.app.api.ApiMethods;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.base.rxjava.BaseObserver;
import com.kevin.app.model.BaseResult;
import com.kevin.app.model.login.LoginModel;
import com.kevin.app.module.login2.contract.LoginMvpView;
import com.kevin.app.module.login2.model.User;
import com.kevin.app.module.login2.view.LoginMvpActivity;


/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class LoginMvpPresenter extends MvpBasePresenter<LoginMvpView> {

    private LoginMvpActivity loginActivity;
    private Api mApi;

    public LoginMvpPresenter(Context context, Api api) {
        loginActivity = (LoginMvpActivity) context;
        mApi = api;
    }

    public void login(User user) {
        LoginModel registerModel = new LoginModel();
        registerModel.setMobile(user.mobile);
        registerModel.setPassword(user.pwd);
        /** 1. 基础封装*/
//        mApi.register(registerModel).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseObserver<BaseResult>(loginActivity, new BaseObserver.OnObserverListener<BaseResult>() {
//            @Override
//            public void onNext(BaseResult data) {
//                if (data.getError_code() ==0) {
//                    loginActivity.showMsg("注册成功");
//                } else {
//                    loginActivity.showMsg(data.getError_msg());
//                }
//            }
//
//            @Override
//            public void onError(String msg) {
//                loginActivity.showMsg(msg);
//            }
//        }) {
//        });
        loginActivity.showLoading();
        /** 再次封装 */
        ApiMethods.login(new BaseObserver<BaseResult>(loginActivity, new BaseObserver.OnObserverListener<BaseResult>() {
            public void onNext(BaseResult data) {
                if (data.getError_code() == 0) {
                    loginActivity.showMsg("登录成功");
                } else {
                    loginActivity.showMsg(data.getError_msg());
                }
            }

            @Override
            public void onError(String msg) {
                loginActivity.showMsg(msg);
            }
        }) {
        },registerModel);
    }
}
