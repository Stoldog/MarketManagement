package com.stoldog.entity;

/**
 * Created by RL on 2017/4/14.
 */
public class ProductInfo {
    private Integer pid;
    private String productName;
    private Double stockPrice;
    private Double marketPrice;
    private Integer effectTime;
    private String productUnit;
    private String productCity;
    private String productCompany;
    private Integer productType;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Integer effectTime) {
        this.effectTime = effectTime;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductCity() {
        return productCity;
    }

    public void setProductCity(String productCity) {
        this.productCity = productCity;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "pid=" + pid +
                ", productName='" + productName + '\'' +
                ", stockPrice=" + stockPrice +
                ", marketPrice=" + marketPrice +
                ", effectTime=" + effectTime +
                ", productUnit='" + productUnit + '\'' +
                ", productCity='" + productCity + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", productType=" + productType +
                '}';
    }
}
