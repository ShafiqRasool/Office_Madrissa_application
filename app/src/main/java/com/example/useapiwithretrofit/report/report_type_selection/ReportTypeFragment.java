package com.example.useapiwithretrofit.report.report_type_selection;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentReportTypeBinding;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;

public class ReportTypeFragment extends Fragment {

    FragmentReportTypeBinding mBinding;
    ReportTypeViewModel mViewModel;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_report_type,container,false);
        navController= NavHostFragment.findNavController(this);
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ReportSelectionModel model=ReportTypeFragmentArgs.fromBundle(getArguments()).getReportSelection();
        mViewModel=new ViewModelProvider(this).get(ReportTypeViewModel.class);
        mViewModel.setData(model,navController);
        mBinding.setViewModel(mViewModel);
    }
}