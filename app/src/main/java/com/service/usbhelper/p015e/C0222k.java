package com.service.usbhelper.p015e;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.service.usbhelper.e.k */
public class C0222k {
    public static int m491a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int m492a(Context context, long j) {
        int i = 0;
        if (!(context == null || j == 0)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                i = (int) (simpleDateFormat.parse(simpleDateFormat.format(new Date(1000 * j))).getTime() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Logooo.e3("dayStamp:formatTimeStampByDay==" + i);
        }
        return i;
    }

    public static String m493a(long j, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(j));
    }
}
