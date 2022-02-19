package com.example.useapiwithretrofit.report;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
    private final List<String> priorityList= new ArrayList<>();
    private final List<String> profileList=new ArrayList<>();
    private final List<String> departmentList=new ArrayList<>();
    private final List<String> locationList=new ArrayList<>();
    FragmentSearchReportBinding mBinding;
    ReportViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_search_report,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel= new ViewModelProvider(this).get(ReportViewModel.class);
        viewModel.setData(getActivity(),requireContext());
        initValues();
        mBinding.setViewModel(viewModel);





    }

    private void initValues() {
        viewModel.getProfileLiveList().observe((LifecycleOwner) this, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {

                if(reportModels!=null)
                {
                    for(ReportModel model : reportModels)
                    {
                        priorityList.add(model.getText());
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(requireContext(),R.layout.support_simple_spinner_dropdown_item,priorityList);
                    mBinding.spinnerOperations.setAdapter(adapter);
                }
            }
        });

        viewModel.getProfileLiveList().observe((LifecycleOwner) this, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if(reportModels!=null){
                    for(ReportModel model:reportModels){
                        profileList.add(model.getText());
                    }
                }
            }
        });
        viewModel.getDepartmentLiveList().observe((LifecycleOwner) this, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if(reportModels!=null){
                    for(ReportModel model:reportModels){
                        departmentList.add(model.getText());
                    }
                }
            }
        });
        viewModel.getLocationLiveList().observe((LifecycleOwner) this, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if(reportModels!=null){
                    for(ReportModel model:reportModels){
                        locationList.add(model.getText());
                    }
                }
            }
        });
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