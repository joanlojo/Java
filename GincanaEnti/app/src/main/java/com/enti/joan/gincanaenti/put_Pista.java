package com.enti.joan.gincanaenti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class put_Pista extends AppCompatActivity {
    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put__pista);
        salir = (Button)findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, "Operacion cancelada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.enviarP);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText descripcio = (EditText)findViewById(R.id.des);
                EditText identificador = (EditText)findViewById(R.id.id);
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                EditText latitud = (EditText)findViewById(R.id.latitud);
                EditText longitud = (EditText)findViewById(R.id.longitud);
                EditText idnextPista = (EditText)findViewById(R.id.idNext);
                Intent i = new Intent();
                i.putExtra("des", descripcio.getText().toString());
                i.putExtra("id", identificador.getText().toString());
                i.putExtra("tipo",spinner.getSelectedItem().toString());
               // i.putExtra("tipo", spinner.getText().toString());
                i.putExtra("latitud", latitud.getText().toString());
                i.putExtra("longitud", longitud.getText().toString());
                i.putExtra("idNext", idnextPista.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
