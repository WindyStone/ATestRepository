package com.service.usbhelper;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.service.usbhelper.p015e.SharedPreferencesManager;
import com.service.usbhelper.p015e.C0229r;
import org.json.JSONException;
import org.json.JSONObject;

public class TwinkleActivity extends Activity {
    public static int f95a;
    private static String f96h;
    Handler f97b;
    private TextView f98c;
    private TextView f99d;
    private TextView f100e;
    private TextView f101f;
    private ImageView f102g;
    private C0238h f103i;
    private int f104j;
    private TextView f105k;

    static {
        f95a = -1;
        f96h = null;
    }

    public TwinkleActivity() {
        this.f104j = -1;
        this.f97b = new C0236f(this);
    }

    private void m238a(int i, int i2) {
        CharSequence charSequence;
        if (i == 0) {
            if ("hzself".equals(C0229r.getPromotionMethod(MyApplication.getCt(), "promotion_method"))) {
                charSequence = "\n\n";
                SharedPreferences a = SharedPreferencesManager.getSharedPreferences(MyApplication.getCt());
                if (!TextUtils.isEmpty(a.getString("box_id", ""))) {
                    charSequence = charSequence + String.format(getString(2131099652), new Object[]{r2});
                }
                if (!TextUtils.isEmpty(a.getString("box_version", ""))) {
                    charSequence = charSequence + String.format(getString(2131099653), new Object[]{r1});
                }
                this.f101f.setText(charSequence);
                this.f101f.setVisibility(0);
                return;
            }
        }
        if (i2 != -1 && this.f101f != null) {
            if (1 == i) {
                this.f101f.setVisibility(0);
            } else {
                this.f101f.setVisibility(4);
            }
            int i3 = i2 % 60;
            if (i2 / 60 < 0 || i3 <= 0) {
                this.f101f.setVisibility(4);
                return;
            }
            charSequence = String.format(getResources().getString(2131099664), new Object[]{String.valueOf(r0), String.valueOf(i3)});
            if (!TextUtils.isEmpty(charSequence)) {
                this.f101f.setText(charSequence);
            }
        } else if (this.f101f != null) {
            this.f101f.setVisibility(4);
        }
    }

    private void m239a(int i, int i2, int i3) {
        m242a(4, String.format(getString(2131099662), new Object[]{String.valueOf(i2 + i3), String.valueOf(i)}), -1);
        f95a = 2;
    }

    private void m240a(int i, int i2, int i3, int i4) {
        m242a(1, String.format(getString(2131099663), new Object[]{String.valueOf(i2)}), i4);
        f95a = 3;
        new Thread(new C0237g(this)).start();
    }

