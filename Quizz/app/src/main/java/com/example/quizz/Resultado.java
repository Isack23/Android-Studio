package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TextView resultado = findViewById(R.id.resultado);
        Intent acao = getIntent();
        Bundle dados = acao.getExtras();
        int score = dados.getInt("resultado");
        resultado.setText("Você acertou "+score+" pergunta(s).");
    }
}