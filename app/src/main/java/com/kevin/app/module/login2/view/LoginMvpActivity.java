package com.kevin.app.module.login2.view;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.base.retrofit.BaseRetrofit;
import com.kevin.app.module.login2.contract.LoginMvpView;
import com.kevin.app.module.login2.model.User;
import com.kevin.app.module.login2.presenter.LoginMvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginMvpActivity extends MvpBaseActivity<LoginMvpView,LoginMvpPresenter> implements LoginMvpView {

    private LoginMvpPresenter loginPresenter;

    @BindView(R.id.et_user_name)
    EditText etUserName;

    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;

    @Override
    protected LoginMvpPresenter createPresenter() {
        loginPresenter = new LoginMvpPresenter(this, BaseRetrofit.getApi());
        return loginPresenter;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        User user = new User();
        user.mobile = etUserName.getText().toString();
        user.pwd = etUserPwd.getText().toString();
        loginPresenter.login(user);
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void showDataSuccessful(Object data) {
        dialog.dismiss();
    }

    @Override
    public void showMsg(String msg) {
        dialog.dismiss();
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }
}
