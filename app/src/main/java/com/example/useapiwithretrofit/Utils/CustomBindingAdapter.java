package com.example.useapiwithretrofit.Utils;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.R;

import kotlin.jvm.JvmStatic;

public class CustomBindingAdapter {
    private static String TAG;

    @JvmStatic
    @BindingAdapter("app:SetCustomAdapter")
    public static void setCustomAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("android:setBindingVisibility")
    public static void setVisibility(View view, boolean value) {
        view.setVisibility((value) ? View.GONE : View.VISIBLE);
    }

    @BindingAdapter("android:setCustomChecked")
    public static void setChecked(SwitchCompat switchCompat, boolean status) {
        if (status) {
            switchCompat.setChecked(true);
        } else {
            switchCompat.setChecked(false);
        }
    }

    @BindingAdapter("setCustomSpinnerAdapter")
    public static void setCustomSpinnerAdapter(AutoCompleteTextView spinner, ArrayAdapter<?> adapter) {
        spinner.setAdapter(adapter);
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("setCustomeColor")
    public static void setCustomeColor(TextView textView,String text){
        if(text.equals("failure")){
            textView.setTextColor(ContextCompat.getColor(textView.getContext(),R.color.red));
        }else{
            textView.setTextColor(ContextCompat.getColor(textView.getContext(),R.color.green));
        }
    }
    @BindingAdapter("setDateToText")
    public static void SetFormatDateInString(TextView textView,String rawDatetime){
        if(rawDatetime!=null) {
            rawDatetime.substring(0, 9).replace("-", "");
            textView.setText(rawDatetime);
        }
    }

}
