package com.kevin.app.module.douban.component;

import com.kevin.app.base.dagger.AppModule;
import com.kevin.app.module.douban.view.DouBanMvpActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoujunjie on 2018/4/9.
 */
@Singleton
@Component(modules = AppModule.class)
public interface DoubanComponent {

    void inject(DouBanMvpActivity activity);

}
