package com.service.usbhelper.service;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.service.usbhelper.data.C0192a;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.DateUtils;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.EncryptionUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.UrlsManager;
import com.service.usbhelper.p015e.C0229r;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.service.usbhelper.service.c */
public class UncaughtExceptionThread extends Thread {
    private Context mContext;
    private String mThrowableStackTrace;

    public UncaughtExceptionThread(Context context, Throwable th) {
        this.mContext = context;
        this.mThrowableStackTrace = getThrowableStackTrace(th);
    }

    private String getThrowableStackTrace(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    private void sendAppInfo(String msg) {
        if (this.mContext == null || TextUtils.isEmpty(msg) || !C0229r.m527b(this.mContext)) {
            Process.killProcess(Process.myPid());
        }
        Logooo.e5("error:\n" + msg);
        String md5 = EncryptionUtil.getMD5A(msg);
        JSONObject header = C0192a.getCommonInfo(mContext);
        JSONArray error = new JSONArray();
        try {
            JSONObject object = new JSONObject();
            object.put("date", DateUtils.dateFormat(System.currentTimeMillis(), "yyyy-MM-dd"));
            object.put("time", DateUtils.dateFormat(System.currentTimeMillis(), "HH:mm:ss"));
            object.put("msg", msg);
            object.put("msgMD5", md5);
            error.put(object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject params = new JSONObject();
        try {
            params.put("header", header);
            params.put("error", error);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        md5 = params.toString() + C0229r.getPromotionMethod(mContext, "project_name");
        if (md5 != null) {
            try {
                String app_key = C0229r.getPromotionMethod(mContext, "app_key");
                String secket = EncryptUtil.encrypt(app_key, md5);
                String response = C0183h.m338a().m340a("http://app.50bang.org/index.php?action=session", UrlsManager.sendData, secket, mContext);
                Logooo.e5("send error response:" + response);
                Process.killProcess(Process.myPid());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void run() {
        super.run();
        sendAppInfo(this.mThrowableStackTrace);
    }
}
