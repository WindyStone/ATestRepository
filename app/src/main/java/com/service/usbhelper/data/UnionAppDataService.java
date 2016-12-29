package com.service.usbhelper.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.p011c.C0183h;
import com.service.usbhelper.p015e.EncryptUtil;
import com.service.usbhelper.p015e.C0229r;
import com.service.usbhelper.p015e.C0230s;

public class UnionAppDataService extends Service {
    private static String f205a;
    private static int f206b;

    static {
        f205a = "";
        f206b = 0;
    }

    private void m384a(String str) {
        if (!TextUtils.isEmpty(str)) {
            C0230s.m551a(new C0201j(this, str));
        }
    }

    private String m385b(String str) {
        try {
            return "romonline".equals(f205a) ? C0183h.m338a().m339a("http://app.50bang.org/api/?api=soft_zhushou_singleApk", EncryptUtil.encrypt("NeA==Sv#i8wMDg.G9+M#j30M08rVst0", str), this) : C0183h.m338a().m340a("http://app.50bang.org/tongji_module_v2/?_c=pubinstall&action=session", "http://app.50bang.org/tongji_module_v2/?_c=pubinstall&action=sendData", EncryptUtil.encrypt(C0229r.getPromotionMethod(MyApplication.getCt(), "app_key"), str), MyApplication.getCt());
        } catch (Exception e) {
            Exception exception = e;
            String str2 = "";
            exception.printStackTrace();
            return str2;
        }
    }

    private void m386b() {
        C0230s.m551a(new C0202k(this));
    }

    private void m387c() {
        C0230s.m551a(new C0203l(this));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        String str;
        super.onCreate();
        CharSequence a = C0229r.getPromotionMethod(MyApplication.getCt(), "promotion_method");
        if (TextUtils.isEmpty(a)) {
            str = "";
        } else {
            CharSequence charSequence = a;
        }
        f205a = str;
        f206b = "romonline".equals(a) ? 0 : 200;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            switch (intent.getIntExtra("cmd", -1)) {
                case ViewDragHelper.STATE_IDLE /*0*/:
                    m386b();
                    break;
                case ViewDragHelper.STATE_DRAGGING /*1*/:
                    m384a(intent.getStringExtra("app_pkgname"));
                    break;
                case ViewDragHelper.STATE_SETTLING /*2*/:
                    m387c();
                    break;
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
