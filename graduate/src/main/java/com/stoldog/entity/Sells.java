package com.stoldog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by RL on 2017/4/14.
 */
public class Sells {
    private Integer sid;
    private Integer productSerialNo;
    private Integer productId;
    private Double productMarketPrice;
    private Integer sellManId;
    private Integer sellNum;
    private Double productTotalPrice;
    private String sellSerial;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getProductSerialNo() {
        return productSerialNo;
    }

    public void setProductSerialNo(Integer productSerialNo) {
        this.productSerialNo = productSerialNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getProductMarketPrice() {
        return productMarketPrice;
    }

    public void setProductMarketPrice(Double productMarketPrice) {
        this.productMarketPrice = productMarketPrice;
    }

    public Integer getSellManId() {
        return sellManId;
    }

    public void setSellManId(Integer sellManId) {
        this.sellManId = sellManId;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(Double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getSellSerial() {
        return sellSerial;
    }

    public void setSellSerial(String sellSerial) {
        this.sellSerial = sellSerial;
    }

    @Override
    public String toString() {
        return "Sells{" +
                "sid=" + sid +
                ", productSerialNo=" + productSerialNo +
                ", productId=" + productId +
                ", productMarketPrice=" + productMarketPrice +
                ", sellManId=" + sellManId +
                ", sellNum=" + sellNum +
                ", productTotalPrice=" + productTotalPrice +
                ", sellSerial=" + sellSerial +
                '}';
    }
}
