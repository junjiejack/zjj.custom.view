package com.kevin.app.base.dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kevin.app.api.Api;
import com.kevin.app.base.retrofit.BaseRetrofit;
import com.kevin.app.base.retrofit.OAuthInterceptor;
import com.kevin.app.base.url.BaseSettings;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhoujunjie on 2018/3/28.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public Api provideApi() {
        // 创建拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 创建okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new OAuthInterceptor())
                .build();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();

        // 创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseSettings.baseHttpsUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit.create(Api.class);
    }

    @Singleton
    @Provides
    public BaseRetrofit provideRetrofit() {
        return new BaseRetrofit();
    }
}
