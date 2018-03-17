package com.kevin.app.module.login.view;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.BaseActivity;
import com.kevin.app.module.login.contract.ILoginContract;
import com.kevin.app.module.login.model.User;
import com.kevin.app.module.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginContract.LoginView {

    private LoginPresenter loginPresenter;

    @BindView(R.id.et_user_name)
    EditText etUserName;

    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;

    @Override
    protected void attachView() {
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);    // presenter绑定activity
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void detachView() {
        if(loginPresenter != null) {
            loginPresenter.detachView();
        }
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        User user = new User();
        user.name = etUserName.getText().toString();
        user.pwd = etUserPwd.getText().toString();
        loginPresenter.login(user);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showDataSuccessful(Object data) {

    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }
}
