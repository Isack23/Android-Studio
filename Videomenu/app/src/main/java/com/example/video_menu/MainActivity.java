package com.example.video_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    Uri leao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = findViewById(R.id.video);
        leao = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.leao);
        MediaController player = new MediaController(this);
        player.setAnchorView(video);
        video.setMediaController(player);
        video.setVideoURI(leao);
        video.start();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_barra,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        LinearLayout telaLayout = findViewById(R.id.telaLayout);
        TextView texto = findViewById(R.id.texto);
        switch (item.getItemId()){
            case R.id.video1:
                video.setVideoURI(leao);
                video.start();
                break;
            case R.id.video2:
                video.setVideoURI(Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"));
                video.start();
                break;
            case R.id.dark:
                telaLayout.setBackgroundColor(Color.GRAY);
                texto.setTextColor(Color.WHITE);
                break;
            case R.id.light:
                telaLayout.setBackgroundColor(Color.WHITE);
                texto.setTextColor(Color.BLACK);
                break;
            case R.id.sair:
                this.finishAffinity();
                break;
            case R.id.help:
                Toast.makeText(this, "Em construção",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}