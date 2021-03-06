package com.example.useapiwithretrofit.report.show_report_in_list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.report.select_report.ReportSelectionModel;
import com.example.useapiwithretrofit.report.show_report_in_list.model.OperationsReportModel;

import java.util.ArrayList;

public class FragmentShowReportViewModel extends AndroidViewModel {

    ReportByOperationsAdapter adapter;
    ShowReportRepository repository;
    ReportSelectionModel model;

    public FragmentShowReportViewModel(@NonNull Application application) {
        super(application);
        repository = new ShowReportRepository(application);
        adapter = new ReportByOperationsAdapter();
        getReportData();
    }

    public void setData(ReportSelectionModel model) {
        this.model = model;
        repository.getReportByOperations(model);
    }

    private void getReportData() {

        repository.setOnReportDataReceived(new ShowReportRepository.OnReportDataReceived() {
            @Override
            public void data(Object obj, int id) {
                if (id == ConstVariables.OPERATION_REPORT_ID) {
                    ArrayList<OperationsReportModel> models = (ArrayList<OperationsReportModel>) obj;
                    adapter.setReportModelArrayList(models);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public ReportByOperationsAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ReportByOperationsAdapter adapter) {
        this.adapter = adapter;
    }
}