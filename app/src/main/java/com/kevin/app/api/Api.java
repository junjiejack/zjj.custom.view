package com.kevin.app.api;

import com.kevin.app.model.BaseResult;
import com.kevin.app.model.register.RegisterModel;
import com.kevin.app.model.login.LoginModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by zhoujunjie on 2018/3/21.
 */
public interface Api {

    // 注册用户接口
    @POST("/v1/cmn/biz/channel/register")
    Observable<BaseResult> register(@Body RegisterModel registerModel);

    // 登录
    @POST("/v1/cmn/biz/channel/login")
    Observable<BaseResult> login(@Body LoginModel loginModel);

}
