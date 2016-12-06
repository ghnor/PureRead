package com.ghnor.pureread.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

/**
 * Created by ghnor on 2016/12/6.
 */

public class ClipboardUtil {

    public static final String COPY_SUCCESS = "复制到剪贴板";

    public static void copy(Context context, String text) {
        copy(context, text, COPY_SUCCESS);
    }

    public static void copy(Context context, String text, String success) {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(
                Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("pure_read_copy", text);
        manager.setPrimaryClip(clipData);
        Toast.makeText(context, success, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    public static String paste(Context context) {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(
                Context.CLIPBOARD_SERVICE);
        ClipData clipData = manager.getPrimaryClip();
        ClipData.Item item = clipData.getItemAt(0);
        return item.getText().toString();
    }

}
