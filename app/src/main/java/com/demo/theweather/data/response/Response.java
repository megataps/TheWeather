package com.demo.theweather.data.response;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public interface Response {

    InputStream getResponseBody() throws IOException;

    int getStatusCode();

    String getHeader(String header);
}
