package com.example.useapiwithretrofit.notifications;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.useapiwithretrofit.R;
import com.example.useapiwithretrofit.databinding.FragmentNotificationBinding;

import org.jetbrains.annotations.NotNull;

public class Notification extends Fragment {
    FragmentNotificationBinding mBinding;
    NotificationViewModel viewModel;
    NotificationAdapter adapter;
    NotificationManager mNotificationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotificationViewModel.class);
        mBinding.setViewModel(viewModel);

        // displayNotification();
//
//        PeriodicWorkRequest saveRequest =
//                new PeriodicWorkRequest.Builder(ReperateWork.class, 1000, TimeUnit.MILLISECONDS)
//                        // Constraints
//                        .build();
//
//        WorkManager
//                .getInstance(requireContext())
//                .enqueue(saveRequest);
//
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void displayNotification() {
        Log.i("Start", "notification");

        /* Invoking the default notification service */
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(requireContext());

        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("You've received new message.");
        mBuilder.setTicker("New Message Alert!");
        //mBuilder.setSmallIcon(R.drawable.woman);

        /* Increase notification number every time a new notification arrives */
        // mBuilder.setNumber(++numMessages);

        /* Add Big View Specific Configuration */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = new String("This is first line....");
        events[1] = new String("This is second line...");
        events[2] = new String("This is third line...");
        events[3] = new String("This is 4th line...");
        events[4] = new String("This is 5th line...");
        events[5] = new String("This is 6th line...");

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");

        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        mBuilder.setStyle(inboxStyle);

//        /* Creates an explicit intent for an Activity in your app */
//        Intent resultIntent = new Intent(this, MainActivity.class);
//
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(NotificationView.class);
//
//        /* Adds the Intent that starts the Activity to the top of the stack */
//        stackBuilder.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

//        mBuilder.setContentIntent(resultPendingIntent);
        // NotificationChannel channel=new NotificationChannel(,"mychannel",NotificationManager.IMPORTANCE_DEFAULT);
        // mNotificationManager = (NotificationManager) requireActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        /* notificationID allows you to update the notification later on. */
        // mNotificationManager.notify(15, mBuilder.build());
    }


}