package com.enti.joan.gincanaenti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jlopez on 11/27/2017.
 */

public class FragmentPista extends Fragment {
    private View vista;
    public View onCreateView(LayoutInflater inflater, ViewGroup contenedor, Bundle savedInstanceState){
        vista = inflater.inflate(R.layout.lista_items, contenedor, false);
        //codigo para inicializar lo que el fragment tenga q mostrar, como un recycler view
        return vista;
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        //codigo para una vez creada la activdad que contiene el fragmento ahcer lo q sea
    }
}
