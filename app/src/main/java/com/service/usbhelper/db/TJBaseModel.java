package com.service.usbhelper.db;

public class TJBaseModel {
    public String appid;
    public int duration;
    public long end;
    public String pkgname;
    public int session_id;
    public long start;
    public int start_sended;

    public String getAppid() {
        return this.appid;
    }

    public int getDuration() {
        return this.duration;
    }

    public long getEnd() {
        return this.end;
    }

    public String getPkgname() {
        return this.pkgname;
    }

    public int getSession_id() {
        return this.session_id;
    }

    public long getStart() {
        return this.start;
    }

    public int getStart_sended() {
        return this.start_sended;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public void setPkgname(String str) {
        this.pkgname = str;
    }

    public void setSession_id(int i) {
        this.session_id = i;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public void setStart_sended(int i) {
        this.start_sended = i;
    }

    public String toString() {
        return "sessiondi:" + this.session_id + "\t pkgname:" + this.pkgname + "\t duration:" + this.duration;
    }
}
