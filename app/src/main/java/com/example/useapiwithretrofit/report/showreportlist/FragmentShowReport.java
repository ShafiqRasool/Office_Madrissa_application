package com.example.useapiwithretrofit.report.showreportlist;

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
import com.example.useapiwithretrofit.databinding.FragmentShowReportBinding;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;

public class FragmentShowReport extends Fragment {

    private FragmentShowReportViewModel mViewModel;
    FragmentShowReportBinding mBinding;

    public static FragmentShowReport newInstance() {
        return new FragmentShowReport();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_show_report,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ReportSelectionModel model=FragmentShowReportArgs.fromBundle(getArguments()).getReportSelection();
    mViewModel = new ViewModelProvider(this).get(FragmentShowReportViewModel.class);
    mViewModel.setData(model);
    mBinding.setViewModel(mViewModel);

    }

}