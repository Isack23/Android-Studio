package com.example.video_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    Uri leao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = findViewById(R.id.video);
        leao = Uri.parse("android.resourse://"+getPackageName()+"/"+R.raw.leao);
        
    }
}