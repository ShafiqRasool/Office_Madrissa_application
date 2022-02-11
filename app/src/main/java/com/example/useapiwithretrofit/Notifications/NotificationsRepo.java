package com.example.useapiwithretrofit.Notifications;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.NotificationDao;
import com.example.useapiwithretrofit.DB.NotificationDatabase;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsRepo {
    onNewNotifications newNotificationsObj;

    LiveData<List<NotificationModel>> NotificationListSaved;
    MutableLiveData<ArrayList<NotificationModel>> newNotificationsLiveData = new MutableLiveData<>();
    NotificationDao dao;
    Context context;

    public NotificationsRepo(Application application) {
        NotificationDatabase database = NotificationDatabase.getInstance(application);
        dao = database.dao();
        NotificationListSaved = dao.getSaveNotifications();
        this.context = application.getApplicationContext();
    }

    public LiveData<ArrayList<NotificationModel>> getNewNotifications(int EmpId) {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<NotificationModel>> call = service.getNewNotifications(EmpId);
        call.enqueue(new Callback<ArrayList<NotificationModel>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<NotificationModel>> call, @NotNull Response<ArrayList<NotificationModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        newNotificationsLiveData.setValue(response.body());
                       // dao.post(response.body());
                        //newNotificationsObj.newData(response.body());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<NotificationModel>> call, @NotNull Throwable t) {
                Toast.makeText(context, "Data not found"+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return newNotificationsLiveData;
    }


    public interface onNewNotifications {
        void newData(ArrayList<NotificationModel> data);
    }

    public void setNewNotificationsObj(onNewNotifications newNotificationsObj) {
        this.newNotificationsObj = newNotificationsObj;
    }


}
