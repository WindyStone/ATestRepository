package com.service.usbhelper.p015e;

/* renamed from: com.service.usbhelper.e.q */
public class UrlsManager {
    public static String sendData;
    public static String getStatisticList;
    public static String api_usbhelp_config;
    public static String usbhelp_time;

    static {
        sendData = "http://app.50bang.org/index.php?action=sendData";
        getStatisticList = "http://shouji.2345.com/api/getStatisticList.php";
        api_usbhelp_config = "http://shouji.2345.com/api/api_usbhelp_config.php";
        usbhelp_time = "http://shouji.2345.com/api/usbhelp_time.php";
    }
}
