package com.example.useapiwithretrofit.report.ReportTypeSelection;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentReportTypeBinding;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;

public class ReportTypeFragment extends Fragment {

    FragmentReportTypeBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_report_type,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ReportSelectionModel model=ReportTypeFragmentArgs.fromBundle(getArguments()).getReportSelection();
        Log.d(TAG, "onViewCreated: ");
        Toast.makeText(requireContext(), ""+model.getSelectedLocation(), Toast.LENGTH_SHORT).show();
    }
}