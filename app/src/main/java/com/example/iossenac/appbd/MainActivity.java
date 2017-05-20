package com.example.iossenac.appbd;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String createTable =
            "CREATE TABLE IF NOT EXISTS contato" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR(30)," +
                    "telefone VARCHAR(12));";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase banco = openOrCreateDatabase("contatos.db", MODE_PRIVATE, null);
        banco.execSQL(createTable);


        ContentValues valores = new ContentValues();
        valores.put("nome","Fulano");
        valores.put("telefone","4535636");
        banco.insert("contato",null, valores);

        valores = new ContentValues();
        valores.put("nome","Renata");
        valores.put("telefone","4674");
        banco.insert("contato",null, valores);

        valores = new ContentValues();
        valores.put("nome","Raquel");
        valores.put("telefone","112233");
        banco.insert("contato",null, valores);

        Cursor cursor = banco.query("contato",
                new String[]{"id","nome","telefone"},
                null,null,null,null,"nome");


        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String texto = "Contato: "+id+" - "+nome+" - "+telefone;
            Log.i("BD",texto);
        }
    }
}