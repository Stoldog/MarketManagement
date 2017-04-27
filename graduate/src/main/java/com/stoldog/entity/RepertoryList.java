package com.stoldog.entity;

import java.sql.Date;

/**
 * Created by RL on 2017/4/25.
 */
public class RepertoryList {
    private Integer productId;
    private String productName;
    private Integer productSerialNo;
    private Double enterSerialNo;
    private Double marketPrice;
    private Integer productType;
    private Integer effectTime;
    private Date productTime;
    private Integer productNum;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductSerialNo() {
        return productSerialNo;
    }

    public void setProductSerialNo(Integer productSerialNo) {
        this.productSerialNo = productSerialNo;
    }

    public Double getEnterSerialNo() {
        return enterSerialNo;
    }

    public void setEnterSerialNo(Double enterSerialNo) {
        this.enterSerialNo = enterSerialNo;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Integer effectTime) {
        this.effectTime = effectTime;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    @Override
    public String toString() {
        return "RepertoryList{" +
                "productName='" + productName + '\'' +
                ", productSerialNo=" + productSerialNo +
                ", enterSerialNo=" + enterSerialNo +
                ", marketPrice=" + marketPrice +
                ", productType=" + productType +
                ", effectTime=" + effectTime +
                ", productTime=" + productTime +
                ", productNum=" + productNum +
                '}';
    }
}
