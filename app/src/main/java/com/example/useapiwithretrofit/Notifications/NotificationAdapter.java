package com.example.useapiwithretrofit.Notifications;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.databinding.SingleItemNotificationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    ArrayList<NotificationModel> arrayList = new ArrayList<>();
    LayoutInflater inflater;

    public void setResults(ArrayList<NotificationModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        SingleItemNotificationBinding binding = SingleItemNotificationBinding.inflate(inflater);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.binding.tvDescription.setText(arrayList.get(position).getNotiDesc());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        SingleItemNotificationBinding binding;

        public ViewHolder(SingleItemNotificationBinding singleItemNotificationBinding) {
            super(singleItemNotificationBinding.getRoot());
            binding = singleItemNotificationBinding;
        }
    }
}
