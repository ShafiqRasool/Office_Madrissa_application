package com.example.useapiwithretrofit.report.showreportlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.CardViewOperationsReportBinding;
import com.example.useapiwithretrofit.report.showreportlist.model.OperationsReportModel;

import java.util.ArrayList;

public class ReportByOperationsAdapter extends RecyclerView.Adapter<ReportByOperationsAdapter.ViewHolder> {


    LayoutInflater inflater;
    ArrayList<OperationsReportModel> reportModelArrayList=new ArrayList<>();
    CardViewOperationsReportBinding mBinding;

    public void setReportModelArrayList(ArrayList<OperationsReportModel> reportModelArrayList) {
        this.reportModelArrayList = reportModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        mBinding= DataBindingUtil.inflate(inflater, R.layout.card_view_operations_report,parent,false);
        return new ViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OperationsReportModel model=reportModelArrayList.get(position);
        model.setOprTransDate(model.getOprTransDate().substring(0,10));
        holder.setView(model);
    }

    @Override
    public int getItemCount() {
        return reportModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardViewOperationsReportBinding cardBinding;
        public ViewHolder(CardViewOperationsReportBinding  cardViewOperationsReportBinding) {
            super(cardViewOperationsReportBinding.getRoot());
            cardBinding=cardViewOperationsReportBinding;
        }
        public void setView(OperationsReportModel model){
            cardBinding.setOperation(model);
            cardBinding.executePendingBindings();
        }
    }
}
