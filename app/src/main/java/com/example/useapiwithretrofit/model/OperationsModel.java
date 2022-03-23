package com.example.useapiwithretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class OperationsModel extends BaseObservable implements Parcelable {

    public static final Creator<OperationsModel> CREATOR = new Creator<OperationsModel>() {
        @Override
        public OperationsModel createFromParcel(Parcel in) {
            return new OperationsModel(in);
        }

        @Override
        public OperationsModel[] newArray(int size) {
            return new OperationsModel[size];
        }
    };
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
    @Bindable
    @SerializedName("Status")
    @Expose
    private boolean status;
    @Bindable
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

    protected OperationsModel(Parcel in) {
        oprCode = in.readString();
        oprDesc = in.readString();
        departmentName = in.readString();
        locationName = in.readString();
        empName = in.readString();
        priority = in.readString();
        oprId = in.readInt();
        oprTransId = in.readInt();
        status = in.readByte() != 0;
        remarks = in.readString();
        OperationsTransDate = in.readString();
        Emp_id = in.readInt();
        IsSend = in.readByte() != 0;
    }

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
        if (status != this.status) {
            this.status = status;
            notifyChange();
        }
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        if (!Objects.equals(remarks, this.remarks))
            this.remarks = remarks;
        notifyChange();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(oprCode);
        parcel.writeString(oprDesc);
        parcel.writeString(departmentName);
        parcel.writeString(locationName);
        parcel.writeString(empName);
        parcel.writeString(priority);
        parcel.writeInt(oprId);
        parcel.writeInt(oprTransId);
        parcel.writeByte((byte) (status ? 1 : 0));
        parcel.writeString(remarks);
        parcel.writeString(OperationsTransDate);
        parcel.writeInt(Emp_id);
        parcel.writeByte((byte) (IsSend ? 1 : 0));
    }
}
