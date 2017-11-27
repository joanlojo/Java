package com.enti.joan.gincanaenti;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_principal);//la R guarda los identificadores de todos los recursos, y los divide por recursos de string, layouts..

        pistaImag pistaI = new pistaImag("0", "36", "prueba", 2, 5, "imag");
        pistaAudio pistaA = new pistaAudio("1", "36", "prueba1", 2, 5, "audio");
        pistaText pistaT = new pistaText("2", "336", "prueba2", 2, 5, "text");

        listaPistas.addPista(pistaI);
        listaPistas.addPista(pistaA);
        listaPistas.addPista(pistaT);
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
         return super.onOptionsItemSelected(item);
    }
}
