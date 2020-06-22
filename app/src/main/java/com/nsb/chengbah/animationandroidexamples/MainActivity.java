package com.nsb.chengbah.animationandroidexamples;

import android.graphics.drawable.AnimationDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.nsb.chengbah.animationandroidexamples.utils.TweenAnimationsUtil;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView,imgDrawable;
    private Button btAlpha,btRotate,btScale,btTranslate,btComplex,btFrameAnim,btFrameAnimStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        btAlpha.setOnClickListener(this);
        btRotate.setOnClickListener(this);
        btScale.setOnClickListener(this);
        btTranslate.setOnClickListener(this);
        btComplex.setOnClickListener(this);
        btFrameAnim.setOnClickListener(this);
        btFrameAnimStop.setOnClickListener(this);
    }

    private void initView() {
        imageView = findViewById(R.id.imageView);
        imgDrawable = findViewById(R.id.img_drawable);
        btAlpha = findViewById(R.id.bt_alpha);
        btRotate = findViewById(R.id.bt_rotate);
        btScale = findViewById(R.id.bt_scale);
        btTranslate = findViewById(R.id.bt_translate);
        btComplex = findViewById(R.id.bt_complex);
        btFrameAnim = findViewById(R.id.bt_frame);
        btFrameAnimStop = findViewById(R.id.bt_frame_stop);
    }

    AnimationDrawable animationDrawable;
    private void startDrawableAnimation() {
        imgDrawable.setBackgroundResource(R.drawable.anim_draw_loading);
        animationDrawable = (AnimationDrawable) imgDrawable.getBackground();
        animationDrawable.setOneShot(false);    //设置是否只执行一次
        animationDrawable.stop();
        animationDrawable.start();
    }

    private void stopDrawableAnimation(){
        animationDrawable.stop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_alpha:
                TweenAnimationsUtil.alphaAnimation(imageView);    //java 代码
                Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
                imageView.setAnimation(animation);  //xml 不会立即执行动画，有条件的（when the view is added to the viewGroup,animation will be called.when the view has been added,the animation will not be called）
                imageView.startAnimation(animation);  //xml 会立即执行动画
                break;
            case R.id.bt_rotate:
                TweenAnimationsUtil.roateAnimation(imageView);
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));
                break;
            case R.id.bt_scale:
                TweenAnimationsUtil.scaleAnimation(imageView);
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale));
                break;
            case R.id.bt_translate:
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
                TweenAnimationsUtil.translateAnimation(imageView);
                break;
            case R.id.bt_complex:
//                imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.complex));
                TweenAnimationsUtil.complexAnimation(imageView);
            case R.id.bt_frame:
                startDrawableAnimation();
                break;
            case R.id.bt_frame_stop:
                stopDrawableAnimation();
                break;
            default:
                break;
        }
    }
}
