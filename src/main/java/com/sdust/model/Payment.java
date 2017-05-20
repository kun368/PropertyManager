package com.sdust.model;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Payment {
    private int paymentId;
    private int houseId;
    private int payTypeId;
    private double payAmount;
    private LocalDateTime payDate;

    public int getPaymentId() {
        return paymentId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(int payTypeId) {
        this.payTypeId = payTypeId;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }
}
