package com.example.useapiwithretrofit.report.report_type_selection;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

import com.example.useapiwithretrofit.Utils.ConstVariables;
import com.example.useapiwithretrofit.report.select_report.ReportSelectionModel;

public class ReportTypeViewModel extends AndroidViewModel {
    private ReportSelectionModel model;
    private NavController navController;

    public ReportTypeViewModel(@NonNull Application application) {
        super(application);
    }

    public void setData(ReportSelectionModel model, NavController navController) {
        this.model = model;
        this.navController = navController;
    }

    public void gotoOperationWise() {
        NavDirections directions = ReportTypeFragmentDirections.actionReportTypeFragmentToFragmentShowReport(model);
        navController.navigate(directions);
    }

    public void gotoDepartmentWise() {
        model.setReportType(ConstVariables.DEPARTMENT_REPORT_ID);
        NavDirections directions = ReportTypeFragmentDirections.actionReportTypeFragmentToTableReportFragment(model);
        navController.navigate(directions);
    }

    public void gotoEmployeeWise() {
        model.setReportType(ConstVariables.EMPLOYEE_REPORT_ID);
        NavDirections directions = ReportTypeFragmentDirections.actionReportTypeFragmentToTableReportFragment(model);
        navController.navigate(directions);
    }

    public void gotoSectionWise() {
        model.setReportType(ConstVariables.SECTION_REPORT_ID);
        NavDirections directions = ReportTypeFragmentDirections.actionReportTypeFragmentToTableReportFragment(model);
        navController.navigate(directions);
    }
}
