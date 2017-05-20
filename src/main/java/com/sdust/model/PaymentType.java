package com.sdust.model;

/**
 * Created by Administrator on 2017/5/20.
 */
public class PaymentType {
    private  int payTypeId;
    private  String payType;

    public void setPayTypeId(int payTypeId) {
        this.payTypeId = payTypeId;
    }

    public int getPayTypeId() {
        return payTypeId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
