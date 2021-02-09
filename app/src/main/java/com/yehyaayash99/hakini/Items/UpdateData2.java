package com.yehyaayash99.hakini.Items;

public class UpdateData2 {

    private boolean status;
    private String message;

    public UpdateData2(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public UpdateData2() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
