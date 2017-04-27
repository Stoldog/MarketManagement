package com.stoldog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * Created by RL on 2017/4/14.
 */
public class Repertory {
    private Integer rid;
    private Integer productId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date productTime;
    private Integer effectTime;
    private Integer productSerialNo;
    private Integer enterSerialNo;
    private Integer productNum;
    private Date effectEndDate;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Integer getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Integer effectTime) {
        this.effectTime = effectTime;
    }

    public Integer getProductSerialNo() {
        return productSerialNo;
    }

    public void setProductSerialNo(Integer productSerialNo) {
        this.productSerialNo = productSerialNo;
    }

    public Integer getEnterSerialNo() {
        return enterSerialNo;
    }

    public void setEnterSerialNo(Integer enterSerialNo) {
        this.enterSerialNo = enterSerialNo;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }


    public Date getEffectEndDate() {
        return effectEndDate;
    }

    public void setEffectEndDate(Date effectEndDate) {
        this.effectEndDate = effectEndDate;
    }

    @Override
    public String toString() {
        return "Repertory{" +
                "rid=" + rid +
                ", productId=" + productId +
                ", productTime='" + productTime + '\'' +
                ", effectTime=" + effectTime +
                ", productSerialNo=" + productSerialNo +
                ", enterSerialNo=" + enterSerialNo +
                ", productNum=" + productNum +
                ", effectEndDate=" + effectEndDate +
                '}';
    }
}
