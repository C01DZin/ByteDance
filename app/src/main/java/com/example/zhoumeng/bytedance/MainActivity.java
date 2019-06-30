package com.example.zhoumeng.bytedance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private TextView mTxtv;
    private String[] str = {"I'm back!","I've changed!"};
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.button);
        mTxtv = findViewById(R.id.textView);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index == 1){
                    mTxtv.setText(str[0]);
                    index = 0;
                }
                else {
                    mTxtv.setText(str[1]);
                    index = 1;
                }

            }
        });
    }
}
