package com.rjesture.startupkit.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class AppPrinting {
    public static final String appError = "Something went wrong";

    public static void setLog(String title, String message) {
        try {
            Log.v(title, " " + message);
        } catch (Exception e) {
            handleCatch(e);
        }
    }

    public static void setLog(String title, String message, Throwable throwable) {
        try {
            Log.v(title, " " + message, throwable);
        } catch (Exception e) {
            handleCatch(e);
        }
    }

    public static void printMessage(String message) {
        System.out.println("Message :  " + message);
    }

    public static void handleCatch(Exception e) {
        e.printStackTrace();
    }

    public static void handleCatch(Exception e, Context context) {
        e.printStackTrace();
        showToast(context, appError);
    }

    public static void handleCatch(Exception e, Context context, String errorMessage) {
        e.printStackTrace();
        showToast(context, errorMessage);
    }

    public static void showToastShort(Context context, String text) {
        try {
            if (context == null)
                return;
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            handleCatch(e);
        }
    }

    public static void showToast(Context context, String text) {
        try {
            if (context == null)
                return;
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            handleCatch(e);
        }
    }
    public static void showApiLog(String title, String message) {
        Log.v(title, message);
    }


    public static void showEditTextError(EditText editText, Context mContext, String message) {
        editText.setError(message);
        editText.requestFocus();
        showToast(mContext,message);
    }



}
