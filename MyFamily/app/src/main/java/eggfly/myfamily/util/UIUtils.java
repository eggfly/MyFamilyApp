package eggfly.myfamily.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class UIUtils {
    public static int dpToPixels(final DisplayMetrics display_metrics, final float dps) {
        final float scale = display_metrics.density;
        return (int) (dps * scale + 0.5f);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density + 0.5);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density + 0.5);
    }
}
