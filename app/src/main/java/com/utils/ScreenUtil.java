package com.utils;


import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by zhoushaosen on 2019/3/21.
 *
 */

public class ScreenUtil {

    private static DisplayMetrics metrics;


    public static int getScreenWidth(Context con) {
        if (metrics == null) {
            getDisplayMetrics(con);
        }
        return metrics.widthPixels;
    }

    public static int dp2px(Context con,float f) {
        if (metrics == null) {
            getDisplayMetrics(con);
        }
        return (int) ((f * metrics.density) + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (metrics == null) {
            metrics = context.getResources().getDisplayMetrics();
        }
        return metrics;
    }
}
