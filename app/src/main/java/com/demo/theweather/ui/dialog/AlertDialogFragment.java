package com.demo.theweather.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class AlertDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "ARG_TITLE";
    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_POSITIVE_BUTTON_TEXT = "ARG_POSITIVE_BUTTON_TEXT";
    private static final String ARG_NEGATIVE_BUTTON_TEXT = "ARG_NEGATIVE_BUTTON_TEXT";

    protected static boolean isShow = false;
    protected String mTitle;
    protected String mMessage;
    protected String mPositiveButtonText;
    protected String mNegativeButtonText;

    protected DialogFragmentListener mListener;

    public static AlertDialogFragment newInstance(String title, String message, String positiveButtonText) {
        return newInstance(title, message, positiveButtonText, null, 0);
    }

    public static <T extends Fragment & DialogFragmentListener> AlertDialogFragment newInstance(String title, String message, String positiveButtonText, T listener, int dialogId) {
        return newInstance(title, message, positiveButtonText, null, listener, dialogId);
    }

    public static <T extends Fragment & DialogFragmentListener> AlertDialogFragment newInstance(String title, String message, String positiveButtonText, String negativeButtonText, T listener, int dialogId) {
        AlertDialogFragment fragment = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_POSITIVE_BUTTON_TEXT, positiveButtonText);
        args.putString(ARG_NEGATIVE_BUTTON_TEXT, negativeButtonText);
        fragment.setArguments(args);

        fragment.setTargetFragment(listener, dialogId);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitle = getArguments().getString(ARG_TITLE);
        mMessage = getArguments().getString(ARG_MESSAGE);
        mPositiveButtonText = getArguments().getString(ARG_POSITIVE_BUTTON_TEXT);
        mNegativeButtonText = getArguments().getString(ARG_NEGATIVE_BUTTON_TEXT);

        if (getTargetFragment() != null && getTargetFragment() instanceof DialogFragmentListener) {
            mListener = (DialogFragmentListener) getTargetFragment();
        } else {
            // check activity
            if (getActivity() instanceof DialogFragmentListener) {
                mListener = (DialogFragmentListener) getActivity();
            }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(mTitle);
        builder.setMessage(mMessage);

        if (mPositiveButtonText != null) {
            builder.setPositiveButton(mPositiveButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();

                    if (mListener != null) {
                        mListener.onPositiveButtonClicked(getTargetRequestCode());
                    }
                }
            });
        }

        if (mNegativeButtonText != null) {
            builder.setNegativeButton(mNegativeButtonText, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();

                    if (mListener != null) {
                        mListener.onCancel(getTargetRequestCode());
                    }
                }
            });
        }


        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

        if (mListener != null) {
            mListener.onCancel(getTargetRequestCode());
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (isShow) return;
        super.show(manager, tag);
        isShow = true;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        isShow = false;
        super.onDismiss(dialog);
    }
}
