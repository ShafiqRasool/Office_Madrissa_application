package com.example.useapiwithretrofit.model;

import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.example.useapiwithretrofit.Operations.FragmentOperations;
import com.example.useapiwithretrofit.Operations.OperationAdapter;
import com.example.useapiwithretrofit.Operations.OperationsRepo;

import java.util.ArrayList;

public class FragmentOperationModel {
    String save;
    String send;
    public static void saveOperations(){
        FragmentOperations.saveOperations();
    }
    public void sendOperations(){
        FragmentOperations.sendOperations();
    }
}
