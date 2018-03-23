package com.kevin.app.model.login;

/**
 * Created by zhoujunjie on 2018/3/23.
 */
public class LoginModel {


    /**
     * mobile : 17683887003
     * sms_code : 220652
     * password:123122
     */

    private String mobile;
    private String sms_code;
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSms_code() {
        return sms_code;
    }

    public void setSms_code(String sms_code) {
        this.sms_code = sms_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
