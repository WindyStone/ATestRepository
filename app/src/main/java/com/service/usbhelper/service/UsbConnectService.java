package com.service.usbhelper.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.service.usbhelper.MyApplication;

public class UsbConnectService extends Service {
    private PendingIntent f319a;
    private C0256q f320b;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f320b = new C0256q(this);
        if (VERSION.SDK_INT < 14) {
            bindService(new Intent(this, HelperService.class), this.f320b, 1);
        } else {
            bindService(new Intent(this, HelperService.class), this.f320b, 64);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Builder builder = new Builder(MyApplication.getCt());
        this.f319a = PendingIntent.getService(this, 0, new Intent(), 0);
        builder.setSmallIcon(2130837510);
        builder.setContentTitle("");
        builder.setContentText("");
        builder.setContentIntent(this.f319a);
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130837510));
        Notification build = builder.build();
        build.flags = 32;
        startForeground(273, build);
        new Handler().postDelayed(new C0255p(this), 1000);
    }

    public void onDestroy() {
        try {
            unbindService(this.f320b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}
