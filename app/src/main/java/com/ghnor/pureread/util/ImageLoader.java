package com.ghnor.pureread.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ghnor on 2016/10/23.
 */

public class ImageLoader {

    public static void show(Context context, String url, ImageView imgv) {
        Glide.with(context).load(url).into(imgv);
    }

    public static void show(Activity activity, String url, ImageView imgv) {
        Glide.with(activity).load(url).into(imgv);
    }

    public static void show(Fragment fragment, String url, ImageView imgv) {
        Glide.with(fragment).load(url).into(imgv);
    }
}
