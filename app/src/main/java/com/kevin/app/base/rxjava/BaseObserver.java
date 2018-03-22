package com.kevin.app.base.rxjava;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhoujunjie on 2018/3/22.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    public static final String TAG = "BaseObserver";

    protected Context context;

    protected OnObserverListener<T> listener;

    public BaseObserver(Context context,OnObserverListener<T> listener) {
        this.context = context;
        this.listener = listener;
    }

    public interface OnObserverListener<T> {
        void onNext(T data);

        void onError(String msg);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T data) {
        if (listener != null) {
            listener.onNext(data);
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,"onError:"+e.getMessage());
        if (listener != null) {
            listener.onError(e.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }

}
