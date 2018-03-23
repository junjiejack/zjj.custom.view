package com.kevin.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kevin.app.module.login1.view.LoginActivity;
import com.kevin.app.module.login2.view.LoginMvpActivity;
import com.kevin.app.module.register.view.RegisterMvpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login,R.id.btn_login_mvp,R.id.btn_register_mvp})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_login:
                intent.setClass(this, LoginActivity.class);
                break;
            case R.id.btn_login_mvp:
                intent.setClass(this, LoginMvpActivity.class);
                break;
            case R.id.btn_register_mvp:
                intent.setClass(this, RegisterMvpActivity.class);
                break;
        }
        startActivity(intent);
    }
}
