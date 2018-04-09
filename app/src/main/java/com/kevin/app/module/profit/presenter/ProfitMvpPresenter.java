package com.kevin.app.module.profit.presenter;

import android.content.Context;

import com.kevin.app.api.ApiMethods;
import com.kevin.app.base.presenter.MvpBasePresenter;
import com.kevin.app.base.rxjava.BaseObserver;
import com.kevin.app.module.profit.contract.ProfitMvpView;
import com.kevin.app.module.profit.model.ProfitResultModel;
import com.kevin.app.module.profit.view.ProfitMvpActivity;

import java.util.HashMap;


/**
 * Created by zhoujunjie on 2018/3/17.
 */
public class ProfitMvpPresenter extends MvpBasePresenter<ProfitMvpView> {

    private ProfitMvpActivity profitActivity;

    public ProfitMvpPresenter(Context context) {
        profitActivity = (ProfitMvpActivity) context;
    }

    public void getProfit(HashMap<String,Integer> hashMap) {
        profitActivity.showLoading();
        /** 再次封装 */
        ApiMethods.getProfitData(new BaseObserver<ProfitResultModel>(profitActivity, new BaseObserver.OnObserverListener<ProfitResultModel>() {
            public void onNext(ProfitResultModel data) {
                if (data.getErr_code() == 0) {
                    profitActivity.showDataSuccessful(data.getRows());
                } else {
//                    profitActivity.showMsg(data.getErr_msg());
                }
            }

            @Override
            public void onError(String msg) {
                profitActivity.showMsg(msg);
            }
        }) {
        },hashMap);
    }
}
