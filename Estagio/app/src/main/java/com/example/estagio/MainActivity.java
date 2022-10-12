package com.example.estagio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Cria um objeto do tipo Spinner
    Spinner meuSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuSpinner = findViewById(R.id.semestre);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.semestres, android.R.layout.simple_spinner_item);

        meuSpinner.setAdapter(adaptador);
    }


    public void verifica(View v){
        EditText nome =  findViewById(R.id.nome);
        String nomeAluno = nome.getText().toString();

        RadioGroup radioGroup = findViewById(R.id.opCursos);
        RadioButton opcao = findViewById(radioGroup.getCheckedRadioButtonId());
        String curso = opcao.getText().toString();

        TextView texto = findViewById(R.id.resultado);
        String semestre = meuSpinner.getSelectedItem().toString();

        if (curso.equals("Informática") && semestre.equals("Semestre 4")){
            texto.setText("Olá, "+nomeAluno+". Sua solicitação foi cadastrada com sucesso.\n\n");
            texto.setText(
                    texto.getText().toString()+"Serão enviadas para seu e-mail as instruções para matrícula. "
            );
        }
        else if (curso.equals("Segurança") && semestre.equals("Semestre 3")){
            texto.setText("Olá, "+nomeAluno+". Sua solicitação foi cadastrada com sucesso.\n\n");
            texto.setText(
                    texto.getText().toString()+"Serão enviadas para seu e-mail as instruções para matrícula. "
            );
        }
        else
            texto.setText(nomeAluno+", desculpe. Você não atende os critérios para estágio.");


    }
}