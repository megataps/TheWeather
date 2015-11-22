package com.demo.theweather.ui.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class BaseDialogFragment extends DialogFragment{

    protected ProgressDialogFragment mProgressDialogFragment;
    protected Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeStyle();

        mProgressDialogFragment = ProgressDialogFragment.newInstance(null, 1);
    }

    protected void setThemeStyle() {
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Translucent_NoTitleBar);
    }

    public void showProgressDialog(final boolean isShow){
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    mProgressDialogFragment.show(getFragmentManager(),
                            ProgressDialogFragment.class.getSimpleName());
                } else {
                    mProgressDialogFragment.dismiss();
                }
            }
        });
    }

    @Override
    public void onStop() {
        mHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    protected Handler getHandler() {
        return mHandler;
    }

}
