package com.example.useapiwithretrofit.DB;

import com.example.useapiwithretrofit.Notifications.NotificationModel;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.OperationsSavedModel;
import com.example.useapiwithretrofit.model.PendingModel;
import com.example.useapiwithretrofit.Operations.SaveOperationsResponse;
import com.example.useapiwithretrofit.model.UserOperationsModel;
import com.example.useapiwithretrofit.model.User_model;
import com.example.useapiwithretrofit.model.UserTokenModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API_Service {

    @FormUrlEncoded
    @POST("token")
    Call<UserTokenModel> getUserToken(@Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);

    @GET("api/AppUser/GetUserInfo")
    Call<User_model> getuserInfo(@Header ("Authorization") String auth,@Query("username") String username, @Query("password") String password);

    @GET("api/AppApi/GetOprList")
    Call<ArrayList<UserOperationsModel>> getOperations(@Header ("Authorization") String auth,@Query("Emp_Id") Integer empId);

    @GET("api/AppApi/AMIC_Read_Notification")
    Call<ArrayList<NotificationModel>>  getNewNotifications(@Header ("Authorization") String auth,@Query("Emp_Id") Integer empId);

    @GET("api/DailyOprActivities/Get_Kpi_Operations_Pending_List")
    Call<ArrayList<PendingModel>>  getPendingOperation(@Header ("Authorization") String auth,@Query("Emp_id") Integer empId);

    @GET("api/DailyOprActivities/Get_Kpi_Operations")
    Call<ArrayList<OperationsModel>>  getDailyNotifications(@Header ("Authorization") String auth, @Query("Emp_id") int empId, @Query("Opr_Trans_Date") String operationsDate);
    @POST("api/DailyOprActivities/Save_Kpi_Operations")
    Call<OperationsSavedModel> saveDailyOperationsList(@Header ("Authorization") String auth, @Body ArrayList<OperationsModel> arrayList);
}
