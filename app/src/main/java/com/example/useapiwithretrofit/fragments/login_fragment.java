package com.example.useapiwithretrofit.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.model.User_model;
import com.example.useapiwithretrofit.databinding.FragmentLoginFragmentBinding;
import com.example.useapiwithretrofit.model.UserTokenModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login_fragment extends Fragment  {
    FragmentLoginFragmentBinding mBinding;
    NavController navController;
    ProgressDialog progressDialog;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    navController=NavHostFragment.findNavController(this);
    checkLoginStatus();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navController= NavHostFragment.findNavController(this);
        mBinding=FragmentLoginFragmentBinding.inflate(getLayoutInflater(),container,false);
        BottomNavigationView navigationView=(getActivity()).findViewById(R.id.bottom_navigation);
        navigationView.setVisibility(View.GONE);
        DrawerLayout navDrawer=(getActivity()).findViewById(R.id.drawer_layout);
        navDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressDialog=new ProgressDialog(requireContext());
        mBinding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
               String email= String.valueOf(mBinding.etEmail.getText());
                String password =String.valueOf(mBinding.etPassword.getText());
                if(!email.isEmpty()&&!password.isEmpty()){
                        getToken(email,password);
                        progressDialog.dismiss();
                }
            }
        });
    }


    void checkLoginStatus(){
        SharedPreferences preferences=getReadSharedPreference();
        boolean token=preferences.getBoolean(String.valueOf(R.string.loginStatus),false);
        if(token){
            navController.navigate(R.id.action_login_fragment_to_homeFragment);
        }
    }

    public void getToken(String email,String password){
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<UserTokenModel> token_call=service.getUserToken(email,password,"password");
        token_call.enqueue(new Callback<UserTokenModel>() {
            @Override
            public void onResponse(Call<UserTokenModel> call, Response<UserTokenModel> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        Toast.makeText(requireContext(),"token is -->"+ response.body().getAccessToken(), Toast.LENGTH_SHORT).show();
                        getUserData(email,password,response.body());
                        getSharedPreferencesEditor().putBoolean(String.valueOf(R.string.loginStatus),true).apply();
                        navController.navigate(R.id.action_login_fragment_to_homeFragment);
                    }
                }else{
                    Toast.makeText(requireContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserTokenModel> call, Throwable t) {
                Toast.makeText(requireContext(), "Wrong Email or Password"+t.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }



    public void getUserData(String username, String password, UserTokenModel token_model){

        API_Service service=RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<User_model> call=service.getuserInfo(username,password);
        call.enqueue(new Callback<User_model>() {
        @Override
        public void onResponse(@NotNull Call<User_model> call, @NotNull Response<User_model> response) {
           if(response.isSuccessful()){
               if(response.body()!=null){
                   User_model user_model=response.body();
                   Toast.makeText(requireContext(), "user email"+user_model.getEmail(), Toast.LENGTH_SHORT).show();
                   SharedPreferences.Editor editor=getSharedPreferencesEditor();
                   editor.putString(String.valueOf(R.string.userEmail),username);
                   editor.putString(String.valueOf(R.string.userPassword),password);
                   editor.putString(String.valueOf(R.string.userToken),"bearer "+token_model.getAccessToken());
                   editor.putBoolean(String.valueOf(R.string.loginStatus),true);
                   editor.putInt(String.valueOf(R.string.empId),user_model.getEmpId());
                   editor.apply();

               }
           }
        }

        @Override
        public void onFailure(@NotNull Call<User_model> call, @NotNull Throwable t) {
            progressDialog.dismiss();
        }
    });

    }
    SharedPreferences.Editor getSharedPreferencesEditor(){
        SharedPreferences preferences=getActivity().getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences.edit();
    }
    SharedPreferences getReadSharedPreference(){
        SharedPreferences preferences= getContext().getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        return preferences;
    }
}