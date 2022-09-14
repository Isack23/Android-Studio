package com.example.campeao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void clicar(View v){
        Intent ação = new Intent(this, Titulos.class);
        ImageButton img = (ImageButton) v;
        String nome= getResources().getResourceEntryName(img.getId());
        //TextView texto = findViewById(R.id.texto);
        //texto.setText(""+nome);
        ação.putExtra("país",nome);
        startActivity(ação);
    }

}