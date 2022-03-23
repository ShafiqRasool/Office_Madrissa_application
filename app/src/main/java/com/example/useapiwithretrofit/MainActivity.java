package com.example.useapiwithretrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.useapiwithretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    NavController nav_controller;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        setUpNavigation();
        //  AppBarConfiguration appBarConfiguration=AppBarConfiguration(nav_controller.getGraph(),mainBinding.);
        nav_controller.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {

            }
        });
    }


    public void setUpNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        assert navHostFragment != null;
        nav_controller = navHostFragment.getNavController();

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(nav_controller.getGraph())
//                .setOpenableLayout(mainBinding.drawerLayout)
//                .build();
        NavigationUI.setupWithNavController(mainBinding.navigationView, nav_controller);
        NavigationUI.setupWithNavController(mainBinding.bottomNavigation, nav_controller);

    }

    @Override
    public void onBackPressed() {
        int current_des_id = nav_controller.getCurrentDestination().getId();
        if (current_des_id == R.id.homeFragment) {
            finish();
        } else if (mainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainBinding.drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
//       }else if(current_des_id==R.id.search_orders){
//            nav_controller.navigate(R.id.homeFragment);
//
//        }else if(current_des_id==R.id.notification2){
//            nav_controller.navigate(R.id.homeFragment);
//
//        }else if(current_des_id==R.id.about_us){
//            nav_controller.navigate(R.id.homeFragment);
//        }else {
        // }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("sad", "asdf");
        return super.onOptionsItemSelected(item);
    }
}