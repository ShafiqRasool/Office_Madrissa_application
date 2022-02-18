package com.example.useapiwithretrofit.report;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class ReportViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<ReportModel>> priorityLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> profileLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> departmentLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> locationLiveList=new MutableLiveData<>();

    ReportRepo repo;

    public ReportViewModel(@NonNull Application application) {
        super(application);
        repo=new ReportRepo(application);
        repo.getFillLocations(1);
        repo.getDepartments(1,1);
        repo.getEmployees(1,1,1);
        repo.getPriority();
        getSpinnerListDate();
    }


    private void getSpinnerListDate() {
    repo.setOnGetList(new ReportRepo.OnGetList() {
        @Override
        public void Data(ArrayList<ReportModel> model, int key) {
            if(key==1){
                priorityLiveList.setValue(model);
            }else if(key==2){
                departmentLiveList.setValue(model);
            }else if(key==3){
                locationLiveList.setValue(model);
            }else if(key==4){
                priorityLiveList.setValue(model);
            }
        }
    });
    }

    public LiveData<ArrayList<ReportModel>> getPriorityLiveList() {
        return priorityLiveList;
    }

    public LiveData<ArrayList<ReportModel>> getProfileLiveList() {
        return profileLiveList;
    }

    public LiveData<ArrayList<ReportModel>> getDepartmentLiveList() {
        return departmentLiveList;
    }

    public LiveData<ArrayList<ReportModel>> getLocationLiveList() {
        return locationLiveList;
    }

    public void setPriorityLiveList(MutableLiveData<ArrayList<ReportModel>> priorityLiveList) {
        this.priorityLiveList = priorityLiveList;
    }

    public void setProfileLiveList(MutableLiveData<ArrayList<ReportModel>> profileLiveList) {
        this.profileLiveList = profileLiveList;
    }

    public void setDepartmentLiveList(MutableLiveData<ArrayList<ReportModel>> departmentLiveList) {
        this.departmentLiveList = departmentLiveList;
    }

    public void setLocationLiveList(MutableLiveData<ArrayList<ReportModel>> locationLiveList) {
        this.locationLiveList = locationLiveList;
    }
}
