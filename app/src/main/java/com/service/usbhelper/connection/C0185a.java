package com.service.usbhelper.connection;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.ScreenLiveActivity;
import com.service.usbhelper.TwinkleActivity;
import com.service.usbhelper.data.C0197f;
import com.service.usbhelper.p015e.C0216e;
import com.service.usbhelper.p015e.DeviceUtils;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;
import com.service.usbhelper.service.C0252m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.connection.a */
public class C0185a {
    public static final byte[] f163a;
    public static final byte[] f164b;
    public static final byte[] f165c;
    public static final byte[] f166d;
    public static final byte[] f167e;
    public static final byte[] f168f;
    public static final byte[] f169g;
    public static final byte[] f170h;
    public static final byte[] f171i;
    public static final byte[] f172j;
    public static final byte[] f173k;
    public static boolean f174l;
    private static Object f175m;
    private static Object f176n;
    private static final Object f177o;
    private static AtomicInteger f178p;
    private static HashMap<String, Integer> f179q;
    private static HashMap<String, Integer> f180r;

    static {
        f163a = new byte[]{(byte) 79, (byte) 75, (byte) 65, (byte) 89};
        f164b = new byte[]{(byte) 70, (byte) 65, (byte) 73, (byte) 76};
        f165c = new byte[]{(byte) 83, (byte) 84, (byte) 65, (byte) 84};
        f166d = new byte[]{(byte) 82, (byte) 69, (byte) 67, (byte) 86};
        f167e = new byte[]{(byte) 68, (byte) 65, (byte) 84, (byte) 65};
        f168f = new byte[]{(byte) 68, (byte) 79, (byte) 78, (byte) 69};
        f169g = new byte[]{(byte) 83, (byte) 69, (byte) 78, (byte) 68};
        f170h = new byte[]{(byte) 80, (byte) 65, (byte) 67, (byte) 75};
        f171i = new byte[]{(byte) 48, (byte) 48, (byte) 73, (byte) 68};
        f172j = new byte[]{(byte) 84, (byte) 89, (byte) 80, (byte) 69};
        f173k = new byte[]{(byte) 78, (byte) 65, (byte) 77, (byte) 69};
        f175m = new Object();
        f176n = new Object();
        f177o = new Object();
        f178p = new AtomicInteger(0);
        f179q = new HashMap();
        f180r = new HashMap();
    }

