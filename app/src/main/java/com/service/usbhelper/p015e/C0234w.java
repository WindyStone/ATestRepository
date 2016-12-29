package com.service.usbhelper.p015e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.service.C0251k;
import com.service.usbhelper.service.HelperService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.e.w */
public class C0234w {
    public static int m554a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    private static void m555a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            Editor edit = SharedPreferencesManager.getSharedPreferences(context).edit();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Logooo.e3("update response==" + jSONObject);
                String string = jSONObject.getString("updatetype");
                if (string == null || !string.equals("update") || jSONObject.getInt("version") <= C0234w.m554a(context)) {
                    edit.putBoolean("haveUpdate", false).commit();
                    return;
                }
                edit.putBoolean("haveUpdate", true).commit();
                Intent intent = new Intent();
                intent.setClass(context, HelperService.class);
                intent.putExtra("service_action", C0251k.update);
                intent.putExtra("user_version", jSONObject.getString("user_version"));
                intent.putExtra("updatelog", jSONObject.getString("updatelog"));
                intent.putExtra("downurl", jSONObject.getString("downurl"));
                intent.putExtra("filename", jSONObject.getString("filename"));
                intent.putExtra("filesize", jSONObject.getString("filesize"));
                intent.putExtra("md5", jSONObject.getString("md5"));
                context.startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String m556b(Context context) {
        String str = null;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void m557c(Context context) {
        C0234w.m558d(context);
    }

    private static void m558d(Context context) {
        if (C0229r.m527b(context) && C0215d.m457a()) {
            String str = "";
            try {
                str = C0217f.getCid(context);
                if (TextUtils.isEmpty(str)) {
                    str = "default";
                }
                String str2 = C0234w.m554a(context) + "";
                String b = C0234w.m556b(context);
                String str3 = "update";
                String str4 = "11111111111111111111111111111111";
                String a = EncryptUtil.encrypt("N#gK3OgTw#eRUI8+8bZsti78P==4s.5", EncryptionUtil.getMD5A("usbhelper14199ef87d993e033fdca2b0c25fe876680f3" + str + str2 + b + str4 + str3));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("authkey", "usbhelper14199"));
                arrayList.add(new BasicNameValuePair("appkey", "ef87d993e033fdca2b0c25fe876680f3"));
                arrayList.add(new BasicNameValuePair("channel", str));
                arrayList.add(new BasicNameValuePair("version", str2));
                arrayList.add(new BasicNameValuePair("user_version", b));
                arrayList.add(new BasicNameValuePair("old_md5", str4));
                arrayList.add(new BasicNameValuePair("type", str3));
                arrayList.add(new BasicNameValuePair("sign", a));
                C0234w.m555a(context, C0183h.m338a().m341a("http://update.app.2345.com/index.php", arrayList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
