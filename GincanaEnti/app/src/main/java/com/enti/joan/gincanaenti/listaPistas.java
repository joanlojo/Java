package com.enti.joan.gincanaenti;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jlopez on 9/20/2017.
 */

public class listaPistas {
    public static ArrayList<Pista>listaPista=new ArrayList<Pista>();

    public static void addPista(Pista p)
    {
        listaPista.add(p);
    }

    public static Pista obtenerP(int a)
    {
        return listaPista.get(a);
    }

    public static Pista findPista(String id) {
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

    public static void eliminarPista(String id) {
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

    public static String pistaSeguent(String id) {
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

    public static void llistarPistes(){
        Pista p;

        Iterator<Pista> i = listaPista.iterator();
        while (i.hasNext()) {
            p = i.next();
          //  Toast.makeText(this, p.getId(),Toast.LENGTH_SHORT).show();
            p.getId();
        }
    }
    public static int getLength(){
        return listaPista.size();
    }
}
