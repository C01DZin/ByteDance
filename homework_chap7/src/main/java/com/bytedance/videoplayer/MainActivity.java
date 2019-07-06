package com.bytedance.videoplayer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SurfaceView sv;
    private Button play,pause,select;
    private SeekBar sb;
    private MediaPlayer mp;
    private Uri mSelectedVideo;
    private  int selected = 0;
    private String[] mPermissionsArrays = new String[]{Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO};

    public class PlayerCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder){
            mp.setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Log.d("jzh", "surfaceChanged: ");

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }

    }


    public void initBtn(){
        sv = findViewById(R.id.surfaceView);
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        select = findViewById(R.id.select);
        sb = findViewById(R.id.seekbar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser && mp.isPlaying()){

                    mp.seekTo((int)(mp.getDuration()*progress/seekBar.getMax()));
                    Log.d("jzh", "onProgressChanged: "+ progress*mp.getDuration()/seekBar.getMax());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseVideo();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                }
            }
        });
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mp) {
                Log.d("jzh", "onPrepared: ");
                mp.start();

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (mp.isPlaying()) {
                                // 如果正在播放，没0.5.毫秒更新一次进度条

                                int current = mp.getCurrentPosition();
                                sb.setProgress((int)(current*sb.getMax()/mp.getDuration()));
                                Log.d("jzh", "run: "+ (int)(current) + " " + mp.getCurrentPosition());
                                sleep(500);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                mp.setLooping(true);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mp.isPlaying()){
                    mp.start();
                }
            }
        });
        if (!checkPermissionAllGranted(mPermissionsArrays)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(mPermissionsArrays, 123);
            }
        } else {
            Toast.makeText(MainActivity.this, "已经获取所有所需权限", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkPermissionAllGranted(String[] permissions) {
        // 6.0以下不需要
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                // 只要有一个权限没有被授予, 则直接返回 false
                return false;
            }
        }
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView imageView = findViewById(R.id.imageView);
        //String url = "https://s3.pstatp.com/toutiao/static/img/logo.271e845.png";
        //Glide.with(this).load(url).into(imageView);

        mp = new MediaPlayer();

        initBtn();

//        MediaController mMediaController = new MediaController(this);
//        mp.setMediaController(mMediaController);




    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null && mp.isPlaying()) {
            mp.pause();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mp != null ) mp.release();
    }
    public void chooseVideo() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select video"),1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && null != data) {
            if (requestCode == 1) {
                mSelectedVideo = data.getData();

                try{
                   /* if (mp != null) {
                        mp.reset();

                        Log.d("jzh", "after reset data: ");
                    }*/
                    SurfaceHolder holder = sv.getHolder();
                    holder.addCallback(new PlayerCallBack());
                    mp.setDataSource(this,mSelectedVideo);
//                    if(selected == 1) mp = MediaPlayer.create(this,mSelectedVideo);
//                    else {
//                        selected = 1;
//                        mp.setDataSource(this,mSelectedVideo);
//                    }
                    mp.prepare();
                    Log.d("jzh", "onCreate: ");


                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        Log.d("jzh", "onConfigurationChanged: ");




    }


}
