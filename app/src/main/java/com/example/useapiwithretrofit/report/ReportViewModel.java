package com.example.useapiwithretrofit.report;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

public class ReportViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<ReportModel>> priorityLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> profileLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> departmentLiveList=new MutableLiveData<>();
    private MutableLiveData<ArrayList<ReportModel>> locationLiveList=new MutableLiveData<>();


    private ArrayAdapter<String> adapter;
     Context context;
     Activity activity;
    ReportRepo repo;

    public ReportViewModel(@NonNull Application application) {
        super(application);
//
        repo=new ReportRepo(application);
        repo.getFillLocations(1);
        repo.getDepartments(1,1);
        repo.getEmployees(1,1,1);
        repo.getPriority();
        getSpinnerListDate();


    }
    public void setData(Activity activity,Context context){
        this.activity=activity;
        this.context=context;
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

    public MutableLiveData<ArrayList<ReportModel>> getPriorityLiveList() {
        return priorityLiveList;
    }

    public MutableLiveData<ArrayList<ReportModel>> getProfileLiveList() {
        return profileLiveList;
    }

    public MutableLiveData<ArrayList<ReportModel>> getDepartmentLiveList() {
        return departmentLiveList;
    }

    public MutableLiveData<ArrayList<ReportModel>> getLocationLiveList() {
        return locationLiveList;
    }


}
