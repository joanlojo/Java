package com.enti.joan.gincanaenti;

/**
 * Created by sobre on 20/09/2017.
 */

public abstract class Pista {
    private String id;
    private String idNext;
    private String descripcion;
    private Coord position;
    private double latitud, longitud;
    private String tipo;


    public Pista(){
        this.id = "";
        this.idNext = "";
        this.descripcion = "";
        this.tipo = "";
    }
    public  Pista(String id, String idNext, String descripcion, double latitud, double longitud){
        this.id = id;
        this.idNext = idNext;
        this.descripcion = descripcion;
        this.position = new Coord(latitud, longitud);
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public void setId(String id){this.id = id;}
    public void setIdNext(String idNext){this.idNext = idNext;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    public void setPosition(double latitud, double longitud){
        position.setLatitud(latitud);
        position.setLongitud(longitud);
    }

    public String getId(){return(this.id);}
    public String getIdNext(){return(this.idNext);}
    public String getDescripcion(){return(this.descripcion);}
    public Coord getPosition(){
        return(this.position);
    }
    public double getLatitud(){return(this.latitud);}
    public double getLongitud(){return(this.longitud);}

    public abstract int getTipo();

}
