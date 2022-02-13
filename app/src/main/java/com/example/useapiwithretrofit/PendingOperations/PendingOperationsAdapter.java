package com.example.useapiwithretrofit.PendingOperations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.BR;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.SingleItemPendingsBinding;
import com.example.useapiwithretrofit.generated.callback.OnClickListener;
import com.example.useapiwithretrofit.model.CustomClickListener;
import com.example.useapiwithretrofit.model.PendingModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PendingOperationsAdapter extends RecyclerView.Adapter<PendingOperationsAdapter.ViewHolder> implements CustomClickListener {
    ArrayList<PendingModel> arrayList=new ArrayList<>();
    NavController navController;
    LayoutInflater inflater;
    public void setResult(ArrayList<PendingModel> arrayList){
        this.arrayList=arrayList;
    }
    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if(inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        SingleItemPendingsBinding binding= DataBindingUtil.inflate(inflater, R.layout.single_item_pendings,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        PendingModel model=arrayList.get(position);
        holder.bind(model);
        holder.binding.cardViewPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections directions=FragmentPendingOperationsDirections.actionFragmentPendingOperationsToDashboardFragment(model.getDateString());
                navController.navigate(directions);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void clicked(PendingModel model) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SingleItemPendingsBinding binding;
        public ViewHolder(SingleItemPendingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Object obj){
            binding.setVariable(BR.pending,obj);
            binding.executePendingBindings();
        }


    }


}
