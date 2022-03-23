package com.example.useapiwithretrofit.report.select_report;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ReportSelectionModel extends BaseObservable implements Parcelable {

    @Bindable
    private String fromDate;
    @Bindable
    private String toDate;
    private int selectedProfile;
    private String selectedPriority;
    private int selectedDepartment;
    private int selectedStatus;
    private int selectedLocation;
    private int reportType;

    public ReportSelectionModel() {
    }

    public ReportSelectionModel(Parcel in) {
        selectedProfile = in.readInt();
        selectedPriority = in.readString();
        selectedDepartment = in.readInt();
        selectedStatus = in.readInt();
        selectedLocation = in.readInt();
        fromDate = in.readString();
        toDate = in.readString();
        reportType = in.readInt();
    }

    public int getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(int selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    public String getSelectedPriority() {
        return selectedPriority;
    }

    public void setSelectedPriority(String selectedPriority) {
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
        if (this.fromDate != fromDate) {
            this.fromDate = fromDate;
            notifyChange();
        }
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        if (this.toDate != toDate) {
            this.toDate = toDate;
            notifyChange();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(selectedProfile);
        parcel.writeString(selectedPriority);
        parcel.writeInt(selectedDepartment);
        parcel.writeInt(selectedStatus);
        parcel.writeInt(selectedLocation);
        parcel.writeString(fromDate);
        parcel.writeString(toDate);
        parcel.writeInt(reportType);
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
}
