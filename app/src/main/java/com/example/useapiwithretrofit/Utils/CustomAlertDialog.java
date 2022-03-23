package com.example.useapiwithretrofit.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import com.example.useapiwithretrofit.databinding.CustomAlerDialogBinding;

public class CustomAlertDialog {
    private static CustomAlertDialog customAlertDialog;
    private Activity activity;

    public static synchronized CustomAlertDialog getInstance() {
        if (customAlertDialog == null) {
            customAlertDialog = new CustomAlertDialog();
        }
        return customAlertDialog;
    }

    public void showDialog(String message, String title, Activity activity, Context context) {
        this.activity = activity;
        CustomAlerDialogBinding dialogBinding = CustomAlerDialogBinding.inflate(activity.getLayoutInflater());
        AlertDialog alertDialog = new AlertDialog.Builder(context).setView(dialogBinding.getRoot()).setCancelable(true).create();
        dialogBinding.title.setText(title);
        dialogBinding.body.setText(message);
        alertDialog.show();

        dialogBinding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


    }

}
