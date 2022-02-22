package com.example.useapiwithretrofit.report;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
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
import com.example.useapiwithretrofit.databinding.FragmentSearchReportBinding;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class SearchReportFragment extends Fragment {

    FragmentSearchReportBinding mBinding;
    ReportViewModel viewModel;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_report, container, false);
        navController= NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ReportViewModel.class);
        viewModel.setDate(getViewLifecycleOwner(),requireActivity(),requireActivity(),navController);
        mBinding.setViewModel(viewModel);
        initData();
    }


    public void initData(){
        mBinding.tvDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(mBinding.tvDateFrom);
            }
        });
        mBinding.tvDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(mBinding.tvDateTo);
            }
        });
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


    public void setDate(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                StringBuilder builder=new StringBuilder();
                builder.append(i);
                builder.append("-");
                if(i1<10){
                    builder.append("0").append((i1+1));
                }else{
                    builder.append(i1+1);
                }
                builder.append("-");
                builder.append(i2);
                textView.setText(builder);
            }
        }, year, month, day);
        dialog.show();
    }

    private void setupRecyclerViewItems() {
        ArrayList<OperationSimpleReportModel> arrayList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            OperationSimpleReportModel model = new OperationSimpleReportModel();
            model.setDate("2/3/2022");
            model.setDepartment("department" + i);
            model.setOperation("operation" + i);
            model.setStatus("status" + i);
            model.setRemarks("Remark" + i);
            model.setPerformedBy("performed by" + i);
            arrayList.add(model);
        }

        SimpleReportAdapter adapter = new SimpleReportAdapter(arrayList, requireContext());

    }


    void createTable(ArrayList<DepartmentWiseReportModel> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            DepartmentWiseReportModel model = arrayList.get(i);
            //TableLayout tableLayout = mBinding.tableLayout;
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


          //  tableLayout.addView(row);
        }
    }

    void setupBarChart(ArrayList<DepartmentWiseReportModel> arrayList) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            DepartmentWiseReportModel model = arrayList.get(i);
            int y = model.getAccepted();
            barEntries.add(new BarEntry(i, y));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Department Wise Report");
        BarData barData = new BarData(barDataSet);
       // mBinding.barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
      //  mBinding.barChart.getDescription().setEnabled(false);

    }
}