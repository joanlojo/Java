package com.enti.joan.gincanaenti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHints extends AppCompatActivity implements View.OnClickListener {
    //private ArrayList<String> listaVersiones;
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private Button btn_salir;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_hints);
        btn_salir = (Button)findViewById(R.id.btn_salir);

        btn_salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        adaptador = new Adaptador(this);
        adaptador.setOnClickListener(this);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.putPista);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putPista(view);
            }
        });
    }

    public void putPista(View view){
        Intent i = new Intent(this, put_Pista.class);
        startActivityForResult(i,8888);
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 8888 && resultCode == RESULT_OK){
            adaptador.notifyDataSetChanged();
        }
    }

    //detectar click sobre la lista
    public void onClick(View v){
        Pista p = listaPistas.listaPista.get(recyclerView.getChildAdapterPosition(v));
        listaPistas.eliminarPista(p.getId());
        recyclerView.removeAllViews();
    }


}
