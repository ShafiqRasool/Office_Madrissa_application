package com.example.useapiwithretrofit.operations;

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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentDashboardBinding;

import org.jetbrains.annotations.NotNull;


public class FragmentOperations extends Fragment {
    public static SaveOperationsResponse saveResponse;
    static String date;
    FragmentDashboardBinding mBinding;
    OperationsViewModel viewModel;
    NavController navController;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        navController = NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OperationAdapter adapter = new OperationAdapter();

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mBinding.recyclerView.setAdapter(adapter);

        date = FragmentOperationsArgs.fromBundle(getArguments()).getDate().replace("-", "");
        viewModel = new ViewModelProvider(this).get(OperationsViewModel.class);
        viewModel.setInitData(date, requireActivity(), requireContext());
        viewModel.setNavController(navController);
        mBinding.setOperationsViewModel(viewModel);

    }

}