    private void m241a(int i, String str) {
        if (this.f98c != null) {
            if (i == 0) {
                this.f105k.setVisibility(0);
                this.f98c.setText(getString(2131099657));
                this.f98c.setTextColor(getResources().getColor(2131034112));
            } else if (1 == i) {
                this.f105k.setVisibility(8);
                if (TextUtils.isEmpty(str)) {
                    this.f98c.setText(getString(2131099661));
                    this.f98c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    return;
                }
                CharSequence spannableString = new SpannableString(str);
                int indexOf = str.indexOf("\u4e2a");
                if (indexOf != -1) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131034115)), 0, 4, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131034112)), 4, indexOf, 33);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131034115)), indexOf, str.length(), 33);
                    this.f98c.setText(spannableString);
                }
            } else if (2 == i) {
                this.f105k.setVisibility(8);
                this.f98c.setText(getString(2131099654));
                this.f98c.setTextColor(getResources().getColor(2131034115));
            } else if (3 == i) {
                this.f105k.setVisibility(8);
                this.f98c.setText(getString(2131099668));
                this.f98c.setTextColor(getResources().getColor(2131034115));
            } else if (4 == i) {
                this.f105k.setVisibility(8);
                this.f98c.setText(getString(2131099666));
                this.f98c.setTextColor(getResources().getColor(2131034115));
            }
        }
    }

    private void m242a(int i, String str, int i2) {
        if (1 == i) {
            m241a(i, str);
        } else {
            m241a(i, null);
        }
        m250b(i);
        m238a(i, i2);
        m251b(i, str);
        m256c(i);
    }

    private void m243a(Intent intent) {
        switch (intent.getIntExtra("communication_status", 0)) {
            case ViewDragHelper.STATE_IDLE /*0*/:
                m257c(intent);
            case ViewDragHelper.STATE_DRAGGING /*1*/:
                m252b(intent);
            case ViewDragHelper.STATE_SETTLING /*2*/:
                m255c();
            default:
        }
    }

    private void m247a(String str) {
        if (this.f97b != null) {
            this.f97b.removeCallbacksAndMessages(null);
            this.f97b.sendEmptyMessageDelayed(0, 11000);
        }
        if (m253b(C0229r.getPromotionMethod(MyApplication.getCt(), "promotion_method"))) {
            m242a(0, getString(2131099656), -1);
        } else {
            m242a(0, "", -1);
        }
        f95a = 1;
        f96h = str;
    }

    private void m249b() {
        this.f98c = (TextView) findViewById(2131165187);
        this.f99d = (TextView) findViewById(2131165188);
        this.f100e = (TextView) findViewById(2131165189);
        this.f102g = (ImageView) findViewById(2131165186);
        this.f101f = (TextView) findViewById(2131165190);
        this.f105k = (TextView) findViewById(2131165184);
    }

    private void m250b(int i) {
        if (this.f102g != null) {
            if (2 == i) {
                this.f102g.setImageResource(2130837514);
            } else if (3 == i) {
                this.f102g.setImageResource(2130837515);
            } else if (4 == i) {
                this.f102g.setImageResource(2130837509);
            } else {
                this.f102g.setImageResource(2130837511);
            }
        }
    }

    private void m251b(int i, String str) {
        if (this.f99d != null) {
            if (TextUtils.isEmpty(str)) {
                this.f99d.setVisibility(4);
            }
            this.f99d.setVisibility(0);
            if (i == 0) {
                this.f99d.setText(str);
                this.f99d.setTextColor(getResources().getColor(2131034113));
            } else if (1 == i) {
                this.f99d.setVisibility(4);
            } else if (2 == i) {
                this.f99d.setText(str);
                this.f99d.setTextColor(getResources().getColor(2131034113));
            } else if (3 == i) {
                this.f99d.setText(str);
                this.f99d.setTextColor(getResources().getColor(2131034113));
            } else if (4 == i) {
                this.f99d.setText(str);
                this.f99d.setTextColor(getResources().getColor(2131034113));
            }
        }
    }

    private void m252b(Intent intent) {
        if (intent != null) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("install_extra"));
                if (jSONObject.getBoolean("uninstallStat")) {
                    m259e();
                } else {
                    int i = jSONObject.getInt("installCount");
                    int i2 = jSONObject.getInt("successCount");
                    int i3 = jSONObject.getInt("failCount");
                    int i4 = -1;
                    if (jSONObject.has("spanTimes")) {
                        i4 = jSONObject.getInt("spanTimes") - 60;
                    }
                    if (jSONObject.getBoolean("finish")) {
                        m240a(i, i2, i3, i4);
                    } else {
                        m239a(i, i2, i3);
                    }
                }
                f96h = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean m253b(String str) {
        return TextUtils.isEmpty(str) ? false : "huaxia".equals(str) || "hzself".equals(str);
    }

    private void m255c() {
        this.f97b.removeMessages(0);
        this.f97b.sendEmptyMessageDelayed(0, 11000);
    }

    private void m256c(int i) {
        if (this.f100e != null) {
            this.f100e.setVisibility(4);
            if (i == 0) {
                this.f100e.setText(2131099658);
                Drawable drawable = VERSION.SDK_INT <= 21 ? getResources().getDrawable(2130837512) : getResources().getDrawable(2130837512, null);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f100e.setCompoundDrawablePadding(C0229r.m518a(5));
                    this.f100e.setCompoundDrawables(drawable, null, null, null);
                    this.f100e.setText(2131099658);
                    return;
                }
                return;
            }
            this.f100e.setVisibility(8);
        }
    }

    private void m257c(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("install_extra");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "{\"connectStatus\": \"true\"}";
                }
                JSONObject jSONObject = new JSONObject(stringExtra);
                if (jSONObject.has("disableFunc") && jSONObject.getBoolean("disableFunc")) {
                    finish();
                } else if (jSONObject.getBoolean("connectStatus")) {
                    m247a(jSONObject.toString());
                } else {
                    m258d();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void m258d() {
        m242a(2, getString(2131099660), -1);
        this.f97b.sendEmptyMessageDelayed(1, 3000);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("communication_status", 0);
            jSONObject.put("connectStatus", false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        f96h = jSONObject.toString();
        f95a = 4;
        m260a(this.f104j);
    }

    private void m259e() {
        m242a(3, getString(2131099669), -1);
        f95a = 5;
    }

    public void m260a(int i) {
        ((NotificationManager) getSystemService("notification")).cancel(i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_install_status);
        m249b();
        this.f103i = new C0238h(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("heartbeat");
        intentFilter.addAction("heartbeat");
        intentFilter.addAction("socket 505");
        registerReceiver(this.f103i, intentFilter);
        m243a(getIntent());
    }

    protected void onDestroy() {
        unregisterReceiver(this.f103i);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m243a(getIntent());
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        ((NotificationManager) getSystemService("notification")).cancel(1);
        if (!this.f97b.hasMessages(0)) {
            this.f97b.sendEmptyMessageDelayed(0, 11000);
        }
    }

    protected void onStop() {
        super.onStop();
    }
}
