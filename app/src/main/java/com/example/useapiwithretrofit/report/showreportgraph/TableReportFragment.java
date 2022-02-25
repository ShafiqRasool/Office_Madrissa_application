package com.example.useapiwithretrofit.report.showreportgraph;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.TableReportFragmentBinding;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;

public class TableReportFragment extends Fragment {

    private TableReportViewModel mViewModel;
    TableReportFragmentBinding mBinding;
    public static TableReportFragment newInstance() {
        return new TableReportFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater,R.layout.table_report_fragment,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ReportSelectionModel model=TableReportFragmentArgs.fromBundle(getArguments()).getReportSelection();
        mViewModel = new ViewModelProvider(this).get(TableReportViewModel.class);
        mViewModel.setData(model,requireContext(), mBinding.tableLayout,mBinding.BarChart);
        mBinding.setViewModel(mViewModel);

    }
}