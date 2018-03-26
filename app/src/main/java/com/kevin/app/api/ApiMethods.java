package com.kevin.app.api;


import com.kevin.app.base.retrofit.BaseRetrofit;
import com.kevin.app.model.BaseResult;
import com.kevin.app.model.register.RegisterModel;
import com.kevin.app.model.login.LoginModel;
import com.kevin.app.module.profit.model.ProfitResultModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhoujunjie on 2018/3/22.
 */
public class ApiMethods {

    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void register(Observer<BaseResult> observer, RegisterModel registerModel) {
        ApiSubscribe(BaseRetrofit.getApi().register(registerModel),observer);
    }

    public static void login(Observer<BaseResult> observer, LoginModel loginModel) {
        ApiSubscribe(BaseRetrofit.getApi().login(loginModel),observer);
    }

    public static void getProfitData(Observer<ProfitResultModel> observer, HashMap<String,Integer> hashMap) {
        ApiSubscribe(BaseRetrofit.getApi().getProfit(hashMap),observer);
    }
}
