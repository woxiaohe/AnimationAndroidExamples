package com.nsb.chengbah.animationandroidexamples.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

public class PointView extends View {
    private MyPoint mCurrentPoint;
    private Paint paint;

    public PointView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    /**
     * onDraw开始使用画笔，如果mCurrentPoint为空，就创建Point对象，否则就直接调用drawPoint方法
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mCurrentPoint == null){
            mCurrentPoint = new MyPoint(50,50);
            drawPoint(canvas);
        }else {
            drawPoint(canvas);
        }
    }

    private void drawPoint(Canvas canvas) {
        canvas.drawCircle(mCurrentPoint.getX(),mCurrentPoint.getY(),30,paint);
    }

    /**
     * 设置属性添加方法:
     * 由于我们知道属性动画ObjectAnimator类是通过将propertyName拼接成对应的set方法，然后通过反射机制去调用该方法，所以我们需要有一个对应的set方法
     * @param point 新的点
     */
    public void setMove(MyPoint point){
        mCurrentPoint = point;
        invalidate();   //refresh view
    }

    /**
     * 在外部调用的方法，通过此方法，开启小球动作的绘画
     */
    public void moveBell(Long duration,MyPoint...values){
        startAnimation(2000L,values);
    }

    private void startAnimation(Long duration,MyPoint...values){
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(PointView.this,"move",new BallEvaluator(),values
                );
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(duration);
        objectAnimator.start();
    }

    /**
     * 小球对象的算值器
     */
    private class BallEvaluator implements TypeEvaluator<MyPoint> {
        float x;
        float y;

        @Override
        public MyPoint evaluate(float fraction, MyPoint startValue, MyPoint endValue) {
            float startX = startValue.getX();
            float startY = startValue.getY();
            float endX = endValue.getX();
            float endY = endValue.getY();

            x = fraction * (endX - startX);
            y = fraction * (endY -startY);

            return new MyPoint(startX+x ,startY+y);
        }
    }
}
