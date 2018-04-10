package com.kevin.app.module.douban.view;

import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.kevin.app.R;
import com.kevin.app.api.Api;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.base.dagger.AppModule;
import com.kevin.app.base.retrofit.BaseRetrofit;
import com.kevin.app.module.douban.component.DaggerDoubanComponent;
import com.kevin.app.module.douban.contract.DouBanMvpView;
import com.kevin.app.module.douban.model.DouBanModel;
import com.kevin.app.module.douban.presenter.DouBanMvpPresenter;
import com.rambler.swipetoload.SwipeToLoadLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DouBanMvpActivity extends MvpBaseActivity<DouBanMvpView,DouBanMvpPresenter> implements DouBanMvpView {

    private DouBanMvpPresenter douBanMvpPresenter;

    @Inject
    Api mApi;

    @BindView(R.id.contentView)
    SwipeToLoadLayout swipeToLoadLayout;

    @Override
    protected DouBanMvpPresenter createPresenter() {
        douBanMvpPresenter = new DouBanMvpPresenter(this, BaseRetrofit.getApi());
        return douBanMvpPresenter;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_profit;
    }

    @Override
    protected void initView() {
        System.out.println("go here111");
        ButterKnife.bind(this);
        DaggerDoubanComponent.builder().appModule(new AppModule()).build().inject(this);
        System.out.println("api is null:"+mApi);

        presenter.get250();
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void showDataSuccessful(DouBanModel.SubjectsBean data) {
        System.out.println("go here222");
        dialog.dismiss();
        ToastUtils.showShort(data.getTitle());
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
