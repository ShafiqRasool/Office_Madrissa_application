package com.example.useapiwithretrofit.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.useapiwithretrofit.notifications.NotificationModel;

public abstract class NotificationDatabase extends RoomDatabase {
    private static NotificationDatabase Instance;

    public static synchronized NotificationDatabase getInstance(Context ctx) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(ctx, NotificationDatabase.class, "NotificationDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Instance;
    }

    public abstract NotificationDao dao();


}
