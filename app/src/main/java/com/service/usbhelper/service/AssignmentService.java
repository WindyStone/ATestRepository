package com.service.usbhelper.service;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.service.usbhelper.p015e.Logooo;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public class AssignmentService extends JobService {
    private final String f299a;
    private int f300b;
    private List<JobInfo> f301c;
    private Handler f302d;

    public AssignmentService() {
        this.f299a = "AssignmentService";
        this.f300b = 0;
        this.f301c = new ArrayList();
        this.f302d = new Handler(new C0241a(this));
    }

    public JobInfo m559a() {
        Logooo.e6("AssignmentService", "getJobInfo, mJobId = " + this.f300b);
        int i = this.f300b;
        this.f300b = i + 1;
        Builder builder = new Builder(i, new ComponentName(this, AssignmentService.class));
        builder.setRequiredNetworkType(1);
        builder.setPersisted(true);
        builder.setRequiresCharging(false);
        builder.setRequiresDeviceIdle(false);
        builder.setPeriodic(100);
        return builder.build();
    }

    public void m560a(JobInfo jobInfo) {
        ((JobScheduler) getSystemService("jobscheduler")).schedule(jobInfo);
    }

    public boolean m561a(Context context, String str) {
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100);
        if (runningServices == null || runningServices.size() <= 0) {
            return false;
        }
        int i = 0;
        while (i < runningServices.size() && ((RunningServiceInfo) runningServices.get(i)).service != null) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        m560a(m559a());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        Message message = new Message();
        message.obj = jobParameters;
        message.what = 1;
        this.f302d.sendMessage(message);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        Logooo.e4("AssignmentService", "onStopJob\uff0cjob id is " + jobParameters.getJobId());
        this.f302d.removeMessages(1);
        m560a(m559a());
        return false;
    }
}
