package com.example.useapiwithretrofit.report.showreportgraph;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;
import com.example.useapiwithretrofit.report.showreportlist.ShowReportRepository;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
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
    private String displayName = "Name";

    BarChart barChart;
    Context context;
    private TableLayout tableLayout;
    MutableLiveData<ArrayList<TableReportModel>> tableData = new MutableLiveData<>();

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
                if (id == ConstVariables.DEPARTMENT_REPORT_ID) {
                    displayName = "Departments";
                    tableData.setValue(models);
                    CreateTable();
                    CreateChart(id);
                } else if (id == ConstVariables.EMPLOYEE_REPORT_ID) {
                    displayName = "Employees";
                    tableData.setValue(models);
                    CreateTable();
                    CreateChart(id);
                } else if (id == ConstVariables.SECTION_REPORT_ID) {
                    displayName = "Sections";
                    tableData.setValue(models);
                    CreateTable();
                    CreateChart(id);
                }
            }
        });
    }

    public void setData(ReportSelectionModel model, Context context, TableLayout tableLayout, BarChart barChart) {
        this.model = model;
        this.context = context;
        repository.getReportForDepartment(model);
        this.tableLayout = tableLayout;
        this.barChart = barChart;
    }

    public void CreateTable() {
        ArrayList<TableReportModel> arrayList = tableData.getValue();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TableReportModel model = arrayList.get(i);

            TableRow row = new TableRow(context);
            TableRow.LayoutParams parameter = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(parameter);
            row.setGravity(17);

            TextView tvDepartment = new TextView(context);
            tvDepartment.setText(model.getName());
            tvDepartment.setTextSize(16);
            tvDepartment.setPadding(10, 2, 10, 2);

//            TextView tvTotal = new TextView(context);
//            tvTotal.setText(String.valueOf(model.getSuccess()+model.getFailure()));
//            tvTotal.setTextSize(16);
//            tvTotal.setPadding(10, 2, 10, 2);

            TextView tvAccepted = new TextView(context);
            tvAccepted.setText(String.valueOf(model.getSuccess()));
            tvAccepted.setTextSize(16);
            tvAccepted.setPadding(10, 2, 10, 2);

            TextView tvRejected = new TextView(context);
            tvRejected.setText(String.valueOf(model.getFailure()));
            tvRejected.setTextSize(16);
            tvRejected.setPadding(10, 2, 10, 2);

            row.addView(tvDepartment);
            row.addView(tvAccepted);
            row.addView(tvRejected);
            //  row.addView(tvTotal);

            tvDepartment.setBackground(ContextCompat.getDrawable(context, R.drawable.table_element_background));
            tvAccepted.setBackground(ContextCompat.getDrawable(context, R.drawable.table_element_background));
            tvRejected.setBackground(ContextCompat.getDrawable(context, R.drawable.table_element_background));
            //  tvTotal.setBackground(ContextCompat.getDrawable(context, R.drawable.table_element_background));


            tableLayout.addView(row);
        }
    }

    public void CreateChart(int id) {

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<TableReportModel> arrayList = tableData.getValue();
        for (int i = 0; i < arrayList.size(); i++) {
            TableReportModel model = arrayList.get(i);
            barEntries.add(new BarEntry(i, model.getSuccess()));
        }


//        XAxis xAxis = barChart.getXAxis();
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value) {
//                 super.getFormattedValue(value);
//                 if (id==ConstVariables.SECTION_REPORT_ID)
//                 return arrayList.get((int) value).getSection();
//                 if(id==ConstVariables.EMPLOYEE_REPORT_ID);
//                return arrayList.get((int) value).getPerformBy();
//            }
//        });
        BarDataSet barDataSet = new BarDataSet(barEntries,"Report");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barChart.getDescription().setEnabled(false);
        barChart.notifyDataSetChanged();
    }

    public String getDisplayName() {
        return displayName;
    }
}