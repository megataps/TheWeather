package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class Weather implements Parcelable {

    private Astronomy mAstronomy;
    private String mDate;
    private double mTempMaxC;
    private double mTempMaxF;
    private double mTempMinC;
    private double mTempMinF;

    public Astronomy getAstronomy() {
        return mAstronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        mAstronomy = astronomy;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public double getTempMaxC() {
        return mTempMaxC;
    }

    public void setTempMaxC(double tempMaxC) {
        mTempMaxC = tempMaxC;
    }

    public double getTempMaxF() {
        return mTempMaxF;
    }

    public void setTempMaxF(double tempMaxF) {
        mTempMaxF = tempMaxF;
    }

    public double getTempMinC() {
        return mTempMinC;
    }

    public void setTempMinC(double tempMinC) {
        mTempMinC = tempMinC;
    }

    public double getTempMinF() {
        return mTempMinF;
    }

    public void setTempMinF(double tempMinF) {
        mTempMinF = tempMinF;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mAstronomy, 0);
        dest.writeString(this.mDate);
        dest.writeDouble(this.mTempMaxC);
        dest.writeDouble(this.mTempMaxF);
        dest.writeDouble(this.mTempMinC);
        dest.writeDouble(this.mTempMinF);
    }

    public Weather() {
    }

    protected Weather(Parcel in) {
        this.mAstronomy = in.readParcelable(Astronomy.class.getClassLoader());
        this.mDate = in.readString();
        this.mTempMaxC = in.readDouble();
        this.mTempMaxF = in.readDouble();
        this.mTempMinC = in.readDouble();
        this.mTempMinF = in.readDouble();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
