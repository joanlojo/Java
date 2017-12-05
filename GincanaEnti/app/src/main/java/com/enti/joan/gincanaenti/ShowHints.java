package com.enti.joan.gincanaenti;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHints extends AppCompatActivity implements View.OnLongClickListener {
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
        adaptador.setonLongClickListener(this);
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
    public boolean onLongClick(View v){

        final View k=v;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Eliminar pista");
        alertDialogBuilder.setMessage("Estas seguro que deseas eliminar la pista de ID: " + listaPistas.listaPista.get(recyclerView.getChildAdapterPosition(v)).getId()+" ?");
        alertDialogBuilder.setPositiveButton("ok",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Pista p = listaPistas.listaPista.get(recyclerView.getChildAdapterPosition(k));
                        listaPistas.eliminarPista(p.getId());
                        recyclerView.removeAllViews();
                    }
                });
        alertDialogBuilder.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return true;
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
