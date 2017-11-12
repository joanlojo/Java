package com.enti.joan.gincanaenti;

/**
 * Created by jlopez on 9/20/2017.
 */

public  class Coord {
    private double latitud;
    private double longitud;

    public Coord(){
        this.latitud = 0;
        this.longitud = 0;
    }
    public Coord(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public void setLatitud(double latitud){this.latitud = latitud;}
    public void setLongitud(double longitud){this.longitud = longitud;}
    public double getLatitud(){return(this.latitud);}
    public  double getLongitud(){return (this.longitud);}

}
