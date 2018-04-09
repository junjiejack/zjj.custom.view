package com.kevin.app.base.dagger;

import com.kevin.app.module.register.view.RegisterMvpActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhoujunjie on 2018/3/28.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(RegisterMvpActivity activity);

}
