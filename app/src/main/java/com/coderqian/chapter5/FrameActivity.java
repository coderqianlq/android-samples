package com.coderqian.chapter5;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-26 上午12:44
 * mail: qianlq0824@gmail.com
 */
public class FrameActivity extends AppCompatActivity {
    private ImageView wifiImage;
    private Button buttonA, buttonB, buttonC;
    private AnimationDrawable animationDrawable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_frame);


        wifiImage = (ImageView) findViewById(R.id.animation);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                wifiImage.setImageResource(R.drawable.frame_1);
                animationDrawable = (AnimationDrawable) wifiImage.getDrawable();
                animationDrawable.start();
            }

        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                animationDrawable = (AnimationDrawable) wifiImage.getDrawable();
                animationDrawable.stop();
            }

        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                wifiImage.setImageResource(R.drawable.frame_2);
                animationDrawable = (AnimationDrawable) wifiImage.getDrawable();
                animationDrawable.start();
            }
        });
    }
}
