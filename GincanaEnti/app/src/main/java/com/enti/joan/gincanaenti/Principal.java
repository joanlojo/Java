package com.enti.joan.gincanaenti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    listaPistas ListaPistas = new listaPistas();
    @Override
    protected void onCreate(Bundle savedInstanceState) { //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);//la R guarda los identificadores de todos los recursos, y los divide por recursos de string, layouts..

    }
   /* public void mostrarNovaPista(View view){
      //  Pista pista;

       EditText identificador = (EditText)findViewById(R.id.identificador);
        EditText descripcio = (EditText)findViewById(R.id.descripcion);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        EditText latitud = (EditText)findViewById(R.id.latitud);
        EditText longitud = (EditText)findViewById(R.id.longitud);
        EditText idnextPista = (EditText)findViewById(R.id.idNex);

        if(spinner.getSelectedItem().toString().equals("Texto")){
            pistaText myText = new pistaText();
            myText.setDes(descripcio.getText().toString());
            myText.setId(identificador.getText().toString());
            myText.setIdNext(idnextPista.getText().toString());
            myText.setPosition(Double.parseDouble(latitud.getText().toString()), Double.parseDouble(longitud.getText().toString()));
            ListaPistas.addPista(myText);
            Toast.makeText(this, "good",Toast.LENGTH_SHORT).show();
        }
        if(spinner.getSelectedItem().toString().equals("Sonido")){
            pistaAudio myAudio = new pistaAudio();
            myAudio.setPath(descripcio.getText().toString());
            myAudio.setId(identificador.getText().toString());
            myAudio.setIdNext(idnextPista.getText().toString());
            myAudio.setPosition(Double.parseDouble(latitud.getText().toString()), Double.parseDouble(longitud.getText().toString()));
            ListaPistas.addPista(myAudio);
            Toast.makeText(this, "good",Toast.LENGTH_SHORT).show();
        }
        if(spinner.getSelectedItem().toString().equals("Imagen")){
            pistaImag myImag = new pistaImag();
            myImag.setPath(descripcio.getText().toString());
            myImag.setId(identificador.getText().toString());
            myImag.setIdNext(idnextPista.getText().toString());
            myImag.setPosition(Double.parseDouble(latitud.getText().toString()), Double.parseDouble(longitud.getText().toString()));
            ListaPistas.addPista(myImag);
            Toast.makeText(this, "good",Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(this, identificador.getText().toString() + descripcio.getText().toString() +spinner.getSelectedItem().toString() + latitud.getText().toString() + longitud.getText().toString() + idnextPista.getText().toString(), Toast.LENGTH_SHORT).show();
        //get text to string
    }*/
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

   /* @Override protected void  onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 8888 && resultCode == RESULT_OK){
            String res  = data.getExtras().getString("resultat");
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }
    }*/

}
