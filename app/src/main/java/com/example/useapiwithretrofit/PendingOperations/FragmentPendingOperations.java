package com.example.useapiwithretrofit.PendingOperations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentPendingOperationsBinding;
import com.example.useapiwithretrofit.model.PendingModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FragmentPendingOperations extends Fragment {
    FragmentPendingOperationsBinding mBinding;
    PendingViewModel viewModel;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_pending_operations,container,false);
        navController= NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PendingOperationsAdapter adapter=new PendingOperationsAdapter();
        mBinding.recyclerViewPending.setAdapter(adapter);
        adapter.setNavController(navController);
        viewModel=new ViewModelProvider(this).get(PendingViewModel.class);
        viewModel.getLivePending().observe(getViewLifecycleOwner(), new Observer<ArrayList<PendingModel>>() {
            @Override
            public void onChanged(ArrayList<PendingModel> modelArrayList) {
                adapter.setResult(modelArrayList);
                adapter.notifyDataSetChanged();
            }
        });

    }
}