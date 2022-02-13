package com.example.useapiwithretrofit.Operations;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.model.OperationsModel;

import java.util.ArrayList;

public class OperationsViewModel extends AndroidViewModel{
    MutableLiveData<ArrayList<OperationsModel>> liveData=new MutableLiveData<>();
    OperationsRepo repo;
    String date=null;
    public OperationsViewModel(@NonNull Application application) {
        super(application);
        repo=new OperationsRepo(application);
        repo.getDailyOperations("something");
        getDailyOperations();
    }
    public void setDate(String date  )
    {
        this.date=date;
    }
    public void getDailyOperations()
    {
        repo.setDailyNotifications(new OperationsRepo.DailyNotifications() {
            @Override
            public void data(ArrayList<OperationsModel> modelArrayList) {
                liveData.setValue(modelArrayList);
            }
        });
    }
    public LiveData<ArrayList<OperationsModel>> getLiveDailyOperations()
    {
        return liveData;
    }
    public void saveOperations(){
        ArrayList<OperationsModel> arrayList=OperationAdapter.getModelArrayList();
        repo.saveOperations(arrayList);

    }

}
