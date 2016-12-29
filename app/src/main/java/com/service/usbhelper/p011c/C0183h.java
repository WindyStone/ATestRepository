package com.service.usbhelper.p011c;

import android.content.Context;
import android.text.TextUtils;
import com.service.usbhelper.p015e.EncryptionUtil;
import com.service.usbhelper.p015e.Logooo;
import com.service.usbhelper.p015e.C0229r;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.service.usbhelper.c.h */
public class C0183h {
    private static C0183h f157d;
    private static String Tag;
    private DefaultHttpClient mHttpClient;
    private HttpPost mHttpPost;
    private HttpGet mHttpGet;

    static {
        Tag = "HttpRequestUtil";
    }

    private C0183h() {
        HttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        basicHttpParams.setParameter("http.protocol.content-charset", "UTF-8");
        basicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(15000));
        basicHttpParams.setParameter("http.connection.stalecheck", Boolean.valueOf(false));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    public static C0183h m338a() {
        f157d = new C0183h();
        return f157d;
    }

    public String m339a(String str, String str2, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        mHttpPost = new HttpPost(str);
        List arrayList = new ArrayList();
        stringBuilder.append(str2);
        arrayList.add(new BasicNameValuePair("content", URLEncoder.encode(str2, "utf-8")));
        if (arrayList != null && arrayList.size() > 0) {
            this.mHttpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
        }
        HttpResponse execute = mHttpClient.execute(mHttpPost);
        if (execute.getStatusLine().getStatusCode() != 200) {
            return null;
        }
        String entityUtils = EntityUtils.toString(execute.getEntity());
        Logooo.e4(Tag, "sendDataResult:" + entityUtils);
        return entityUtils;
    }

    public String m340a(String url, String url2, String params, Context context) {
        String result = "";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(params);
            mHttpPost = new HttpPost(url2);
            if (!TextUtils.isEmpty(url)) {
                stringBuilder.append(getSessIdFromServer(url, mHttpPost));//获得sid和key，并把sid、key、PHPSESSID、tid放入mHttpPost
            }
            String md5 = EncryptionUtil.getMD5B(stringBuilder.toString());
            List<BasicNameValuePair> entityList = new ArrayList<>();
            entityList.add(new BasicNameValuePair("project", C0229r.getPromotionMethod(context, "project_name")));
            entityList.add(new BasicNameValuePair("data", URLEncoder.encode(params, "utf-8")));
            entityList.add(new BasicNameValuePair("sign", md5));
            if (entityList.size() > 0) {
                mHttpPost.setEntity(new UrlEncodedFormEntity(entityList, "UTF-8"));
            }
            HttpResponse response = mHttpClient.execute(mHttpPost);
            if (response.getStatusLine().getStatusCode() != 200) {
                return result;
            }
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logooo.e4(Tag, "sendDataResult:" + result);
        return result;
    }

    public String m341a(String str, ArrayList<BasicNameValuePair> arrayList) {
        mHttpPost = new HttpPost(str);
        if (arrayList != null && arrayList.size() > 0) {
            mHttpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
        }
        HttpResponse execute = this.mHttpClient.execute(mHttpPost);
        return execute.getStatusLine().getStatusCode() == 200 ? EntityUtils.toString(execute.getEntity()) : null;
    }

    public String getSessIdFromServer(String url, HttpPost httpPost) {
        mHttpGet = new HttpGet(url);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpResponse response = mHttpClient.execute(mHttpGet);
            if (response == null) {
                return "";
            }
            Header[] headers = response.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                String value = headers[i].getValue();
                if (value.contains("sid")) {
                    int index = value.indexOf("=");
                    stringBuilder.append(value.substring(index + 1));
                    httpPost.setHeader("sid", value.substring(index + 1));
                }
                if (value.contains("key")) {
                    int index = value.indexOf("=");
                    stringBuilder.append(value.substring(index + 1));
                    httpPost.setHeader("key", value.substring(index + 1));
                }
                if (value.contains("PHPSESSID")) {
                    httpPost.setHeader("PHPSESSID", value.substring(value.indexOf("=") + 1));
                }
                if (value.contains("tid")) {
                    httpPost.setHeader("tid", value.substring(value.indexOf("=") + 1));
                }
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public String m343b(String str, ArrayList<BasicNameValuePair> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            String str2 = str + "?";
            String str3 = "";
            int i = 0;
            while (i < arrayList.size()) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
                i++;
                str2 = basicNameValuePair.getValue() != null ? str2 + (basicNameValuePair.getName() + "=" + basicNameValuePair.getValue() + "&") : str2;
            }
            str = str2;
        }
        this.mHttpGet = new HttpGet(str);
        HttpResponse execute = mHttpClient.execute(mHttpGet);
        return execute.getStatusLine().getStatusCode() == 200 ? EntityUtils.toString(execute.getEntity()) : null;
    }
}
