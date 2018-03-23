package com.kevin.app.module.register.view;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.module.register.contract.RegisterMvpView;
import com.kevin.app.module.register.model.User;
import com.kevin.app.module.register.presenter.RegisterMvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterMvpActivity extends MvpBaseActivity<RegisterMvpView,RegisterMvpPresenter> implements RegisterMvpView {

    private RegisterMvpPresenter registerPresenter;

    @BindView(R.id.et_user_name)
    EditText etUserName;

    @BindView(R.id.et_user_pwd)
    EditText etUserPwd;

    @Override
    protected RegisterMvpPresenter createPresenter() {
        registerPresenter = new RegisterMvpPresenter(this);
        return registerPresenter;
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
        if(registerPresenter != null) {
            registerPresenter.detachView();
        }
    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        User user = new User();
        user.mobile = etUserName.getText().toString();
        user.pwd = etUserPwd.getText().toString();
        registerPresenter.login(user);
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
