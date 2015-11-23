package com.demo.common.parser;

import org.json.JSONException;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public interface Parser<T> {

    void parse(byte[] data) throws JSONException;
    void parse(String data) throws JSONException;

    T getResult();
}
