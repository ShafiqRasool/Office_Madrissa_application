package com.example.useapiwithretrofit.PendingOperations;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.model.PendingModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PendingViewModel extends AndroidViewModel {
    MutableLiveData<ArrayList<PendingModel>> livePending = new MutableLiveData<>();
    PendingOperationsRepo repo;

    public PendingViewModel(@NonNull @NotNull Application application) {
        super(application);
        repo = new PendingOperationsRepo(application);
        repo.getPendingOperations();
        getOperations();
    }

    private void getOperations() {
//        ProgressDialog dialog=new ProgressDialog(context);
//        dialog.setMessage("loading...");
//        dialog.show();
        repo.setDataFound(new PendingOperationsRepo.dataFound() {
            @Override
            public void setData(ArrayList<PendingModel> modelArrayList) {
                livePending.setValue(modelArrayList);
                // dialog.dismiss();
            }
        });
    }

    public LiveData<ArrayList<PendingModel>> getLivePending() {
        return livePending;
    }
}
