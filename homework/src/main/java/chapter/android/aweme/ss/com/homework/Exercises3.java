package chapter.android.aweme.ss.com.homework;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

import static chapter.android.aweme.ss.com.homework.model.PullParser.getMessage;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    private RecyclerView rv;
    private Adapter adapter;
    private Button like,fans,at,comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise3);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter = new Adapter(this));


        like = findViewById(R.id.like);
        fans = findViewById(R.id.fans);
        at = findViewById(R.id.at);
        comment = findViewById(R.id.comment);


    }
    public void showText(View view){
        int n = view.getId();
        if(n == R.id.at){
            Toast.makeText(this, "@我的", Toast.LENGTH_SHORT).show();
        }
        else if (n == R.id.comment){
            Toast.makeText(this, "评论", Toast.LENGTH_SHORT).show();
        }
        else if(n == R.id.like){
            Toast.makeText(this, "赞", Toast.LENGTH_SHORT).show();
        }
        else if(n == R.id.fans){
            Toast.makeText(this, "粉丝", Toast.LENGTH_SHORT).show();
        }

    }

    public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
        List<Message> msgList = new ArrayList<Message>();
        private Context lContext;

        public Adapter(Context context){
            lContext = context;
            for(int i=0;i<11;i++){
                try{
                    msgList = getMessage(Exercises3.this);
                }catch(Exception e){}


            }
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view = LayoutInflater.from(lContext).inflate(R.layout.im_list_item,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            Log.i("adapter", "onCreateViewHolder: ");
            return holder;
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position){

            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Exercises3.this,ChatRoom.class);
                    intent.putExtra("description",msgList.get(position).getDescription());
                    intent.putExtra("time",msgList.get(position).getTime());
                    intent.putExtra("title",msgList.get(position).getTitle());
                    intent.putExtra("position",position);
                    startActivity(intent);
                }
            });

            holder.description.setText(msgList.get(position).getDescription());
            holder.time.setText(msgList.get(position).getTime());
            holder.title.setText(msgList.get(position).getTitle());

        }
        @Override
        public int getItemCount(){return msgList.size();}



        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView description,time,title;
            private ImageView img;
            public MyViewHolder(View v){
                super(v);
                title = v.findViewById(R.id.tv_title);
                time = v.findViewById(R.id.tv_time);
                description = v.findViewById(R.id.tv_description);
                img = v.findViewById(R.id.iv_avatar);
            }
        }
    }

}
