package com.example.appinscricao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDataBase extends SQLiteOpenHelper {

    AppDataBase(Context context){
        super(context, "app08", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE JOGADORES(CHAVE INTEGER PRIMARY KEY AUTOINCREMENT,MATRICULA TEXT, NOME TEXT, MODALIDADE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public long salvar(String mat, String nome, String mod){
        long num;
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues valores = new ContentValues();
        try{
            valores.put("MATRICULA",mat);
            valores.put("NOME", nome);
            valores.put("MODALIDADE",mod);
            num=bd.insert("JOGADORES",null,valores);

        }finally {
            bd.close();
        }
        return num;
    }
    public String exibir(){
        SQLiteDatabase bd = getWritableDatabase();
        String resultado = "";

        try {
            Cursor cursor = bd.rawQuery("SELECT * FROM JOGADORES",null);
            if (cursor.moveToFirst()){
                do {
                    resultado=resultado+"\n"+" Matricula: "+cursor.getString(1)+" Nome: "+cursor.getString(2)+" Modalidade: "+cursor.getString(3)+"\n";
                }while (cursor.moveToNext());
            }

        }finally {
            bd.close();
        }

        return resultado;
    }

    public void apagar(){
        SQLiteDatabase bd = getWritableDatabase();
        bd.execSQL("DELETE FROM JOGADORES");
    }

    public boolean verifica(String mat,String mod){
        SQLiteDatabase bd = getWritableDatabase();
        try {

            Cursor cursor = bd.rawQuery("SELECT * FROM JOGADORES WHERE MATRICULA=? AND MODALIDADE=?",new String[]{mat,mod});
            return cursor.moveToFirst();

        }finally {
            bd.close();
        }

    }
}