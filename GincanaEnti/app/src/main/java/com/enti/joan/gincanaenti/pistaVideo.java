package com.enti.joan.gincanaenti;

/**
 * Created by jlopez on 12/13/2017.
 */

public class pistaVideo extends Pista {
    private String path;
    private String tipo;

    public pistaVideo(){
        super("","","",0,0);
        this.path = "";
        this.tipo = "Video";
    }
    public pistaVideo(String id, String idNext, String descripcion, double latitud, double longitud, String path){
        super(id, idNext, descripcion, latitud, longitud);
        this.path = path;
        this.tipo = "Video";
    }

    public void setPath(String path){this.path = path;}
    public String getPath(){return(this.path);}

    public int getTipo(){return R.mipmap.ic_video;}

}

