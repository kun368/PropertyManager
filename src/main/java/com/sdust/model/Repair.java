package com.sdust.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Repair {
    private int repairId;
    private int houseId;
    private Date repairdata;
    private String repairState;
    private  int repairManId;
    private String repairDetail;

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public int getRepairId() {
        return repairId;
    }
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public Date getRepairdata() {
        return repairdata;
    }

    public void setRepairdata(Date repairdata) {
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
