package com.crzforapps.proyectofirebasesqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        final EditText editTextNombre = (EditText)findViewById(R.id.editTextNombre);

        Button btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDbHelper mOpenHelper = new MovieDbHelper(getApplicationContext());
                final SQLiteDatabase db=mOpenHelper.getWritableDatabase();
                final String nombre = editTextNombre.getText().toString();
                ContentValues values = new ContentValues();
                values.put("nombre",nombre);
                db.insert("persona",null,values);
                startActivity(new Intent(NuevoActivity.this, ListaPersonasActivity.class));
            }
        });
    }
}
