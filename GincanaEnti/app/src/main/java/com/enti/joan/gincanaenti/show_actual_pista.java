package com.enti.joan.gincanaenti;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

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

public class show_actual_pista extends AppCompatActivity{
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;
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
    }}
