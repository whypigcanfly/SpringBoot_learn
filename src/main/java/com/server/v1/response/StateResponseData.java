package com.server.v1.response;

/**
 * Created by wanghaoyang on 17-3-21.
 */
public class StateResponseData {
    private int state;
    private String msg;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
