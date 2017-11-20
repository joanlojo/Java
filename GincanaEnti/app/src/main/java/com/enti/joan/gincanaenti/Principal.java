package com.enti.joan.gincanaenti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);//la R guarda los identificadores de todos los recursos, y los divide por recursos de string, layouts..
        pistaImag pistaI = new pistaImag("0", "36", "prueba", 2, 5, "imag");
        pistaAudio pistaA = new pistaAudio("1", "36", "prueba1", 2, 5, "audio");
        pistaText pistaT = new pistaText("2", "336", "prueba2", 2, 5, "text");

        listaPistas.addPista(pistaI);
        listaPistas.addPista(pistaA);
        listaPistas.addPista(pistaT);
    }
    public void showPista(View view){


        Intent i = new Intent(this, ShowHints.class);
        startActivity(i);
    }
    public void showAbout(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }
    public void Exit(View view){
        Intent i = new Intent(this, Salir.class);
        startActivity(i);
    }
}
