package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class Weather implements Parcelable {

    private Astronomy mAstronomy;
    private String mDate;
    private String mTempMaxC;
    private String mTempMaxF;
    private String mTempMinC;
    private String mTempMinF;
    private String mWindspeedMiles;
    private String mWindspeedKmph;
    private String mWinddirection;
    private String mWeatherCode;
    private String mWeatherIconUrl;
    private String mWeatherDesc;
    private String mPrecipMM;

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

    public String getTempMaxC() {
        return mTempMaxC;
    }

    public void setTempMaxC(String tempMaxC) {
        mTempMaxC = tempMaxC;
    }

    public String getTempMaxF() {
        return mTempMaxF;
    }

    public void setTempMaxF(String tempMaxF) {
        mTempMaxF = tempMaxF;
    }

    public String getTempMinC() {
        return mTempMinC;
    }

    public void setTempMinC(String tempMinC) {
        mTempMinC = tempMinC;
    }

    public String getTempMinF() {
        return mTempMinF;
    }

    public void setTempMinF(String tempMinF) {
        mTempMinF = tempMinF;
    }

    public String getWindspeedMiles() {
        return mWindspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        mWindspeedMiles = windspeedMiles;
    }

    public String getWindspeedKmph() {
        return mWindspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        mWindspeedKmph = windspeedKmph;
    }

    public String getWinddirection() {
        return mWinddirection;
    }

    public void setWinddirection(String winddirection) {
        mWinddirection = winddirection;
    }

    public String getWeatherCode() {
        return mWeatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        mWeatherCode = weatherCode;
    }

    public String getWeatherIconUrl() {
        return mWeatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        mWeatherIconUrl = weatherIconUrl;
    }

    public String getWeatherDesc() {
        return mWeatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        mWeatherDesc = weatherDesc;
    }

    public String getPrecipMM() {
        return mPrecipMM;
    }

    public void setPrecipMM(String precipMM) {
        mPrecipMM = precipMM;
    }

    public Weather() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mAstronomy, 0);
        dest.writeString(this.mDate);
        dest.writeString(this.mTempMaxC);
        dest.writeString(this.mTempMaxF);
        dest.writeString(this.mTempMinC);
        dest.writeString(this.mTempMinF);
        dest.writeString(this.mWindspeedMiles);
        dest.writeString(this.mWindspeedKmph);
        dest.writeString(this.mWinddirection);
        dest.writeString(this.mWeatherCode);
        dest.writeString(this.mWeatherIconUrl);
        dest.writeString(this.mWeatherDesc);
        dest.writeString(this.mPrecipMM);
    }

    protected Weather(Parcel in) {
        this.mAstronomy = in.readParcelable(Astronomy.class.getClassLoader());
        this.mDate = in.readString();
        this.mTempMaxC = in.readString();
        this.mTempMaxF = in.readString();
        this.mTempMinC = in.readString();
        this.mTempMinF = in.readString();
        this.mWindspeedMiles = in.readString();
        this.mWindspeedKmph = in.readString();
        this.mWinddirection = in.readString();
        this.mWeatherCode = in.readString();
        this.mWeatherIconUrl = in.readString();
        this.mWeatherDesc = in.readString();
        this.mPrecipMM = in.readString();
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
