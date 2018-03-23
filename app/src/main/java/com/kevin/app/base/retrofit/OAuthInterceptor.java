package com.kevin.app.base.retrofit;

import com.blankj.utilcode.util.SPUtils;
import com.kevin.app.common.SPConstant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 添加token认证
 * Created by zhoujunjie on 2018/3/23.
 */
public class OAuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        /**获取token*/
        String bearToken = "Bearer " + SPUtils.getInstance().getString(SPConstant.SP_TOKEN);
        Request request = chain.request();


        return null;
    }
}
