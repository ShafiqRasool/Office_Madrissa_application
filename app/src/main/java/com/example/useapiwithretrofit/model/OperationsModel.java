package com.example.useapiwithretrofit.model;

import android.view.View;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OperationsModel {

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

}
