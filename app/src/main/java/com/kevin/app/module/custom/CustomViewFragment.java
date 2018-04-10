package com.kevin.app.module.custom;

import com.kevin.app.R;
import com.kevin.app.base.fragment.BaseFragment;

/**
 * Created by zhoujunjie on 2018/4/9.
 */
public class CustomViewFragment extends BaseFragment {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_custom_view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showDataSuccessful(Object data) {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
