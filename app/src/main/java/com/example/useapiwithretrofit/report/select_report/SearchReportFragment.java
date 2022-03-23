package com.example.useapiwithretrofit.report.select_report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentSearchReportBinding;


public class SearchReportFragment extends Fragment {

    FragmentSearchReportBinding mBinding;
    ReportViewModel viewModel;
    NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_report, container, false);
        navController = NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ReportViewModel.class);
        viewModel.setData(getViewLifecycleOwner(), requireActivity(), requireActivity(), navController);
        mBinding.setViewModel(viewModel);
    }

}