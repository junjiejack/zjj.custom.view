package com.kevin.app.module.profit.view;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.module.profit.contract.ProfitMvpView;
import com.kevin.app.module.profit.presenter.ProfitMvpPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfitMvpActivity extends MvpBaseActivity<ProfitMvpView,ProfitMvpPresenter> implements ProfitMvpView {


    @BindView(R.id.recycler_view_premium)
    RecyclerView recyclerView;

    private int rows = 10;

    private int page = 1;

    @Override
    protected ProfitMvpPresenter createPresenter() {
        ProfitMvpPresenter profitPresenter = new ProfitMvpPresenter(this);
        return profitPresenter;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_profit;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("page",page);
        hashMap.put("rows",rows);
        presenter.getProfit(hashMap);
    }

    @Override
    protected void detachView() {
        if(presenter != null) {
            presenter.detachView();
        }
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
