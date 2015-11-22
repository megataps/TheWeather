package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class WeatherWrapper implements Parcelable {

    private List<CurrentCondition> mCurrentConditions;

    private Request mRequest;

    private List<Weather> mWeathers;

    public List<CurrentCondition> getCurrentConditions() {
        return mCurrentConditions;
    }

    public void setCurrentConditions(List<CurrentCondition> currentConditions) {
        mCurrentConditions = currentConditions;
    }

    public Request getRequest() {
        return mRequest;
    }

    public void setRequest(Request request) {
        mRequest = request;
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public void setWeathers(List<Weather> weathers) {
        mWeathers = weathers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mCurrentConditions);
        dest.writeParcelable(this.mRequest, 0);
        dest.writeTypedList(mWeathers);
    }

    public WeatherWrapper() {
    }

    protected WeatherWrapper(Parcel in) {
        this.mCurrentConditions = in.createTypedArrayList(CurrentCondition.CREATOR);
        this.mRequest = in.readParcelable(Request.class.getClassLoader());
        this.mWeathers = in.createTypedArrayList(Weather.CREATOR);
    }

    public static final Parcelable.Creator<WeatherWrapper> CREATOR = new Parcelable.Creator<WeatherWrapper>() {
        public WeatherWrapper createFromParcel(Parcel source) {
            return new WeatherWrapper(source);
        }

        public WeatherWrapper[] newArray(int size) {
            return new WeatherWrapper[size];
        }
    };
}
