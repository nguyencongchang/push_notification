package com.example.createnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplicaiton extends Application {
    public static final String CHANNEL_ID = "channel changdz";
    public static final String CHANNEL_ID_2 = "channel changdz2";


    @Override
    public void onCreate() {
        createNotificationChannel();
        super.onCreate();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
           //config channel_2
            CharSequence name2 = getString(R.string.channel_name_2);
            String description2 = getString(R.string.channel_description_2);
            int importance2 = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel2 = new NotificationChannel(CHANNEL_ID_2, name2, importance2);
            channel2.setDescription(description2);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager!=null){
                notificationManager.createNotificationChannel(channel);
                notificationManager.createNotificationChannel(channel2);

            }
        }
    }
}
