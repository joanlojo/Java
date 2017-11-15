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
    EditText descripcion = (EditText)findViewById(R.id.des);
    EditText identificador = (EditText)findViewById(R.id.id);
    Spinner option = (Spinner)findViewById(R.id.spinner);
    EditText latitud = (EditText)findViewById(R.id.latitud);
    EditText longitud = (EditText)findViewById(R.id.longitud);
    EditText idnextPista = (EditText)findViewById(R.id.idNext);
    boolean relleno = false;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.enviarP);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!descripcion.getText().toString().equals("") && !identificador.getText().toString().equals("") && !latitud.getText().toString().equals("") && !longitud.getText().toString().equals("") && !idnextPista.getText().toString().equals("")){
                    Pista temp = null;
                    if(option.getSelectedItemPosition()==0){
                        pistaImag pistaI = new pistaImag(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                        PistaGlobal.pistaL.addPista(pistaI);
                    }
                    else if(option.getSelectedItemPosition()==1){
                        pistaText pistaT = new pistaText(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                        PistaGlobal.pistaL.addPista(pistaT);
                    }
                    else if(option.getSelectedItemPosition()==2){
                        pistaAudio pistaA = new pistaAudio(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                        PistaGlobal.pistaL.addPista(pistaA);
                    }
                   // setResult(RESULT_OK);
                    finish();
                }
                else {
                      Snackbar.make(view, "Faltan campos por rellenar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
    }

}
