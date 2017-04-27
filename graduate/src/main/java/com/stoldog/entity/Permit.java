package com.stoldog.entity;

/**
 * Created by RL on 2017/4/19.
 */
public class Permit {
    private Integer pid;
    private String permitName;
    private Integer permitValue;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public Integer getPermitValue() {
        return permitValue;
    }

    public void setPermitValue(Integer permitValue) {
        this.permitValue = permitValue;
    }

    @Override
    public String toString() {
        return "Permit{" +
                "pid=" + pid +
                ", permitName='" + permitName + '\'' +
                ", permitValue=" + permitValue +
                '}';
    }
}
