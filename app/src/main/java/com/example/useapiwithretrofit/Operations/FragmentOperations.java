package com.example.useapiwithretrofit.Operations;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.useapiwithretrofit.DB.API_Service;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.DB.RetrofitClientInstance;
import com.example.useapiwithretrofit.databinding.FragmentDashboardBinding;
import com.example.useapiwithretrofit.model.UserOperationsModel;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOperations extends Fragment {
     FragmentDashboardBinding mBinding;
    ArrayList<UserOperationsModel> userOperationsModelArrayList=new ArrayList<>();
    public static SaveOperationsResponse saveResponse;
    NavController navController;
    DateTime dateTime;
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding =FragmentDashboardBinding.inflate(getLayoutInflater());
        navController= NavHostFragment.findNavController(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDateOperations(1);
       getSelectedDate();
        mBinding.floatingButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOperations(OperationAdapter.modelArrayList);
            }
        });

    }

    private void getSelectedDate() {
        HorizontalPicker picker= mBinding.tvDateTop;
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        picker.setBackgroundColor(Color.WHITE);
        picker.setListener(new DatePickerListener() {
            @Override
            public void onDateSelected(DateTime dateSelected) {
                dateTime=dateSelected;

            }
        }).init();
        picker.setDate(new DateTime());
        picker.setDateSelectedColor((int ) R.color.custom_pink);

    }

    void setDateOperations(int empId){
        ProgressDialog dialog=new ProgressDialog(requireContext());
        dialog.setTitle("Loading...");
        dialog.show();

        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        Call<ArrayList<UserOperationsModel>> call=service.getOperations(getToken(),empId);
        call.enqueue(new Callback<ArrayList<UserOperationsModel>>() {
            @Override
            public void onResponse(@NotNull Call<ArrayList<UserOperationsModel>> call, @NotNull Response<ArrayList<UserOperationsModel>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        dialog.dismiss();
                        userOperationsModelArrayList=response.body();
                        Toast.makeText(requireContext(), "Data found", Toast.LENGTH_SHORT).show();
                        setAdapter();
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<ArrayList<UserOperationsModel>> call, @NotNull Throwable t) {
                dialog.dismiss();
                Toast.makeText(requireContext(), "Data Not found", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String getToken(){
        SharedPreferences preferences= getContext().getSharedPreferences(String.valueOf(R.string.file_name), Context.MODE_PRIVATE);
        String mtoken=preferences.getString(String.valueOf(R.string.userToken),"null");
        String token="bearer "+mtoken;
        return token;
    }




    private void saveOperations(ArrayList<UserOperationsModel> arrayList){
        ProgressDialog dialog=new ProgressDialog(requireContext());
        dialog.setTitle("Loading...");
        dialog.show();
        API_Service service= RetrofitClientInstance.getClientInstance().create(API_Service.class);
        for(int x=0;x<arrayList.size();x++){
            UserOperationsModel model= arrayList.get(x);
            model.setOprActivityExeDate(dateTime.toString(df.toPattern()));
        }


        Call<SaveOperationsResponse> call=service.saveOperations(getToken(),arrayList);
       call.enqueue(new Callback<SaveOperationsResponse>() {
           @Override
           public void onResponse(Call<SaveOperationsResponse> call, Response<SaveOperationsResponse> response) {
               if(response.isSuccessful()){
                   if(response.body()!=null){
                       dialog.dismiss();
                       saveResponse=response.body();
                      // navController.navigate(R.id.action_dashboard_fragment_to_operationsSavedFragment);
                   }
               }
           }
           @Override
           public void onFailure(Call<SaveOperationsResponse> call, Throwable t) {
               dialog.dismiss();
               Toast.makeText(requireContext(), "Operations Not Saved", Toast.LENGTH_SHORT).show();
           }
       });

    }

    private void setAdapter() {
        OperationAdapter adapter=new OperationAdapter(userOperationsModelArrayList);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mBinding.recyclerView.setAdapter(adapter);
    }

}