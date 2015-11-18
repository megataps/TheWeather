package com.demo.theweather.data.response;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/18/15.
 */
public class BaseResponse<T> implements Response {

    private T mData;

    public BaseResponse() {
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
