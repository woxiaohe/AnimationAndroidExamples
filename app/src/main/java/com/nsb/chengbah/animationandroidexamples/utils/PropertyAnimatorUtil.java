package com.nsb.chengbah.animationandroidexamples.utils;

import android.animation.AnimatorInflater;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsb.chengbah.animationandroidexamples.R;
import com.nsb.chengbah.animationandroidexamples.myclass.MyAnimObject;

public class PropertyAnimatorUtil {
    private static final String TAG = "hcb";

    public static ValueAnimator startImageValueAnimator(final ImageView imageView){
        //注意：这里的单位都是像素而不是dp
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,300);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());  //设置插值器

        //设置动画过程监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                imageView.layout(curValue,imageView.getTop(),imageView.getWidth()+curValue,imageView.getBottom());
            }
        });
        valueAnimator.start();
        return valueAnimator;
    }

    public static void stopImageValueAnimator(ValueAnimator animator){
        if (animator != null){
            animator.removeAllUpdateListeners();
            animator.cancel();
        }
    }

    public static ValueAnimator startXmlValueAnimator(Context context, final ImageView imageView){
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(context,R.animator.anim_value_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                imageView.layout(curValue,imageView.getTop(),imageView.getWidth()+curValue,imageView.getBottom());
            }
        });
        valueAnimator.start();
        return valueAnimator;
    }


    public static ValueAnimator startObjValueAnimator(final TextView textView, TypeEvaluator evaluator, Object... values){
        ValueAnimator objectAnimator = ValueAnimator.ofObject(evaluator,values);
        objectAnimator.setDuration(10000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                MyAnimObject animObject = (MyAnimObject) animation.getAnimatedValue();
                textView.setText("value="+animObject.value);
                Log.d(TAG,"value="+animObject.value);
            }
        });
        objectAnimator.start();

        return objectAnimator;
    }
}
