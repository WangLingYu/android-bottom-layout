package com.example.wang.wechatdemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wang on 16/7/27.
 */
public class PhoneView extends View {
    int mViewWidth, mViewHeight;
    boolean mTouched = false;
    Paint mPaint;
    String[] mIndex;
    float mTextSize;
    Rect mTextBound;

    public PhoneView(Context context) {
        super(context);
    }

    public PhoneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec) {
        int width;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            width = size;
        } else { /*否则的话我们就需要结合padding的值来确定*/
            int desire = size + getPaddingLeft() + getPaddingRight();
            if (mode == MeasureSpec.AT_MOST) {
                width = Math.min(desire, size);
            } else {
                width = desire;
            }
        }
        mViewWidth = width;
        return width;
    }

    private int measureHeight(int heightMeasureSpec) {
        int height;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            height = size;
        } else { /*否则的w话我们就需要结合padding的值来确定*/
            int desire = size + getPaddingLeft() + getPaddingRight();
            if (mode == MeasureSpec.AT_MOST) {
                height = Math.min(desire, size);
            } else {
                height = desire;
            }
        }
        mViewHeight = height;
        return height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mTouched) {
            canvas.drawColor(0x30000000);
        }
        for (int i = 0; i < mIndex.length; i++) {
            mPaint.setColor(0xff000000);
            mPaint.setTextSize(mTextSize * 3.0f / 4.0f);
            mPaint.setTypeface(Typeface.DEFAULT);
            mPaint.getTextBounds(mIndex[i], 0, mIndex[i].length(), mTextBound);
            float formX = mViewWidth / 2.0f - mTextBound.width() / 2.0f;
            float formY = mTextSize * i + mTextSize / 2.0f + mTextBound.height() / 2.0f;
            canvas.drawText(mIndex[i], formX, formY, mPaint);
            mPaint.reset();
        }
    }
}
