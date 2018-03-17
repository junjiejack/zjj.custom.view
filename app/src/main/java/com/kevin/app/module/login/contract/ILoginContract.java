package com.kevin.app.module.login.contract;

import com.kevin.app.base.presenter.BasePresenter;
import com.kevin.app.base.view.BaseNetView;
import com.kevin.app.module.login.model.User;
import com.kevin.app.module.login.view.LoginActivity;

/**
 * 将我们需要的presenter和view联系起来
 * Created by zhoujunjie on 2018/3/17.
 */
public interface ILoginContract {

    interface LoginView extends BaseNetView{

    }

    interface LoginPresenter extends BasePresenter<LoginActivity> {

        void login(User user);
    }

}
