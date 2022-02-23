package com.example.useapiwithretrofit.report.showreport;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;
import com.example.useapiwithretrofit.report.showreport.model.OperationsReportModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowReportRepository {
    Context context;
    private OnReportDataReceived onReportDataReceived;


    public ShowReportRepository(Context context) {
        this.context = context;
    }

    public void getReportByOperations(){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<OperationsReportModel>> call=service.getOperationsReport(SharedPreferencesHelper.getInstance(context).getToken());
        call.enqueue(new Callback<ArrayList<OperationsReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<OperationsReportModel>> call, @NonNull Response<ArrayList<OperationsReportModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        onReportDataReceived.data(response.body(), ConstVariables.OPERATION_REPORT_ID);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<OperationsReportModel>> call, @NonNull Throwable t) {

            }
        });
    }
    public interface OnReportDataReceived{
        void data(Object obj,int id);
    }

    public void setOnReportDataReceived(OnReportDataReceived onReportDataReceived) {
        this.onReportDataReceived = onReportDataReceived;
    }
}
