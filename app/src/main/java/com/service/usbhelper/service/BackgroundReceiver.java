package com.service.usbhelper.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.service.usbhelper.p015e.Logooo;

public class BackgroundReceiver extends BroadcastReceiver {
    static {
    }

    public void onReceive(Context context, Intent intent) {
        Logooo.e4("song", "background receiver onreceiver");
        if (context != null) {
        }
    }
}
