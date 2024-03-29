package com.example.zhoumeng.bytedance;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private TextView mTxtv;
    private String[] str = {"I'm back!","I've changed!"};
    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.button);
        mTxtv = findViewById(R.id.textView);
        System.out.println("on create");

        final ImageView iv = findViewById(R.id.imageView);
        ValueAnimator va = ValueAnimator.ofFloat(0,360);
        va.setRepeatCount(ValueAnimator.INFINITE);
        va.setInterpolator(new AccelerateInterpolator());
        va.setRepeatMode(ValueAnimator.RESTART);
        va.setDuration(9000);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                iv.setRotation((float)animation.getAnimatedValue());
            }
        });
        va.start();

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTxtv.setText(str[(index++)%2]);
                finish();
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("on destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("on stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("on pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("on restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("on resume");
    }
}
