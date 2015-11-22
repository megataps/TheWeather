package com.demo.common.network;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class HttpRequest {

    private URL mUrl;
    private Map<String, List<String>> mHeaders;

    public HttpRequest(URL uri, Map<String, List<String>> headers) {
        this.mUrl = uri; this.mHeaders = headers;
    }

    public URL getUrl() {
        return mUrl;
    }

    public void setUrl(URL url) {
        mUrl = url;
    }

    public Map<String, List<String>> getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        mHeaders = headers;
    }
}
