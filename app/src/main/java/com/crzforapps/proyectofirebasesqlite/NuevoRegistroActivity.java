package com.crzforapps.proyectofirebasesqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoRegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);
        EditText editTextNombre2 = (EditText) findViewById(R.id.editTextNombre2);
        String nombre = editTextNombre2.getText().toString();

        Button btn = (Button) findViewById(R.id.btnGuardar2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
