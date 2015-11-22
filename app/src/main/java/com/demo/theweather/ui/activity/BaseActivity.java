package com.demo.theweather.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.demo.theweather.R;
import com.demo.theweather.ui.dialog.AlertDialogFragment;
import com.demo.theweather.ui.dialog.ProgressDialogFragment;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/17/15.
 */
public class BaseActivity extends AppCompatActivity {

    private static final int PROGRESS_DIALOG_FRAGMENT_ID = 1;

    protected Handler mHandler = new Handler();
    protected ProgressDialogFragment mProgressDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialogFragment = ProgressDialogFragment.newInstance(null, PROGRESS_DIALOG_FRAGMENT_ID);
    }

    public void showAlertDialog(final String title, final String message) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                AlertDialogFragment dialogFragment = AlertDialogFragment.newInstance(title, message, getString(R.string.common_ok));
                dialogFragment.show(getSupportFragmentManager(), dialogFragment.getClass().getSimpleName());
            }
        });
    }

    /**
     * show or hide progress dialog
     *
     * @param isShow true : show, false : hide progress
     */
    public void showProgressDialog(final boolean isShow) {

        if (mProgressDialogFragment == null) {
            return;
        }

        getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    mProgressDialogFragment.show(getSupportFragmentManager(),
                            ProgressDialogFragment.class.getSimpleName());
                } else {
                    if (mProgressDialogFragment.getActivity() != null) {
                        mProgressDialogFragment.dismissAllowingStateLoss();
                    }
                }
            }
        });
    }

    protected Handler getHandler() {
        return mHandler;
    }

    @Override
    public void onStop() {
        //Always clear the handler
        mHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

}
