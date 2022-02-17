package com.example.useapiwithretrofit.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.useapiwithretrofit.R;

public class SharedPreferencesHelper {
    private  Context context;
    private static SharedPreferencesHelper Instance;
    private SharedPreferences preferences;

    public SharedPreferencesHelper(Context context) {
        this.context=context;
        if(preferences==null){
            preferences= (SharedPreferences) context.getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        }
    }

    public static synchronized SharedPreferencesHelper getInstance(Context context){
        if(Instance==null){
            Instance= (SharedPreferencesHelper) new SharedPreferencesHelper(context);
        }
        return Instance;
    }


    public String getToken(){
        return preferences.getString(String.valueOf(R.string.userToken),"");
    }

    public int getEmpId(){
        return preferences.getInt(String.valueOf(R.string.empId),0);
    }
}
