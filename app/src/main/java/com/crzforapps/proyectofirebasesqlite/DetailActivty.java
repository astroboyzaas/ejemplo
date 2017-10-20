package com.crzforapps.proyectofirebasesqlite;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivty extends AppCompatActivity {

    public static final String ITEM_VALUE = "itemValue";
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activty);

        String itemValue = getIntent().getExtras().getString(ITEM_VALUE);
        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setText(itemValue);

        mProgressBar = (ProgressBar)findViewById(R.id.progressbar);

        Button btnTarea= (Button) findViewById(R.id.btnTarea);
        btnTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                TareaAsincrona tarea = new TareaAsincrona();
                tarea.execute();
            }
        });

        Button btnNuevo= (Button) findViewById(R.id.btnNuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NuevoActivity.class));
            }
        });
    }

    class TareaAsincrona extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Thread.sleep(3000);
            }catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressBar.setVisibility(View.GONE);
            Toast.makeText(DetailActivty.this, "Tarea terminada", Toast.LENGTH_SHORT).show();

        }
    }
}
