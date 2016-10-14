package com.example.wang.wechatdemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.Calendar;

/**
 * Created by wang on 16/8/3.
 */
public class TimeView extends View {
    int mCirclex, mCircley, mRadius;
    Context mContext;

    public TimeView(Context context) {
        super(context);
        this.mContext = context;
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void draw(Canvas canvas) {

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        canvas.drawCircle(width / 2, height / 2, width / 2, paint);
        super.draw(canvas);

        Paint paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                paintDegree.setAntiAlias(true);
                canvas.drawLine(width / 2, height / 2 - width / 2, width / 2, height / 2 - width / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, width / 2 - paintDegree.measureText(degree) / 2, height / 2 - width / 2 + 90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(width / 2, height / 2 - width / 2, width / 2, height / 2 - width / 2 + 30, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, width / 2 - paintDegree.measureText(degree) / 2, height / 2 - width / 2 + 60, paintDegree);
            }
            canvas.rotate(15, width / 2, height / 2);
        }

        Paint paintHour = new Paint();
        paintHour.setStrokeWidth(20);
        Paint paintMinute = new Paint();
        paintMinute.setStrokeWidth(10);
        canvas.save();
        canvas.translate(width / 2, height / 2);
        Log.d("Calendar", "秒数为" + second);

        second += 100;
        canvas.rotate(second);
        canvas.drawLine(0, 0, 100, 100, paintHour);
        canvas.drawLine(0, 0, 100, 200, paintMinute);
        canvas.restore();

    }
}
