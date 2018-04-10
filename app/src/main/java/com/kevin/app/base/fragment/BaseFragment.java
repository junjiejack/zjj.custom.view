package com.kevin.app.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kevin.app.R;
import com.kevin.app.base.view.MvpBaseView;

import me.drakeet.materialdialog.MaterialDialog;


public abstract class BaseFragment extends Fragment implements MvpBaseView {

    protected MaterialDialog mDialog;
    protected ProgressBar progressBar;
    protected TextView tvLoadingText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layoutRes = getLayoutRes();
        if (layoutRes == 0) {
            throw new IllegalArgumentException(
                    "getLayoutRes() returned 0, which is not allowed. "
                            + "If you don't want to use getLayoutRes() but implement your own view for this "
                            + "fragment manually, then you have to override onCreateView();");
        } else {
            View v = inflater.inflate(layoutRes, container, false);
            return v;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDialog = new MaterialDialog(getActivity())
                .setContentView(R.layout.dialog_loading);
        initDialogView();
    }

    private void initDialogView() {
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_loading, null);
        progressBar = dialogView.findViewById(R.id.progressBar);
        tvLoadingText = dialogView.findViewById(R.id.tv_loading_text);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    protected int getLayoutRes() {
        return 0;
    }

}
