package com.enti.joan.gincanaenti;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jlopez on 9/20/2017.
 */

public class listaPistas {
    ArrayList<Pista>listaPista=new ArrayList<Pista>();

    public void addPista(Pista p){
        listaPista.add(p);
    }

    public Pista findPista(String id) {
        Pista p = null;
        Iterator<Pista> i = listaPista.iterator();
        boolean found = false;

        while (i.hasNext() && found == false) {
            p = i.next();
            if (p.getId() == id) {
                found = true;
            }
        }
        if (found == true) {
            return p;
        } else {
            return null;
        }
    }

    public void eliminarPista(String id) {
        Pista p;
        boolean find = false;

        Iterator<Pista> i = listaPista.iterator();
        while (i.hasNext() && !find) {
            p = i.next();
            if (p.getId() == id) {
                i.remove();
                find = true;
            }
        }
    }

    public String pistaSeguent(String id) {
        Pista p = null;
        boolean find = false;

        Iterator<Pista> i = listaPista.iterator();
        while (i.hasNext() && !find) {
            p = i.next();
            if (p.getId() == id) {
                find = true;
            }
        }
        if(find){return p.getIdNext();}
        else return "";
    }

    public void llistarPistes(){
        Pista p;

        Iterator<Pista> i = listaPista.iterator();
        while (i.hasNext()) {
            p = i.next();
          //  Toast.makeText(this, p.getId(),Toast.LENGTH_SHORT).show();
            p.getId();
        }
    }
}
