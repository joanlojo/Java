package com.enti.joan.gincanaenti;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPista extends AppCompatActivity {
    private Button salir;

    boolean relleno = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put__pista);

        final EditText descripcion = (EditText)findViewById(R.id.des);
        final EditText identificador = (EditText)findViewById(R.id.id);
        final Spinner option = (Spinner)findViewById(R.id.spinner);
        final EditText latitud = (EditText)findViewById(R.id.latitud);
        final EditText longitud = (EditText)findViewById(R.id.longitud);
        final EditText idnextPista = (EditText)findViewById(R.id.idNext);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

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
                if(!descripcion.getText().toString().equals("") && !identificador.getText().toString().equals("") && !latitud.getText().toString().equals("") && !longitud.getText().toString().equals("") && !idnextPista.getText().toString().equals("")) {
                    // Pista temp = null;
                    if (listaPistas.findPista(identificador.getText().toString()) == null) {
                        if (option.getSelectedItemPosition() == 0) {
                            pistaImag pistaI = new pistaImag(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                            listaPistas.addPista(pistaI);
                        } else if (option.getSelectedItemPosition() == 1) {
                            pistaText pistaT = new pistaText(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                            listaPistas.addPista(pistaT);
                        } else if (option.getSelectedItemPosition() == 2) {
                            pistaAudio pistaA = new pistaAudio(identificador.getText().toString(), idnextPista.getText().toString(), descripcion.getText().toString(), Double.parseDouble(latitud.getText().toString()), Double.parseDouble(latitud.getText().toString()), "text");
                            listaPistas.addPista(pistaA);

                        }
                        setResult(RESULT_OK);
                        finish();
                    }
                    else{
                        Toast.makeText(view.getContext(), "El ID de esta pista ya existe", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                      Snackbar.make(view, "Faltan campos por rellenar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
       });
    }
    @Override public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.id_about){
            Intent i = new Intent(this, About.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.id_ShowHint){
            Intent i = new Intent(this, ShowHints.class);
            startActivity(i);
            return true;
        }
        if(id==R.id.id_Exit){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Salir");
            alertDialogBuilder.setMessage("Estas seguro que deseas salir de la app ?");
            alertDialogBuilder.setPositiveButton("ok",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    finishAffinity();
                }
            });
            alertDialogBuilder.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        if(id == R.id.id_showActual){
            Intent i = new Intent(this, ShowActualPista.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
