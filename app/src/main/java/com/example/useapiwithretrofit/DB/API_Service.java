package com.example.useapiwithretrofit.DB;

import com.example.useapiwithretrofit.model.PendingModel;
import com.example.useapiwithretrofit.notifications.NotificationModel;
import com.example.useapiwithretrofit.model.OperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsModel;
import com.example.useapiwithretrofit.model.SaveOperationsResponse;
import com.example.useapiwithretrofit.model.UserOperationsModel;
import com.example.useapiwithretrofit.model.UserTokenModel;
import com.example.useapiwithretrofit.model.User_model;
import com.example.useapiwithretrofit.report.select_report.ReportModel;
import com.example.useapiwithretrofit.report.show_report_graph.TableReportModel;
import com.example.useapiwithretrofit.report.show_report_in_list.model.OperationsReportModel;

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
    Call<User_model> getuserInfo(@Header("Authorization") String auth, @Query("username") String username, @Query("password") String password);

    @GET("api/AppApi/GetOprList")
    Call<ArrayList<UserOperationsModel>> getOperations(@Header("Authorization") String auth, @Query("Emp_Id") Integer empId);

    @GET("api/DailyOprActivities/Get_SMS_By_Receiver")
    Call<ArrayList<NotificationModel>> getNewNotifications(@Header("Authorization") String auth, @Query("Receiver_Id") Integer empId);

    @GET("api/DailyOprActivities/Get_Kpi_Operations_Pending_List")
    Call<ArrayList<PendingModel>> getPendingOperation(@Header("Authorization") String auth, @Query("Emp_id") Integer empId);

    @GET("api/DailyOprActivities/Get_Kpi_Operations")
    Call<ArrayList<OperationsModel>> getDailyNotifications(@Header("Authorization") String auth, @Query("Emp_id") int empId, @Query("Opr_Trans_Date") String operationsDate);

    @POST("api/DailyOprActivities/Save_Kpi_Operations")
    Call<SaveOperationsResponse> saveDailyOperationsList(@Header("Authorization") String auth, @Body ArrayList<SaveOperationsModel> arrayList);


    ////////////////************************ REPORT SERVICES***************/////////////////////////////
    @GET("api/DDL/GetDDLPriority")
    Call<ArrayList<ReportModel>> getPriorityList(@Header("Authorization") String auth);

    @GET("api/DDL/GetDDLDepartment")
    Call<ArrayList<ReportModel>> getDepartments(@Header("Authorization") String auth, @Query("Company_Id") int companyId, @Query("Country_Id") int countryId);

    @GET("api/DDL/FillLocation")
    Call<ArrayList<ReportModel>> getFillLocations(@Header("Authorization") String auth, @Query("Company_Id") int companyId);

    @GET("api/DDL/GetDDLEmpProfile")
    Call<ArrayList<ReportModel>> getEmployees(@Header("Authorization") String auth, @Query("Company_Id") int companyId, @Query("Country_Id") int countryId, @Query("Location_Id") int LocationId);

    @GET("api/DailyOprActivities/Get_Kpi_Operations_Reports")
    Call<ArrayList<OperationsReportModel>> getOperationsReport(@Header("Authorization") String auth, @Query("From_date") String From_date, @Query("To_date") String To_date, @Query("Perform_by") int Perform_by,
                                                               @Query("Section_Id") int Section_Id, @Query("Department_id") int Department_id, @Query("Status") int Status, @Query("Priority") String Priority, @Query("Rpt_Id") int Rpt_Id);

    @GET("api/DailyOprActivities/Get_Kpi_Operations_Reports")
    Call<ArrayList<TableReportModel>> getTableReport(@Header("Authorization") String auth, @Query("From_date") String From_date, @Query("To_date") String To_date, @Query("Perform_by") int Perform_by,
                                                     @Query("Section_Id") int Section_Id, @Query("Department_id") int Department_id, @Query("Status") int Status, @Query("Priority") String Priority, @Query("Rpt_Id") int Rpt_Id);

}
