package com.bytedance.clockapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });



        final Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    mClockView.postInvalidate();
                    try{
                        sleep(1000);
                    }catch(Exception e){}
                }

            }

        });
        thread.start();

    }




}



