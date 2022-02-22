package com.example.useapiwithretrofit.report;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import com.example.useapiwithretrofit.PendingOperations.FragmentPendingOperationsDirections;
import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.report.models.ReportSelectionModel;

import java.util.ArrayList;
import java.util.List;


public class ReportViewModel extends AndroidViewModel {

    private final MutableLiveData<ArrayList<ReportModel>> priorityLiveList=new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> profileLiveList=new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> departmentLiveList=new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> locationLiveList=new MutableLiveData<>();

    private ArrayAdapter<String> adapterProfile;
    private ArrayAdapter<String> adapterPriority;
    private ArrayAdapter<String> adapterDepartment;
    private ArrayAdapter<String> adapterLocation;
    private ArrayAdapter<String> adapterStatus;

    private final List<String> listProfile = new ArrayList<>();
    private final List<String> listPriority = new ArrayList<>();
    private final List<String> listDepartment = new ArrayList<>();
    private final List<String> listLocation = new ArrayList<>();
    List<String> statusList=new ArrayList<String>();

    private ReportSelectionModel reportSelectionModel;
    private final ReportRepo repo;

    private  ObservableField<String> selectedProfile = new ObservableField<>();
    private  ObservableField<String> selectedPriority = new ObservableField<>();
    private  ObservableField<String> selectedDepartment = new ObservableField<>() ;
    private  ObservableField<String> selectedLocation = new ObservableField<>() ;
    private ObservableField<String> selectedStatus = new ObservableField<>();
    private ObservableField<String> formDate=new ObservableField<>();
    private ObservableField<String> toDate=new ObservableField<>();

    private LifecycleOwner lifecycleOwner;
    private Context context;
    private Activity activity;
    private NavController navController;

    public ReportViewModel(@NonNull Application application) {
        super(application);

        repo=new ReportRepo(application);
        repo.getFillLocations(1);
        repo.getDepartments(1,1);
        repo.getEmployees(1,1,1);
        repo.getPriority();
        reportSelectionModel=new ReportSelectionModel();
        statusList.add("ALL");
        statusList.add("failure");
        statusList.add("Success");
        getSpinnerListDate();


    }


    private void getSpinnerListDate() {
    repo.setOnGetList((model, key) -> {
        if(key==1){
            priorityLiveList.setValue(model);
        }else if(key==2){
            departmentLiveList.setValue(model);
        }else if(key==3){
            locationLiveList.setValue(model);
        }else if(key==4){
            profileLiveList.setValue(model);
        }
    });
    }

    public void TransmitData(){

        reportSelectionModel.setSelectedDepartment(listDepartment.indexOf(selectedDepartment.get()));
        reportSelectionModel.setSelectedLocation(listLocation.indexOf(selectedLocation.get()));
        reportSelectionModel.setSelectedPriority(listPriority.indexOf(selectedPriority.get()));
        reportSelectionModel.setSelectedProfile(listProfile.indexOf(selectedProfile.get()));
        reportSelectionModel.setSelectedStatus(statusList.indexOf(selectedStatus.get()));
        reportSelectionModel.setFromDate(formDate.get());
        reportSelectionModel.setToDate(toDate.get());
        NavDirections directions=SearchReportFragmentDirections.actionSearchReportFragmentToReportTypeFragment(reportSelectionModel);
        navController.navigate(directions);
    }

    private void setObserversToData() {

        adapterPriority = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listPriority);
        adapterLocation = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listLocation);
        adapterProfile = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listProfile);
        adapterDepartment = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listDepartment);
        adapterStatus = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, statusList);


        profileLiveList.observe(lifecycleOwner, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if (reportModels != null) {
                    listProfile.add("ALL");
                    for (ReportModel model : reportModels) {
                        listProfile.add(model.getText());
                    }
                    adapterProfile.notifyDataSetChanged();
                }
            }
        });

        priorityLiveList.observe(lifecycleOwner, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if (reportModels != null) {
                    listPriority.add("ALL");
                    for (ReportModel model : reportModels) {
                        listPriority.add(model.getText());
                    }
                    adapterPriority.notifyDataSetChanged();
                }
            }
        });

        departmentLiveList.observe(lifecycleOwner, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if (reportModels != null) {
                    listDepartment.add("ALL");
                    for (ReportModel model : reportModels) {
                        listDepartment.add(model.getText());
                    }
                    adapterDepartment.notifyDataSetChanged();
                }
            }
        });
        locationLiveList.observe(lifecycleOwner, new Observer<ArrayList<ReportModel>>() {
            @Override
            public void onChanged(ArrayList<ReportModel> reportModels) {
                if (reportModels != null) {
                    listLocation.add("ALL");
                    for (ReportModel model : reportModels) {
                        listLocation.add(model.getText());
                    }
                    adapterLocation.notifyDataSetChanged();
                }
            }
        });


    }

    public void setDate(LifecycleOwner lifecycleOwner, Context context, Activity activity, NavController navController){
        this.lifecycleOwner=lifecycleOwner;
        this.context=context;
        this.activity=activity;
        this.navController=navController;
        setObserversToData();
    }

    public ArrayAdapter<String> getAdapterProfile() {
        return adapterProfile;
    }

    public ArrayAdapter<String> getAdapterPriority() {
        return adapterPriority;
    }

    public ArrayAdapter<String> getAdapterDepartment() {
        return adapterDepartment;
    }

    public ArrayAdapter<String> getAdapterLocation() {
        return adapterLocation;
    }

    public ArrayAdapter<String> getAdapterStatus() {
        return adapterStatus;
    }

    public ObservableField<String> getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(ObservableField<String> selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    public ObservableField<String> getSelectedPriority() {
        return selectedPriority;
    }

    public void setSelectedPriority(ObservableField<String> selectedPriority) {
        this.selectedPriority = selectedPriority;
    }

    public ObservableField<String> getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(ObservableField<String> selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public ObservableField<String> getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(ObservableField<String> selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public ObservableField<String> getSelectedStatus() {
        return selectedStatus;
    }

    public ObservableField<String> getFormDate() {
        return formDate;
    }

    public void setFormDate(ObservableField<String> formDate) {
        this.formDate = formDate;
    }

    public ObservableField<String> getToDate() {
        return toDate;
    }

    public void setToDate(ObservableField<String> toDate) {
        this.toDate = toDate;
    }

    public void setSelectedStatus(ObservableField<String> selectedStatus) {
        this.selectedStatus = selectedStatus;
    }
}
