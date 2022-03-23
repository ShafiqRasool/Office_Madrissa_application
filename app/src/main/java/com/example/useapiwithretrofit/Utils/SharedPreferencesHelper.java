package com.example.useapiwithretrofit.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.useapiwithretrofit.R;

public class SharedPreferencesHelper {
    private static SharedPreferencesHelper Instance;
    private Context context;
    private SharedPreferences preferences;

    public SharedPreferencesHelper(Context context) {
        this.context = context;
        if (preferences == null) {
            preferences = (SharedPreferences) context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        }
    }

    public static synchronized SharedPreferencesHelper getInstance(Context context) {
        if (Instance == null) {
            Instance = (SharedPreferencesHelper) new SharedPreferencesHelper(context);
        }
        return Instance;
    }

    public SharedPreferences.Editor edit() {
        return preferences.edit();
    }


    public String getToken() {
        return preferences.getString(String.valueOf(R.string.userToken), "");
    }

    public int getEmpId() {
        return preferences.getInt(String.valueOf(R.string.empId), 0);
    }

    public boolean GetLoginState() {
        return preferences.getBoolean(String.valueOf(R.string.loginStatus), false);
    }
}
