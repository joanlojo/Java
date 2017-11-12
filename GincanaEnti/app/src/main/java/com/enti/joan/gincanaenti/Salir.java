package com.enti.joan.gincanaenti;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Salir extends AppCompatActivity {
    private Button si, no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salir);
        si = (Button)findViewById(R.id.si);
        si.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finishAffinity();
            }
        });

        no = (Button)findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                 finish();
            }
        });
    }
}
