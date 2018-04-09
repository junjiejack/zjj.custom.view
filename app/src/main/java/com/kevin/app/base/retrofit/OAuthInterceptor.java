package com.kevin.app.base.retrofit;

import com.blankj.utilcode.util.SPUtils;

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
        SPUtils.getInstance().put("token","10321|Yvm1k0LW1eq3iAcvZQtfCm+JHRD7Y5kNAkqTkKtuzQf0AgSWt+/JMGbUPpHvIFWZX+6HYgXxAkPgDS5sOpvlbg==");
        String basic = "Bearer " + SPUtils.getInstance()
                .getString("token", "");

        Request originalRequest = chain.request();
        String cacheControl = originalRequest.cacheControl().toString();

        Request.Builder requestBuilder = originalRequest.newBuilder()
                //Basic Authentication,也可用于token验证,OAuth验证
                .header("Authorization", basic)
                .header("Accept", "application/json")
                .header("Charset", "UTF-8")
                .header("Accept-Encoding", "gzip,deflate")
                .method(originalRequest.method(), originalRequest.body());

        Request request = requestBuilder.build();

        Response originalResponse = chain.proceed(request);
        Response.Builder responseBuilder =
                //Cache control设置缓存
                originalResponse.newBuilder().header("Cache-Control", cacheControl);
        return responseBuilder.build();
    }
}
