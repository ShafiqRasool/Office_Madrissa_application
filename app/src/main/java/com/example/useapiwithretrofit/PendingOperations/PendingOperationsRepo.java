package com.example.useapiwithretrofit.PendingOperations;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;
import com.example.useapiwithretrofit.model.PendingModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingOperationsRepo {
    dataFound dataFound;

    public void setDataFound(dataFound dataFound) {
        this.dataFound = dataFound;
    }

    public interface dataFound {
        void setData(ArrayList<PendingModel> modelArrayList);
    }

    Context context;

    public PendingOperationsRepo(Context context) {
        this.context = context;
    }

    public void getPendingOperations() {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        SharedPreferencesHelper.getInstance(context).getToken();
        Call<ArrayList<PendingModel>> call = service.getPendingOperation(SharedPreferencesHelper.getInstance(context.getApplicationContext()).getToken(), SharedPreferencesHelper.getInstance(context.getApplicationContext()).getEmpId());
        call.enqueue(new Callback<ArrayList<PendingModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<PendingModel>> call, @NonNull Response<ArrayList<PendingModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        dataFound.setData(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<PendingModel>> call, @NonNull Throwable t) {
                Toast.makeText(context, "Failed to Get data", Toast.LENGTH_SHORT).show();
            }
        });
    }


}


