package com.service.usbhelper.p015e;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.data.C0204m;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.p009a.C0164b;
import com.service.usbhelper.p009a.C0171i;
import com.service.usbhelper.service.C0244j;
import com.service.usbhelper.service.C0252m;
import com.service.usbhelper.service.HelperService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.e.f */
public class C0217f {
    public static List<String> f266a;
    public static List<String> f267b;
    public static List<String> f268c;
    public static List<C0204m> f269d;
    private static boolean f270e;

    static {
        f266a = new ArrayList();
        f267b = new ArrayList();
        f268c = new ArrayList();
        f269d = new ArrayList();
        f270e = false;
    }

    public static String getChannel(Context context) {
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
                if (zipEntry.getName().startsWith("META-INF/channel_")) {
                    String channel = zipEntry.getName().substring("META-INF/channel_".length());
                    return channel;
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

    public static String getChannel(Context context, String str) {
        if (context == null) {
            return "";
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith("META-INF/channel_")) {
                    String channel = zipEntry.getName().substring("META-INF/channel_".length());
                    return channel;
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

    public static List<String> m469a() {
        Process exec;
        Throwable th;
        Process process = null;
        String str = "";
        List<String> arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            exec = Runtime.getRuntime().exec("pm list packages");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        str = bufferedReader.readLine();
                        if (str == null) {
                            break;
                        }
                        str = str.substring(str.indexOf(58) + 1);
                        Logooo.e1("pkgName is " + str);
                        arrayList.add(str);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                exec.waitFor();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (exec != null) {
                    exec.destroy();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            exec = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (exec != null) {
                exec.destroy();
            }
            throw th;
        }
        return arrayList;
    }

    public static synchronized List<C0204m> m470a(Context context, String str, List<String> list) {
        List<C0204m> list2;
        synchronized (C0217f.class) {
            String str2 = "";
            if (context == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
                list2 = null;
            } else {
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("appList");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        List<C0204m> arrayList = new ArrayList();
                        String str3 = str2;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            C0204m c0204m = new C0204m();
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            c0204m.f242f = jSONObject.getString("ifwork");
                            c0204m.f241e = jSONObject.getString("ifspy");
                            c0204m.f246j = jSONObject.getString("pkgName");
                            if (!TextUtils.isEmpty(c0204m.f246j)) {
                                if (list.contains(c0204m.f246j) && "1".equals(c0204m.f242f) && ("1".equals(c0204m.f241e) || HelperService.f307e)) {
                                    c0204m.f237a = jSONObject.getString("id");
                                    c0204m.f243g = jSONObject.getString("ifspy_init");
                                    c0204m.f240d = jSONObject.getString("path");
                                    c0204m.f238b = jSONObject.getString("pkey");
                                    c0204m.f239c = jSONObject.getString("softname");
                                    c0204m.f244h = jSONObject.getString("update_date");
                                    c0204m.f245i = jSONObject.getString("appid");
                                    if (!(TextUtils.isEmpty(c0204m.f240d) || TextUtils.isEmpty(c0204m.f245i))) {
                                        str3 = str3 + "," + c0204m.f240d;
                                        if ("1".equals(c0204m.f243g)) {
                                            SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "init_path");
                                            Editor edit = a.edit();
                                            String str4 = "1," + c0204m.f245i + "," + c0204m.f246j;
                                            String[] split = c0204m.f240d.split(";");
                                            if (split.length > 0) {
                                                for (String str5 : split) {
                                                    if (!a.contains(Environment.getExternalStorageDirectory() + "/" + str5)) {
                                                        edit.putString(Environment.getExternalStorageDirectory() + "/" + str5, str4);
                                                    }
                                                }
                                            } else {
                                                edit.putString(Environment.getExternalStorageDirectory() + "/" + c0204m.f240d, str4);
                                            }
                                            edit.commit();
                                        }
                                        arrayList.add(c0204m);
                                    }
                                }
                            }
                        }
                        Editor edit2 = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "observer_path").edit();
                        edit2.remove("observer_path_key");
                        edit2.putString("observer_path_key", str3);
                        edit2.commit();
                        list2 = arrayList;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                list2 = null;
            }
        }
        return list2;
    }

    public static List<String> m471a(Context context, List<String> list) {
        List a = C0217f.m469a();
        List<String> arrayList = new ArrayList();
        if (a == null || a.size() == 0 || list == null || list.size() == 0) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (a.contains(str)) {
                try {
                    String b = C0217f.m480b(context, context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
                    if (!TextUtils.isEmpty(b) && b.contains("channeltj")) {
                        Logooo.e3("getDataAppChannel met_info \u6587\u4ef6\u4fe1\u606f1==" + b);
                        arrayList.add(str);
                    }
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static List<C0204m> m472a(Context context, List<String> list, C0244j c0244j) {
        if (context == null || list == null || list.size() == 0) {
            return null;
        }
        if (C0229r.m527b(context)) {
            new Thread(new C0220i(context, list, c0244j)).start();
        }
        return f269d;
    }

    public static void m473a(Context context, C0244j c0244j) {
        List e = C0217f.m489e(context, "server_watch_list");
        if (e == null || e.size() == 0) {
            if (!f270e) {
                C0217f.m481b(context, c0244j);
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(context);
                a.edit().putInt("refresh_server_watch_list_stamp", DateUtils.m492a(context, (long) DateUtils.m491a())).commit();
            }
            f270e = true;
        }
    }

    public static void m474a(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(context, "watch_list");
                Object string = a.getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(",");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]);
                    split[1] = "";
                    int length = split.length;
                    for (int i = 1; i < length; i++) {
                        stringBuilder.append("," + split[i]);
                    }
                    a.edit().putString(str2, stringBuilder.toString()).commit();
                }
            } else {
                String[] split2 = str.split("_");
                if (split2 != null && split2.length == 3 && split2[0].equals("channeltj")) {
                    ContentValues contentValues;
                    SharedPreferences a2 = SharedPreferencesManager.getSharedPreferences(context, "watch_list");
                    SharedPreferences a3 = SharedPreferencesManager.getSharedPreferences(context, "union_app_list");
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(split2[1]);
                    stringBuilder2.append("," + split2[2]);
                    try {
                        String str3 = "-1";
                        int i2 = -1;
                        long j = -1;
                        if (!TextUtils.isEmpty(str2)) {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                            str3 = packageInfo.versionName;
                            i2 = packageInfo.versionCode;
                            if (VERSION.SDK_INT >= 9) {
                                j = packageInfo.firstInstallTime / 1000;
                            }
                        }
                        stringBuilder2.append("," + str3);
                        stringBuilder2.append("," + i2);
                        stringBuilder2.append("," + j);
                    } catch (NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (!C0209b.m421a().m430b(str2)) {
                        contentValues = new ContentValues();
                        contentValues.put("package", str2);
                        contentValues.put("traffic_used", Long.valueOf(C0229r.m535e(str2)));
                        contentValues.put("stamp", String.valueOf((System.currentTimeMillis() / 1000) + 10800));
                        C0209b.m421a().m428b(contentValues);
                    }
                    if (!C0209b.m421a().m433c(str2)) {
                        contentValues = new ContentValues();
                        contentValues.put("package", str2);
                        C0209b.m421a().m431c(contentValues);
                        C0164b.m264a().m270b();
                    }
                    a2.edit().putString(str2, stringBuilder2.toString()).commit();
                    a3.edit().putString(str2, stringBuilder2.toString()).commit();
                }
            }
            C0252m.f346h = true;
        }
    }

    private static void m475a(JSONObject jSONObject) {
        if (jSONObject == null) {
            C0171i.m287a().f126a = false;
            C0171i.m287a().m293b();
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("pmConfig");
            if (jSONObject2 == null) {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
                return;
            }
            C0171i.m287a().f126a = true;
            Object string = jSONObject2.getString("installInfo");
            if (TextUtils.isEmpty(string)) {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
            }
            SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt());
            if (!TextUtils.isEmpty(string) && "-1".equals(a.getString("pmConfig_send_install_info", "-1"))) {
                a.edit().putString("pmConfig_send_install_info", string).commit();
            }
            string = jSONObject2.getString("arriveInfo");
            if (TextUtils.isEmpty(string)) {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
            }
            if (!TextUtils.isEmpty(string) && "-1".equals(a.getString("pmConfig_send_arrive_info", "-1"))) {
                a.edit().putString("pmConfig_send_arrive_info", string).commit();
            }
            if (jSONObject2.has("ad")) {
                a.edit().putLong("pmConfig_arrive_duration", jSONObject2.getLong("ad") * 1000).commit();
            } else {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
            }
            string = jSONObject2.getString("thirdArriveInfo");
            if (TextUtils.isEmpty(string)) {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
            }
            if (!TextUtils.isEmpty(string) && "-1".equals(a.getString("app_pmConfig_send_arrive_info", "-1"))) {
                a.edit().putString("app_pmConfig_send_arrive_info", string).commit();
            }
            if (jSONObject2.has("thirdAd")) {
                a.edit().putLong("app_pmConfig_arrive_duration", jSONObject2.getLong("thirdAd") * 1000).commit();
            } else {
                C0171i.m287a().f126a = false;
                C0171i.m287a().m293b();
            }
            if ("1".equals(a.getString("app_pmConfig_send_arrive_info", "-1"))) {
                C0164b.m264a().m270b();
            }
        } catch (Exception e) {
            C0171i.m287a().f126a = false;
            C0171i.m287a().m293b();
            e.printStackTrace();
        }
    }

