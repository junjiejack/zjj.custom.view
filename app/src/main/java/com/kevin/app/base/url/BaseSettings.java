package com.kevin.app.base.url;

import com.kevin.app.BuildConfig;

/**
 * Created by zhoujunjie on 2018/3/21.
 */
public class BaseSettings {
    public static final String BUILD_TYPE_PD = "pd";
    public static final String BUILD_TYPE_QA = "qa";
    public static final String BASE_RELEASE_URL = "https://www.jubao56.com";
    public static final String BASE_SHARE_URL = "http://www.jubao56.com";
    public static final String BASE_DEBUG_URL= "http://test.jubao56.com";

    public static String baseHttpsUrl = BASE_RELEASE_URL;
    public static String baseShareUrl = BASE_SHARE_URL;

    static {
        try {
            if (BUILD_TYPE_QA.equals(BuildConfig.FLAVOR)) {
                baseHttpsUrl = BASE_DEBUG_URL;
                baseShareUrl = BASE_DEBUG_URL;
            } else if (BUILD_TYPE_PD.equals(BuildConfig.FLAVOR)) {
                baseHttpsUrl = BASE_RELEASE_URL;
                baseShareUrl = BASE_SHARE_URL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
