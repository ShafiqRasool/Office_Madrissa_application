package com.example.useapiwithretrofit.operations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.useapiwithretrofit.databinding.FragmentOperationsSavedBinding;

public class OperationsSavedFragment extends Fragment {
    FragmentOperationsSavedBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentOperationsSavedBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    void setupViews() {
        SaveOperationsResponse response = FragmentOperations.saveResponse;
        if (response != null) {
            mBinding.Code.setText(response.getCode());
            mBinding.CrudNo.setText(String.valueOf(response.getCrudNo()));
            mBinding.EmailAddress.setText(response.getEmailAddress());
            mBinding.EmailHost.setText(response.getEmailHost());
            mBinding.EmailPassword.setText(response.getEmailPassword());
            mBinding.ID.setText(String.valueOf(response.getId()));
            mBinding.NotifyMessage.setText(response.getNotifyMessage());
            mBinding.RcKey.setText(String.valueOf(response.getRcKey()));
            mBinding.ReturnId.setText(String.valueOf(response.getReturnId()));
            mBinding.Status.setText(String.valueOf(response.getStatus()));
            mBinding.StrMessage.setText(response.getStrMessage());
            mBinding.UserName.setText(response.getUserName());
        }

    }
}