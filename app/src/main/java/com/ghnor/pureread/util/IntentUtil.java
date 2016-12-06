package com.ghnor.pureread.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by ghnor on 2016/12/6.
 */

public class IntentUtil {

    /************************ 打开浏览器 ************************/

    public static final String OPEN_BROWSER_FAIL = "打开浏览器失败";

    public static void openBrowser(Context context, String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        intent.setData(uri);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, OPEN_BROWSER_FAIL, Toast.LENGTH_SHORT).show();
        }
    }

}
