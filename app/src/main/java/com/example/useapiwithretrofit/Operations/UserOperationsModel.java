package com.example.useapiwithretrofit.Operations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserOperationsModel {

    @SerializedName("Opr_Activity_Exe_date")
    @Expose
    private String oprActivityExeDate;
    @SerializedName("Opr_Activity_Exe_Id")
    @Expose
    private int oprActivityExeId;
    @SerializedName("Opr_Id")
    @Expose
    private Float oprId;
    @SerializedName("Opr_Desc")
    @Expose
    private String oprDesc;
    @SerializedName("Opr_Remarks")
    @Expose
    private String oprRemarks;
    @SerializedName("Opr_Status")
    @Expose
    private boolean oprStatus;

    public String getOprActivityExeDate() {
        return oprActivityExeDate;
    }

    public void setOprActivityExeDate(String oprActivityExeDate) {
        this.oprActivityExeDate = oprActivityExeDate;
    }

    public int getOprActivityExeId() {
        return oprActivityExeId;
    }

    public void setOprActivityExeId(int oprActivityExeId) {
        this.oprActivityExeId = oprActivityExeId;
    }

    public Float getOprId() {
        return oprId;
    }

    public void setOprId(Float oprId) {
        this.oprId = oprId;
    }

    public String getOprDesc() {
        return oprDesc;
    }

    public void setOprDesc(String oprDesc) {
        this.oprDesc = oprDesc;
    }

    public String getOprRemarks() {
        return oprRemarks;
    }

    public void setOprRemarks(String oprRemarks) {
        this.oprRemarks = oprRemarks;
    }

    public boolean isOprStatus() {
        return oprStatus;
    }

    public void setOprStatus(boolean oprStatus) {
        this.oprStatus = oprStatus;
    }
}