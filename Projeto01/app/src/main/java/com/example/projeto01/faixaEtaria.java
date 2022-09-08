package com.example.projeto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class faixaEtaria extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faixaetaria);
        confereFaixa();
    }

   public void confereFaixa(){
       Intent acao = getIntent();
       Bundle pacote = acao.getExtras();
       String nome2 = (String) pacote.get("nome");
       String idade2 = (String) pacote.get("idade");
       int idade3 = Integer.parseInt(idade2);
       TextView texto = findViewById(R.id.texto2);
        if(idade3 <= 12){
           texto.setText("Nome: " + nome2 + "\nVocê é uma Criança!" );
        } else if ((idade3 > 12) && (idade3 < 18)){
            texto.setText("Nome: " + nome2 + "\nVocê é um Adolescente!" );
        } else {
            texto.setText("Nome: " + nome2 + "\nVocê é um adulto!" );
        }
    }
}