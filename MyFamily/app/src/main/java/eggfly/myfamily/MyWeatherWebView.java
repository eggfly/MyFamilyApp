package eggfly.myfamily;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;

public class MyWeatherWebView extends WebView {
    private final static String TAG = "MyWeatherWebView";

    private final static float CONTENT_WIDTH = 282.0f;
    private final static float CONTENT_HEIGHT = 125.0f;

    public MyWeatherWebView(Context context) {
        super(context);
    }

    public MyWeatherWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWeatherWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Log.d(TAG, "onDraw");
    }

    private static final float MARGIN_LEFT = -0.08f;
    private static final float MARGIN_TOP = -0.3f;
    private static final float MARGIN_BOTTOM = -0.05f;

    private int mMeasuredWidth = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width * CONTENT_HEIGHT / CONTENT_WIDTH);
        setMeasuredDimension(width, height);
        if (mMeasuredWidth != width) {
            mMeasuredWidth = width;
            int scalePercent = (int) (width * 100 / CONTENT_WIDTH);
            setInitialScale(scalePercent);
            MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
            lp.leftMargin = (int) (width * MARGIN_LEFT);
            lp.topMargin = (int) (height * MARGIN_TOP);
            lp.bottomMargin = (int) (height * MARGIN_BOTTOM);
            setLayoutParams(lp);
        }
        Log.d(TAG, "onMeasure, width=" + width + ", height=" + height);
    }
}
