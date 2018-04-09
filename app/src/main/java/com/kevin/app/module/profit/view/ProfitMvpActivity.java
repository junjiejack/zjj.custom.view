package com.kevin.app.module.profit.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kevin.app.R;
import com.kevin.app.base.activity.MvpBaseActivity;
import com.kevin.app.base.adapter.MyPremiumAdapter;
import com.kevin.app.module.profit.contract.ProfitMvpView;
import com.kevin.app.module.profit.model.ProfitResultModel;
import com.kevin.app.module.profit.presenter.ProfitMvpPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfitMvpActivity extends MvpBaseActivity<ProfitMvpView,ProfitMvpPresenter> implements ProfitMvpView {

        // 如何抉择  分析自己 分析当前形势
    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;

    private int rows = 10;

    private int page = 1;

    @Override
    protected ProfitMvpPresenter createPresenter() {
        return new ProfitMvpPresenter(this);
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
        System.out.println("presenter is null:"+presenter);
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
    public void showDataSuccessful(List<ProfitResultModel.RowsBean> data) {
        dialog.dismiss();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyPremiumAdapter(data,this));
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
