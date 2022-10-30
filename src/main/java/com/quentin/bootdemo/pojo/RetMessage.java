package com.quentin.bootdemo.pojo;

import java.io.Serializable;

/**
 * @author:quentin
 * @create: 2022-10-16 21:00
 * @Description:
 */
public class RetMessage<T> {

    private String msg;
    private String status;
    private T data;

    public RetMessage() {
    }

    public RetMessage<T> defaultBuild() {
        this.msg = this.msg == null ? "empty message" : this.msg;
        this.status = this.status == null ? "ok" : this.status;
        return this;
    }

    public RetMessage<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public RetMessage<T> status(String status) {
        this.status = status;
        return this;
    }

    public RetMessage<T> data(T data) {
        this.data = data;
        return this;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RetMessage{" +
                "msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
