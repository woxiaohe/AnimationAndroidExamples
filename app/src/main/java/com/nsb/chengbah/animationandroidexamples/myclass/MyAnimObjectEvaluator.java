package com.nsb.chengbah.animationandroidexamples.myclass;

import android.animation.TypeEvaluator;

/**
 * 自定义对象动画算值器
 * 返回的结果是传入值的两倍
 */
public class MyAnimObjectEvaluator implements TypeEvaluator<MyAnimObject> {

    @Override
    public MyAnimObject evaluate(float fraction, MyAnimObject startValue, MyAnimObject endValue) {
        int oldValue = startValue.value;
        int newValue = endValue.value;

        int res = (int) ((oldValue + newValue) * fraction) * 2;
        return new MyAnimObject(res);
    }
}
