package com.example.useapiwithretrofit.Utils;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.report.ReportModel;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class CustomBindingAdapter {
    @JvmStatic
    @BindingAdapter("app:SetCustomAdapter")
    public static void SetCustomAdapter(RecyclerView recyclerView,RecyclerView.Adapter<?> adapter){
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
    @BindingAdapter("android:setCustomSpinnerAdapter")
    public static void setCustomSpinnerAdapter(Spinner spinner, ArrayList<ReportModel> models){
        List<String> list =null;
        if(models!=null) {
            for (int x = 0; x < models.size(); x++) {
                list.add(models.get(x).getText());
            }
        }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
            spinner.setAdapter(adapter);

    }

}
