package com.demo.network.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class IOUtils {

    private final static int BYTE_LENGTH_DEFAULT = 1024;

    public static byte[] readStream(InputStream in) throws IOException {

        byte[] buf = new byte[BYTE_LENGTH_DEFAULT];
        int count = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream(BYTE_LENGTH_DEFAULT);

        while ((count = in.read(buf)) != -1) {
            out.write(buf, 0, count);
        }

        return out.toByteArray();
    }

}
