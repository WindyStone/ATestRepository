package com.service.usbhelper.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import com.service.usbhelper.MainActivity;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.connection.ConnectionService;
import com.service.usbhelper.data.C0192a;
import com.service.usbhelper.data.C0200i;
import com.service.usbhelper.data.C0204m;
import com.service.usbhelper.db.C0211b;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.p009a.C0164b;
import com.service.usbhelper.p011c.C0177b;
import com.service.usbhelper.p011c.C0178c;
import com.service.usbhelper.p015e.C0215d;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.DateUtils;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;
import com.service.usbhelper.p015e.C0231t;

import java.io.File;
import java.util.List;

public class HelperService extends Service implements C0240l {
    public static C0251k f303a;
    public static String f304b;
    public static List<C0231t> f305c;
    public static final Object f306d;
    public static boolean f307e;
    public static List<C0204m> f308f;
    BroadcastReceiver f309g;
    private C0177b f310h;
    private List<String> f311i;
    private C0252m f312j;
    private SharedPreferences f313k;
    private boolean f314l;
    private C0244j f315m;
    private PendingIntent f316n;
    private C0250i f317o;

    static {
        f303a = C0251k.initService;
        f304b = "HelperService";
        f306d = new Object();
        f307e = false;
    }

    public HelperService() {
        this.f314l = false;
        this.f315m = new C0245d(this);
        this.f309g = new C0248g(this);
        m565a();
    }

    private void m565a() {
        CharSequence a = C0252m.m587a(MyApplication.getCt());
        boolean z = TextUtils.isEmpty(a) || "running_package_null".equals(a);
        f307e = z;
    }

    private void m566a(Context context, String str) {
        Logooo.e3("refreshServerWatchListAfterAppAdded" + str);
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences a = SharedPreferencesManager.getSharedPreferences(context);
            int i = a.getInt("refresh_server_watch_list_stamp", 0);
            Logooo.e3("before:" + i);
            int a2 = DateUtils.m492a(context, (long) DateUtils.m491a());
            if (i == 0 || a2 == 0 || i != a2) {
                C0217f.m481b(context, this.f315m);
                if (a2 == 0) {
                    a2 = DateUtils.m492a(context, (long) DateUtils.m491a());
                }
                a.edit().putInt("refresh_server_watch_list_stamp", a2).commit();
                return;
            }
            try {
                Logooo.e3("save info " + str);
                C0217f.m488d(context, str);
                C0217f.m483b(MyApplication.getCt(), C0217f.m471a(context, this.f311i), this.f315m);
                C0252m.f346h = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void m567a(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            this.f313k = SharedPreferencesManager.getSharedPreferences(context, str);
            Editor edit = this.f313k.edit();
            int a = DateUtils.m491a();
            int i2 = this.f313k.getInt("app_start_stamp", 0);
            int i3 = this.f313k.getInt("app_end_stamp", 0);
            int i4 = this.f313k.getInt("app_duration", 0);
            int i5 = this.f313k.getInt("app_sessionid", 0);
            int i6 = this.f313k.getInt("app_is_start_sended", 0);
            String string = this.f313k.getString("app_appid", "");
            if (TextUtils.isEmpty(string)) {
                string = m570b(context, str);
            }
            Logooo.e5("sessionid: " + a + "\t preStart:" + i2 + "\t preEnd:" + i3 + "\n preDuration:" + i4 + "\t preSessionid" + i5);
            if (i5 == 0 || i2 == 0 || i3 == 0 || i4 == 0) {
                edit.putString("app_pkgname", str);
                edit.putInt("app_start_stamp", a);
                edit.putInt("app_end_stamp", a);
                edit.putInt("app_sessionid", a);
                edit.putInt("app_duration", 0);
                edit.putInt("app_is_start_sended", 0);
                edit.putString("app_appid", string);
                edit.commit();
                Logooo.e5("\u7b2c\u4e09\u65b9\u7b2c\u4e00\u6b21\u6253\u5f00\uff0c\u53d1\u9001\u542f\u52a8\u4fe1\u606f");
                C0192a.m403b(C0192a.m389a(context), context, i);
                return;
            }
            Logooo.e5("\u672c\u6b21\u542f\u52a8session:" + a + "\t \u4e0a\u6b21\u7ed3\u675f \uff1a" + i3);
            if (a - i3 > 30) {
                ContentValues contentValues = new ContentValues();
                if (i5 == 0) {
                    i5 = a;
                }
                if (i4 > 0) {
                    contentValues.put("usbhelper_session", Integer.valueOf(i5));
                    contentValues.put("usbhelper_package_name", str);
                    contentValues.put("usbhelper_duration", Integer.valueOf(i4));
                    contentValues.put("usbhelper_is_start_sended", Integer.valueOf(i6));
                    contentValues.put("usbhelper_appid", string);
                    C0211b.m442a(context, contentValues);
                }
                edit.putInt("app_start_stamp", a);
                edit.putInt("app_end_stamp", a);
                edit.putInt("app_sessionid", a);
                edit.putInt("app_duration", 0);
                edit.putInt("app_is_start_sended", 0);
                edit.commit();
                Logooo.e3("\u7b2c\u4e09\u65b9app \u8ddd\u79bb\u4e0a\u6b21\u6253\u5f00\u8d85\u8fc730\u79d2\u53d1\u9001 \u542f\u52a8\u6570\u636e");
                C0192a.m403b(C0192a.m389a(context), context, i);
                return;
            }
            Logooo.e5("\u7b2c\u4e8c\u6b21\u6253\u5f00\uff0c\u548c\u4e0a\u6b21\u95f4\u9694< 30s");
            edit.putInt("app_end_stamp", a);
            edit.putInt("app_duration", (a - i3) + i4);
            edit.commit();
        }
    }

    private static String m570b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Logooo.e3("getPackageAppid" + str);
        String[] split = SharedPreferencesManager.getSharedPreferences(context, "watch_list").getString(str, "").split(",");
        String str2 = "";
        return (split == null || split.length <= 0) ? str2 : split[0];
    }

