package com.nsb.chengbah.animationandroidexamples.utils;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class TweenAnimationsUtil {
    public static void alphaAnimation(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(3);
        alphaAnimation.setRepeatMode(Animation.RESTART);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator()); //设置插值器
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void roateAnimation(View view){
        //Animation.RELATIVE_TO_SELF 相对于自己
        //Animation.RELATIVE_TO_PARENT 相对于父节点
        RotateAnimation rotateAnimation = new RotateAnimation(-30,30,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(500);   //设置周期
        rotateAnimation.setRepeatCount(Animation.INFINITE); //设置为无限次
        rotateAnimation.setRepeatMode(Animation.REVERSE);

        //启动动画
        view.startAnimation(rotateAnimation);
    }

    public static void scaleAnimation(View view){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f,1.5f,0.5f,1.5f,Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,1.0f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(3);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setZAdjustment(Animation.ZORDER_TOP);//设置永远在最顶端，不被其他控件遮挡
        view.startAnimation(scaleAnimation);
    }

    public static void translateAnimation(View view) {
        //ABSOLUTE 绝对像素
        TranslateAnimation translateAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f);
        translateAnimation.setDuration(1000);
        translateAnimation.setRepeatCount(3);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setZAdjustment(Animation.ZORDER_TOP);//设置永远在最顶端，不被其他控件遮挡
        view.startAnimation(translateAnimation);
    }

    public static void complexAnimation(View view) {
        AnimationSet set = new AnimationSet(false);

        //透明
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.1f);
        alphaAnimation.setDuration(3000);

        //旋转
        RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);

        //缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);

        //位移
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f);
        translateAnimation.setDuration(3000);

        set.addAnimation(alphaAnimation);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(translateAnimation);
        view.startAnimation(set);
    }
}
