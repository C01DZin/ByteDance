package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    public static int sum = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static int getViewCount(View view) {
        if(view instanceof ViewGroup){
            ViewGroup vg  = (ViewGroup) view;
            for(int i=0;i<vg.getChildCount();i++){
                getViewCount(vg.getChildAt(i));
            }
        }
        else{
            sum++;
        }


        return 2;
    }
}
