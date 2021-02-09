package com.yehyaayash99.hakini.Items;

public class LoginResponse {

    private boolean status;
    private String msg;
    private DataLogin data;

    public LoginResponse(boolean status, String msg, DataLogin data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LoginResponse() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin dataLogin) {
        this.data = dataLogin;
    }
}
