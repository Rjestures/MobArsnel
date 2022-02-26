package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;
import static com.rjesture.startupkit.utilities.AppPrinting.showToast;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.annotation.NonNull;

/**
 * Created by Rjesture on 2/26/2022.
 */
public class TextUtils {
    public static String showDoubleDigit(int digit) {
        String finalDig = (digit < 10 ? "0" : "") + digit;
        return finalDig;
    }

    public static String showDoubleDigit(long digit) {
        String finalDig = (digit < 10 ? "0" : "") + digit;
        return finalDig;
    }

    public static String setPrice(String price) {
        return "₹ " + price;
    }

    public static String setPriceTotal(String price) {
        return "₹ " + price + " /-";
    }

    public static String setPriceTotal(int price) {
        return "₹ " + price + " /-";
    }
    public static String updateQuantity(String oldQuantity, int newQuantity) {
        if ((oldQuantity.equalsIgnoreCase("0") ||
                oldQuantity.equalsIgnoreCase("")) && newQuantity <= 0)
            return "0";
        return Integer.toString(Integer.parseInt(oldQuantity) + newQuantity);
    }

    public static void copyText(String text, Context context, String message) {
        try {
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("text label", text);
            clipboard.setPrimaryClip(clip);
            showToast(context, message);
        } catch (Exception e) {
            handleCatch(e, context, "Unable to copy text");
        }
    }
    public static double getDisplacementMiles(@NonNull double lat1, @NonNull double lon1,
                                              @NonNull double lat2, @NonNull double lon2) {
        try {
            double theta = lon1 - lon2;
            double dist = Math.sin(deg2rad(lat1))
                    * Math.sin(deg2rad(lat2))
                    + Math.cos(deg2rad(lat1))
                    * Math.cos(deg2rad(lat2))
                    * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;
            return (dist);
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0.0;
    }

    public static double deg2rad(@NonNull double deg) {
        try {
            return (deg * Math.PI / 180.0);
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0.0;
    }

    public static double rad2deg(@NonNull double rad) {
        try {
            return (rad * 180.0 / Math.PI);
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0.0;
    }

    public static double milesToKm(@NonNull Double miles) {
        try {
            return miles * 1.609344;
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0.0;
    }

    public static double kmToMiles(@NonNull Double kilometers) {
        try {
            return kilometers / 1.609344;
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0.0;
    }
    //***********************************Image Util**********************************************
    public static Bitmap stringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }


}
