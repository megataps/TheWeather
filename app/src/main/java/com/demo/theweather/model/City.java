package com.demo.theweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public class City implements Parcelable {

    private int mId;
    private String mName;
    private boolean mIsSelected;

    public City() {
    }

    public City(int id, String name, boolean isSelected) {
        mId = id;
        mName = name;
        mIsSelected = isSelected;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

    public void setSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mName);
        dest.writeByte(mIsSelected ? (byte) 1 : (byte) 0);
    }

    protected City(Parcel in) {
        this.mId = in.readInt();
        this.mName = in.readString();
        this.mIsSelected = in.readByte() != 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
