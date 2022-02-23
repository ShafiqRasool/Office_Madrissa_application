package com.example.useapiwithretrofit.report.showreport;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.report.showreport.model.OperationsReportModel;

import java.util.ArrayList;

public class FragmentShowReportViewModel extends AndroidViewModel {

    MutableLiveData<ArrayList<OperationsReportModel>> liveOperationReport;
    ReportByOperationsAdapter adapter;
    ShowReportRepository repository;

    public FragmentShowReportViewModel(@NonNull Application application) {
        super(application);
        liveOperationReport =new MutableLiveData<>();
        adapter=new ReportByOperationsAdapter();
        repository=new ShowReportRepository(application);
        getReportData();
    }

    private void getReportData() {

        repository.setOnReportDataReceived(new ShowReportRepository.OnReportDataReceived() {
            @Override
            public void data(Object obj, int id) {
                if(id== ConstVariables.OPERATION_REPORT_ID){
                    ArrayList<OperationsReportModel> models= (ArrayList<OperationsReportModel>) obj;
                    liveOperationReport.postValue(models);
                    adapter.setReportModelArrayList(liveOperationReport.getValue());
                }
            }
        });
    }

}