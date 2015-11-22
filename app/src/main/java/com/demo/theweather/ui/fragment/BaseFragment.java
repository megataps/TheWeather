package com.demo.theweather.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.widget.ViewSwitcher;

import com.demo.theweather.ui.activity.BaseActivity;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class BaseFragment extends Fragment {

    protected static final int INDEX_CONTENT = 0;
    protected static final int INDEX_PROGRESS = 1;

    protected Activity mActivity;
    protected Handler mHandler = new Handler();
    protected ViewSwitcher mViewSwitcher;

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

    /**
     * show progress inside view with view switcher
     *
     * @param isShow true : show, false : hide
     */
    public void showProgressbar(final boolean isShow) {
        if (mViewSwitcher != null) {
            mViewSwitcher.setDisplayedChild(isShow ? INDEX_PROGRESS : INDEX_CONTENT);
        }
    }
}
