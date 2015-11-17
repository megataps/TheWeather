package com.demo.theweather.model;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class TimeZone {

    private String mLocalTime;
    private double mUtcOffset;

    public String getLocalTime() {
        return mLocalTime;
    }

    public void setLocalTime(String localTime) {
        mLocalTime = localTime;
    }

    public double getUtcOffset() {
        return mUtcOffset;
    }

    public void setUtcOffset(double utcOffset) {
        mUtcOffset = utcOffset;
    }
}
