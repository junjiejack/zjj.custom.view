package com.kevin.app.module.login.presenter;

import android.text.TextUtils;

import com.kevin.app.module.login.contract.ILoginContract;
import com.kevin.app.module.login.model.User;
import com.kevin.app.module.login.view.LoginActivity;

/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class LoginPresenter implements ILoginContract.LoginPresenter {

    private LoginActivity loginActivity;

    @Override
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

    @Override
    public void attachView(LoginActivity view) {
        this.loginActivity = view;
    }

    @Override
    public void detachView() {
        if (loginActivity != null) {
            loginActivity = null;
        }
    }
}
