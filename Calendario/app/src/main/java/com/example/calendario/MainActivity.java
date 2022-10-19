package com.example.calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText dataEscolhida;
    Button botao;
    Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataEscolhida = findViewById(R.id.campoData);
        botao = findViewById(R.id.botao);
        calendario = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener data = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                Calendar c = Calendar.getInstance();
                c.set(ano,mes,dia);
                String formato="dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat();
                Date date = c.getTime();
                dataEscolhida.setText(sdf.format(date));
            }
        };

        dataEscolhida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new DatePickerDialog(MainActivity.this,data,calendario.get(Calendar.YEAR),calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle("Confirmação");
                msg.setMessage("Deseja submeter seu agendamento?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Agendamento realizado",Toast.LENGTH_LONG).show();
                        dataEscolhida.setText("");
                    }
                });
                msg.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                msg.create();
                msg.show();
            }
        });
    }
}