package com.quentin.bootdemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author quentin
 * @create 2022-10-19 18:07
 */
@Entity
public class MyMessage {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
