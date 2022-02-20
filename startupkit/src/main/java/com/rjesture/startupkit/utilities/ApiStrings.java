package com.rjesture.startupkit.utilities;

import android.util.Log;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class ApiStrings {
    public static String apiUrl;
    public static String apiRequest;
    public static String apiString;
    public static String apiRequestError;
    public static String apiResponse;
    public static String apiResponseError;
    public static String defResponse="No data available";

    public static void setApiString(String assignedString) {
        apiString = assignedString;
        apiUrl = assignedString + "_Url";
        apiRequest = assignedString + "_Request";
        apiRequestError = assignedString + "_RequestError";
        apiResponse = assignedString + "_Response";
        apiResponseError = assignedString + "_ResponseError";
    }

}