    public static String[] m477a(PackageInfo packageInfo, String str, String str2) {
        ZipFile zipFile;
        Exception e;
        Throwable th;
        if (packageInfo == null) {
            return null;
        }
        if (packageInfo.applicationInfo != null) {
            String str3 = packageInfo.applicationInfo.sourceDir;
            if (str3 != null) {
                try {
                    zipFile = new ZipFile(str3);
                    try {
                        Enumeration entries = zipFile.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                            if (zipEntry.getName().startsWith(str)) {
                                String[] split = zipEntry.getName().split(str2);
                                if (zipFile == null) {
                                    return split;
                                }
                                try {
                                    zipFile.close();
                                    return split;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return split;
                                }
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e3 = e4;
                        try {
                            e3.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e32) {
                                    e32.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e32 = e5;
                    zipFile = null;
                    e32.printStackTrace();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = null;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    @Deprecated
    public static String[] m478a(String str, String str2) {
        Exception e;
        Throwable th;
        ApplicationInfo applicationInfo = MyApplication.getCt().getApplicationInfo();
        if (applicationInfo != null) {
            String str3 = applicationInfo.sourceDir;
            if (str3 != null) {
                ZipFile zipFile;
                try {
                    zipFile = new ZipFile(str3);
                    try {
                        Enumeration entries = zipFile.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                            if (zipEntry.getName().startsWith(str)) {
                                String[] split = zipEntry.getName().split(str2);
                                if (zipFile == null) {
                                    return split;
                                }
                                try {
                                    zipFile.close();
                                    return split;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return split;
                                }
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        e3 = e4;
                        try {
                            e3.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e32) {
                                    e32.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e32 = e5;
                    zipFile = null;
                    e32.printStackTrace();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = null;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    public static String m479b(Context context) {
        ZipFile zipFile;
        Exception e;
        Throwable th;
        if (context == null) {
            return "";
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            String str = applicationInfo.sourceDir;
            if (str != null) {
                try {
                    zipFile = new ZipFile(str);
                    try {
                        Enumeration entries = zipFile.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                            if (zipEntry.getName().startsWith("META-INF/tc_")) {
                                str = zipEntry.getName().substring("META-INF/tc_".length());
                                break;
                            }
                        }
                        str = null;
                        if (zipFile == null) {
                            return str;
                        }
                        try {
                            zipFile.close();
                            return str;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return str;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                    return null;
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    return null;
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    zipFile = null;
                    e4.printStackTrace();
                    if (zipFile != null) {
                        zipFile.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = null;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    public static String m480b(Context context, String str) {
        ZipFile zipFile;
        Exception e;
        ZipFile zipFile2;
        Throwable th;
        String str2 = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            String str3 = "";
            try {
                zipFile = new ZipFile(str);
                try {
                    Enumeration entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.getName().startsWith("META-INF/channeltj_")) {
                            Logooo.e5("filepath name :" + zipEntry.getName());
                            str3 = zipEntry.getName().substring("META-INF/".length());
                            Logooo.e3("filename:" + str3);
                            str2 = str3;
                            break;
                        }
                    }
                    str2 = str3;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    str2 = str3;
                    zipFile2 = zipFile;
                    e2 = exception;
                    try {
                        e2.printStackTrace();
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e222 = e4;
                str2 = str3;
                zipFile2 = null;
                e222.printStackTrace();
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                return str2;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                zipFile = null;
                th = th5;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        }
        return str2;
    }

    public static List<String> m481b(Context context, C0244j c0244j) {
        if (context == null) {
            return null;
        }
        if (C0229r.m527b(context)) {
            new Thread(new C0218g(context, c0244j)).start();
        } else {
            try {
                new Thread(new C0219h(context)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f268c;
    }

    public static List<String> m482b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C0217f.m475a(jSONObject);
            JSONArray jSONArray = jSONObject.getJSONArray("appList");
            if (jSONArray != null && jSONArray.length() > 0) {
                String str3 = "";
                List<String> arrayList = new ArrayList();
                Editor edit = SharedPreferencesManager.getSharedPreferences(context, str2).edit();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getJSONObject(i).getString("packageName");
                    if (!TextUtils.isEmpty(string)) {
                        edit.putString(string, string);
                        arrayList.add(string);
                    }
                }
                edit.commit();
                return arrayList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<C0204m> m483b(Context context, List<String> list, C0244j c0244j) {
        if (context == null || list == null || list.size() == 0) {
            return null;
        }
        new Thread(new C0221j(context, list, c0244j)).start();
        return f269d;
    }

    public static String getCid(Context context) {
        String cid = "";
        try {
            cid = context.createPackageContext("com.market2345", Context.CONTEXT_IGNORE_SECURITY).getSharedPreferences(".lminstalllist", 1).getString("cid_key", "");

        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(cid)) {
            cid = C0217f.getChannel(context, "com.market2345");
            if (TextUtils.isEmpty(cid)) {
                cid = C0217f.getChannel(context);
                if (TextUtils.isEmpty(cid)) {
                    cid = C0229r.getPromotionMethod(context, "UMENG_CHANNEL");
                }
            }
            Logooo.e3("getUsbHelperSelfChannel----" + cid);
        }
        return cid;
    }

    public static synchronized List<String> m485c(Context context, C0244j c0244j) {
        List<String> list;
        synchronized (C0217f.class) {
            f266a = C0217f.m489e(context, "watch_list");
            if (f266a == null || f266a.size() == 0) {
                C0217f.m473a(context, c0244j);
            } else {
                Logooo.e3("getWatchAppList" + f266a);
                if (HelperService.f308f == null || HelperService.f308f.size() == 0) {
                    String string = SharedPreferencesManager.getSharedPreferences(context, "watch_list_path").getString("watch_list_path_key", "");
                    if (TextUtils.isEmpty(string)) {
                        HelperService.f308f = C0217f.m472a(context, f266a, c0244j);
                    } else {
                        HelperService.f308f = C0217f.m470a(context, string, f266a);
                    }
                }
                C0171i.m287a().m293b();
            }
            if ((HelperService.f305c == null || HelperService.f305c.size() == 0) && c0244j != null && HelperService.f308f != null && HelperService.f308f.size() > 0) {
                c0244j.m582a(HelperService.f308f);
            }
            list = f266a;
        }
        return list;
    }

    public static boolean m486c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Object obj = null;
        try {
            obj = C0217f.m480b(context, context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(obj)) {
            String[] split = obj.split("_");
            if (split != null && split.length == 3 && split[0].equals("channeltj")) {
                return true;
            }
        }
        return false;
    }

    public static void m488d(Context context, String str) {
        String b;
        NameNotFoundException e;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                b = C0217f.m480b(context, context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
                try {
                    Logooo.e3("getDataAppChannel met_info \u6587\u4ef6\u4fe1\u606f2==" + b);
                } catch (NameNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    C0217f.m474a(context, b, str);
                }
            } catch (NameNotFoundException e3) {
                NameNotFoundException nameNotFoundException = e3;
                b = null;
                e = nameNotFoundException;
                e.printStackTrace();
                C0217f.m474a(context, b, str);
            }
            C0217f.m474a(context, b, str);
        }
    }

    public static synchronized List<String> m489e(Context context, String str) {
        List<String> list;
        synchronized (C0217f.class) {
            Logooo.e3("parseSPWatchList==" + str);
            try {
                Map all = SharedPreferencesManager.getSharedPreferences(context, str).getAll();
                if (all != null) {
                    List<String> arrayList = new ArrayList();
                    for (Entry key : all.entrySet()) {
                        arrayList.add((String) key.getKey());
                    }
                    Logooo.e3("parseSPWatchList result ==" + arrayList);
                    list = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            list = null;
        }
        return list;
    }

    private static void m490e(Context context) {
        f267b = C0217f.m469a();
        Logooo.e3("installed size;" + f267b.size());
        f268c = C0217f.m489e(context, "server_watch_list");
        int i;
        if (f268c == null || f268c.size() <= 0) {
            for (i = 0; i < f267b.size(); i++) {
                C0217f.m488d(context, (String) f267b.get(i));
            }
            return;
        }
        for (i = 0; i < f268c.size(); i++) {
            if (f267b.contains(f268c.get(i))) {
                Logooo.e3("\u7f51\u7edc\u4e0d\u53ef\u7528 \u8981\u89e3\u6790\u7684apk\uff1a" + ((String) f268c.get(i)));
                C0217f.m488d(context, (String) f268c.get(i));
            }
        }
    }
}
