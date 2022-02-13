package com.example.useapiwithretrofit.Report;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentSearchOrdersBinding;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;


public class Report extends Fragment {
    String[] list_operations=new String[]{"Select operation","operation 1","operation 2","operation 3","operation 4","operation 5","operation 6"};
    String[] listStatus=new String[]{"Status","Accepted","Rejected"};
    String[] listPerformedBy=new String[]{"Performed By","person","department 2","department 3","department 4","department 5","department 6"};
    ArrayList<DepartmentWiseReportModel> departmentWiseReportModels;
    FragmentSearchOrdersBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding=FragmentSearchOrdersBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();

        mBinding.tvDateFrom.setOnClickListener(view1 -> getDate(mBinding.tvDateFrom));
        mBinding.tvDateTo.setOnClickListener(view12 -> getDate(mBinding.tvDateTo));
        initValues();
        setupRecyclerViewItems();

    }

    private void initValues() {
        departmentWiseReportModels=new ArrayList<>();
        for(int i=0;i<=20;i=i+2){
            DepartmentWiseReportModel model=new DepartmentWiseReportModel();
            model.setDepartment("department"+i);
            model.setAccepted(i);
            model.setRejected(i);
            model.setTotal(i);
            departmentWiseReportModels.add(model);
        }
        createTable(departmentWiseReportModels);
        setupBarChart(departmentWiseReportModels);

    }

    private void setupRecyclerViewItems() {
        ArrayList<OperationSimpleReportModel> arrayList=new ArrayList<>();
        for(int i=0;i<=20;i++){
            OperationSimpleReportModel model=new OperationSimpleReportModel();
            model.setDate("2/3/2022");
            model.setDepartment("department"+i);
            model.setOperation("operation"+i);
            model.setStatus("status"+i);
            model.setRemarks("Remark"+i);
            model.setPerformedBy("performed by"+i);
            arrayList.add(model);
        }

        SimpleReportAdapter adapter=new SimpleReportAdapter(arrayList,requireContext());
        mBinding.recyclerViewOrder.setLayoutManager(new GridLayoutManager(requireContext(),1));
        mBinding.recyclerViewOrder.setAdapter(adapter);

    }

    void setupView( ){
        ArrayAdapter<String> operationsAdapter=new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,list_operations);
        ArrayAdapter<String> statusAdapter=new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,listStatus);
        ArrayAdapter<String> performedByAdapter=new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,listPerformedBy);

        mBinding.spinnerOperations.setAdapter(operationsAdapter);
        mBinding.spinnerStatus.setAdapter(statusAdapter);
        mBinding.spinnerPerformBy.setAdapter(performedByAdapter);
    }
    private void getDate(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                StringBuilder builder = new StringBuilder();
                builder.append(i).append("/").append(i1 + 1).append("/").append(i2);
                textView.setText(builder);

            }
        }, year, month, day);
        datePickerDialog.show();
    }

    void createTable(ArrayList<DepartmentWiseReportModel> arrayList){
        int size=arrayList.size();
        for(int i=0;i<size;i++) {
            DepartmentWiseReportModel model=arrayList.get(i);
            TableLayout tableLayout = mBinding.tableLayout;
            TableRow row = new TableRow(requireContext());
            TableRow.LayoutParams parameter = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(parameter);
            row.setGravity(17);

            TextView tvDepartment = new TextView(requireContext());
            tvDepartment.setText(model.getDepartment());
            tvDepartment.setTextSize(16);
            tvDepartment.setPadding(10, 2, 10, 2);

            TextView tvTotal = new TextView(requireContext());
            tvTotal.setText(String.valueOf(model.getTotal()));
            tvTotal.setTextSize(16);
            tvTotal.setPadding(10, 2, 10, 2);

            TextView tvAccepted = new TextView(requireContext());
            tvAccepted.setText(String.valueOf(model.getAccepted()));
            tvAccepted.setTextSize(16);
            tvAccepted.setPadding(10, 2, 10, 2);

            TextView tvRejected = new TextView(requireContext());
            tvRejected.setText(String.valueOf(model.getRejected()));
            tvRejected.setTextSize(16);
            tvRejected.setPadding(10, 2, 10, 2);

            row.addView(tvDepartment);
            row.addView(tvTotal);
            row.addView(tvAccepted);
            row.addView(tvRejected);

            tvDepartment.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            tvTotal.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            tvAccepted.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            tvRejected.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));


            tableLayout.addView(row);
        }
    }

    void setupBarChart(ArrayList<DepartmentWiseReportModel> arrayList){
        ArrayList<BarEntry> barEntries=new ArrayList<>();
        for(int i=0;i<arrayList.size();i++){
            DepartmentWiseReportModel model=arrayList.get(i);
            int y= model.getAccepted();
            barEntries.add(new BarEntry(i,y));
        }

        BarDataSet barDataSet=new BarDataSet(barEntries,"Department Wise Report");
        BarData barData=new BarData(barDataSet);
        mBinding.barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        mBinding.barChart.getDescription().setEnabled(false);

    }
}



