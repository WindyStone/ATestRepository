package com.service.usbhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.service.usbhelper.data.C0192a;
import com.service.usbhelper.service.HelperService;
import com.service.usbhelper.service.UsbConnectService;

public class MainActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        new Thread(new C0184c(this)).start();
        C0192a.m395a(1, (Context) this);
        startService(new Intent(getApplicationContext(), HelperService.class));
        startService(new Intent(getApplicationContext(), UsbConnectService.class));
        finish();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
