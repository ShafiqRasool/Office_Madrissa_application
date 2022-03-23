package com.example.useapiwithretrofit.notifications;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationModel {


    @SerializedName("Company_Id")
    @Expose
    private Float companyId;
    @SerializedName("Country_Id")
    @Expose
    private Float countryId;
    @SerializedName("Location_Id")
    @Expose
    private Float locationId;
    @SerializedName("Project_Id")
    @Expose
    private Float projectId;
    @SerializedName("SMS_Id")
    @Expose
    private Float smsId;
    @SerializedName("Msg_Desc")
    @Expose
    private String msgDesc;
    @SerializedName("To_Number")
    @Expose
    private String toNumber;
    @SerializedName("Status")
    @Expose
    private Long status;
    @SerializedName("Generated_By")
    @Expose
    private String generatedBy;
    @SerializedName("Generated_on")
    @Expose
    private String generatedOn;
    @SerializedName("Doc_Ref_ID")
    @Expose
    private Float docRefID;
    @SerializedName("active")
    @Expose
    private int active;
    @SerializedName("Receiver_Id")
    @Expose
    private Long receiverId;
    @SerializedName("Msg_Title")
    @Expose
    private String msgTitle;

    public Float getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Float companyId) {
        this.companyId = companyId;
    }

    public Float getCountryId() {
        return countryId;
    }

    public void setCountryId(Float countryId) {
        this.countryId = countryId;
    }

    public Float getLocationId() {
        return locationId;
    }

    public void setLocationId(Float locationId) {
        this.locationId = locationId;
    }

    public Float getProjectId() {
        return projectId;
    }

    public void setProjectId(Float projectId) {
        this.projectId = projectId;
    }

    public Float getSmsId() {
        return smsId;
    }

    public void setSmsId(Float smsId) {
        this.smsId = smsId;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getGeneratedOn() {
        return generatedOn;
    }

    public void setGeneratedOn(String generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Float getDocRefID() {
        return docRefID;
    }

    public void setDocRefID(Float docRefID) {
        this.docRefID = docRefID;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

}
