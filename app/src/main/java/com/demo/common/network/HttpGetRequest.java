package com.demo.common.network;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class HttpGetRequest extends HttpRequest {

    public HttpGetRequest(URL uri, Map<String, List<String>> headers) {
        super(uri, headers);
    }
}
