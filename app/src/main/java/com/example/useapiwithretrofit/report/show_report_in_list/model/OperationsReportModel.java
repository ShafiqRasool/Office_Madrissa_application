package com.example.useapiwithretrofit.report.show_report_in_list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OperationsReportModel {
    @SerializedName("Opr_Trans_Date")
    @Expose
    private String oprTransDate;
    @SerializedName("Opr_Code")
    @Expose
    private String oprCode;
    @SerializedName("Opr_Desc")
    @Expose
    private String oprDesc;
    @SerializedName("Priority")
    @Expose
    private String priority;
    @SerializedName("Perform_by")
    @Expose
    private String performBy;
    @SerializedName("Department_Name")
    @Expose
    private String departmentName;
    @SerializedName("Section")
    @Expose
    private String section;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("Status")
    @Expose
    private String status;

    public String getOprTransDate() {
        return oprTransDate;
    }

    public void setOprTransDate(String oprTransDate) {
        this.oprTransDate = oprTransDate;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPerformBy() {
        return performBy;
    }

    public void setPerformBy(String performBy) {
        this.performBy = performBy;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
