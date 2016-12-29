package com.service.usbhelper.p015e;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.service.usbhelper.e.p */
public class SharedPreferencesManager {
    private static SharedPreferences mSharedPreferences;

    public static SharedPreferences getSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences("usbHelper", Context.MODE_PRIVATE);
        return mSharedPreferences;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        mSharedPreferences = context.getSharedPreferences(str, Context.MODE_PRIVATE);
        return mSharedPreferences;
    }
}
