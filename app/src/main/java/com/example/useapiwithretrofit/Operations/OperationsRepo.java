package com.example.useapiwithretrofit.Operations;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.OperationsSavedModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OperationsRepo {
    Context context;
    DailyNotifications setDailyNotifications;
    public void setDailyNotifications(DailyNotifications setDailyNotifications) {
        this.setDailyNotifications = setDailyNotifications;
    }

    public OperationsRepo(Context context) {
        this.context = context;
    }

    public void getDailyOperations(String date) {
        String s;
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<OperationsModel>> call = service.getDailyNotifications(getToken(), getEmpId(), date);
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

    public String getToken() {
        android.content.SharedPreferences preferences = context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getString(String.valueOf(R.string.userToken), "null");
    }

    public int getEmpId() {
        android.content.SharedPreferences preferences = context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getInt(String.valueOf(R.string.empId), 0);
    }

    public void saveOperations(ArrayList<OperationsModel> arrayList) {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<OperationsSavedModel> call = service.saveDailyOperationsList(getToken(), arrayList);
        call.enqueue(new Callback<OperationsSavedModel>() {
            @Override
            public void onResponse(Call<OperationsSavedModel> call, Response<OperationsSavedModel> response) {
                Toast.makeText(context, "saved successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<OperationsSavedModel> call, Throwable t) {
                Toast.makeText(context, "not saved", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public interface DailyNotifications {
        void data(ArrayList<OperationsModel> modelArrayList);
    }

}
