package com.example.av1mobilen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BoasVindas extends AppCompatActivity {

    TextView frase;
    EditText campoidade;
    EditText camponome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
    }

    public void barreira(View v){

        frase = findViewById(R.id.frase);
        campoidade = findViewById(R.id.idade);
        camponome = findViewById(R.id.nome);

        if (campoidade.equals("19")) {
            frase.setText("Olá " + camponome + "seja bem vindo(a) ao nosso sistema de faixa étaria, vimos aqui que você é um(a) Adolecente");
        }
        else {
            frase.setText("Olá " + camponome + "seja bem vindo(a) ao nosso sistema de faixa étaria, vimos aqui que você é um(a) Adulto(a)");

        }
    }
}