package com.enti.joan.gincanaenti;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/*public class show_actual_pista extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener, OnMapReadyCallback {
    private GoogleApiClient apiClient;
    private GoogleMap mapa;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_actual_pista);

        TextView des = (TextView)findViewById(R.id.des);
        TextView id = (TextView)findViewById(R.id.id);
        TextView idNext = (TextView)findViewById(R.id.idNext);
        TextView latitud = (TextView)findViewById(R.id.latitud);
        TextView longitud = (TextView)findViewById(R.id.longitud);
        ImageView imagen = (ImageView)findViewById(R.id.imageView);
        des.setText("Descripcion: " + listaPistas.obtenerP(0).getDescripcion().toString());
        id.setText("ID: " + listaPistas.obtenerP(0).getId().toString());
        idNext.setText("ID Next: " + listaPistas.obtenerP(0).getIdNext().toString());
        latitud.setText("Lat: " + Double.toString(listaPistas.obtenerP(0).getLatitud()));
        longitud.setText("Long: " + Double.toString(listaPistas.obtenerP(0).getLongitud()));
        int k=listaPistas.obtenerP(0).getTipo();
        imagen.setImageResource(k);

       apiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragmentMapa);
        if (mapFragment == null)
            Toast.makeText(this, "Mapa no encontrado", Toast.LENGTH_SHORT).show();
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap p) {
        mapa = p;
    }

    public void onLocationChanged(Location location) {
    }


    public void onConnectionFailed(ConnectionResult result) {
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void onStatusChanged(String proveedor, int estado, Bundle extras) {
    }

    public void onProviderDisabled(String proveedor) {
    }

    public void onConnected(@Nullable Bundle bundle) {

    }
}*/

public class show_actual_pista extends AppCompatActivity implements OnMapReadyCallback{
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_actual_pista);
        TextView des = (TextView)findViewById(R.id.des);
        TextView id = (TextView)findViewById(R.id.id);
        TextView idNext = (TextView)findViewById(R.id.idNext);
        TextView latitud = (TextView)findViewById(R.id.latitud);
        TextView longitud = (TextView)findViewById(R.id.longitud);
        ImageView imagen = (ImageView)findViewById(R.id.imageView);
        des.setText("Descripcion: " + listaPistas.obtenerP(0).getDescripcion().toString());
        id.setText("ID: " + listaPistas.obtenerP(0).getId().toString());
        idNext.setText("ID Next: " + listaPistas.obtenerP(0).getIdNext().toString());
        latitud.setText("Lat: " + Double.toString(listaPistas.obtenerP(0).getLatitud()));
        longitud.setText("Long: " + Double.toString(listaPistas.obtenerP(0).getLongitud()));
        int k=listaPistas.obtenerP(0).getTipo();
        imagen.setImageResource(k);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMap);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
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
            Intent i = new Intent(this, show_actual_pista.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


