package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;
import static com.rjesture.startupkit.utilities.AppPrinting.showEditTextError;
import static com.rjesture.startupkit.utilities.AppPrinting.showToast;
import static com.rjesture.startupkit.utilities.AppTools.getEtText;

import android.content.Context;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rjesture.startupkit.R;

import org.json.JSONObject;

/**
 * Created by Rjesture on 2/21/2022.
 */
public class DataValidator {

    public static Boolean checkMobileNumber(EditText editText, Context mContext) {
        if (getEtText(editText).isEmpty()) {
            showEditTextError(editText, mContext, mContext.getString(R.string.mobileNumberBlankError));
            return false;
        } else if (getEtText(editText).length() < 10) {
            showEditTextError(editText, mContext, mContext.getString(R.string.mobileNumberInvalidError));
            return false;
        }
        return true;
    }
    
    public static Boolean checkMoneyAmount(EditText editText, Context mContext) {
        if (getEtText(editText).isEmpty()) {
            showEditTextError(editText, mContext, mContext.getString(R.string.amountCannotBeBlank));
            return false;
        } else if (Integer.parseInt(getEtText(editText))==0) {
            showEditTextError(editText, mContext, mContext.getString(R.string.amountCannotBeZero));
            return false;
        }
        return true;
    }

    public static Boolean checkDataFeild(EditText editText, Context mContext, String message) {
        if (getEtText(editText).isEmpty()) {
            showEditTextError(editText, mContext, message);
            return false;
        }
        return true;
    }


    public static Boolean checkDataValue(String value, Context mContext, String title) {
        if (value.isEmpty()) {
            showToast(mContext, title + " cannot be blank");
            return false;
        }
        return true;
    }

    public static JSONObject makeJsonObjectFromPojo(Object object, Context context) {
        JSONObject jsonObject = new JSONObject();
        try {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(object);
            jsonObject = new JSONObject(json);
        } catch (Exception e) {
            handleCatch(e, context);
        }

        return jsonObject;
    }

}
