package com.enti.joan.gincanaenti;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowActualPista extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_actual_pista);
        if(listaPistas.getLength() == 0) {
            Toast.makeText(this, "No hay ninguna pista", Toast.LENGTH_SHORT).show();
        }
        else {
            TextView des = (TextView) findViewById(R.id.des);
            TextView id = (TextView) findViewById(R.id.id);
            TextView idNext = (TextView) findViewById(R.id.idNext);
            TextView latitud = (TextView) findViewById(R.id.latitud);
            TextView longitud = (TextView) findViewById(R.id.longitud);
            ImageView imagen = (ImageView) findViewById(R.id.imageView);
            des.setText("Descripcion: " + listaPistas.obtenerP(0).getDescripcion().toString());
            id.setText("ID: " + listaPistas.obtenerP(0).getId().toString());
            idNext.setText("ID Next: " + listaPistas.obtenerP(0).getIdNext().toString());
            latitud.setText("Lat: " + Double.toString(listaPistas.obtenerP(0).getLatitud()));
            longitud.setText("Long: " + Double.toString(listaPistas.obtenerP(0).getLongitud()));
            int k = listaPistas.obtenerP(0).getTipo();
            imagen.setImageResource(k);
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMap);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng bcn = new LatLng(41.40363f, 2.174356f);
        mMap.addMarker(new MarkerOptions().position(bcn).title("Sagrada Familia"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bcn));
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


