package com.example.useapiwithretrofit.operations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentDashboardBinding;
import com.example.useapiwithretrofit.model.UserOperationsModel;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class FragmentOperations extends Fragment {
     FragmentDashboardBinding mBinding;
    ArrayList<UserOperationsModel> userOperationsModelArrayList=new ArrayList<>();
     OperationsViewModel viewModel;
    public static SaveOperationsResponse saveResponse;
    NavController navController;
    static int EmpId;
    static String date;
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard,container,false);
        navController= NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OperationAdapter adapter=new OperationAdapter();

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mBinding.recyclerView.setAdapter(adapter);

        date=FragmentOperationsArgs.fromBundle(getArguments()).getDate().replace("-","");
        viewModel=new ViewModelProvider(this).get(OperationsViewModel.class);
        viewModel.setInitData(date,requireActivity(),requireContext());
        viewModel.setNavController(navController);
        mBinding.setOperationsViewModel(viewModel);

    }

}