package com.example.zhoumeng.bytedance;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ObjectAnimator animator = ObjectAnimator.ofFloat(findViewById(R.id.img),
                "rotation",0,720);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();


    }

}
