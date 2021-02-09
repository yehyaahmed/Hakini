package com.yehyaayash99.hakini.URLClass;

public class UpdateData {

    private boolean status;
    private String msg;

    public UpdateData(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public UpdateData() {
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

}
