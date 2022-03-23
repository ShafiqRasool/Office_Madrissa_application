package com.example.useapiwithretrofit.operations;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveOperationsResponse implements Parcelable {


    public static final Creator<SaveOperationsResponse> CREATOR = new Creator<SaveOperationsResponse>() {
        @Override
        public SaveOperationsResponse createFromParcel(Parcel in) {
            return new SaveOperationsResponse(in);
        }

        @Override
        public SaveOperationsResponse[] newArray(int size) {
            return new SaveOperationsResponse[size];
        }
    };
    @SerializedName("RcKey")
    @Expose
    private Long rcKey;
    @SerializedName("StrMessage")
    @Expose
    private String strMessage;
    @SerializedName("NotifyMessage")
    @Expose
    private String notifyMessage;
    @SerializedName("CrudNo")
    @Expose
    private Long crudNo;
    @SerializedName("Status")
    @Expose
    private Long status;
    @SerializedName("ReturnId")
    @Expose
    private Float returnId;
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

    protected SaveOperationsResponse(Parcel in) {
        if (in.readByte() == 0) {
            rcKey = null;
        } else {
            rcKey = in.readLong();
        }
        strMessage = in.readString();
        notifyMessage = in.readString();
        if (in.readByte() == 0) {
            crudNo = null;
        } else {
            crudNo = in.readLong();
        }
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readLong();
        }
        if (in.readByte() == 0) {
            returnId = null;
        } else {
            returnId = in.readFloat();
        }
        code = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        emailAddress = in.readString();
        emailPassword = in.readString();
        emailHost = in.readString();
        userName = in.readString();
    }

    public Long getRcKey() {
        return rcKey;
    }

    public void setRcKey(Long rcKey) {
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

    public Long getCrudNo() {
        return crudNo;
    }

    public void setCrudNo(Long crudNo) {
        this.crudNo = crudNo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Float getReturnId() {
        return returnId;
    }

    public void setReturnId(Float returnId) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (rcKey == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(rcKey);
        }
        parcel.writeString(strMessage);
        parcel.writeString(notifyMessage);
        if (crudNo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(crudNo);
        }
        if (status == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(status);
        }
        if (returnId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(returnId);
        }
        parcel.writeString(code);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(emailAddress);
        parcel.writeString(emailPassword);
        parcel.writeString(emailHost);
        parcel.writeString(userName);
    }
}
