package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class Astronomy implements Parcelable {

    private String mSunrise;
    private String mSunset;
    private String mMoonrise;
    private String mMoonset;

    public String getSunrise() {
        return mSunrise;
    }

    public void setSunrise(String sunrise) {
        mSunrise = sunrise;
    }

    public String getSunset() {
        return mSunset;
    }

    public void setSunset(String sunset) {
        mSunset = sunset;
    }

    public String getMoonrise() {
        return mMoonrise;
    }

    public void setMoonrise(String moonrise) {
        mMoonrise = moonrise;
    }

    public String getMoonset() {
        return mMoonset;
    }

    public void setMoonset(String moonset) {
        mMoonset = moonset;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mSunrise);
        dest.writeString(this.mSunset);
        dest.writeString(this.mMoonrise);
        dest.writeString(this.mMoonset);
    }

    public Astronomy() {
    }

    protected Astronomy(Parcel in) {
        this.mSunrise = in.readString();
        this.mSunset = in.readString();
        this.mMoonrise = in.readString();
        this.mMoonset = in.readString();
    }

    public static final Creator<Astronomy> CREATOR = new Creator<Astronomy>() {
        public Astronomy createFromParcel(Parcel source) {
            return new Astronomy(source);
        }

        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };
}
