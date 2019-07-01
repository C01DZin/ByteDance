package chapter.android.aweme.ss.com.homework;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ChatRoom extends Activity {
    TextView tv_title,tv_des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        String title =  getIntent().getStringExtra("title");
        String description =  getIntent().getStringExtra("description");
        String time =  getIntent().getStringExtra("time");
        int position =  getIntent().getIntExtra("position",1) + 1;

        tv_title = findViewById(R.id.tv_with_name);
        tv_title.setText(title);
        tv_des = findViewById(R.id.tv_content_info);
        tv_des.setText("我是第"+position+"个Item: "+description);

    }
}

