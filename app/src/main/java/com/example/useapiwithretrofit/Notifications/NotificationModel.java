package com.example.useapiwithretrofit.Notifications;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "notifications")
public class NotificationModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("Noti_id")
    @Expose
    private Float notiId;
    @SerializedName("Noti_Desc")
    @Expose
    private String notiDesc;
    @SerializedName("Noti_Created_on")
    @Expose
    private boolean notiCreatedOn;
    @SerializedName("Is_Read")
    @Expose
    private boolean isRead;
    @SerializedName("Is_Removed")
    @Expose
    private boolean isRemoved;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getNotiId() {
        return notiId;
    }

    public void setNotiId(Float notiId) {
        this.notiId = notiId;
    }

    public String getNotiDesc() {
        return notiDesc;
    }

    public void setNotiDesc(String notiDesc) {
        this.notiDesc = notiDesc;
    }

    public boolean isNotiCreatedOn() {
        return notiCreatedOn;
    }

    public void setNotiCreatedOn(boolean notiCreatedOn) {
        this.notiCreatedOn = notiCreatedOn;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }
}
