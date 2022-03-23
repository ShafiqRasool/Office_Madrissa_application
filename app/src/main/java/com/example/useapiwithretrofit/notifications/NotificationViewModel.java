package com.example.useapiwithretrofit.notifications;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.useapiwithretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NotificationViewModel extends AndroidViewModel {
    LiveData<ArrayList<NotificationModel>> notificationsListLiveData;
    NotificationsRepo repo;
    NotificationAdapter adapter;

    public NotificationViewModel(@NonNull @NotNull Application application) {
        super(application);
        repo = new NotificationsRepo(application);
        adapter=new NotificationAdapter();
        getNotifications();
    }

    public void getNotifications() {
        SharedPreferences preferences = getReadSharedPreferece();
       int empId = preferences.getInt(String.valueOf(R.string.empId), 0);
         repo.getNewNotifications(empId);
        repo.setNewNotificationsObj(new NotificationsRepo.onNewNotifications() {
            @Override
            public void newData(ArrayList<NotificationModel> data) {
                if(data!=null)
                adapter.setResults(data);
            }
        });
    }

    public NotificationAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(NotificationAdapter adapter) {
        this.adapter = adapter;
    }

    public LiveData<ArrayList<NotificationModel>> getLiveNotifications() {
        return notificationsListLiveData;
    }

    private SharedPreferences getReadSharedPreferece() {
        SharedPreferences preferences = getApplication().getApplicationContext().getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences;
    }


}
