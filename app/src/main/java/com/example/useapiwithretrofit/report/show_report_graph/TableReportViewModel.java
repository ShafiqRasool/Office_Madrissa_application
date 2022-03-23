package com.example.useapiwithretrofit.report.show_report_graph;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.report.select_report.ReportSelectionModel;
import com.example.useapiwithretrofit.report.show_report_in_list.ShowReportRepository;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TableReportViewModel extends AndroidViewModel {
    ShowReportRepository repository;
    ReportSelectionModel model;
    private MutableLiveData<ArrayList<TableReportModel>> tableData = new MutableLiveData<>();
    private  ObservableField<Boolean> dataFound = new ObservableField<>(false);
    private int Id;
    private ObservableField<String> displayName = new ObservableField<>("Report");

    public TableReportViewModel(@NonNull Application application) {
        super(application);

        repository = new ShowReportRepository(application);

        getDataForRepo();
    }

    private void getDataForRepo() {
        repository.setOnReportDataReceived(new ShowReportRepository.OnReportDataReceived() {
            @Override
            public void data(Object obj, int id) {

                ArrayList<TableReportModel> models = (ArrayList<TableReportModel>) obj;

                if (models.size() > 0) {

                    dataFound.set(true);

                    if (id == ConstVariables.DEPARTMENT_REPORT_ID) {
                        displayName.set("Departments Report");
                        tableData.postValue(models);
                        Id=id;
                    } else if (id == ConstVariables.EMPLOYEE_REPORT_ID) {
                        displayName.set("Employees Report");
                       tableData.postValue(models);
                       Id=id;
                    } else if (id == ConstVariables.SECTION_REPORT_ID) {
                        displayName.set("Sections Report");
                        tableData.postValue(models);
                        Id=id;
                    }
                } else {
                    dataFound.set(false);
                }

            }
        });
    }

    public void setData(ReportSelectionModel model) {
        this.model = model;
        repository.getReportForDepartment(model);
    }



    public ObservableField<Boolean> getDataFound() {
        return dataFound;
    }

    public void setDataFound(ObservableField<Boolean> dataFound) {
        this.dataFound = dataFound;
    }

    public ObservableField<String> getDisplayName() {
        return displayName;
    }

    public void setDisplayName(ObservableField<String> displayName) {
        this.displayName = displayName;
    }

    public MutableLiveData<ArrayList<TableReportModel>> getTableData() {
        return tableData;
    }

    public int getId() {
        return Id;
    }
}