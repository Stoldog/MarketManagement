package com.stoldog.entity;

/**
 * Created by RL on 2017/4/14.
 */
public class ProductType {
    private Integer tid;
    private String typeName;
    private String typeValue;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "tid=" + tid +
                ", typeName='" + typeName + '\'' +
                ", typeValue='" + typeValue + '\'' +
                '}';
    }
}
