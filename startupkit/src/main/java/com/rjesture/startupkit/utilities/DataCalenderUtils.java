package com.rjesture.startupkit.utilities;

import static com.rjesture.startupkit.utilities.AppPrinting.handleCatch;
import static com.rjesture.startupkit.utilities.AppPrinting.setLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rjesture on 2/20/2022.
 */
public class DataCalenderUtils {

    static String patternFormat = "";

    public DataCalenderUtils(String pattern) {
        patternFormat = pattern.isEmpty() ? "dd-MMM-yyyy hh:mm aa" : pattern;
    }

    public static int checkTimeSlot() {
        try {
            Calendar c = Calendar.getInstance();
            int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
            if (timeOfDay >= 0 && timeOfDay < 12) {
                return 1;
            } else if (timeOfDay >= 12 && timeOfDay < 16) {
                return 2;
            } else if (timeOfDay >= 16 && timeOfDay < 21) {
                return 3;
            } else if (timeOfDay >= 21 && timeOfDay < 24) {
                return 4;
            }
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0;
    }

    public static String checkTimeMessage(int code) {
        try {
            switch (code) {
                case 1:
                    return "Good Morning";
                case 2:
                    return "Good Afternoon";
                case 3:
                    return "Good Evening";
                case 4:
                    return "Good Night";
            }
        } catch (Exception e) {
            handleCatch(e);
        }
        return "error";
    }

    public String convertEpochDate(String timestamp) {
        return Long.toString(Long.parseLong(timestamp) * 1000);
    }

    public String readTimeStampDate(String timeStampDate) {
        try {
            Date date = new Date(Long.parseLong(timeStampDate));
            SimpleDateFormat format = new SimpleDateFormat(patternFormat);
            String myDate = format.format(date);
            return myDate;
        } catch (Exception e) {
            handleCatch(e);
        }
        return "";
    }

    public int getDays(String startDate) {
        try {
            long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
            SimpleDateFormat dateFormat = new SimpleDateFormat(patternFormat);
            long begin = dateFormat.parse(startDate).getTime();
            long end = new Date().getTime(); // 2nd date want to compare
            long diff = (end - begin) / (MILLIS_PER_DAY);
            setLog("Days_Ago", "days " + diff);
            return (int) diff;
        } catch (Exception e) {
            handleCatch(e);
        }
        return 0;
    }

    public String getCurrentDate() {
        try {
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);
            SimpleDateFormat df = new SimpleDateFormat(patternFormat);
            String formattedDate = df.format(c);
            return formattedDate;
        } catch (Exception e) {
            handleCatch(e);
        }
        return "";
    }

    public String addDays(String oldDate, int days) {
        DateFormat formatter = new SimpleDateFormat(patternFormat, Locale.US);
        try {
            Date date = formatter.parse(oldDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            System.out.println("Cool" + formatter.format(calendar.getTime()));
            return formatter.format(calendar.getTime());
        } catch (Exception e) {
            handleCatch(e);
            System.out.println("Wrong date");
        }
        return "";
    }

}
