package com.example.useapiwithretrofit.report.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ReportSelectionModel implements Parcelable {
    private String fromDate;
    private String toDate;
    private int selectedProfile;
    private int selectedPriority;
    private int selectedDepartment;
    private int selectedStatus;
    private int selectedLocation;

    public ReportSelectionModel() {
    }

    public ReportSelectionModel(Parcel in) {
        selectedProfile = in.readInt();
        selectedPriority = in.readInt();
        selectedDepartment = in.readInt();
        selectedStatus = in.readInt();
        selectedLocation = in.readInt();
        fromDate=in.readString();
        toDate=in.readString();
    }

    public static final Creator<ReportSelectionModel> CREATOR = new Creator<ReportSelectionModel>() {
        @Override
        public ReportSelectionModel createFromParcel(Parcel in) {
            return new ReportSelectionModel(in);
        }

        @Override
        public ReportSelectionModel[] newArray(int size) {
            return new ReportSelectionModel[size];
        }
    };

    public int getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(int selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    public int getSelectedPriority() {
        return selectedPriority;
    }

    public void setSelectedPriority(int selectedPriority) {
        this.selectedPriority = selectedPriority;
    }

    public int getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(int selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public int getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(int selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public int getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(int selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(selectedProfile);
        parcel.writeInt(selectedPriority);
        parcel.writeInt(selectedDepartment);
        parcel.writeInt(selectedStatus);
        parcel.writeInt(selectedLocation);
        parcel.writeString(fromDate);
        parcel.writeString(toDate);
    }
}
