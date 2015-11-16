package com.demo.theweather.loader;

import android.content.Context;

import com.demo.theweather.exception.ExceptionAwareLoader;
import com.demo.theweather.util.LogUtils;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/16/15.
 */
public abstract class BaseLoader<T> extends AbstractAsyncTaskLoader<T> implements ExceptionAwareLoader {

    private Exception mException;

    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    public final T loadInBackground() {
        //Ensuring the previous error is cleared
        mException = null;

        try {
            return doLoadInBackground();
        } catch (Exception e) {
            LogUtils.printStackTrace(e);
            mException = e;
        }

        return null;
    }

    protected abstract T doLoadInBackground() throws Exception;

    @Override
    public Exception getException() {
        return mException;
    }
}
