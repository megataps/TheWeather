package com.demo.theweather.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.theweather.R;

/**
 * Created by Jackie Nguyen <nguyenngoc100@gmail.com> on 11/22/15.
 */
public class ProgressDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "ARG_TITLE";

    public static <T extends Fragment & DialogFragmentListener> ProgressDialogFragment newInstance(T listener, int dialogId) {
        return newInstance(null, listener, dialogId);
    }

    public static <T extends Fragment & DialogFragmentListener> ProgressDialogFragment newInstance(String title, T listener, int dialogId) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.setTargetFragment(listener, dialogId);

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme_Dialog_Transparent);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loading_dialog, container, false);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

        if (getTargetFragment() instanceof DialogFragmentListener) {
            ((DialogFragmentListener) getTargetFragment()).onCancel(getTargetRequestCode());
        }
    }
}
