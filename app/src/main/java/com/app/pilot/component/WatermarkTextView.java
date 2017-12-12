package com.app.pilot.component;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;

public class WatermarkTextView extends android.support.v7.widget.AppCompatTextView {

    public WatermarkTextView(Context context) {
        super(context);
    }

    public WatermarkTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WatermarkTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        TextPaint textPaint = getPaint();
        textPaint.setColor(getCurrentTextColor());
        textPaint.drawableState = getDrawableState();

        canvas.save();
        canvas.translate(0, getHeight());
        canvas.rotate(-90);
        canvas.translate(getCompoundPaddingLeft(), getCompoundPaddingTop());

        getLayout().draw(canvas);

        canvas.restore();
    }
}
