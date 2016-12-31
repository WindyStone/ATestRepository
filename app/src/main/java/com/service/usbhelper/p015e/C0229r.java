package com.service.usbhelper.p015e;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.data.C0204m;
import com.service.usbhelper.service.C0240l;
import com.service.usbhelper.service.C0244j;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.service.usbhelper.e.r */
public class C0229r {
    private static String f286a;
    private static int f287b;

    static {
        f287b = -1;
    }

    public static int m517a() {
        String packageName = MyApplication.getCt().getPackageName();
        try {
            PackageManager packageManager = MyApplication.getCt().getPackageManager();
            if (!(packageManager == null || packageName == null)) {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                return (packageInfo == null || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? 2 : 1;
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public static int m518a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, MyApplication.getCt().getResources().getDisplayMetrics());
    }

    public static int m519a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            PackageManager packageManager = MyApplication.getCt().getPackageManager();
            if (packageManager == null || str == null) {
                return 3;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? 2 : 1;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 3;
        }
    }

    public static String getResolution(Context context) {
        String resolution = null;
        if (context == null) {
            Logooo.e3("context为空,获取不到手机分辨率...");
            return "*";
        }
        SharedPreferences sp = SharedPreferencesManager.getSharedPreferences(context);
        if (sp != null && sp.contains("resolution")) {
            resolution = sp.getString("resolution", null);
        }
        if (TextUtils.isEmpty(resolution)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            resolution = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            sp.edit().putString("resolution", resolution).commit();
        }
        if (resolution != null) {
            return resolution;
        }
        Logooo.e3("result为空,获取不到手机分辨率...");
        return "*";
    }

    public static String getPromotionMethod(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                applicationInfo = null;
            }
            if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                return applicationInfo.metaData.getString(str);
            }
        }
        return "";
    }

    public static List<C0231t> m522a(List<C0204m> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<C0231t> arrayList = new ArrayList();
        for (C0204m c0204m : list) {
            if (c0204m.f240d != null) {
                String[] split = c0204m.f240d.split(";");
                if (split.length > 0) {
                    for (String str : split) {
                        C0231t c0231t = new C0231t(Environment.getExternalStorageDirectory() + "/" + str);
                        c0231t.startWatching();
                        arrayList.add(c0231t);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void m523a(C0240l c0240l, int i, C0244j c0244j) {
        if (c0240l != null) {
            Object b = C0229r.m525b("ps");
            C0217f.f266a = C0217f.m485c(MyApplication.getCt(), c0244j);
            for (String str : C0217f.f266a) {
                if (!TextUtils.isEmpty(b) && b.contains(str)) {
                    Logooo.e7("TJFile running pkg is " + str);
                    c0240l.m562a(str, i);
                }
            }
        }
    }

    public static String m524b() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(2);
        return (i + 1) + "\u6708" + instance.get(5) + "\u65e5";
    }

    public static synchronized String m525b(String str) {
        String stringBuffer;
        synchronized (C0229r.class) {
            try {
                Process exec = Runtime.getRuntime().exec(str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                char[] cArr = new char[AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD];
                StringBuffer stringBuffer2 = new StringBuffer();
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read > 0) {
                        stringBuffer2.append(cArr, 0, read);
                    } else {
                        bufferedReader.close();
                        exec.waitFor();
                        stringBuffer = stringBuffer2.toString();
                    }
                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        return stringBuffer;
    }

    public static void m526b(Context context, String str) {
        File file = new File(str);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static boolean m527b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    int i = 0;
                    while (i < allNetworkInfo.length) {
                        if (allNetworkInfo[i] != null && allNetworkInfo[i].getState() == State.CONNECTED) {
                            return true;
                        }
                        i++;
                    }
                }
            }
            Logooo.e5("net work error...");
            return false;
        } catch (Exception e) {
            Logooo.e5("net work error...");
            return false;
        }
    }

    public static String m528c() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            str = MyApplication.getCt().getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT).activityInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return str == null ? "" : str;
    }

    public static String getAccess(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return null;
        }
        try {
            String access = null;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                switch (activeNetworkInfo.getType()) {
                    case ConnectivityManager.TYPE_MOBILE :
                        if (activeNetworkInfo.getSubtype() != 1 && activeNetworkInfo.getSubtype() != 4 && activeNetworkInfo.getSubtype() != 2) {
                            if (activeNetworkInfo.getSubtype() != 13) {
                                access = "3G";
                                break;
                            }
                            access = "4G";
                            break;
                        }
                        access = "2G";
                        break;
                    case ConnectivityManager.TYPE_WIFI /*1*/:
                        access = "WiFi";
                        break;
                    default:
                        access = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                }
            }
            return access;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void m530c(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + ".system_uuid");
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                bufferedWriter.write("uuid:" + str);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            Logooo.e5("new uuid create...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int m531d() {
        return MyApplication.getCt().getResources().getDisplayMetrics().heightPixels;
    }

    public static PackageInfo m532d(String str) {
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                packageInfo = MyApplication.getCt().getPackageManager().getPackageInfo(str, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return packageInfo;
    }

    public static String getSubscriberId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager == null) {
                return "";
            }
            String subscriberId = telephonyManager.getSubscriberId();
            if (!TextUtils.isEmpty(subscriberId)) {
                return subscriberId;
            }
            String simOperator = telephonyManager.getSimOperator();
            return !TextUtils.isEmpty(simOperator) ? simOperator + "@" + DeviceUtils.m502d(context) : telephonyManager.getSimState() == 5 ? DeviceUtils.m496a("@", 14) : DeviceUtils.m496a("#", 14);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int m534e() {
        return MyApplication.getCt().getResources().getDisplayMetrics().widthPixels;
    }

    public static long m535e(String str) {
        PackageInfo d = C0229r.m532d(str);
        if (d == null) {
            return 0;
        }
        int i = d.applicationInfo.uid;
        return (TrafficStats.getUidRxBytes(i) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + (TrafficStats.getUidTxBytes(i) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }

    public static List<String> m536e(Context context) {
        List f = C0229r.m539f(context);
        List<String> arrayList = f == null ? new ArrayList() : f;
        if (arrayList.size() < 1) {
            List<String> a = C0217f.m469a();
            if (a != null && a.size() > 0) {
                for (String str : a) {
                    if (!TextUtils.isEmpty(str) && (str.contains("home") || str.contains("launcher"))) {
                        arrayList.add(str);
                    }
                }
            }
        }
        List<String> arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str2) && C0229r.m519a(str2) == 1) {
                arrayList2.add(str2);
            }
        }
        return arrayList2;
    }

    public static long m537f() {
        ActivityManager activityManager = (ActivityManager) MyApplication.getCt().getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static String m538f(String str) {
        Object obj = "";
        PackageInfo d = C0229r.m532d(str);
        String[] strArr = null;
        if (d != null) {
            strArr = C0217f.m477a(d, "META-INF/combo_", "_");
        }
        if (strArr != null && strArr.length >= 2) {
            obj = strArr[1];
        }
        return TextUtils.isEmpty(obj) ? SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).getString("combo_id", "") : obj;
    }

    public static List<String> m539f(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Class cls = Class.forName("android.content.pm.PackageManager");
            if (cls == null) {
                return null;
            }
            Method method = cls.getMethod("getHomeActivities", new Class[]{List.class});
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            if (method == null) {
                return null;
            }
            method.invoke(packageManager, new Object[]{arrayList});
            List<String> arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                if (!(resolveInfo == null || resolveInfo.activityInfo == null || TextUtils.isEmpty(resolveInfo.activityInfo.packageName))) {
                    arrayList2.add(resolveInfo.activityInfo.packageName);
                }
            }
            return arrayList2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long m540g() {
        BufferedReader bufferedReader;
        String str;
        Exception e;
        Throwable th;
        long j = 0;
        BufferedReader bufferedReader2 = null;
        if (VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) MyApplication.getCt().getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = readLine;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (str != null) {
                        return j;
                    }
                    try {
                        return (long) (Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim()) * AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return j;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e4 = e6;
            bufferedReader = null;
            e4.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (str != null) {
                return j;
            }
            return (long) (Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim()) * AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        if (str != null) {
            return j;
        }
        return (long) (Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim()) * AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
    }

    public static String m541g(Context context) {
        if (context == null) {
            return "";
        }
        String str = "";
        SharedPreferences a = SharedPreferencesManager.getSharedPreferences(context);
        String string = a.contains("tj_sim_iccid") ? a.getString("tj_sim_iccid", "") : str;
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (TextUtils.isEmpty(string)) {
                return string;
            }
            a.edit().putString("tj_sim_iccid", string).commit();
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public static String m542g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "-1";
        }
        try {
            return String.valueOf(MyApplication.getCt().getPackageManager().getPackageInfo(str, 1).versionCode);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static String m543h() {
        if (!TextUtils.isEmpty(f286a)) {
            return f286a;
        }
        try {
            f286a = MyApplication.getCt().getPackageManager().getPackageInfo(MyApplication.getCt().getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return f286a == null ? "" : f286a;
    }

    public static String getMetaInf(Context context) {
        if (context == null) {
            return "";
        }
        String sourceDir = context.getApplicationInfo().sourceDir;
        if (TextUtils.isEmpty(sourceDir)) {
            return "";
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith("META-INF/gysid_")) {
                    String metaInf = zipEntry.getName().substring("META-INF/gysid_".length());
                    return metaInf;
                }
            }
        } catch (Exception e5) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th3) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static boolean m545h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = MyApplication.getCt().getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addCategory("android.intent.category.DEFAULT");
        try {
            return str.equals(packageManager.resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT).activityInfo.packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int m546i() {
        int i = -1;
        if (f287b != i) {
            return f287b;
        }
        try {
            f287b = MyApplication.getCt().getPackageManager().getPackageInfo(MyApplication.getCt().getPackageName(), 0).versionCode;
            return f287b;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static boolean m547i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    public static boolean m548j(Context context) {
        String b = C0229r.m524b();
        return b != null && b.equals(SharedPreferencesManager.getSharedPreferences(context).getString("self log time", ""));
    }

    public static String getSystemUuid() {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + ".system_uuid");
            if (file.exists()) {
                InputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String systemUuid = "";
                while (systemUuid != null) {
                    systemUuid = bufferedReader.readLine();
                    if (systemUuid != null && systemUuid.contains("uuid:") && systemUuid.length() > 6) {
                        return systemUuid;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            } else {
                file.createNewFile();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
        return "";
    }
}
