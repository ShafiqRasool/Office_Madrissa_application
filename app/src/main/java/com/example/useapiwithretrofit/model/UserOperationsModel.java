package com.example.useapiwithretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserOperationsModel {

    @SerializedName("Opr_Id")
    @Expose
    private Float oprId;
    @SerializedName("Opr_Code")
    @Expose
    private String oprCode;
    @SerializedName("Opr_Desc")
    @Expose
    private String oprDesc;
    @SerializedName("Department_Name")
    @Expose
    private String departmentName;
    @SerializedName("Location_Name")
    @Expose
    private String locationName;
    @SerializedName("Emp_Name")
    @Expose
    private String empName;
    @SerializedName("Priority")
    @Expose
    private String priority;
    @SerializedName("Opr_Trans_Id")
    @Expose
    private float oprTransId;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("Remarks")
    @Expose
    private String remarks;

    public Float getOprId() {
        return oprId;
    }

    public void setOprId(Float oprId) {
        this.oprId = oprId;
    }

    public String getOprCode() {
        return oprCode;
    }

    public void setOprCode(String oprCode) {
        this.oprCode = oprCode;
    }

    public String getOprDesc() {
        return oprDesc;
    }

    public void setOprDesc(String oprDesc) {
        this.oprDesc = oprDesc;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public float getOprTransId() {
        return oprTransId;
    }

    public void setOprTransId(float oprTransId) {
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
}