package com.example.useapiwithretrofit.notifications;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useapiwithretrofit.databinding.CardViewNotificationsBinding;
import com.example.useapiwithretrofit.databinding.SingleItemNotificationBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    ArrayList<NotificationModel> arrayList = new ArrayList<>();
    LayoutInflater inflater;

    public void setResults(ArrayList<NotificationModel> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        CardViewNotificationsBinding binding = CardViewNotificationsBinding.inflate(inflater);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.setView(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardViewNotificationsBinding binding;

        public ViewHolder(CardViewNotificationsBinding singleItemNotificationBinding) {
            super(singleItemNotificationBinding.getRoot());
            binding = singleItemNotificationBinding;
        }
        public void setView(NotificationModel model){
            binding.setViewModel(model);
            binding.executePendingBindings();
        }
    }
}
