package com.coderqian.chapter4;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-25 下午10:13
 * mail: qianlq0824@gmail.com
 */
public class AnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View {
        public MyAnimationView(Context context) {
            super(context);
            ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater
                    .loadAnimator(AnimatorActivity.this, R.animator.color_anim);
            objectAnimator.setEvaluator(new ArgbEvaluator());
            objectAnimator.setTarget(this);
            objectAnimator.start();
        }
    }

}
