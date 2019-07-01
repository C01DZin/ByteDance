package chapter.android.aweme.ss.com.homework;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 * 竖屏横屏切换时：
 *  onPause -> onStop -> onDestroy -> onCreate -> onResume
 */
public class Exercises1 extends AppCompatActivity {

    private static final String TAG = "Exercise1:";
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises1);
        Log.d(TAG, "onCreate");
        LinearLayout l = findViewById(R.id.liner);
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onCreate");
        l.addView(v);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        LinearLayout l = findViewById(R.id.liner);
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onResume");
        l.addView(v);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onRestart");
        LinearLayout l = findViewById(R.id.liner);
        l.addView(v);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onPause");
        LinearLayout l = findViewById(R.id.liner);
        l.addView(v);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onStop");
        LinearLayout l = findViewById(R.id.liner);
        l.addView(v);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        TextView v = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        v.setText("onDestroy");
        LinearLayout l = findViewById(R.id.liner);
        l.addView(v);
    }
}
