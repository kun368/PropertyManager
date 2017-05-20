package com.sdust.model;

import java.time.LocalDate;

/**
 * Created by Administrator on 2017/5/20.
 */
public class Complanint {
    private int complanintId;

    public int getComplanintId() {
        return complanintId;
    }

    private int propertorId;
    private String comDetail;
    private LocalDate comDate;
    private String solveState;
    public int getPropertorId() {
        return propertorId;
    }

    public void setPropertorId(int propertorId) {
        this.propertorId = propertorId;
    }

    public String getComDetail() {
        return comDetail;
    }

    public void setComDetail(String comDetail) {
        this.comDetail = comDetail;
    }

    public LocalDate getComDate() {
        return comDate;
    }

    public void setComDate(LocalDate comDate) {
        this.comDate = comDate;
    }

    public String getSolveState() {
        return solveState;
    }

    public void setSolveState(String solveState) {
        this.solveState = solveState;
    }
}
