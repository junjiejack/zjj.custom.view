package com.kevin.app;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by zhoujunjie on 2018/3/23.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
