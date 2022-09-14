package com.example.campeao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Titulos extends AppCompatActivity {
    String brasil[] = {"1958", "1962", "1970", "1994", "2002"};
    String alemanha[] = {"1954", "1974", "1990", "2014"};
    String italia[] = {"1934", "1938", "1982", "2006"};
    String argentina[] = {"1978", "1986"};

    String país;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulos);
        TextView texto = findViewById(R.id.texto);
        Intent i = getIntent();
        Bundle dados = i.getExtras();
        país = dados.getString("país");
        texto.setText("supercampeõs\n-"+país+" -");
        exibeTitulos();


    }

    public void exibeTitulos(){
        TextView textoTilulos = findViewById(R.id.textoTitulos);
        if(país.equals("Brasil")){
            for(int i=0; i<brasil.length; i++)
                textoTilulos.append(brasil[i]+"\n");
        } else if(país.equals("Alemanha")) {
            for (int i = 0; i < alemanha.length; i++)
                textoTilulos.append(alemanha[i] + "\n");
        } else if(país.equals("Italia")) {
            for (int i = 0; i < italia.length; i++)
                textoTilulos.append(italia[i] + "\n");
        } else if(país.equals("Argentina")) {
            for (int i = 0; i < argentina.length; i++)
                textoTilulos.append(argentina[i] + "\n");
        }

    }




}