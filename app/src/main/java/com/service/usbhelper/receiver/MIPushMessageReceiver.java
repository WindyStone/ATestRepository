package com.service.usbhelper.receiver;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.service.usbhelper.MyApplication;
import com.service.usbhelper.service.HelperService;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.List;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

public class MIPushMessageReceiver extends PushMessageReceiver {
    private String TAG;
    private String mAlias;
    private String mCommand;
    private int mFragmentEvent;
    private String mMessage;
    private String mReason;
    private String mRegId;
    private long mResultCode;
    private String mTopic;

    public MIPushMessageReceiver() {
        this.mResultCode = -1;
        this.TAG = "MIPush";
        this.mFragmentEvent = 0;
    }

    public void onCommandResult(Context context, MiPushCommandMessage message) {
        Log.e(this.TAG, "onCommandResult is called. " + message.toString());
        String a = message.getCommand();
        List b = message.getCommandArguments();
        String str = (b == null || b.size() <= 0) ? null : (String) b.get(0);
        if (b != null && b.size() > 1) {
            String str2 = (String) b.get(1);
        }
        if (MiPushClient.COMMAND_REGISTER.equals(a)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                this.mRegId = str;
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(a)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                this.mAlias = str;
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(a)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                this.mAlias = str;
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(a)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                this.mTopic = str;
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(a)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                this.mTopic = str;
            }
        } else if (!"accept-time".equals(a)) {
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage message) {
        Log.e(this.TAG, "onNotificationMessageArrived is called. " + message.toString());
        this.mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
            this.mTopic = message.getTopic();
        } else if (!TextUtils.isEmpty(message.getAlias())) {
            this.mAlias = message.getAlias();
        }
        MyApplication.getCt().startService(new Intent(MyApplication.getCt(), HelperService.class));
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage c0410f) {
        Log.e(this.TAG, "onNotificationMessageClicked is called. " + c0410f.toString());
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage message) {
        Log.e(this.TAG, "onReceivePassThroughMessage is called. " + message.toString());
        this.mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
            this.mTopic = message.getTopic();
        } else if (!TextUtils.isEmpty(message.getAlias())) {
            this.mAlias = message.getAlias();
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        Log.e(this.TAG, "onReceiveRegisterResult is called. " + message.toString());
        String a = message.getCommand();
        List b = message.getCommandArguments();
        String str = (b == null || b.size() <= 0) ? null : (String) b.get(0);
        if (b != null && b.size() > 1) {
            String str2 = (String) b.get(1);
        }
        if (MiPushClient.COMMAND_REGISTER.equals(a) && message.getResultCode() == ErrorCode.SUCCESS) {
            this.mRegId = str;
        }
    }
}
