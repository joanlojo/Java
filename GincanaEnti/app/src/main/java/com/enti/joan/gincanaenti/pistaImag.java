package com.enti.joan.gincanaenti;

/**
 * Created by sobre on 20/09/2017.
 */

public class pistaImag extends Pista {
    private String path;
    private String tipo;

    public pistaImag(){
        super("","","",0,0);
        this.path = "";
        this.tipo = "Imagen";
    }
    public pistaImag(String id, String idNext, String descripcion, double latitud, double longitud, String path){
        super(id, idNext, descripcion, latitud, longitud);
        this.path = path;
        this.tipo = "Imagen";
    }

    public void setPath(String path){this.path = path;}
    public String getPath(){return(this.path);}

    public String getTipo(){return this.tipo;}

}
