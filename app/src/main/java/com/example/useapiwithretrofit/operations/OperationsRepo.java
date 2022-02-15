package com.example.useapiwithretrofit.operations;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OperationsRepo {
    Context context;
    DailyNotifications setDailyNotifications;
    int EmpID;
    String token;
    public void setDailyNotifications(DailyNotifications setDailyNotifications) {
        this.setDailyNotifications = setDailyNotifications;
    }

    public OperationsRepo(Context context) {
         EmpID=SharedPreferencesHelper.getInstance(context).getEmpId();
         token=SharedPreferencesHelper.getInstance(context).getToken();
        this.context = context;
    }

    public void getDailyOperations(String date) {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<OperationsModel>> call = service.getDailyNotifications(token,EmpID,date);
        call.enqueue(new Callback<ArrayList<OperationsModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<OperationsModel>> call, Response<ArrayList<OperationsModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        setDailyNotifications.data(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<OperationsModel>> call, @NonNull Throwable t) {
                Toast.makeText(context, "NotOperationsFound", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void saveOperations(ArrayList<SaveOperationsModel> arrayList) {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<SaveOperationsResponse> call = service.saveDailyOperationsList(token, arrayList);
        call.enqueue(new Callback<SaveOperationsResponse>() {
            @Override
            public void onResponse(Call<SaveOperationsResponse> call, Response<SaveOperationsResponse> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        Toast.makeText(context, response.body().getStrMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SaveOperationsResponse> call, Throwable t) {
                Toast.makeText(context, "not save", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public interface DailyNotifications {
        void data(ArrayList<OperationsModel> modelArrayList);
    }

}
