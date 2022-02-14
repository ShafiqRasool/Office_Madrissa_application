package com.example.useapiwithretrofit.Utils;

import android.content.Context;
import android.preference.PreferenceManager;

import com.example.useapiwithretrofit.R;

public class SharedPreferences {
    private  Context context;

    public void setContext(Context context) {this.context = context;
    }

    public SharedPreferences(Context context) {
        this.context = context;
    }

    public String getToken(){
        android.content.SharedPreferences preferences= context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getString(String.valueOf(R.string.userToken),"null");
    }

    public int getEmpId(){
        android.content.SharedPreferences preferences= context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.getInt(String.valueOf(R.string.empId),0);
    }
}
