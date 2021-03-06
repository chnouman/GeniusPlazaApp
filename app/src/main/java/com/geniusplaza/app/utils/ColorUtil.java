package com.geniusplaza.app.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

public class ColorUtil {

    public static int getMatColor(Context context,String typeColor)
    {
        int returnColor = Color.BLACK;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor, "array", context.getPackageName());

        if (arrayId != 0)
        {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }
        return returnColor;
    }
}
