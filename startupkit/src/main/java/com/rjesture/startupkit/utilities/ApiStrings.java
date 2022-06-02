package com.rjesture.startupkit.utilities;

import android.util.Log;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class ApiStrings {
    String defResponse = "No data available";
    String assignedString = "api";

    public ApiStrings(String assignedString) {
        this.assignedString = assignedString;
    }

    public String getApiUrl() {
        return assignedString + "_Url";
    }

    public String getApiRequest() {
        return assignedString + "_Request";
    }

    public String getApiRequestError() {
        return assignedString + "_RequestError";
    }

    public String getApiResponse() {
        return assignedString + "_Response";
    }

    public String getApiResponseError() {
        return assignedString + "_ResponseError";
    }

    public String getDefResponse() {
        return defResponse;
    }
}
