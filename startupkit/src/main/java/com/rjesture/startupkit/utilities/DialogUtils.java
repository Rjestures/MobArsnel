package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;

import android.app.Activity;
import android.app.ProgressDialog;

import com.rjesture.startupkit.R;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class DialogUtils {
    static ProgressDialog progressDialog;

    public static void showRequestDialog(Activity activity) {
        try {
            if (!activity.isFinishing()) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(activity);
                    progressDialog.setCancelable(false);
                    progressDialog.setMessage(activity.getString(R.string.please_wait));
                    progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                    progressDialog.show();
                }
            }
        } catch (Exception e) {
            handleCatch(e);
        }
    }

    public static void showRequestDialog(Activity activity, String message) {
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(activity);
                progressDialog.setCancelable(false);
                progressDialog.setMessage(message);
                progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                progressDialog.show();
            }
        } catch (Exception e) {
            handleCatch(e);
        }
    }

    public static void hideDialog() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
            handleCatch(e);
        }
    }

}
