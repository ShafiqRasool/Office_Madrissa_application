package com.example.useapiwithretrofit.Operations;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.useapiwithretrofit.databinding.LayoutCardViewOperationBinding;
import com.example.useapiwithretrofit.model.UserOperationsModel;

import java.util.ArrayList;


public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.viewHolder> {
    public static ArrayList<UserOperationsModel> modelArrayList=new ArrayList<>();
    private LayoutInflater inflater;

    public OperationAdapter(ArrayList<UserOperationsModel> modelArrayList) {
        OperationAdapter.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        LayoutCardViewOperationBinding binding=LayoutCardViewOperationBinding.inflate(inflater);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        UserOperationsModel model=modelArrayList.get(position);
        holder.mBinding.tvOperationCard.setText(model.getOprDesc());
        holder.mBinding.tvRemarksCard.setText(model.getOprRemarks());
        holder.mBinding.switchAction.setChecked(true);
        holder.mBinding.tvRemarksCard.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setOprRemarks(holder.mBinding.tvRemarksCard.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.mBinding.switchAction.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    holder.mBinding.viewRemark.setVisibility(View.INVISIBLE);
                    holder.mBinding.tvRemarksCard.setVisibility(View.GONE);
                }else {
                    holder.mBinding.tvRemarksCard.setVisibility(View.VISIBLE);
                    holder.mBinding.viewRemark.setVisibility(View.VISIBLE);
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
    }
}
