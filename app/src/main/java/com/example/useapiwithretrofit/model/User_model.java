package com.example.useapiwithretrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User_model {

    @SerializedName("lstclsUserRole")
    @Expose
    private Object lstclsUserRole;
    @SerializedName("lstclsDefLocationUser")
    @Expose
    private Object lstclsDefLocationUser;
    @SerializedName("lstCurrentUserRight")
    @Expose
    private Object lstCurrentUserRight;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("MaritalStatus")
    @Expose
    private String maritalStatus;
    @SerializedName("FatherName")
    @Expose
    private String fatherName;
    @SerializedName("CNIC")
    @Expose
    private String cnic;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("GuardianNo")
    @Expose
    private String guardianNo;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("HomeAddress")
    @Expose
    private String homeAddress;
    @SerializedName("RoleID")
    @Expose
    private Integer roleID;
    @SerializedName("Emp_Id")
    @Expose
    private Integer empId;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("IsAllowToLogin")
    @Expose
    private Boolean isAllowToLogin;
    @SerializedName("strRoleID")
    @Expose
    private String strRoleID;
    @SerializedName("SMSAlerts")
    @Expose
    private Boolean sMSAlerts;
    @SerializedName("Code_Genereted_Date_Time")
    @Expose
    private Object codeGeneretedDateTime;
    @SerializedName("Code_Expiry_Time")
    @Expose
    private Object codeExpiryTime;
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Session_Id")
    @Expose
    private Long sessionId;
    @SerializedName("Verified")
    @Expose
    private Boolean verified;
    @SerializedName("Is_Device_Confg")
    @Expose
    private Boolean isDeviceConfg;
    @SerializedName("Device_Address")
    @Expose
    private Object deviceAddress;

    public Object getLstclsUserRole() {
        return lstclsUserRole;
    }

    public void setLstclsUserRole(Object lstclsUserRole) {
        this.lstclsUserRole = lstclsUserRole;
    }

    public Object getLstclsDefLocationUser() {
        return lstclsDefLocationUser;
    }

    public void setLstclsDefLocationUser(Object lstclsDefLocationUser) {
        this.lstclsDefLocationUser = lstclsDefLocationUser;
    }

    public Object getLstCurrentUserRight() {
        return lstCurrentUserRight;
    }

    public void setLstCurrentUserRight(Object lstCurrentUserRight) {
        this.lstCurrentUserRight = lstCurrentUserRight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGuardianNo() {
        return guardianNo;
    }

    public void setGuardianNo(String guardianNo) {
        this.guardianNo = guardianNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getIsAllowToLogin() {
        return isAllowToLogin;
    }

    public void setIsAllowToLogin(Boolean isAllowToLogin) {
        this.isAllowToLogin = isAllowToLogin;
    }

    public String getStrRoleID() {
        return strRoleID;
    }

    public void setStrRoleID(String strRoleID) {
        this.strRoleID = strRoleID;
    }

    public Boolean getSMSAlerts() {
        return sMSAlerts;
    }

    public void setSMSAlerts(Boolean sMSAlerts) {
        this.sMSAlerts = sMSAlerts;
    }

    public Object getCodeGeneretedDateTime() {
        return codeGeneretedDateTime;
    }

    public void setCodeGeneretedDateTime(Object codeGeneretedDateTime) {
        this.codeGeneretedDateTime = codeGeneretedDateTime;
    }

    public Object getCodeExpiryTime() {
        return codeExpiryTime;
    }

    public void setCodeExpiryTime(Object codeExpiryTime) {
        this.codeExpiryTime = codeExpiryTime;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getIsDeviceConfg() {
        return isDeviceConfg;
    }

    public void setIsDeviceConfg(Boolean isDeviceConfg) {
        this.isDeviceConfg = isDeviceConfg;
    }

    public Object getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(Object deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

}
