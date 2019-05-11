package com.geniusplaza.app.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.geniusplaza.app.utils.logs.AppLogger;

public class GlideTools {

    public static void displayImageRound(final Context ctx, final ImageView img, String  url) {
        try {
            Glide.with(ctx).load(url).centerCrop()
                    .apply(RequestOptions.circleCropTransform())
                    .into(img)
            ;

        } catch (Exception e) {
            AppLogger.d("Error Occurs " + e.getMessage());
        }
    }
}
