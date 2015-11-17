package com.demo.network;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class GetRequest extends Request {

    public GetRequest(URL uri, Map<String, List<String>> headers) {
        super(uri, headers);
    }
}
