package com.sdust.model;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Propertor {
    private  int propertorId;
    private  String prName;
    private  String prSex;
    private String prPhone;
    private String prIdNumber;

    public void setPropertorId(int propertorId) {
        this.propertorId = propertorId;
    }

    public int getPropertorId() {
        return propertorId;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public String getPrSex() {
        return prSex;
    }

    public void setPrSex(String prSex) {
        this.prSex = prSex;
    }

    public String getPrPhone() {
        return prPhone;
    }

    public void setPrPhone(String prPhone) {
        this.prPhone = prPhone;
    }

    public String getPrIdNumber() {
        return prIdNumber;
    }

    public void setPrIdNumber(String prIdNumber) {
        this.prIdNumber = prIdNumber;
    }
}