    public static int m344a(byte[] bArr, int i) {
        return (((0 | (bArr[i] & MotionEventCompat.ACTION_MASK)) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 8)) | ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[i + 3] & MotionEventCompat.ACTION_MASK) << 24);
    }

    private static void m345a() {
        f174l = true;
    }

    public static void m346a(int i, int i2, BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        int i3 = 0;
        byte[] bArr = new byte[i2];
        while (i3 != -1 && i3 < i2) {
            i3 += bufferedInputStream.read(bArr, i3, i2 - i3);
        }
        Intent intent = new Intent(MyApplication.getCt(), TwinkleActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("communication_status", 1);
        intent.putExtra("install_extra", new String(bArr));
        MyApplication.getCt().startActivity(intent);
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", "00001");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            int length = jSONObject2.getBytes().length;
            byte[] bArr2 = new byte[4];
            C0185a.m351a(i, bArr2, 0);
            bufferedOutputStream.write(bArr2);
            C0185a.m351a(length, bArr2, 0);
            bufferedOutputStream.write(bArr2);
            bufferedOutputStream.write(jSONObject2.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void m347a(int i, BufferedInputStream bufferedInputStream, Context context) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 != -1 && i2 < i) {
            i2 += bufferedInputStream.read(bArr, i2, i - i2);
        }
        Intent intent = new Intent(context, TwinkleActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("communication_status", 0);
        intent.putExtra("install_extra", new String(bArr));
        context.startActivity(intent);
    }

    public static void m348a(int i, BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream, Context context) {
        C0185a.m345a();
        try {
            JSONObject a = C0197f.m408a(context);
            a.put("error_code", "00001");
            C0185a.m356a(a, 29, (OutputStream) bufferedOutputStream);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.gc();
    }

    public static void m349a(int i, BufferedOutputStream bufferedOutputStream) {
        CharSequence a = C0252m.m587a(MyApplication.getCt());
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", "00001");
                if (TextUtils.isEmpty(a) || "running_package_null".equals(a)) {
                    jSONObject.put("access_settings", false);
                    C0185a.m350a(i, (OutputStream) bufferedOutputStream, jSONObject.toString());
                }
                jSONObject.put("access_settings", true);
                C0185a.m350a(i, (OutputStream) bufferedOutputStream, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m350a(int i, OutputStream outputStream, String str) {
        if (!TextUtils.isEmpty(str) && outputStream != null) {
            try {
                int length = str.getBytes().length;
                byte[] bArr = new byte[4];
                C0185a.m351a(i, bArr, 0);
                outputStream.write(bArr);
                C0185a.m351a(length, bArr, 0);
                outputStream.write(bArr);
                outputStream.write(str.getBytes());
                outputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void m351a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & MotionEventCompat.ACTION_MASK);
        bArr[i2 + 1] = (byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8);
        bArr[i2 + 2] = (byte) ((16711680 & i) >> 16);
        bArr[i2 + 3] = (byte) ((ViewCompat.MEASURED_STATE_MASK & i) >> 24);
    }

    public static void m352a(BufferedInputStream bufferedInputStream, int i, Context context) {
        if (TwinkleActivity.f95a != -1) {
            Intent intent = new Intent();
            intent.setAction("heartbeat");
            intent.putExtra("communication_status", 2);
            context.sendBroadcast(intent);
        }
    }

    public static void m353a(BufferedOutputStream bufferedOutputStream, int i) {
        C0185a.m355a("usbHelper", i, (OutputStream) bufferedOutputStream);
    }

    public static void m354a(BufferedOutputStream bufferedOutputStream, int i, Context context) {
        String a = DeviceUtils.getImei(context);
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        String a2 = DeviceUtils.getMac();
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        String d = C0229r.getSubscriberId(context);
        if (TextUtils.isEmpty(d)) {
            d = "";
        }
        String obj = Build.BRAND;
        if (TextUtils.isEmpty(obj)) {
            obj = "";
        }
        String obj2 = Build.MODEL;
        if (TextUtils.isEmpty(obj2)) {
            obj2 = "";
        }
        List<String> e = C0229r.m536e(context);
        C0229r.m528c();
        String obj3 = VERSION.RELEASE;
        if (TextUtils.isEmpty(obj3)) {
            obj3 = "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Object c = DeviceUtils.getUuid(MyApplication.getCt());
            String str = "uuid";
            if (c == null) {
                c = "";
            }
            jSONObject.put(str, c);
            jSONObject.put("imei", a);
            jSONObject.put("wmac", a2);
            jSONObject.put("imsi", d);
            jSONObject.put("brand", obj);
            jSONObject.put("device_model", obj2);
            JSONArray jSONArray = new JSONArray();
            if (e != null && e.size() > 0) {
                for (String str2 : e) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put("packageName", str2);
                        jSONObject2.put("versionCode", C0229r.m542g(str2));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("deviceLauncher", jSONArray);
            jSONObject.put("launchName", C0229r.m528c());
            jSONObject.put("os_version", obj3);
            jSONObject.put("androidSdk", VERSION.SDK_INT);
            jSONObject.put("displayWidth", C0229r.m534e());
            jSONObject.put("displayHeight", C0229r.m531d());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        C0185a.m356a(jSONObject, i, (OutputStream) bufferedOutputStream);
    }

    private static void m355a(String str, int i, OutputStream outputStream) {
        byte[] bArr = new byte[4];
        C0185a.m351a(str.getBytes().length, bArr, 0);
        byte[] bArr2 = new byte[4];
        C0185a.m351a(i, bArr2, 0);
        outputStream.write(bArr2);
        outputStream.write(bArr);
        outputStream.write(str.getBytes());
        outputStream.flush();
    }

    private static void m356a(JSONObject jSONObject, int i, OutputStream outputStream) {
        String jSONObject2 = jSONObject.toString();
        byte[] bArr = new byte[4];
        C0185a.m351a(jSONObject2.getBytes().length, bArr, 0);
        byte[] bArr2 = new byte[4];
        C0185a.m351a(i, bArr2, 0);
        outputStream.write(bArr2);
        outputStream.write(bArr);
        outputStream.write(jSONObject2.getBytes());
        outputStream.flush();
    }

    public static void m357b(int i, int i2, BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        JSONObject jSONObject;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 != -1 && i3 < i2) {
            i3 += bufferedInputStream.read(bArr, i3, i2 - i3);
        }
        String str = new String(bArr);
        if (!TextUtils.isEmpty(str)) {
            jSONObject = new JSONObject(str);
            if (jSONObject.has("showMode") && jSONObject.getInt("showMode") == 0) {
                str = jSONObject.has("showMsg") ? jSONObject.getString("showMsg") : "";
                int i4 = jSONObject.has("times") ? jSONObject.getInt("times") : 1000;
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(MyApplication.getCt(), ScreenLiveActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("toast_msg", str);
                    intent.putExtra("times", i4);
                    MyApplication.getCt().startActivity(intent);
                }
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", "00001");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C0185a.m350a(i, (OutputStream) bufferedOutputStream, jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m358b(BufferedOutputStream bufferedOutputStream, int i, Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("phoneSdcardMem_total", C0216e.m466e());
            jSONObject.put("phoneSdcardMem_free", C0216e.m465d());
            jSONObject.put("phoneMem_total", C0216e.m463c());
            jSONObject.put("phoneMem_free", C0216e.m461b());
            jSONObject.put("sdcardMem_total", C0216e.m462b(context));
            jSONObject.put("sdcardMem_free", C0216e.m459a(context));
            jSONObject.put("phoneRamMem_free", C0229r.m537f());
            jSONObject.put("phoneRamMem_total", C0229r.m540g());
            jSONObject.put("error_code", "00001");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C0185a.m356a(jSONObject, i, (OutputStream) bufferedOutputStream);
    }

    public static void m359c(int i, int i2, BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        JSONObject jSONObject = new JSONObject();
        String str = "00001";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        while (i3 != -1 && i3 < i2) {
            i3 += bufferedInputStream.read(bArr, i3, i2 - i3);
        }
        Object str6 = new String(bArr);
        String str7;
        if (TextUtils.isEmpty(str6)) {
            str7 = str5;
            str5 = str3;
            str3 = "00006";
            str = str4;
            str4 = str7;
        } else {
            CharSequence string;
            CharSequence charSequence;
            CharSequence string2;
            JSONObject jSONObject2 = new JSONObject(str6);
            if (jSONObject2.has("boxID")) {
                str2 = jSONObject2.getString("boxID");
                if (TextUtils.isEmpty(str2)) {
                    str = "00002";
                }
            } else {
                str = "00002";
            }
            if (jSONObject2.has("boxVersion")) {
                string = jSONObject2.getString("boxVersion");
                if (TextUtils.isEmpty(string)) {
                    charSequence = string;
                    str4 = "00003";
                    str = charSequence;
                } else {
                    charSequence = string;
                    str4 = str;
                    CharSequence charSequence2 = charSequence;
                }
            } else {
                str7 = str4;
                str4 = "00003";
                str = str7;
            }
            if (jSONObject2.has("cid")) {
                string2 = jSONObject2.getString("cid");
                if (TextUtils.isEmpty(string2)) {
                    charSequence = string2;
                    str5 = "00004";
                    str4 = charSequence;
                } else {
                    charSequence = string2;
                    str5 = str4;
                    string = charSequence;
                }
            } else {
                str7 = str5;
                str5 = "00004";
                str4 = str7;
            }
            if (jSONObject2.has("comboID")) {
                CharSequence string3 = jSONObject2.getString("comboID");
                if (TextUtils.isEmpty(string3)) {
                    charSequence = string3;
                    Object obj = "00005";
                    str5 = charSequence;
                } else {
                    charSequence = string3;
                    str3 = str5;
                    string2 = charSequence;
                }
            } else {
                str7 = str3;
                str3 = "00005";
                str5 = str7;
            }
        }
        if ("00001".equals(obj)) {
            SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putString("box_id", str2).putString("combo_id", str5).putString("box_version", str).putString("box_cid", str4).commit();
            MyApplication.getCt().sendBroadcast(new Intent("socket 505"));
        }
        try {
            jSONObject.put("error_code", obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            C0185a.m350a(i, (OutputStream) bufferedOutputStream, jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
