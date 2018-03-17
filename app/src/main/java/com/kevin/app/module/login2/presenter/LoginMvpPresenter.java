package com.kevin.app.module.login2.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.module.login2.contract.LoginMvpView;
import com.kevin.app.module.login2.model.User;
import com.kevin.app.module.login2.view.LoginMvpActivity;

/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class LoginMvpPresenter extends MvpBasePresenter<LoginMvpView> {

    private LoginMvpActivity loginActivity;

    public LoginMvpPresenter(Context context){
        loginActivity = (LoginMvpActivity) context;
    }

    public void login(User user) {
        if(TextUtils.isEmpty(user.name) || TextUtils.isEmpty(user.pwd)) {
            loginActivity.showMsg("用户名或者密码为空");
        } else {
            if ("hehe".equals(user.name) && "1234".equals(user.pwd)) {
                loginActivity.showMsg("登录成功");
            } else {
                loginActivity.showMsg("登录失败");
            }
        }
    }
}
