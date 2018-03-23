package com.kevin.app.module.register.presenter;

import android.content.Context;

import com.kevin.app.api.ApiMethods;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.base.rxjava.BaseObserver;
import com.kevin.app.model.BaseResult;
import com.kevin.app.model.register.RegisterModel;
import com.kevin.app.module.register.contract.RegisterMvpView;
import com.kevin.app.module.register.model.User;
import com.kevin.app.module.register.view.RegisterMvpActivity;


/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class RegisterMvpPresenter extends MvpBasePresenter<RegisterMvpView> {

    private RegisterMvpActivity registerActivity;

    public RegisterMvpPresenter(Context context) {
        registerActivity = (RegisterMvpActivity) context;
    }

    public void login(User user) {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setMobile(user.mobile);
        registerModel.setPassword(user.pwd);
        registerModel.setEmail("123@qq.com");
        registerModel.setRealname("周俊杰");
        registerActivity.showLoading();
        /** 再次封装 */
        ApiMethods.register(new BaseObserver<BaseResult>(registerActivity, new BaseObserver.OnObserverListener<BaseResult>() {
            public void onNext(BaseResult data) {
                if (data.getError_code() == 0) {
                    registerActivity.showMsg("注册成功");
                } else {
                    registerActivity.showMsg(data.getError_msg());
                }
            }

            @Override
            public void onError(String msg) {
                registerActivity.showMsg(msg);
            }
        }) {
        },registerModel);
    }
}
