package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;
import static com.rjesture.startupkit.utilities.AppPrinting.showToast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.provider.Settings;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.rjesture.startupkit.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class AppTools {
    private static boolean doubleBackToExitPressedOnce;


    public static String getAppVersion(Activity context) {
        String latestVersion = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            latestVersion = String.valueOf(info.versionName);
        } catch (Exception e) {
            handleCatch(e, context);
        }
        return latestVersion;
    }

    public static boolean isNetworkOnline(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                netInfo = cm.getNetworkInfo(1);
                if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
                else
                    showToast(context, context.getString(R.string.no_internet_connection));
            }
        } catch (Exception e) {
            e.printStackTrace();
            showToast(context, context.getString(R.string.no_internet_connection));
            return false;
        }
        return status;
    }

    public static String getEtText(TextInputEditText editText) {
        return editText.getText().toString().trim();
    }

    public static String getEtText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static String getEtText(TextView textView) {
        return textView.getText().toString().trim();
    }

    public static void backToExit(Activity mActivity) {
        if (doubleBackToExitPressedOnce) {
            mActivity.finishAffinity();
            return;
        }
        doubleBackToExitPressedOnce = true;
        showToast(mActivity, "Press again to exit");
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 1000);
    }

    public static void backToExit(Activity mActivity, String message) {
        if (doubleBackToExitPressedOnce) {
            mActivity.finishAffinity();
            return;
        }
        doubleBackToExitPressedOnce = true;
        showToast(mActivity, message);
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 1000);
    }

    public static String retrieveJSONString(JSONObject jsonObject, String key) {
        try {
            return jsonObject.has(key) ? jsonObject.get(key).toString() : "";
        } catch (JSONException e) {
            handleCatch(e);
        }
        return "";
    }

    public static String retrieveJSONString(JSONObject jsonObject, String key, String defaultValue) {
        try {
            return jsonObject.has(key) ? jsonObject.get(key).toString() : defaultValue;
        } catch (JSONException e) {
            handleCatch(e);
        }
        return defaultValue;
    }

    public static JSONObject retrieveJSONObject(JSONObject jsonObject, String key) {
        try {
            return jsonObject.has(key) ? jsonObject.getJSONObject(key) : null;
        } catch (JSONException e) {
            handleCatch(e);
        }
        return null;
    }

    public static JSONArray retrieveJSONArray(JSONObject jsonObject, String key) {
        try {
            return jsonObject.has(key) ? jsonObject.getJSONArray(key) : null;
        } catch (JSONException e) {
            handleCatch(e);
        }
        return null;
    }

    public static boolean isLocationEnabled(Context context) {
        try {
            LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            boolean gps_enabled = false;
            boolean network_enabled = false;
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!gps_enabled && !network_enabled) {
                // notify user
                new AlertDialog.Builder(context)
                        .setMessage(R.string.gps_network_not_enabled)
                        .setPositiveButton(R.string.open_location_settings, (paramDialogInterface, paramInt) -> {
                            context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        })
                        .setCancelable(false)
                        .show();
            } else {
                return true;
            }
        } catch (Exception ex) {
            handleCatch(ex);
        }
        return false;
    }

    public static int dpToPx(int dp, Context context) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
