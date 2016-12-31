package com.service.usbhelper.p015e;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.service.usbhelper.MyApplication;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

/* renamed from: com.service.usbhelper.e.l */
public class DeviceUtils {
    public static String getMac() {
        String trim;
        Context context = MyApplication.getCt();
        SharedPreferences sp = SharedPreferencesManager.getSharedPreferences(context);
        String mac = sp.getString("MAC", "");
        try {
            if (TextUtils.isEmpty(mac)) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo();
                if (connectionInfo != null) {
                    mac = connectionInfo.getMacAddress();
                }
                if (mac != null) {
                    trim = mac.replaceAll(":", "").replaceAll("\\.", "").toLowerCase(Locale.US).trim();
                    sp.edit().putString("MAC", trim).commit();
                } else {
                    trim = "";
                }
            } else {
                trim = mac;
            }
        } catch (Exception e) {
            trim = "";
        }
        if ("020000000000".equals(trim)) {
            trim = DeviceUtils.getHardwareAddress();
        }
        return trim == null ? "" : trim.trim();
    }

    public static String getImei(Context context) {
        if (context == null) {
            return "";
        }
        SharedPreferences sp = SharedPreferencesManager.getSharedPreferences(context);
        String imei = "";
        if (sp.contains("tj_imei")) {
            imei = sp.getString("tj_imei", "");
        }
        if (TextUtils.isEmpty(imei)) {
            try {
                String deviceId = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
                if (TextUtils.isEmpty(deviceId)) {
                    imei = "";
                } else {
                    imei = deviceId.trim();
                    sp.edit().putString("tj_imei", imei).commit();
                }
            } catch (SecurityException e) {
                e.getStackTrace();
                imei = "";
            } catch (Exception e2) {
                imei = "";
            }
        }
        return imei == null ? "" : imei.trim();
    }

    public static String m496a(String str, int i) {
        String random = String.valueOf(Math.random());
        if (random.contains(".")) {
            String[] split = random.split("\\.");
            random = (split == null || split.length < 2 || split[1].length() <= i) ? DeviceUtils.m496a("", i) : split[1].substring(split[1].length() - i, split[1].length());
        } else {
            random = random.length() > i ? random.substring(random.length() - i, random.length()) : DeviceUtils.m496a("", i);
        }
        return str + random;
    }

    public static String getUid(Context context) {
        String uid = "";
        if (context != null) {
            SharedPreferences sp = SharedPreferencesManager.getSharedPreferences(context);
            if (sp != null && sp.contains("uid")) {
                uid = sp.getString("uid", "");
            }
            if (TextUtils.isEmpty(uid)) {
                uid = DeviceUtils.getImei(context);
                if (TextUtils.isEmpty(uid)) {
                    uid = DeviceUtils.getMac();
                    if (TextUtils.isEmpty(uid)) {
                        uid = DeviceUtils.m496a("#", 14);
                    }
                }
                if (!(TextUtils.isEmpty(uid) || sp == null)) {
                    sp.edit().putString("uid", uid).commit();
                }
            }
        }
        return uid == null ? "" : uid.trim();
    }

    public static boolean m498b() {
        String str;
        String str2;
        Exception exception;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            str = (String) method.invoke(null, new Object[]{"ro.yunos.version"});
            try {
                str2 = (String) method.invoke(null, new Object[]{"java.vm.name"});
            } catch (Exception e) {
                Exception exception2 = e;
                str2 = str;
                exception = exception2;
                exception.printStackTrace();
                str = str2;
                str2 = null;
                if (str2 == null) {
                }
            }
        } catch (Exception e2) {
            exception = e2;
            str2 = null;
            exception.printStackTrace();
            str = str2;
            str2 = null;
            if (str2 == null) {
            }
        }
        return (str2 == null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }

    public static String m499c() {
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.yunos.version"});
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return (str == null || str.trim().length() <= 0) ? "" : str;
    }

    public static String getUuid(Context context) {
        String systemUuid = C0229r.getSystemUuid();
        if (!TextUtils.isEmpty(systemUuid)) {
            int length = systemUuid.length();
            if (length > 6) {
                return systemUuid.substring(5, length);
            }
        }
        systemUuid = DeviceUtils.getImei(context);
        String sim = DeviceUtils.getSimOperator(context);
        //sim = "TJUUIDENCODEKEY1";
        systemUuid = AESEncryptUtil.getAESEncrypt(sim, systemUuid + sim + DeviceUtils.m502d(context) + DeviceUtils.getMac().replaceAll(":", "").replaceAll("\\.", "").toLowerCase(Locale.US));
        if (systemUuid != null) {
            try {
                C0229r.m530c(systemUuid);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return systemUuid == null ? "" : systemUuid;
    }

    private static String getHardwareAddress() {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        String stringBuilder2 = stringBuilder.toString();
                        if (!TextUtils.isEmpty(stringBuilder2)) {
                            SharedPreferencesManager.getSharedPreferences(MyApplication.getCt()).edit().putString("MAC", stringBuilder2).commit();
                        }
                        return stringBuilder2.toLowerCase();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String m502d(Context context) {
        if (context == null) {
            return "";
        }
        String string;
        String str = "";
        try {
            string = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            string = str;
        }
        return string == null ? "" : string.trim();
    }

    private static String getSimOperator(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager == null) {
                return "";
            }
            String str = telephonyManager.getSubscriberId();
            String simOperator = (str == null || "".equals(str)) ? telephonyManager.getSimOperator() : str;
            return simOperator == null ? "" : simOperator;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
