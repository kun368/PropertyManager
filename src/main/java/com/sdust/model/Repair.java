package com.sdust.model;

import java.time.LocalDate;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Repair {
    private int repairId;
    private int houseId;
    private LocalDate repairdata;
    private String repairState;
    private  int repairManId;
    private String repairDetail;

    public int getRepairId() {
        return repairId;
    }
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public LocalDate getRepairdata() {
        return repairdata;
    }

    public void setRepairdata(LocalDate repairdata) {
        this.repairdata = repairdata;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public int getRepairManId() {
        return repairManId;
    }

    public void setRepairManId(int repairManId) {
        this.repairManId = repairManId;
    }

    public String getRepairDetail() {
        return repairDetail;
    }

    public void setRepairDetail(String repairDetail) {
        this.repairDetail = repairDetail;
    }
}
