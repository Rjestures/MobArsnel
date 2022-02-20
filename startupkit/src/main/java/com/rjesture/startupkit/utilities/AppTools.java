package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;
import static com.rjesture.startupkit.utilities.AppPrinting.showToast;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.rjesture.startupkit.R;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class AppTools {

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


}
