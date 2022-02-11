package com.example.useapiwithretrofit.Home;

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

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeFragment extends Fragment {
    FragmentHomeBinding mBinding;
    NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//
//    @Override
//    public void onAttach(@NonNull  Context context) {
//        super.onAttach(context);
//         requireActivity().getOnBackPressedDispatcher().addCallback(this,backPressedCallback);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navController= NavHostFragment.findNavController(this);
        mBinding=FragmentHomeBinding.inflate(getLayoutInflater());
        BottomNavigationView navigationView=(getActivity()).findViewById(R.id.bottom_navigation);
        navigationView.setVisibility(View.VISIBLE);
        DrawerLayout navDrawer=(getActivity()).findViewById(R.id.drawer_layout);
        navDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
//    OnBackPressedCallback backPressedCallback=new OnBackPressedCallback(true) {
//        @Override
//        public void handleOnBackPressed() {
//            (requireActivity()).onBackPressed();
//        }
//    };
}