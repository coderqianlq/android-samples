package com.coderqian.chapter4;


import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.coderqian.R;

/**
 * @author qianliqing
 * @since 2018-10-25 下午9:31
 * mail: qianlq0824@gmail.com
 */
public class IntentActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button buttonOne = (Button) findViewById(R.id.intentOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOne = new Intent(IntentActivity.this, FragmentActivity.class);
                intentOne.putExtra(Intent.EXTRA_TEXT, IntentActivity.this.getLocalClassName());
                startActivity(intentOne);
            }
        });

        Button buttonTwo = (Button) findViewById(R.id.intentTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTwo = new Intent(Intent.ACTION_DIAL);
                intentTwo.setData(Uri.parse("tel:17816875411"));
                startActivity(intentTwo);
            }
        });

        Button buttonThree = (Button) findViewById(R.id.intentThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThree = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto://17816875411"));
                intentThree.putExtra("sms_body", "钱立清的短信");
                startActivity(intentThree);
            }
        });

        Button buttonFour = (Button) findViewById(R.id.intentFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFour = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/weixin_36759405"));
                startActivity(intentFour);
            }
        });

        Button buttonFive = (Button) findViewById(R.id.intentFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFive = new Intent();
                intentFive.setAction(Intent.ACTION_WEB_SEARCH);
                intentFive.putExtra(SearchManager.QUERY, "浙江大学软件学院");
                startActivity(intentFive);
            }
        });

        Button buttonSix = (Button) findViewById(R.id.intentSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSix = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intentSix);
            }
        });

    }
}
