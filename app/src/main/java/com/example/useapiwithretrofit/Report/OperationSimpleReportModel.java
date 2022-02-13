package com.example.useapiwithretrofit.Report;

public class OperationSimpleReportModel {
private String Department;
private String Status;
private String Operation;
private String PerformedBy;
private String Remarks;
private String Date;


    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getPerformedBy() {
        return PerformedBy;
    }

    public void setPerformedBy(String performedBy) {
        PerformedBy = performedBy;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
