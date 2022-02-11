package com.example.useapiwithretrofit.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.useapiwithretrofit.Notifications.NotificationModel;

@Database(entities = {NotificationModel.class} ,version = 1,exportSchema = false)
public abstract class NotificationDatabase extends RoomDatabase {
    public abstract NotificationDao dao();
    private static NotificationDatabase Instance;
    public static synchronized NotificationDatabase getInstance(Context ctx){
        if(Instance==null){
            Instance=Room.databaseBuilder(ctx,NotificationDatabase.class,"NotificationDatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Instance;
    }


}
