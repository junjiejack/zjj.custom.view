package com.kevin.app.module.common.view;

import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.base.retrofit.BaseRetrofit;
import com.kevin.app.module.common.contract.CommonMvpView;
import com.kevin.app.module.common.presenter.CommonMvpPresenter;

import butterknife.ButterKnife;

public class CommonMvpActivity extends MvpBaseActivity<CommonMvpView,CommonMvpPresenter> implements CommonMvpView {

    private CommonMvpPresenter commonMvpPresenter;

    @Override
    protected CommonMvpPresenter createPresenter() {
        commonMvpPresenter = new CommonMvpPresenter(this, BaseRetrofit.getApi());
        return commonMvpPresenter;
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
