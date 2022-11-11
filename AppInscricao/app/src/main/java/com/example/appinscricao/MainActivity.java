package com.example.appinscricao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mat,nome,mod;
    TextView result;
    Button enviar,relatorio;
    AppDataBase banco;
    String vmat,vnome,vmod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mat=findViewById(R.id.matricula);
        nome=findViewById(R.id.nome);
        mod=findViewById(R.id.modalidade);
        result=findViewById(R.id.resultado);
        enviar=findViewById(R.id.enviar);
        relatorio=findViewById(R.id.consultar);

        banco=new AppDataBase(this);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vmat=mat.getText().toString();
                vnome=nome.getText().toString();
                vmod=mod.getText().toString();

                if (banco.verifica(vmat,vmod)==false){
                    long num = banco.salvar(vmat,vnome,vmod);
                    if (num!=-1){
                        mat.setText("");
                        mod.setText("");
                        nome.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(),"já inscrinto na modalidade",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        relatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(banco.exibir());
            }
        });

    }
}