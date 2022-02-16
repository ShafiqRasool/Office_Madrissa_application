package com.example.useapiwithretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveOperationsResponse {

    @SerializedName("RcKey")
    @Expose
    private int rcKey;
    @SerializedName("StrMessage")
    @Expose
    private String strMessage;
    @SerializedName("NotifyMessage")
    @Expose
    private String notifyMessage;
    @SerializedName("CrudNo")
    @Expose
    private int crudNo;
    @SerializedName("Status")
    @Expose
    private int status;
    @SerializedName("ReturnId")
    @Expose
    private double returnId;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("ID")
    @Expose
    private Long id;
    @SerializedName("Email_Address")
    @Expose
    private String emailAddress;
    @SerializedName("Email_Password")
    @Expose
    private String emailPassword;
    @SerializedName("Email_Host")
    @Expose
    private String emailHost;
    @SerializedName("User_Name")
    @Expose
    private String userName;

    public int getRcKey() {
        return rcKey;
    }

    public void setRcKey(int rcKey) {
        this.rcKey = rcKey;
    }

    public String getStrMessage() {
        return strMessage;
    }

    public void setStrMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }

    public int getCrudNo() {
        return crudNo;
    }

    public void setCrudNo(int crudNo) {
        this.crudNo = crudNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getReturnId() {
        return returnId;
    }

    public void setReturnId(double returnId) {
        this.returnId = returnId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
