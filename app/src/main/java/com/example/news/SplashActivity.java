package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout mSplashRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashRoot = (RelativeLayout) findViewById(R.id.splash_root);

//        RotateAnimation rotateAnimation=new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        rotateAnimation.setFillAfter(false);
//
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setFillAfter(false);
//
//        ScaleAnimation scaleAnimation=new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setFillAfter(false);
//
//        AnimationSet animationSet=new AnimationSet(false);
//        animationSet.addAnimation(rotateAnimation);
//        animationSet.addAnimation(alphaAnimation);
//        animationSet.addAnimation(scaleAnimation);
//        animationSet.setDuration(2000);
//
//        mSplashRoot.setAnimation(animationSet);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        mSplashRoot.setAnimation(animation);
        
        animation.setAnimationListener(new MyAnimationListener());

//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mSplashRoot, "alpha", 0, 1);
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mSplashRoot, "scaleX", 0, 1);
//        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mSplashRoot, "scaleY", 0, 1);
//        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mSplashRoot, "rotation", 0, 360);
//        objectAnimator1.setDuration(2000);
//        objectAnimator2.setDuration(2000);
//        objectAnimator3.setDuration(2000);
//        objectAnimator4.setDuration(2000);
//        objectAnimator1.start();
//        objectAnimator2.start();
//        objectAnimator3.start();
//        objectAnimator4.start();
    }
    
    class MyAnimationListener implements Animation.AnimationListener{

        /**
         * 动画开始播放时调用
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {
            
        }

        /**
         * 动画播放结束时调用
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(SplashActivity.this, "欢迎使用！", Toast.LENGTH_SHORT).show();
        }
        
        /**
         * 动画重新播放时调用
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}