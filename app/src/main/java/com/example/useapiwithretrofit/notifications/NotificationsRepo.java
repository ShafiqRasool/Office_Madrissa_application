package com.example.useapiwithretrofit.notifications;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.DB.NotificationDao;
import com.example.useapiwithretrofit.DB.NotificationDatabase;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsRepo {
    onNewNotifications newNotificationsObj;

    MutableLiveData<ArrayList<NotificationModel>> newNotificationsLiveData = new MutableLiveData<>();
    Context context;

    public NotificationsRepo(Application application) {
        this.context = application.getApplicationContext();
    }

    public void getNewNotifications(int EmpId) {
        API_Service service = RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<NotificationModel>> call = service.getNewNotifications(getToken(), 1990);
        call.enqueue(new Callback<ArrayList<NotificationModel>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<NotificationModel>> call, @NotNull Response<ArrayList<NotificationModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        newNotificationsLiveData.setValue(response.body());

                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ArrayList<NotificationModel>> call, @NotNull Throwable t) {
                Toast.makeText(context, "Data not found" + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getToken() {
        SharedPreferences preferences = context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        String mtoken = preferences.getString(String.valueOf(R.string.userToken), "null");
        String token = "bearer " + mtoken;
        return token;
    }

    public void setNewNotificationsObj(onNewNotifications newNotificationsObj) {
        this.newNotificationsObj = newNotificationsObj;
    }

    public interface onNewNotifications {
        void newData(ArrayList<NotificationModel> data);
    }


}
