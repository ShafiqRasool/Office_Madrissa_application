package com.example.useapiwithretrofit.Operations;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.R;
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
    public interface dataFound{
        void setData(ArrayList<PendingModel> modelArrayList);
    }
    Context context;
    public PendingOperationsRepo(Context context) {
        this.context = context;
    }
    public void getPendingOperations(int empId){
        SharedPreferences preferences=getReadSharedPreference();
        int id=preferences.getInt(String.valueOf(R.string.empId),0);
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<PendingModel>> call=service.getPendingOperation(getToken(),empId);
        call.enqueue(new Callback<ArrayList<PendingModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PendingModel>> call, Response<ArrayList<PendingModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        dataFound.setData(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PendingModel>> call, Throwable t) {

            }
        });

    }
    public String getToken(){
        SharedPreferences preferences= context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getString(String.valueOf(R.string.userToken),"null");
    }



    SharedPreferences getReadSharedPreference(){
        SharedPreferences preferences= context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences;
    }
}


