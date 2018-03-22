package com.kevin.app.base.retrofit;

import com.kevin.app.api.Api;
import com.kevin.app.base.url.BaseSettings;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhoujunjie on 2018/3/21.
 */
public class BaseRetrofit {

    public static Api getApi() {
        // 创建拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        // 创建okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        // 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseSettings.baseHttpsUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(Api.class);
    }

}
