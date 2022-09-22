package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quizz extends AppCompatActivity implements View.OnClickListener {

    String perguntas[]={
            "Não é exemplo de SO para Dispositivos Móveis:",
            "Android foi lançado em: "
    };
    String respostas[][]={
            {"Android","Java","ioS"},
            {"2008","2010","2005"}
    };
    String respCorretas[]={
            "Java","2008"
    };

    TextView pergunta;
    Button resp1,resp2,resp3,enviar;
    int acertos=0, indice=0, totalPerguntas=2;
    String respSelecionada="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_quizz);

        pergunta= findViewById(R.id.pergunta);
        resp1=findViewById(R.id.p1);
        resp2=findViewById(R.id.p2);
        resp3=findViewById(R.id.p3);
        enviar=findViewById(R.id.enviar);


        resp1.setOnClickListener(this);
        resp2.setOnClickListener(this);
        resp3.setOnClickListener(this);
        enviar.setOnClickListener(this);

        mudaPergunta();

    }

    @Override
    public void onClick(View v){
        resp1.setBackgroundColor(Color.WHITE);
        resp2.setBackgroundColor(Color.WHITE);
        resp3.setBackgroundColor(Color.WHITE);


        Button botaoClicado = (Button) v;

        if (botaoClicado.getId()==R.id.enviar){
            if(respSelecionada.equals(respCorretas[indice])){
                acertos++;
            }
            indice++;
            mudaPergunta();
        }else{
            respSelecionada=botaoClicado.getText().toString();
            botaoClicado.setBackgroundColor(Color.parseColor("#D0D1D3"));
        }
    }

    public void mudaPergunta(){
        if (indice==totalPerguntas){
            Intent acao = new Intent(this,Resultado.class);
            acao.putExtra("resultado",acertos);
            startActivity(acao);
        } else {
            pergunta.setText(perguntas[indice]);
            resp1.setText(respostas[indice][0]);
            resp2.setText(respostas[indice][1]);
            resp3.setText(respostas[indice][2]);
        }

    }
}