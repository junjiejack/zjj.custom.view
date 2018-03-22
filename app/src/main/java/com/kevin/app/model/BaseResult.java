package com.kevin.app.model;

import java.io.Serializable;

/**
 * Created by zhoujunjie on 2018/3/21.
 */
public class BaseResult<T> implements Serializable {

    private int err_code;

    private String err_msg;

    private T data;

    public int getError_code() {
        return err_code;
    }

    public void setError_code(int error_code) {
        this.err_code = error_code;
    }

    public String getError_msg() {
        return err_msg;
    }

    public void setError_msg(String error_msg) {
        this.err_msg = error_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
