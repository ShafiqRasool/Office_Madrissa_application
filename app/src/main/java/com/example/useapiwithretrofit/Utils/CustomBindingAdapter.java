package com.example.useapiwithretrofit.Utils;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.report.ReportModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class CustomBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:SetCustomAdapter")
    public static void setCustomAdapter(RecyclerView recyclerView,RecyclerView.Adapter<?> adapter){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("android:setBindingVisibility")
    public static void setVisibility(View view,boolean value){
        view.setVisibility((value)? View.GONE:View.VISIBLE);
    }
    @BindingAdapter("android:setCustomChecked")
    public static void setChecked(SwitchCompat switchCompat,boolean status){
        if(status){
            switchCompat.setChecked(true);
        }else{
            switchCompat.setChecked(false);
        }
    }
    @BindingAdapter("setCustomSpinnerAdapter")
    public static void setCustomSpinnerAdapter(AutoCompleteTextView spinner, ArrayAdapter<?> adapter){
       spinner.setAdapter(adapter);

    }


}
