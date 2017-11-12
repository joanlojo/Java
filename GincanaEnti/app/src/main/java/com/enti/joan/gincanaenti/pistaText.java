package com.enti.joan.gincanaenti;

/**
 * Created by sobre on 20/09/2017.
 */

public class pistaText extends Pista {
    private String des;

    public pistaText(){
        super("","","",0,0);
        this.des = "";
    }
    public pistaText(String id, String idNext, String descripcion, double latitud, double longitud, String des){
        super(id, idNext, descripcion, latitud, longitud);
        this.des = des;
    }

    public void setDes(String des){this.des = des;}
    public String getDes(){return(this.des);}

    public void printInfo(){
        System.out.println("Tipo de pista: Audio!");
        System.out.println("Id: "+ getId());
        System.out.println("Siguiente Id: "+ getIdNext());
        System.out.println("Descripcion: "  + getDescripcion());
       // System.out.println("Latitud: "+ getLatitud());
       // System.out.println("Longitud: "+ getLongitud());
        System.out.println("Pista: "+ getDes());
    }
}
