package com.service.usbhelper.p015e;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import com.service.usbhelper.TwinkleActivity;

/* renamed from: com.service.usbhelper.e.c */
public class C0214c {
    private static int f265a;

    static {
        f265a = 0;
    }

    public static int m454a() {
        int i = f265a;
        f265a = i + 1;
        return i;
    }

    private static PendingIntent m455a(Context context, int i, String str) {
        Intent intent = new Intent(context, TwinkleActivity.class);
        intent.setFlags(268435456);
        switch (i) {
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                intent.putExtra("communication_status", 0);
                break;
            case ViewDragHelper.STATE_SETTLING /*2*/:
                intent.putExtra("communication_status", 1);
                break;
            case ViewDragHelper.DIRECTION_ALL /*3*/:
                intent.putExtra("communication_status", 1);
                break;
            case ViewDragHelper.EDGE_TOP /*4*/:
                intent.putExtra("communication_status", 0);
                break;
            case MotionEventCompat.AXIS_TOUCH_MINOR /*5*/:
                intent.putExtra("communication_status", 1);
                break;
        }
        intent.putExtra("install_extra", str);
        int random = ((int) (Math.random() * 100.0d)) + 11122;
        Logooo.e2("diff", "notifitions:" + random);
        return PendingIntent.getActivity(context, random, intent, 134217728);
    }

    public static void m456a(Context context, int i, String str, int i2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Builder builder = new Builder(context);
        builder.setContentTitle("\u5df2\u8fde\u63a5\u624b\u673a\u52a9\u624b").setContentText("\u70b9\u51fb\u53ef\u67e5\u770b\u5b89\u88c5\u8fdb\u5ea6").setContentIntent(C0214c.m455a(context, i, str)).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis()).setSmallIcon(2130837505);
        notificationManager.notify(i2, builder.build());
    }
}
