package com.demo.common.network;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class HttpPostRequest extends HttpRequest {

    private byte[] mBodyData;

    public HttpPostRequest(URL uri, Map<String, List<String>> headers, byte[] bodyData) {
        super(uri, headers);
        this.mBodyData = bodyData;
    }

    public byte[] getBodyData() {
        return mBodyData;
    }

    public void setBodyData(byte[] bodyData) {
        mBodyData = bodyData;
    }
}
