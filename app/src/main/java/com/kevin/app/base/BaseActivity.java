package com.kevin.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kevin.app.R;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by zhoujunjie on 2018/3/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected MaterialDialog dialog;
    protected ProgressBar progressBar;
    protected TextView tvLoadingText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        dialog = new MaterialDialog(this)
                .setContentView(R.layout.dialog_loading);
        initDialogView();
        initView();
    }

    private void initDialogView() {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_loading, null);
        progressBar = dialogView.findViewById(R.id.progressBar);
        tvLoadingText = dialogView.findViewById(R.id.tv_loading_text);
    }

    public abstract int getContentViewId();  // 获取布局id,设置布局

    protected abstract void initView();      // 初始化布局



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
