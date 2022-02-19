package com.example.useapiwithretrofit.Notifications;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationViewModel extends AndroidViewModel {
    LiveData<ArrayList<NotificationModel>> notificationsListLiveData;
    NotificationsRepo repo;

    public NotificationViewModel(@NonNull @NotNull Application application) {
        super(application);
        repo = new NotificationsRepo(application);
        getNotifications();
    }

    public void getNotifications() {
        SharedPreferences preferences = getReadSharedPreferece();
        int empId = preferences.getInt(String.valueOf(R.string.empId), 0);
        notificationsListLiveData = repo.getNewNotifications(empId);
    }
    public LiveData<ArrayList<NotificationModel>> getLiveNotifications() {
        return notificationsListLiveData;
    }

    private SharedPreferences getReadSharedPreferece() {
        SharedPreferences preferences = getApplication().getApplicationContext().getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences;
    }


}
