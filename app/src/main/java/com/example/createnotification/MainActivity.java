package com.example.createnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.createnotification.MyApplicaiton.CHANNEL_ID;
import static com.example.createnotification.MyApplicaiton.CHANNEL_ID_2;

public class MainActivity extends AppCompatActivity {
    private Button btnThongBao,btnthongbao2;
    private static final String title_notification = "Thông Báo!!!";
    private static final String content_notification = "Từ tối nay: sẽ di dời hơn 1.000 dân phường Thanh Xuân Trung (Hà Nội) đến Khu KTX Trường Đại học FPT. Nguyen Cong Chang";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThongBao = findViewById(R.id.BTNTHONGBAO);
        btnthongbao2 = findViewById(R.id.BTNTHONGBAO2);
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
        btnthongbao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification2();
            }
        });
    }
    private void createNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title_notification)
                .setContentText(content_notification)
                .setSmallIcon(R.drawable.user)
                .setColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark))
                //set BigText trong thong bao
                .setStyle(new NotificationCompat.BigTextStyle().bigText(content_notification))
                .setLargeIcon(bitmap)
                .build();
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (manager!=null){
//            manager.notify(1,notification);
//        }
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1,notification);
    }

    private void createNotification2() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.chang);
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID_2)
                .setContentTitle("Nguyen Cong Chang 2")
                .setContentText("Chang dz 2")
                .setSmallIcon(R.drawable.user)
                .setColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark))
                .setLargeIcon(bitmap)
                //set PictureStyle
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))

                .build();
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (manager!=null){
//            manager.notify(1,notification);
//        }
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(2,notification);
    }


}