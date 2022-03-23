package com.example.useapiwithretrofit.report.select_report;

import android.app.Activity;
import android.app.Application;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;


import com.example.useapiwithretrofit.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ReportViewModel extends AndroidViewModel {

    private final MutableLiveData<ArrayList<ReportModel>> priorityLiveList = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> profileLiveList = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> departmentLiveList = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ReportModel>> locationLiveList = new MutableLiveData<>();
    private final List<String> listProfile = new ArrayList<>();
    private final List<String> listPriority = new ArrayList<>();
    private final List<String> listDepartment = new ArrayList<>();
    private final List<String> listLocation = new ArrayList<>();
    private final ReportSelectionModel reportSelectionModel;
    private final ReportRepo repo;
    List<String> statusList = new ArrayList<>();
    private ArrayAdapter<String> adapterProfile;
    private ArrayAdapter<String> adapterPriority;
    private ArrayAdapter<String> adapterDepartment;
    private ArrayAdapter<String> adapterLocation;
    private ArrayAdapter<String> adapterStatus;
    private ObservableField<String> selectedProfile = new ObservableField<>();
    private ObservableField<String> selectedPriority = new ObservableField<>();
    private ObservableField<String> selectedDepartment = new ObservableField<>();
    private ObservableField<String> selectedLocation = new ObservableField<>();
    private ObservableField<String> selectedStatus = new ObservableField<>();
    private ObservableField<String> formDate = new ObservableField<>("Form Date");
    private ObservableField<String> toDate = new ObservableField<>("To Date");

    private LifecycleOwner lifecycleOwner;
    private Context context;
    private Activity activity;
    private NavController navController;

    public ReportViewModel(@NonNull Application application) {
        super(application);

        repo = new ReportRepo(application);
        repo.getFillLocations(1);
        repo.getDepartments(1, 1);
        repo.getEmployees(1, 1, 1);
        repo.getPriority();
        reportSelectionModel = new ReportSelectionModel();
        statusList.add("All");
        statusList.add("failure");
        statusList.add("Success");
        getSpinnerListDate();


    }


    private void getSpinnerListDate() {
        repo.setOnGetList((model, key) -> {
            if (key == 1) {
                priorityLiveList.setValue(model);
            } else if (key == 2) {
                departmentLiveList.setValue(model);
            } else if (key == 3) {
                locationLiveList.setValue(model);
            } else if (key == 4) {
                profileLiveList.setValue(model);
            }
        });
    }

    public void TransmitData() {

        reportSelectionModel.setSelectedDepartment(listDepartment.indexOf(selectedDepartment.get()));
        reportSelectionModel.setSelectedLocation(listLocation.indexOf(selectedLocation.get()));
        reportSelectionModel.setSelectedPriority(selectedPriority.get());
        reportSelectionModel.setSelectedProfile(listProfile.indexOf(selectedProfile.get()));
        reportSelectionModel.setSelectedStatus(statusList.indexOf(selectedStatus.get()));
        reportSelectionModel.setFromDate(formDate.get().replace("-", ""));
        reportSelectionModel.setToDate(toDate.get().replace("-", ""));
        NavDirections directions = SearchReportFragmentDirections.actionSearchReportFragmentToReportTypeFragment(reportSelectionModel);
        navController.navigate(directions);
    }

    private void setObserversToData() {

        adapterPriority = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listPriority);
        adapterLocation = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listLocation);
        adapterProfile = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listProfile);
        adapterDepartment = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, listDepartment);
        adapterStatus = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, statusList);
        profileLiveList.observe(lifecycleOwner, reportModels -> {
            if (reportModels != null) {
                listProfile.clear();
                listProfile.add("ALL");
                for (ReportModel model : reportModels) {
                    listProfile.add(model.getText());
                }
                adapterProfile.notifyDataSetChanged();
            }
        });

        priorityLiveList.observe(lifecycleOwner, reportModels -> {
            if (reportModels != null) {
                listPriority.clear();
                listPriority.add("All");
                for (ReportModel model : reportModels) {
                    listPriority.add(model.getText());
                }
                adapterPriority.notifyDataSetChanged();
            }
        });

        departmentLiveList.observe(lifecycleOwner, reportModels -> {
            if (reportModels != null) {
                listDepartment.clear();
                listDepartment.add("ALL");
                for (ReportModel model : reportModels) {
                    listDepartment.add(model.getText());
                }
                adapterDepartment.notifyDataSetChanged();
            }
        });
        locationLiveList.observe(lifecycleOwner, reportModels -> {
            if (reportModels != null) {
                listLocation.clear();
                listLocation.add("ALL");
                for (ReportModel model : reportModels) {
                    listLocation.add(model.getText());
                }
                adapterLocation.notifyDataSetChanged();
            }
        });


    }

    public void setData(LifecycleOwner lifecycleOwner, Context context, Activity activity, NavController navController) {
        this.lifecycleOwner = lifecycleOwner;
        this.context = context;
        this.activity = activity;
        this.navController = navController;
        setObserversToData();
    }

    public void setDate(View view) {
        TextView textView = (TextView) view;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(context, (datePicker, i, i1, i2) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            builder.append("-");
            if (i1 < 9) {
                builder.append("0").append((i1 + 1));
            } else {
                builder.append(i1 + 1);
            }
            builder.append("-");
            if (i2 < 10) {
                builder.append("0");
            }
            builder.append(i2);
            textView.setText(builder.toString());
        }, year, month, day);
        dialog.show();
    }

    ////////////////GETTERS , SETTERS //////////////

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

    public void setSelectedStatus(ObservableField<String> selectedStatus) {
        this.selectedStatus = selectedStatus;
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
}
