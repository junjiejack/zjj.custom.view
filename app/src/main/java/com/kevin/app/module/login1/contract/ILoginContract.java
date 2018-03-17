package com.kevin.app.module.login1.contract;

import com.kevin.app.base.presenter.BasePresenter;
import com.kevin.app.base.view.MvpBaseView;
import com.kevin.app.module.login1.model.User;
import com.kevin.app.module.login1.view.LoginActivity;

/**
 * 将我们需要的presenter和view联系起来
 * Created by zhoujunjie on 2018/3/17.
 */
public interface ILoginContract {

    interface LoginBaseView extends MvpBaseView {

    }

    interface LoginPresenter extends BasePresenter<LoginActivity> {

        void login(User user);
    }

}
