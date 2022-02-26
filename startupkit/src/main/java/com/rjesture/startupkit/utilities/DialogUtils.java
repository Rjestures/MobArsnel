package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;

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

    public static AlertDialog showAlertDialog(Context context, String title, String message, String positiveLabel,
                                              DialogInterface.OnClickListener positiveClick, String negativeLabel,
                                              DialogInterface.OnClickListener negativeClick, boolean isCancelable) {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setTitle(title);
            dialogBuilder.setCancelable(isCancelable);
            dialogBuilder.setMessage(message);
            dialogBuilder.setPositiveButton(positiveLabel, positiveClick);
            dialogBuilder.setNegativeButton(negativeLabel, negativeClick);
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
            return alertDialog;
        } catch (Exception e) {
            handleCatch(e);
        }
        return null;
    }
    public static String removeSpecial(String string) {
        try {
            return string.replaceAll("[^a-zA-Z0-9]", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void updateAlertDialog(Context context, String title, String message,
                                         DialogInterface.OnClickListener negativeClickListener) {
        try {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(context,
                    androidx.databinding.library.baseAdapters.R.style.Theme_AppCompat_DayNight_Dialog));
            alertDialogBuilder.setTitle(title);
            alertDialogBuilder.setMessage(message);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setNegativeButton(R.string.close, negativeClickListener);
            alertDialogBuilder.show();

        } catch (Exception e) {
            handleCatch(e);
        }
    }



}
