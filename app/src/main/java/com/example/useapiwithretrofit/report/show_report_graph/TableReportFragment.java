package com.example.useapiwithretrofit.report.show_report_graph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.databinding.TableReportFragmentBinding;
import com.example.useapiwithretrofit.report.select_report.ReportSelectionModel;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class TableReportFragment extends Fragment {

    TableReportFragmentBinding mBinding;
    private TableReportViewModel mViewModel;

    public static TableReportFragment newInstance() {
        return new TableReportFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.table_report_fragment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ReportSelectionModel model=TableReportFragmentArgs.fromBundle(getArguments()).getReportSelection();
        mViewModel = new ViewModelProvider(this).get(TableReportViewModel.class);
        mViewModel.setData(model);
        setUpData();
        mBinding.setViewModel(mViewModel);

    }
    public void setUpData(){
        mViewModel.getTableData().observe(getViewLifecycleOwner(), new Observer<ArrayList<TableReportModel>>() {
            @Override
            public void onChanged(ArrayList<TableReportModel> tableReportModels) {
                if(tableReportModels!=null){
                    CreateTable(tableReportModels);
                    CreateChart(tableReportModels,mViewModel.getId());
                }
            }
        });
    }

    public void CreateTable(ArrayList<TableReportModel> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {
            TableReportModel model = arrayList.get(i);

            TableRow row = new TableRow(requireContext());
            TableRow.LayoutParams parameter = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(parameter);
            row.setGravity(17);

            TextView tvDepartment = new TextView(requireContext());
            tvDepartment.setText(model.getName());
            tvDepartment.setTextSize(16);
            tvDepartment.setPadding(10, 2, 10, 2);

//            TextView tvTotal = new TextView(context);
//            tvTotal.setText(String.valueOf(model.getSuccess()+model.getFailure()));
//            tvTotal.setTextSize(16);
//            tvTotal.setPadding(10, 2, 10, 2);

            TextView tvAccepted = new TextView(requireContext());
            tvAccepted.setText(String.valueOf(model.getSuccess()));
            tvAccepted.setTextSize(16);
            tvAccepted.setPadding(10, 2, 10, 2);

            TextView tvRejected = new TextView(requireContext());
            tvRejected.setText(String.valueOf(model.getFailure()));
            tvRejected.setTextSize(16);
            tvRejected.setPadding(10, 2, 10, 2);

            row.addView(tvDepartment);
            row.addView(tvAccepted);
            row.addView(tvRejected);
            //  row.addView(tvTotal);

            tvDepartment.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            tvAccepted.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            tvRejected.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.table_element_background));
            //  tvTotal.setBackground(ContextCompat.getDrawable(context, R.drawable.table_element_background));


            mBinding.tableLayout.addView(row);
        }
    }


    public void CreateChart(ArrayList<TableReportModel> arrayList, int id) {
        mBinding.BarChart.setPinchZoom(false);
        mBinding.BarChart.setGridBackgroundColor(R.color.green);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            TableReportModel model = arrayList.get(i);
            barEntries.add(new BarEntry(i, model.getSuccess()));
        }


        XAxis xAxis = mBinding.BarChart.getXAxis();
        xAxis.setLabelCount(1);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                super.getFormattedValue(value);
                if (id == ConstVariables.SECTION_REPORT_ID)
                    return arrayList.get((int) value).getSection();
                else if (id == ConstVariables.DEPARTMENT_REPORT_ID)
                    return arrayList.get((int) value).getDepartmentName();
                else if (id == ConstVariables.EMPLOYEE_REPORT_ID)
                    return arrayList.get((int) value).getPerformBy();
                return null;
            }
        });
        BarDataSet barDataSet = new BarDataSet(barEntries, "Report");
        BarData barData = new BarData(barDataSet);
        mBinding.BarChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        mBinding.BarChart.getDescription().setEnabled(false);
        mBinding.BarChart.notifyDataSetChanged();
        mBinding.BarChart.invalidate();
    }

}