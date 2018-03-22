package com.kevin.app.model;

import java.io.Serializable;

/**
 * Created by zhoujunjie on 2018/3/21.
 */
public class BaseListModel<T> implements Serializable {

    private int error_code;

    private String error_msg;

    private T rows;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public T getData() {
        return rows;
    }

    public void setData(T data) {
        this.rows = data;
    }
}
