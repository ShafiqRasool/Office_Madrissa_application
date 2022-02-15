package com.example.useapiwithretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveOperationsModel {
    @SerializedName("Opr_Id")
    @Expose
    private int oprId;
    @SerializedName("Opr_Trans_Id")
    @Expose
    private int oprTransId;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("Opr_Trans_Date")
    @Expose
    private String OperationsTransDate;
    @SerializedName("Emp_id")
    @Expose
    private int Emp_id;
    @SerializedName("Is_Send")
    @Expose
    private boolean IsSend;

    public int getOprId() {
        return oprId;
    }

    public void setOprId(int oprId) {
        this.oprId = oprId;
    }

    public int getOprTransId() {
        return oprTransId;
    }

    public void setOprTransId(int oprTransId) {
        this.oprTransId = oprTransId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOperationsTransDate() {
        return OperationsTransDate;
    }

    public void setOperationsTransDate(String operationsTransDate) {
        OperationsTransDate = operationsTransDate;
    }

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int emp_id) {
        Emp_id = emp_id;
    }

    public boolean isSend() {
        return IsSend;
    }

    public void setSend(boolean send) {
        IsSend = send;
    }
}
