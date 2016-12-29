package com.service.usbhelper.service;

import android.app.job.JobParameters;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.service.usbhelper.p015e.Logooo;

/* renamed from: com.service.usbhelper.service.a */
class C0241a implements Callback {
    final /* synthetic */ AssignmentService f321a;

    C0241a(AssignmentService assignmentService) {
        this.f321a = assignmentService;
    }

    public boolean handleMessage(Message message) {
        Logooo.e4("AssignmentService", "onStartJob, job id is " + ((JobParameters) message.obj).getJobId());
        boolean a = this.f321a.m561a(this.f321a, HelperService.class.getName());
        boolean a2 = this.f321a.m561a(this.f321a, UsbConnectService.class.getName());
        if (!(a && a2)) {
            this.f321a.startService(new Intent(this.f321a, HelperService.class));
            this.f321a.startService(new Intent(this.f321a, UsbConnectService.class));
        }
        this.f321a.jobFinished((JobParameters) message.obj, true);
        return true;
    }
}
