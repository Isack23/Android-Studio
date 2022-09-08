package com.example.projeto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v){
        EditText nome = findViewById(R.id.nome);
        EditText idade = findViewById(R.id.idade);

        String valorNome = nome.getText().toString();
        String valorIdade = idade.getText().toString();

        if(valorNome.equals("") || valorIdade.equals("")){
            if(valorNome.equals("") && valorIdade.equals("")){
                TextView respostaErro = findViewById(R.id.mensagemErro);
                respostaErro.setText("Você não inseriu nenhum dado!");
            }
                else{
                if(valorNome.equals("")){
                    TextView respostaErro = findViewById(R.id.mensagemErro);
                    respostaErro.setText("Favor Informar o Nome!");
                } else if (valorIdade.equals("")){
                        TextView respostaErro = findViewById(R.id.mensagemErro);
                        respostaErro.setText("Favor Informar a Idade");
                }
            }
        }
        else{
            Intent acao = new Intent(this, faixaEtaria.class);
            acao.putExtra("nome",valorNome);
            acao.putExtra("idade",valorIdade);
            startActivity(acao);

        }
    }




}