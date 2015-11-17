package com.demo.theweather.data.response;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class BaseResponse implements Response {

    @Override
    public InputStream getResponseBody() throws IOException {
        return null;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public String getHeader(String header) {
        return null;
    }
}
