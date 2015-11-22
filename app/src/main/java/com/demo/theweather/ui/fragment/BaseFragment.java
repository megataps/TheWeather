package com.demo.theweather.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;

import com.demo.theweather.ui.activity.BaseActivity;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class BaseFragment extends Fragment {

    protected Activity mActivity;
    protected Handler mHandler = new Handler();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity)context;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        mHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    /**
     * A general purpose handler, especially useful for doing fragment transaction inside a loader callback
     *
     * @return the handler
     */
    protected Handler getHandler() {
        return mHandler;
    }

    protected LoaderManager getSupportLoaderManager() {
        return getActivity().getSupportLoaderManager();
    }

    public void showProgressDialog(final boolean isShow) {
        ((BaseActivity)mActivity).showProgressDialog(isShow);
    }
}
