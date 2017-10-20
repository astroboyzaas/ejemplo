package com.crzforapps.proyectofirebasesqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaPersonasActivity extends AppCompatActivity {
    String lista[];
    ListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas);
        lista=obtenerLista();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        ListView listaPersonas = (ListView) findViewById(R.id.listViewPersonas);
        listaPersonas.setAdapter(mAdapter);

    }

    private String[] obtenerLista() {
        MovieDbHelper mOpenHelper = new MovieDbHelper(getApplicationContext());
        Cursor cursor=mOpenHelper.getReadableDatabase().rawQuery("SELECT * from persona", null);
        cursor.moveToFirst();
        ArrayList<String> nombres = new ArrayList<String>();
        while(!cursor.isAfterLast()) {
            nombres.add(cursor.getString(cursor.getColumnIndex("nombre")));
            cursor.moveToNext();
        }
        cursor.close();
        return nombres.toArray(new String[nombres.size()]);
    }


}
