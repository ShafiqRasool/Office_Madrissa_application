package com.example.useapiwithretrofit.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.useapiwithretrofit.Notifications.NotificationModel;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void post(ArrayList<NotificationModel> notificationsList);
    @Query("SELECT * FROM notifications ORDER BY Id ASC")
    LiveData<List<NotificationModel>> getSaveNotifications();

}
