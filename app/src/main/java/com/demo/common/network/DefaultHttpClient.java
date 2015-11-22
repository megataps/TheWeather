package com.demo.common.network;

import com.demo.common.network.util.IOUtils;
import com.demo.theweather.BuildConfig;
import com.demo.theweather.util.LogUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class DefaultHttpClient {

    private static final int CONNECT_TIME_OUT = 1000*30;
    private static final int READ_TIME_OUT = 1000*30;

    private String mErrorMessage;



    public HttpResponse get(URL uri, Map<String, List<String>> headers) {

        HttpGetRequest get = new HttpGetRequest(uri, headers);

        return getOrPost(get);
    }

    private HttpResponse getOrPost(HttpRequest request) {

        mErrorMessage = null;
        HttpURLConnection conn = null;
        HttpResponse response = null;

        try {
            conn = (HttpURLConnection) request.getUrl().openConnection();
            conn.setReadTimeout(READ_TIME_OUT);
            conn.setConnectTimeout(CONNECT_TIME_OUT);
            conn.setDoOutput(true);

            if (request.getHeaders() != null) {
                for (String header : request.getHeaders().keySet()) {
                    for (String value : request.getHeaders().get(header)) {
                        conn.addRequestProperty(header, value);
                    }
                }
            }

            if (BuildConfig.DEBUG) {
                LogUtils.d("url:", request.getUrl().toString());
            }

            if (request instanceof HttpPostRequest) {
                byte[] payload = ((HttpPostRequest) request).getBodyData();
                conn.setFixedLengthStreamingMode(payload.length);
                conn.getOutputStream().write(payload);
                int status = conn.getResponseCode();
                if (status / 100 != 2) {
                    response = new HttpResponse(status, new Hashtable<String, List<String>>(), conn.getResponseMessage().getBytes());
                }
            } else {
                conn.setRequestMethod("GET");
                conn.connect();
            }

            if (response == null) {
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
                byte[] body = IOUtils.readStream(in);
                response = new HttpResponse(conn.getResponseCode(), conn.getHeaderFields(), body);
            }

            // TODO: 11/17/15: Log response headers - Should be create injectable log util
            if (BuildConfig.DEBUG && response.getHeaders() != null) {
                for (String header : response.getHeaders().keySet()) {
                    for (String value : response.getHeaders().get(header)) {
                        LogUtils.d(header, value);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace(System.err);
            mErrorMessage = ((request instanceof HttpPostRequest) ? "POST " : "GET ") + ": " + e.getLocalizedMessage();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }
}
