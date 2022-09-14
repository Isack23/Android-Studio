package com.example.av1mobilen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {
    public EditText camponome;
    public EditText campoidade;
    public TextView texto;
    public TextView frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void cadastro(View v){

        campoidade = findViewById(R.id.idade);
        texto = findViewById(R.id.resp);
        camponome = findViewById(R.id.nome);
        frase = findViewById(R.id.frase);

        if (camponome.getText().length() > 0 && campoidade.getText().length() > 0){
            texto.setText("Você será redirecionado para proxima tela");
            Intent mudar = new Intent(this, BoasVindas.class);
            startActivity(mudar);
        }

        else{
            texto.setText("Preencha todos os campos");
        }
    }

}