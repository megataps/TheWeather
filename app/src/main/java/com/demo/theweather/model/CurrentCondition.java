package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/21/15.
 */
public class CurrentCondition implements Parcelable {

    private String mObservationTime;
    private double mTempC;
    private double mTempF;
    private String mWeatherCode;
    private String mWeatherIconUrl;
    private String mWeatherDesc;
    private String mWindspeedMiles;
    private String mWindspeedKmph;
    private String mWinddirDegree;
    private String mWinddir16Point;
    private String mPrecipMM;
    private String mHumidity;
    private String mVisibility;
    private String mPressure;
    private String mCloudcover;

    private String mFeelsLikeC;
    private String mFeelsLikeF;

    public String getObservationTime() {
        return mObservationTime;
    }

    public void setObservationTime(String observationTime) {
        mObservationTime = observationTime;
    }

    public double getTempC() {
        return mTempC;
    }

    public void setTempC(double tempC) {
        mTempC = tempC;
    }

    public double getTempF() {
        return mTempF;
    }

    public void setTempF(double tempF) {
        mTempF = tempF;
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

    public String getWinddirDegree() {
        return mWinddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        mWinddirDegree = winddirDegree;
    }

    public String getWinddir16Point() {
        return mWinddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        mWinddir16Point = winddir16Point;
    }

    public String getPrecipMM() {
        return mPrecipMM;
    }

    public void setPrecipMM(String precipMM) {
        mPrecipMM = precipMM;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public void setHumidity(String humidity) {
        mHumidity = humidity;
    }

    public String getVisibility() {
        return mVisibility;
    }

    public void setVisibility(String visibility) {
        mVisibility = visibility;
    }

    public String getPressure() {
        return mPressure;
    }

    public void setPressure(String pressure) {
        mPressure = pressure;
    }

    public String getCloudcover() {
        return mCloudcover;
    }

    public void setCloudcover(String cloudcover) {
        mCloudcover = cloudcover;
    }

    public String getFeelsLikeF() {
        return mFeelsLikeF;
    }

    public void setFeelsLikeF(String feelsLikeF) {
        mFeelsLikeF = feelsLikeF;
    }

    public String getFeelsLikeC() {
        return mFeelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        mFeelsLikeC = feelsLikeC;
    }

    public CurrentCondition() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mObservationTime);
        dest.writeDouble(this.mTempC);
        dest.writeDouble(this.mTempF);
        dest.writeString(this.mWeatherCode);
        dest.writeString(this.mWeatherIconUrl);
        dest.writeString(this.mWeatherDesc);
        dest.writeString(this.mWindspeedMiles);
        dest.writeString(this.mWindspeedKmph);
        dest.writeString(this.mWinddirDegree);
        dest.writeString(this.mWinddir16Point);
        dest.writeString(this.mPrecipMM);
        dest.writeString(this.mHumidity);
        dest.writeString(this.mVisibility);
        dest.writeString(this.mPressure);
        dest.writeString(this.mCloudcover);
        dest.writeString(this.mFeelsLikeC);
        dest.writeString(this.mFeelsLikeF);
    }

    protected CurrentCondition(Parcel in) {
        this.mObservationTime = in.readString();
        this.mTempC = in.readDouble();
        this.mTempF = in.readDouble();
        this.mWeatherCode = in.readString();
        this.mWeatherIconUrl = in.readString();
        this.mWeatherDesc = in.readString();
        this.mWindspeedMiles = in.readString();
        this.mWindspeedKmph = in.readString();
        this.mWinddirDegree = in.readString();
        this.mWinddir16Point = in.readString();
        this.mPrecipMM = in.readString();
        this.mHumidity = in.readString();
        this.mVisibility = in.readString();
        this.mPressure = in.readString();
        this.mCloudcover = in.readString();
        this.mFeelsLikeC = in.readString();
        this.mFeelsLikeF = in.readString();
    }

    public static final Creator<CurrentCondition> CREATOR = new Creator<CurrentCondition>() {
        public CurrentCondition createFromParcel(Parcel source) {
            return new CurrentCondition(source);
        }

        public CurrentCondition[] newArray(int size) {
            return new CurrentCondition[size];
        }
    };
}
