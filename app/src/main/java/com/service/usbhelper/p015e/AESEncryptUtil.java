package com.service.usbhelper.p015e;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.service.usbhelper.e.a */
public class AESEncryptUtil {

    public static String getAESEncrypt(String str, String str2) {
        Cipher cipher;
        try {
            Key key = new SecretKeySpec(str.getBytes(), "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        byte[] content = new byte[0];
        try {
            content = cipher.doFinal(str2.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        String result = new String(Base64.encode(content, 2));
        try {
            result = URLEncoder.encode(result, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }
}
