package com.demo.common.network;

import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class HttpResponse {

    /**
     * The HTTP status code
     */
    private int mStatus;

    /**
     * The HTTP headers received in the response
     */
    private  Map<String, List<String>> mHeaders;

    /**
     * The response body, if any
     */
    private byte[] mBody;

    protected HttpResponse(int status, Map<String, List<String>> headers, byte[] body) {
        this.mStatus = status;
        this.mHeaders = headers;
        this.mBody = body;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public Map<String, List<String>> getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        mHeaders = headers;
    }

    public byte[] getBody() {
        return mBody;
    }

    public void setBody(byte[] body) {
        mBody = body;
    }
}
