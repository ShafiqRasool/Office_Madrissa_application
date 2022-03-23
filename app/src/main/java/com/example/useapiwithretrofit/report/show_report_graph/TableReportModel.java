package com.example.useapiwithretrofit.report.show_report_graph;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableReportModel {

    @SerializedName("Department_Name")
    @Expose
    private String departmentName;
    @SerializedName("Perform_by")
    @Expose
    private String performBy;
    @SerializedName("Section")
    @Expose
    private String section;
    @SerializedName("Failure")
    @Expose
    private Integer failure;
    @SerializedName("Succes")
    @Expose
    private Integer success;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPerformBy() {
        return performBy;
    }

    public void setPerformBy(String performBy) {
        this.performBy = performBy;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getName() {
        String name;
        if (departmentName != null)
            return departmentName;
        else if (performBy != null)
            return performBy;
        else if (section != null)
            return section;
        return null;
    }
}
