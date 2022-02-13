package com.example.useapiwithretrofit.Utils;

import android.content.Context;

import com.example.useapiwithretrofit.R;

public class SharedPreferences {
    private static Context context;

    public void setContext(Context context) {
        SharedPreferences.context = context;
    }

    public SharedPreferences(Context context) {
        SharedPreferences.context = context;
    }

    public static String getToken(){
        android.content.SharedPreferences preferences=context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getString(String.valueOf(R.string.userToken),"null");
    }

    public static int getEmpId(){
        android.content.SharedPreferences preferences= context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getInt(String.valueOf(R.string.empId),0);
    }
}
