package com.example.useapiwithretrofit.report.show_report_in_list;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.Utils.SharedPreferencesHelper;
import com.example.useapiwithretrofit.report.select_report.ReportSelectionModel;
import com.example.useapiwithretrofit.report.show_report_graph.TableReportModel;
import com.example.useapiwithretrofit.report.show_report_in_list.model.OperationsReportModel;

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

    public void getReportByOperations(ReportSelectionModel model) {

        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<OperationsReportModel>> call = service.getOperationsReport(SharedPreferencesHelper.getInstance(context.getApplicationContext()).getToken(),
                model.getFromDate(), model.getToDate(), model.getSelectedProfile(), model.getSelectedLocation()
                , model.getSelectedDepartment(), 10, model.getSelectedPriority()
                , ConstVariables.OPERATION_REPORT_ID);

        call.enqueue(new Callback<ArrayList<OperationsReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<OperationsReportModel>> call, @NonNull Response<ArrayList<OperationsReportModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        onReportDataReceived.data(response.body(), ConstVariables.OPERATION_REPORT_ID);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<OperationsReportModel>> call, @NonNull Throwable t) {
                Toast.makeText(context, "error to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getReportForDepartment(ReportSelectionModel model) {

        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<TableReportModel>> call = service.getTableReport(SharedPreferencesHelper.getInstance(context.getApplicationContext()).getToken(),
                model.getFromDate(), model.getToDate(), model.getSelectedProfile(), model.getSelectedLocation()
                , model.getSelectedDepartment(), 10, model.getSelectedPriority()
                , model.getReportType());
        call.enqueue(new Callback<ArrayList<TableReportModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<TableReportModel>> call, @NonNull Response<ArrayList<TableReportModel>> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        onReportDataReceived.data(response.body(), model.getReportType());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<TableReportModel>> call, @NonNull Throwable t) {
                Toast.makeText(context, "Data not found!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setOnReportDataReceived(OnReportDataReceived onReportDataReceived) {
        this.onReportDataReceived = onReportDataReceived;
    }

    public interface OnReportDataReceived {
        void data(Object obj, int id);
    }
}
