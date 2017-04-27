package com.stoldog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by RL on 2017/4/18.
 */
public class RepertorySerial {
    private Integer enterSerialNo;
    private Integer enterUserId;
    private String enterUserName;
    private Long enterTime;

    public Integer getEnterSerialNo() {
        return enterSerialNo;
    }

    public void setEnterSerialNo(Integer enterSerialNo) {
        this.enterSerialNo = enterSerialNo;
    }

    public Integer getEnterUserId() {
        return enterUserId;
    }

    public void setEnterUserId(Integer enterUserId) {
        this.enterUserId = enterUserId;
    }

    public String getEnterUserName() {
        return enterUserName;
    }

    public void setEnterUserName(String enterUserName) {
        this.enterUserName = enterUserName;
    }

    public Long getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Long enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return "RepertorySerial{" +
                "enterSerialNo=" + enterSerialNo +
                ", enterUserId=" + enterUserId +
                ", enterUserName='" + enterUserName + '\'' +
                ", enterTime=" + enterTime +
                '}';
    }
}
