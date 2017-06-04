package com.sdust.model;

/**
 * Created by Administrator on 2017/5/20.
 */
public class House {
    private  int houseId;
    private int buildingNo;
    private int unitNo;
    private int houseNo;
    private int prpertorId;
    private String sealState;
    private String houseStyle;
    private double houseArea;

    public int getHouseId() {
        return houseId;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getPrpertorId() {
        return prpertorId;
    }

    public void setPrpertorId(int prpertorId) {
        this.prpertorId = prpertorId;
    }

    public String getSealState() {
        return sealState;
    }

    public void setSealState(String sealState) {
        this.sealState = sealState;
    }

    public String getHouseStyle() {
        return houseStyle;
    }

    public void setHouseStyle(String houseStyle) {
        this.houseStyle = houseStyle;
    }

    public double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(double houseArea) {
        this.houseArea = houseArea;
    }

    @Override
    public String toString() {
        return "House{" +
                "buildingNo=" + buildingNo +
                ", unitNo=" + unitNo +
                ", houseNo=" + houseNo +
                ", prpertorId=" + prpertorId +
                ", sealState='" + sealState + '\'' +
                ", houseStyle='" + houseStyle + '\'' +
                ", houseArea=" + houseArea +
                '}';
    }
}
