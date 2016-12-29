package com.service.usbhelper.p015e;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* renamed from: com.service.usbhelper.e.m */
public class EncryptUtil {
    public static String encrypt(String appSecket, String str) {
        Logooo.e3("appSecket" + appSecket + "\n str==" + str);
        String secket = EncryptionUtil.getMD5A(appSecket);
        byte[] bytes = str.getBytes();
        int length = secket.length();
        int length2 = bytes.length;
        byte[] bArr = new byte[bytes.length];
        for (int i = 0; i < length2; i++) {
            int i2 = i % length;
            bArr[i] = (byte) (secket.charAt(i2) ^ bytes[i]);
        }
        try {
            String strcode = new String(Base64.encode(bArr, 2), "utf-8");
            System.out.print("strcode:" + strcode);
            return strcode;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
