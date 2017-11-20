package com.enti.joan.gincanaenti;

/**
 * Created by sobre on 20/09/2017.
 */

public class pistaText extends Pista {
    private String des;
    private String tipo;

    public pistaText(){
        super("","","",0,0);
        this.des = "";
        this.tipo = "Texto";
    }
    public pistaText(String id, String idNext, String descripcion, double latitud, double longitud, String des){
        super(id, idNext, descripcion, latitud, longitud);
        this.des = des;
        this.tipo = "Texto";
    }

    public void setDes(String des){this.des = des;}
    public String getDes(){return(this.des);}


    public int getTipo(){return R.mipmap.ic_texto;}
}
