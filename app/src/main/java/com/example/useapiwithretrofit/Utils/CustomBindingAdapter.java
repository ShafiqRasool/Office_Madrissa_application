package com.example.useapiwithretrofit.Utils;

import android.view.View;
import android.widget.AbsListView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

}
