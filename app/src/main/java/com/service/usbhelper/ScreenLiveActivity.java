package com.service.usbhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.service.usbhelper.p015e.C0233v;

public class ScreenLiveActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903041);
        Intent intent = getIntent();
        if (intent != null) {
            Object stringExtra = intent.getStringExtra("toast_msg");
            int intExtra = intent.getIntExtra("times", 1000);
            if (!TextUtils.isEmpty(stringExtra)) {
                C0233v.m553a(stringExtra, intExtra);
            }
        }
        new Handler().postDelayed(new C0235e(this), 100);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            Object stringExtra = intent.getStringExtra("toast_msg");
            int intExtra = intent.getIntExtra("times", 1000);
            if (!TextUtils.isEmpty(stringExtra)) {
                C0233v.m553a(stringExtra, intExtra);
            }
        }
        super.onNewIntent(intent);
    }
}
