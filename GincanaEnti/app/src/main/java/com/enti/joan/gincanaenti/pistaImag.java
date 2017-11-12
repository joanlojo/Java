package com.enti.joan.gincanaenti;

/**
 * Created by sobre on 20/09/2017.
 */

public class pistaImag extends Pista {
    private String path;

    public pistaImag(){
        super("","","",0,0);
        this.path = "";
    }
    public pistaImag(String id, String idNext, String descripcion, double latitud, double longitud, String path){
        super(id, idNext, descripcion, latitud, longitud);
        this.path = path;
    }

    public void setPath(String path){this.path = path;}
    public String getPath(){return(this.path);}

    public void printInfo(){
        System.out.println("Tipo de pista: Audio!");
        System.out.println("Id: "+ getId());
        System.out.println("Siguiente Id: "+ getIdNext());
        System.out.println("Descripcion: "  + getDescripcion());
       // System.out.println("Latitud: "+ getLatitud());
       // System.out.println("Longitud: "+ getLongitud());
        System.out.println("El archivo esta en: "+ getPath());
    }

}
