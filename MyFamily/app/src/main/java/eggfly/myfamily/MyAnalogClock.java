package eggfly.myfamily;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AnalogClock;

public class MyAnalogClock extends AnalogClock {
    public MyAnalogClock(Context context) {
        super(context);
    }

    public MyAnalogClock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyAnalogClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // setMeasuredDimension((int) (getMeasuredWidth() * getScaleX()), (int) (getMeasuredHeight() * getScaleY()));
    }
}
