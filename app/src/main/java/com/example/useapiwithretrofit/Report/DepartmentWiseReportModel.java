package com.example.useapiwithretrofit.Report;

public class DepartmentWiseReportModel {
    private String department="";
    private int total=0;
    private int accepted=0;
    private int rejected=0;

    public DepartmentWiseReportModel() {
    }

    public DepartmentWiseReportModel(String department, int total, int accepted, int rejected) {
        this.department = department;
        this.total = total;
        this.accepted = accepted;
        this.rejected = rejected;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }
}
