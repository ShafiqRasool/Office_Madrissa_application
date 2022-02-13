package com.example.useapiwithretrofit.Operations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.BR;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.LayoutCardViewOperationBinding;
import com.example.useapiwithretrofit.model.CustomOperationsClick;
import com.example.useapiwithretrofit.model.OperationsModel;

import java.util.ArrayList;


public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.viewHolder> {
    public static ArrayList<OperationsModel> modelArrayList=new ArrayList<>();
    private LayoutInflater inflater;

    public void setResult(ArrayList<OperationsModel> modelArrayList) {
        OperationAdapter.modelArrayList = modelArrayList;
    }

    public static ArrayList<OperationsModel> getModelArrayList() {
        return modelArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        LayoutCardViewOperationBinding mBinding= DataBindingUtil.inflate(inflater, R.layout.layout_card_view_operation,parent,false);
        return new viewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        OperationsModel model=modelArrayList.get(position);
        holder.bind(model);
        holder.mBinding.switchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.mBinding.switchAction.isChecked()){
                    holder.mBinding.tvRemarksCard.setVisibility(View.GONE);
                }else{
                    holder.mBinding.tvRemarksCard.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }




    public static class viewHolder extends RecyclerView.ViewHolder {
       LayoutCardViewOperationBinding mBinding;
        public viewHolder(@NonNull LayoutCardViewOperationBinding binding ) {
            super(binding.getRoot());
            mBinding=binding;
        }
        public void bind(Object obj){
            mBinding.setVariable(BR.operations,obj);
            mBinding.executePendingBindings();
        }

    }
    public interface OnRecyclerItemClicked{

    }
}
