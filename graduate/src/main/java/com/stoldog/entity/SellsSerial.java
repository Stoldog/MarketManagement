package com.stoldog.entity;


/**
 * Created by RL on 2017/4/26.
 */
public class SellsSerial {
    private Integer sellSerial;
    private Long sellTime;
    private Integer sellManId;
    private Double sellTotalPrice;

    public Integer getSellSerial() {
        return sellSerial;
    }

    public void setSellSerial(Integer sellSerial) {
        this.sellSerial = sellSerial;
    }

    public Long getSellTime() {
        return sellTime;
    }

    public void setSellTime(Long sellTime) {
        this.sellTime = sellTime;
    }

    public Integer getSellManId() {
        return sellManId;
    }

    public void setSellManId(Integer sellManId) {
        this.sellManId = sellManId;
    }

    public Double getSellTotalPrice() {
        return sellTotalPrice;
    }

    public void setSellTotalPrice(Double sellTotalPrice) {
        this.sellTotalPrice = sellTotalPrice;
    }

    @Override
    public String toString() {
        return "SellsSerial{" +
                "sellSerial=" + sellSerial +
                ", sellTime=" + sellTime +
                ", sellManId=" + sellManId +
                ", sellTotalPrice=" + sellTotalPrice +
                '}';
    }
}
