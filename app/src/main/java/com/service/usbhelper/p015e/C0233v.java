package com.service.usbhelper.p015e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.service.usbhelper.MyApplication;

/* renamed from: com.service.usbhelper.e.v */
public class C0233v {
    private static Toast f294a;

    static {
        f294a = null;
    }

    public static void m553a(String str, int i) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str)) {
            if (f294a == null) {
                f294a = Toast.makeText(MyApplication.getCt(), str, 0);
                View inflate = LayoutInflater.from(MyApplication.getCt()).inflate(2130903042, null);
                ((TextView) inflate.findViewById(2131165191)).setText(str);
                f294a.setView(inflate);
            } else {
                View view = f294a.getView();
                if (view instanceof LinearLayout) {
                    TextView textView = (TextView) view.findViewById(2131165191);
                    if (textView != null) {
                        textView.setText(str);
                    }
                } else {
                    f294a.setText(str);
                }
            }
            int d = C0229r.m531d();
            f294a.setGravity(48, 0, d > 0 ? d / 20 : 0);
            Toast toast = f294a;
            if (i != 1000) {
                i2 = 1;
            }
            toast.setDuration(i2);
            f294a.show();
        }
    }
}
