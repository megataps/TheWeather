package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class Astronomy implements Parcelable {

    private Date mSunrise;
    private Date mSunset;
    private Date mMoonrise;
    private Date mMoonset;

    public Date getSunrise() {
        return mSunrise;
    }

    public void setSunrise(Date sunrise) {
        mSunrise = sunrise;
    }

    public Date getSunset() {
        return mSunset;
    }

    public void setSunset(Date sunset) {
        mSunset = sunset;
    }

    public Date getMoonrise() {
        return mMoonrise;
    }

    public void setMoonrise(Date moonrise) {
        mMoonrise = moonrise;
    }

    public Date getMoonset() {
        return mMoonset;
    }

    public void setMoonset(Date moonset) {
        mMoonset = moonset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mSunrise != null ? mSunrise.getTime() : -1);
        dest.writeLong(mSunset != null ? mSunset.getTime() : -1);
        dest.writeLong(mMoonrise != null ? mMoonrise.getTime() : -1);
        dest.writeLong(mMoonset != null ? mMoonset.getTime() : -1);
    }

    public Astronomy() {
    }

    protected Astronomy(Parcel in) {
        long tmpMSunrise = in.readLong();
        this.mSunrise = tmpMSunrise == -1 ? null : new Date(tmpMSunrise);
        long tmpMSunset = in.readLong();
        this.mSunset = tmpMSunset == -1 ? null : new Date(tmpMSunset);
        long tmpMMoonrise = in.readLong();
        this.mMoonrise = tmpMMoonrise == -1 ? null : new Date(tmpMMoonrise);
        long tmpMMoonset = in.readLong();
        this.mMoonset = tmpMMoonset == -1 ? null : new Date(tmpMMoonset);
    }

    public static final Parcelable.Creator<Astronomy> CREATOR = new Parcelable.Creator<Astronomy>() {
        public Astronomy createFromParcel(Parcel source) {
            return new Astronomy(source);
        }

        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };
}
