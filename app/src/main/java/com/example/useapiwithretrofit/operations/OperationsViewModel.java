package com.example.useapiwithretrofit.operations;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;
import com.example.useapiwithretrofit.databinding.LayoutCardViewOperationBinding;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsResponse;

import java.util.ArrayList;

public class OperationsViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<OperationsModel>> liveData = new MutableLiveData<>();
    private ObservableField<Boolean> Visibility;
    private OperationsRepo repo;
    private String date = null;
    private final OperationAdapter adapter;
    private int EmpId;

    public OperationsViewModel(@NonNull Application application) {
        super(application);
        repo = new OperationsRepo(application);
        repo.getDailyOperations("something");
        adapter = new OperationAdapter();
        getDailyOperations();
       EmpId=SharedPreferencesHelper.getInstance(repo.context).getEmpId();
    }

    public ObservableField<Boolean> getVisibility() {
        return Visibility;
    }

    public void setVisibility(ObservableField<Boolean> visibility) {
        Visibility = visibility;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void getDailyOperations() {
        repo.setDailyNotifications(new OperationsRepo.DailyNotifications() {
            @Override
            public void data(ArrayList<OperationsModel> modelArrayList) {
                liveData.setValue(modelArrayList);
                adapter.setModelArrayList(modelArrayList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public OperationAdapter getAdapter() {
        return adapter;
    }


    public void saveOperations() {
       repo.saveOperations(changeListtoSaveOperationModel(adapter.modelArrayList,false));

    }
    public ArrayList<SaveOperationsModel> changeListtoSaveOperationModel(ArrayList<OperationsModel> arrayList,boolean setsend){
       ArrayList<SaveOperationsModel> saveOperationsModelArrayList=new ArrayList<>();
        for (int x = 0; x < arrayList.size(); x++) {

            OperationsModel model = arrayList.get(x);

            SaveOperationsModel model1=new SaveOperationsModel();

            model1.setRemarks(model.getRemarks());
            model1.setOperationsTransDate(date);
            model1.setOprTransId(model.getOprTransId());
            model1.setStatus(model.isStatus());
            model1.setEmp_id(EmpId);
            model1.setSend(setsend);
            model1.setOprId(model.getOprId());
            //add to new list

            saveOperationsModelArrayList.add(model1);

        }
        return saveOperationsModelArrayList;
    }

    public void SendOperations() {
        repo.saveOperations(changeListtoSaveOperationModel(adapter.getModelArrayList(),true));

    }


}



