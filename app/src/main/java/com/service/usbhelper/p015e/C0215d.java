package com.service.usbhelper.p015e;

import android.os.Environment;

/* renamed from: com.service.usbhelper.e.d */
public class C0215d {
    public static boolean m457a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String m458b() {
        return C0215d.m457a() ? Environment.getExternalStorageDirectory().getPath() : "/";
    }
}
