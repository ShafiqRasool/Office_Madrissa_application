package com.example.useapiwithretrofit.report;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportRepo {
    private  Context context;
    private  OnGetList onGetList;

    public  void setOnGetList(OnGetList getList) {
        this.onGetList = getList;
    }

    public ReportRepo(Context context) {
        this.context = context;
    }

    public void getPriority(){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<ReportModel>> call= service.getPriorityList(SharedPreferencesHelper.getInstance(context).getToken());
        call.enqueue(new Callback<ArrayList<ReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Response<ArrayList<ReportModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        onGetList.Data(response.body(),1);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Throwable t) {

            }
        });

    }
    public void getDepartments(int companyId,int countryId ){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<ReportModel>> call= service.getDepartments(SharedPreferencesHelper.getInstance(context).getToken(),companyId,countryId);
        call.enqueue(new Callback<ArrayList<ReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Response<ArrayList<ReportModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        onGetList.Data(response.body(),2);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Throwable t) {

            }
        });

    }
    public void getFillLocations(int companyId){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<ReportModel>> call= service.getFillLocations(SharedPreferencesHelper.getInstance(context).getToken(),companyId);
        call.enqueue(new Callback<ArrayList<ReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Response<ArrayList<ReportModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        onGetList.Data(response.body(),2);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Throwable t) {

            }
        });

    }
    public void getEmployees(int companyId,int countryId,int location){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<ReportModel>> call= service.getEmployees(SharedPreferencesHelper.getInstance(context).getToken(),companyId,countryId,location);
        call.enqueue(new Callback<ArrayList<ReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Response<ArrayList<ReportModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        onGetList.Data(response.body(),4);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ReportModel>> call, @NonNull Throwable t) {

            }
        });
    }

    public interface OnGetList{
         void Data(ArrayList<ReportModel> model,int key);
    }
}
