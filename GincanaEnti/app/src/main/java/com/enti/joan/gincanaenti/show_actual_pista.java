package com.enti.joan.gincanaenti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class show_actual_pista extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener, OnMapReadyCallback {
    private GoogleApiClient apiClient;
    private GoogleMap mapa;

    protected void onCreate(Bundle savedInstanceState) {
        apiClient = new GoogleApiClient(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();

        FragmentMapa fragmentMapa=(FragmentMapa)getFragmentManager().findFragmentById(R.id.FragmentMapa);
        if(fragmentMapa== null)
            Toast.makeText(this, "Mapa no encontrado", Toast.LENGTH_SHORT).show();
        fragmentMapa.getMapAsync(this);
    }

    public void onMapReady(GoogleMap p){
        mapa = p;
    }
}
