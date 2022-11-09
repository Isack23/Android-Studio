package com.example.apppaginaprogresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    final int maxFotos = 4;
    ProgressBar barra;
    Button avançar, voltar;
    ImageView foto;
    int indice=0, valor=0;
    int idFotos[]={R.drawable.imagem1, R.drawable.imagem2, R.drawable.imagem3, R.drawable.imagem4, R.drawable.imagem5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra=findViewById(R.id.progresso);
        avançar=findViewById(R.id.avançar);
        voltar=findViewById(R.id.voltar);
        foto=findViewById(R.id.foto);


        foto.setImageResource(idFotos[indice]);


        avançar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valor <100){
                    valor=valor +25;
                    barra.setProgress(valor);
                }
                if (indice<maxFotos){
                    indice++;
                    foto.setImageResource(idFotos[indice]);
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valor>0){
                    valor=valor - 25;
                    barra.setProgress(valor);
                }
                if (indice>0){
                    indice--;
                    foto.setImageResource(idFotos[indice]);
                }
            }
        });
    }
}