package com.coderqian.chapter2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * @author qianliqing
 * @since 2018-09-30 下午4:00
 * mail: qianlq0824@gmail.com
 */
public class RelativeActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        viewFlipper = findViewById(R.id.details);
    }

    public void prev(View source) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void next(View source) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }

    public void auto(View source) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        if (viewFlipper.isFlipping()) viewFlipper.stopFlipping();
        else viewFlipper.startFlipping();
    }
}
