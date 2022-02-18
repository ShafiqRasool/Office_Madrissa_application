package com.example.useapiwithretrofit.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.databinding.CardViewOrdersBinding;

import java.util.ArrayList;

public class SimpleReportAdapter extends RecyclerView.Adapter<SimpleReportAdapter.SimpleReportViewHolder> {

    private ArrayList<OperationSimpleReportModel> arrayList=new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public SimpleReportAdapter(ArrayList<OperationSimpleReportModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SimpleReportViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        if(inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        CardViewOrdersBinding binding=CardViewOrdersBinding.inflate(inflater);
        return new SimpleReportViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleReportAdapter.SimpleReportViewHolder holder, int position) {
        OperationSimpleReportModel model=arrayList.get(position);
        holder.mBinding.tvDepartment.setText(model.getDepartment());
        holder.mBinding.tvOperation.setText(model.getOperation());
        holder.mBinding.tvPerformedBy.setText(model.getPerformedBy());
        holder.mBinding.tvRemarks.setText(model.getRemarks());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class SimpleReportViewHolder extends RecyclerView.ViewHolder {

        CardViewOrdersBinding mBinding;
    public SimpleReportViewHolder(@NonNull  CardViewOrdersBinding binding) {
        super(binding.getRoot());
        mBinding=binding;
    }
}
}