    private void m571b() {
        if (this.f312j == null) {
            this.f312j = C0252m.m584a(getApplicationContext(), this, this.f315m);
            this.f312j.start();
        }
    }

    private void m572b(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            this.f313k = SharedPreferencesManager.getSharedPreferences(context, str);
            Editor edit = this.f313k.edit();
            if (i == 1) {
                String string = this.f313k.getString("app_appid", "");
                if (TextUtils.isEmpty(string)) {
                    string = m570b(context, str);
                }
                edit.putLong("app_file_observer_duration", this.f313k.getLong("app_file_observer_duration", 0) + 1);
                edit.putString("app_appid", string);
                edit.commit();
                return;
            }
            int a = DateUtils.m491a();
            int i2 = this.f313k.getInt("app_sessionid", 0);
            int i3 = this.f313k.getInt("app_start_stamp", 0);
            int i4 = this.f313k.getInt("app_end_stamp", 0);
            int i5 = this.f313k.getInt("app_duration", 0);
            int i6 = this.f313k.getInt("app_is_start_sended", 0);
            String string2 = this.f313k.getString("app_appid", "");
            if (TextUtils.isEmpty(string2)) {
                string2 = m570b(context, str);
            }
            if (i2 == 0 || i3 == 0 || i4 == 0) {
                edit.putInt("app_start_stamp", a);
                edit.putInt("app_end_stamp", a);
                edit.putInt("app_sessionid", a);
                edit.putInt("app_duration", 0);
                edit.putString("app_appid", string2);
                edit.commit();
                return;
            }
            Logooo.e5("\u672c\u6b21\u542f\u52a8session:" + a + "\t \u4e0a\u6b21\u7ed3\u675f \uff1a" + i4);
            if (i4 < i3 || a - i4 <= 60) {
                edit.putInt("app_end_stamp", a);
                edit.putInt("app_duration", (a - i4) + i5);
                edit.commit();
                return;
            }
            Logooo.e5("\u672c\u6b21\u542f\u52a8\u8ddd\u4e0a\u6b21\u7ed3\u675f\u8d85\u8fc760s");
            ContentValues contentValues = new ContentValues();
            if (i2 == 0) {
                i2 = a;
            }
            if (i5 > 0) {
                contentValues.put("usbhelper_session", Integer.valueOf(i2));
                contentValues.put("usbhelper_package_name", str);
                contentValues.put("usbhelper_duration", Integer.valueOf(i5));
                contentValues.put("usbhelper_is_start_sended", Integer.valueOf(i6));
                contentValues.put("usbhelper_appid", string2);
                C0211b.m442a(context, contentValues);
            }
            edit.putInt("app_start_stamp", a);
            edit.putInt("app_end_stamp", a);
            edit.putInt("app_sessionid", a);
            edit.putInt("app_duration", 0);
            edit.putInt("app_is_start_sended", 0);
            edit.commit();
            C0192a.m403b(C0192a.m389a(context), context, i);
        }
    }

    private void m575c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(this.f309g, intentFilter);
    }

    public void m576a(String str, int i) {
        if (this.f311i != null && this.f311i.size() > 0 && !TextUtils.isEmpty(str) && this.f311i.contains(str)) {
            Logooo.e3("running package:" + str);
            m572b(getApplicationContext(), str, i);
        }
    }

    public void m577a(String str, String str2, int i) {
        this.f311i = C0217f.m485c(getApplicationContext(), this.f315m);
        Logooo.e5("running:" + str + "next:" + str2);
        Logooo.e3("watchapps:" + this.f311i);
        if (this.f311i != null && this.f311i.size() > 0 && !TextUtils.isEmpty(str2) && this.f311i.contains(str2)) {
            Logooo.e3("change app : running +" + str + "next;" + str2);
            m567a(getApplicationContext(), str2, i);
        }
    }

    public void m578a(List<String> list) {
        if (this.f311i == null || this.f311i.size() == 0) {
            this.f311i = list;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Logooo.e3("oncreate service");
        this.f317o = new C0250i(this);
        this.f311i = C0217f.m485c(getApplicationContext(), this.f315m);
        this.f312j = C0252m.m584a(getApplicationContext(), this, this.f315m);
        try {
            if (!C0252m.f342d) {
                this.f312j.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            m575c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Logooo.e3("service \u4e2d oncreate \u53d1\u9001\u7edf\u8ba1\u6a21\u5757\u81ea\u8eab\u542f\u52a8\u65e5\u5fd7");
        C0192a.m395a(3, getApplicationContext());
        new Handler().postDelayed(new C0246e(this), 10000);
        Logooo.e2("diff", "usbHelper,Create");
        startService(new Intent(getApplicationContext(), ConnectionService.class));
        if (VERSION.SDK_INT < 14) {
            bindService(new Intent(this, UsbConnectService.class), this.f317o, 1);
        } else {
            bindService(new Intent(this, UsbConnectService.class), this.f317o, 8);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        Builder builder = new Builder(MyApplication.getCt());
        this.f316n = PendingIntent.getService(this, 0, new Intent(), 0);
        builder.setContentIntent(this.f316n);
        builder.setSmallIcon(2130837510);
        builder.setContentTitle("");
        builder.setContentText("");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), 2130837510));
        Notification build = builder.build();
        build.flags = 32;
        startForeground(273, build);
        new Handler().postDelayed(new C0247f(this), 1000);
        if (VERSION.SDK_INT >= 21) {
            startService(new Intent(getApplicationContext(), AssignmentService.class));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f309g != null) {
                unregisterReceiver(this.f309g);
            }
            unbindService(this.f317o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Logooo.e3("helper service onstartcommand----" + intent);
        String str = "";
        if (intent == null) {
            return 1;
        }
        f303a = (C0251k) intent.getSerializableExtra("service_action");
        m565a();
        if (f303a == null) {
            f303a = C0251k.initService;
        }
        if (f303a != null) {
            Logooo.e3("helper service onstartcommand----" + f303a.toString());
        }
        str = intent.getStringExtra("pkgName");
        if (!TextUtils.isEmpty(str)) {
            C0192a.m396a(4, getApplicationContext(), str);
        }
        Logooo.e3("------" + f303a);
        switch (C0249h.f330a[f303a.ordinal()]) {
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                String stringExtra = intent.getStringExtra("downurl");
                str = intent.getStringExtra("filename");
                long parseLong = Long.parseLong(intent.getStringExtra("filesize"));
                String str2 = C0215d.m458b() + "/Android/data/com.book2345.reader/apk" + "/" + str;
                File file = new File(str2);
                if (!file.exists() || parseLong != file.length()) {
                    this.f310h = new C0177b(getApplicationContext(), str);
                    new C0178c(stringExtra, str2, false, 1, this.f310h).m330a();
                    break;
                }
                C0229r.m526b(getApplicationContext(), str2);
                break;
            case ViewDragHelper.STATE_SETTLING /*2*/:
                Logooo.e3("startMainActivity");
                Intent intent2 = new Intent(this, MainActivity.class);
                intent2.setFlags(268435456);
                startActivity(intent2);
                break;
            case ViewDragHelper.DIRECTION_ALL /*3*/:
                Logooo.e3("startMonitorApp");
                m571b();
                break;
            case ViewDragHelper.EDGE_TOP /*4*/:
                Logooo.e3("initService");
                this.f311i = C0217f.m485c(getApplicationContext(), this.f315m);
                Logooo.e1("watchApps" + this.f311i.toString());
                m571b();
                break;
            case MotionEventCompat.AXIS_TOUCH_MINOR /*5*/:
                Logooo.e3("package added");
                str = intent.getStringExtra("package");
                m566a(getApplicationContext(), str);
                this.f311i = C0217f.m485c(getApplicationContext(), this.f315m);
                C0200i.m415a(getApplicationContext(), str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("package", str);
                C0209b.m421a().m431c(contentValues);
                C0164b.m264a().m270b();
                break;
            case MotionEventCompat.AXIS_TOOL_MAJOR /*6*/:
                m571b();
                break;
            case MotionEventCompat.AXIS_TOOL_MINOR /*7*/:
                Logooo.e3("netStateChanged");
                break;
            case ViewDragHelper.EDGE_BOTTOM /*8*/:
                Logooo.e3("usbStateChanged\uff0c\u53d1\u9001\u7edf\u8ba1\u6a21\u5757\u81ea\u8eab\u8fd0\u884c\u6570\u636e");
                m571b();
                C0192a.m395a(6, getApplicationContext());
                break;
        }
        return super.onStartCommand(intent, 1, i2);
    }
}
