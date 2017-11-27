package com.enti.joan.gincanaenti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jlopez on 11/27/2017.
 */

public class FragmentMapa extends Fragment {
    private View vista;
    public View onCreateView(LayoutInflater inflater, ViewGroup contenedor, Bundle savedInstanceState){
        vista = inflater.inflate(R.layout.activity_show_actual_pista, contenedor, false);
        return vista;
    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
    }
}
