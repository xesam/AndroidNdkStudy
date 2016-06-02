package dev.xesam.android.ndk;

import android.content.Context;

/**
 * Created by xesamguo@gmail.com on 16-6-2.
 */
public class NdkTools {
    public static native String getPackageName(Context context);

    public static native String getDeviceId(Context context);
}
