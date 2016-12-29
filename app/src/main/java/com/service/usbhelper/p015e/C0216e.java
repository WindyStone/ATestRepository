package com.service.usbhelper.p015e;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.lang.reflect.Method;

/* renamed from: com.service.usbhelper.e.e */
public class C0216e {
    public static long m459a(Context context) {
        long j = 0;
        String[] c = C0216e.m464c(context);
        if (c != null) {
            for (String str : c) {
                try {
                    if (!str.equals(Environment.getExternalStorageDirectory().getPath())) {
                        StatFs statFs = new StatFs(str);
                        j += ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    public static boolean m460a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long m461b() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long m462b(Context context) {
        long j = 0;
        String[] c = C0216e.m464c(context);
        if (c != null) {
            for (String str : c) {
                try {
                    if (!str.equals(Environment.getExternalStorageDirectory().getPath())) {
                        StatFs statFs = new StatFs(str);
                        j += ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    public static long m463c() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String[] m464c(Context context) {
        if (context == null || VERSION.SDK_INT <= 8) {
            return null;
        }
        Method method;
        String[] strArr;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            method = storageManager.getClass().getMethod("getVolumePaths", new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            method = null;
        }
        if (method != null) {
            try {
                strArr = (String[]) method.invoke(storageManager, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        strArr = null;
        return strArr;
    }

    public static long m465d() {
        long j = 0;
        if (!C0216e.m460a()) {
            return j;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long m466e() {
        long j = 0;
        if (!C0216e.m460a()) {
            return j;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }
}
