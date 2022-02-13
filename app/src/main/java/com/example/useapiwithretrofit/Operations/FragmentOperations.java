package com.example.useapiwithretrofit.Operations;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentDashboardBinding;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.UserOperationsModel;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOperations extends Fragment {
     FragmentDashboardBinding mBinding;
    ArrayList<UserOperationsModel> userOperationsModelArrayList=new ArrayList<>();
    static OperationsViewModel viewModel;
    public static SaveOperationsResponse saveResponse;
    NavController navController;
    DateTime dateTime;
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

        String date=FragmentOperationsArgs.fromBundle(getArguments()).getDate();
        viewModel=new ViewModelProvider(this).get(OperationsViewModel.class);
        viewModel.setDate(date);

        SharedPreferences preferences= requireContext().getSharedPreferences(String.valueOf(R.string.file_name),Context.MODE_PRIVATE);
        int EmpId=preferences.getInt(String.valueOf(R.string.empId),0);
        viewModel.getLiveDailyOperations().observe(getViewLifecycleOwner(), new Observer<ArrayList<OperationsModel>>() {
            @Override
            public void onChanged(ArrayList<OperationsModel> modelArrayList) {
               for(int x=0;modelArrayList.size()>x;x++){
                   OperationsModel model=modelArrayList.get(x);
                   model.setOperationsTransDate(date);
                   model.setEmp_id(EmpId);
               }
                adapter.setResult(modelArrayList);
                adapter.notifyDataSetChanged();
            }
        });

    }



    public static void saveOperations(){
        Log.d("TAG", "saveOperations: in Fragment Operation");
        ArrayList<OperationsModel> operationsModels=OperationAdapter.getModelArrayList();
        for(int x=0;operationsModels.size()>x;x++) {
           OperationsModel model=operationsModels.get(x);
           model.setSend(false);
        }
            viewModel.saveOperations();
    }

    public static void sendOperations(){
        Log.d("TAG", "sendOperations: in Fragment Operation");
        ArrayList<OperationsModel> operationsModels=OperationAdapter.getModelArrayList();
        for(int x=0;operationsModels.size()>x;x++) {
            OperationsModel model=operationsModels.get(x);
            model.setSend(true);
        }
        viewModel.saveOperations();
    }






}