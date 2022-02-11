package com.example.useapiwithretrofit.DB;

import com.example.useapiwithretrofit.Notifications.NotificationModel;
import com.example.useapiwithretrofit.Operations.SaveOperationsResponse;
import com.example.useapiwithretrofit.Operations.UserOperationsModel;
import com.example.useapiwithretrofit.model.User_model;
import com.example.useapiwithretrofit.model.UserTokenModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_Service {

    @FormUrlEncoded
    @POST("token")
    Call<UserTokenModel> getUserToken(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);

    @GET("api/AppUser/GetUserInfo")
    Call<User_model> getuserInfo(@Query("username") String username, @Query("password") String password);

    @GET("api/AppApi/GetOprList")
    Call<ArrayList<UserOperationsModel>> getOperations(@Query("Emp_Id") Integer empId);

    @POST("api/AppApi/Opr_Activity_Exe")
    Call<SaveOperationsResponse> saveOperations(@Body ArrayList<UserOperationsModel>  operationsModels);

    @GET("api/AppApi/AMIC_Read_Notification")
    Call<ArrayList<NotificationModel>>  getNewNotifications(@Query("Emp_Id") Integer empId);


}
