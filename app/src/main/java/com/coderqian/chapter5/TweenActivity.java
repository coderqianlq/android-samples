package com.coderqian.chapter5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-26 下午10:30
 * mail: qianlq0824@gmail.com
 */
public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        // 步骤1:创建 需要设置动画的 视图View
        Button translateButton = (Button) findViewById(R.id.translate_1);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation translateAnimation = new TranslateAnimation(0, 500, 0, 500);
        translateAnimation.setDuration(3000);
        // 步骤3:播放动画
        translateButton.startAnimation(translateAnimation);

        // 步骤1:创建 需要设置动画的 视图View
        Button translate2Button = (Button) findViewById(R.id.translate_2);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation translate2Animation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        // 步骤3:播放动画
        translate2Button.startAnimation(translate2Animation);


        // 步骤1:创建 需要设置动画的 视图View
        Button scaleButton = (Button) findViewById(R.id.scale_1);
        // 步骤2：创建缩放动画的对象 & 设置动画效果：缩放动画对应的Animation子类为RotateAnimation
        Animation scaleAnimation = new ScaleAnimation(0, 2, 0, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        // 步骤3：播放动画
        scaleButton.startAnimation(scaleAnimation);

        // 步骤1:创建 需要设置动画的 视图View
        Button scale2Button = (Button) findViewById(R.id.scale_2);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation scale2Animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        // 步骤3:播放动画
        scale2Button.startAnimation(scale2Animation);


        // 步骤1:创建 需要设置动画的 视图View
        Button rotateButton = (Button) findViewById(R.id.rotate_1);
        // 步骤2：创建旋转动画的对象 & 设置动画效果：旋转动画对应的Animation子类为RotateAnimation
        Animation rotateAnimation = new RotateAnimation(0, 270, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        // 步骤3：播放动画
        rotateButton.startAnimation(rotateAnimation);

        // 步骤1:创建 需要设置动画的 视图View
        Button rotate2Button = (Button) findViewById(R.id.rotate_2);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation rotate2Animation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        // 步骤3:播放动画
        rotate2Button.startAnimation(rotate2Animation);


        // 步骤1:创建 需要设置动画的 视图View
        Button alphaButton = (Button) findViewById(R.id.alpha_1);
        // 步骤2：创建透明度动画的对象 & 设置动画效果：透明度动画对应的Animation子类为AlphaAnimation
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
        alphaAnimation.setDuration(3000);
        // 步骤3：播放动画
        alphaButton.startAnimation(alphaAnimation);


        // 步骤1:创建 需要设置动画的 视图View
        Button alpha2Button = (Button) findViewById(R.id.alpha_2);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation alpha2Animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        // 步骤3:播放动画
        alpha2Button.startAnimation(alpha2Animation);


        // 创建 需要设置动画的 视图View
        Button setButton = (Button) findViewById(R.id.set_1);

        // 组合动画设置
        // 步骤1:创建组合动画对象(设置为true)
        AnimationSet setAnimation = new AnimationSet(true);
        // 步骤2:设置组合动画的属性
        setAnimation.setRepeatMode(Animation.RESTART);
        setAnimation.setRepeatCount(1);

        // 步骤3:逐个创建子动画(方式同单个动画创建方式,此处不作过多描述)
        // 子动画1:旋转动画
        Animation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setRepeatCount(Animation.INFINITE);

        // 子动画2:平移动画
        Animation translate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
                TranslateAnimation.RELATIVE_TO_SELF, 0
                , TranslateAnimation.RELATIVE_TO_SELF, 0);
        translate.setDuration(10000);

        // 子动画3:透明度动画
        Animation alpha = new AlphaAnimation(1f, 0.3f);
        alpha.setDuration(3000);
        alpha.setStartOffset(7000);

        // 子动画4:缩放动画
        Animation scale1 = new ScaleAnimation(1, 0.5f, 1, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale1.setDuration(1000);
        scale1.setStartOffset(4000);

        // 步骤4:将创建的子动画添加到组合动画里
        setAnimation.addAnimation(alpha);
        setAnimation.addAnimation(rotate);
        setAnimation.addAnimation(translate);
        setAnimation.addAnimation(scale1);

        // 步骤5:播放动画
        setButton.startAnimation(setAnimation);

        // 步骤1:创建 需要设置动画的 视图View
        Button set2Button = (Button) findViewById(R.id.set_2);
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation set2Animation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
        // 步骤3:播放动画
        set2Button.startAnimation(set2Animation);
    }
}
