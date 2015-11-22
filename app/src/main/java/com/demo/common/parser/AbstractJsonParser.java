package com.demo.common.parser;

import com.demo.common.network.util.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public abstract class AbstractJsonParser<T> implements Parser<T> {

    private T mResult = null;

    @Override
    public void parse(byte[] data) throws JSONException{
        JSONObject jObj = new JSONObject(IOUtils.bytesToString(data));

        mResult = parse(jObj);
    }

    @Override
    public T getResult() {
        return mResult;
    }

    protected abstract T parse(JSONObject jsonParser) throws JSONException;

    protected JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    protected JSONArray getArrayObject(String tagName, JSONObject jObj)  throws JSONException {
        return jObj.getJSONArray(tagName);
    }

    protected String getString(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName)) {
            return jObj.getString(tagName);
        }

        return "";
    }

    protected float  getDouble(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName)) {
            return (float) jObj.getDouble(tagName);
        }

        return 0;
    }

    protected int  getInt(String tagName, JSONObject jObj) throws JSONException {
        if(jObj.has(tagName)) {
            return jObj.getInt(tagName);
        }

        return 0;
    }
}
