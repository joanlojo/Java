package com.enti.joan.gincanaenti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sobre on 05/11/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    protected View.OnClickListener onClickListener;

    protected ArrayList<String> listaVersiones;    //Versions a mostrar

    protected LayoutInflater inflador;             //Crea Layouts a partir de l'XML list_item

    protected Context contexto;                    //Necessari per l'inflater





    public Adaptador(Context _contexto, ArrayList<String> _listaVersiones) {

        this.contexto = _contexto;
        this.listaVersiones = _listaVersiones;

//TO DO: assignar la llista de versions a la propietat

        //ens guardem una referència a la llista d'strings

//END TO DO



        inflador = (LayoutInflater) contexto

                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }





    //Creem el ViewHolder, amb els elements que cal mostrar

    public static class ViewHolder extends RecyclerView.ViewHolder {



        //Posem com a propietats tots els views que conté cada ítem de la llista

        // (en aquest cas només un TextView per a guardar el nom de la versió

        public TextView nombreVersion;



        public ViewHolder(View itemView) {

            super(itemView);

            //TO DO: assignar a la propietat nomVersió el TextView que s'ha especificat al layout amb el seu ID
            this.nombreVersion.findViewById(R.id.nombreVersion);//???

            //END TO DO



        }

    }





    //Mètode obligatori que genera un ViewHolder a partir de l'id de l'XML list_item

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.lista_items, null);
        v.setOnClickListener(onClickListener);

        return new ViewHolder(v);

    }
    //metodo para detectar el lcick sobre un elemento de la lista
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    // Mètode obligatori que ens permet especificar què posar als views de cada item

    @Override

    public void onBindViewHolder(ViewHolder holder, int posicio) {

        holder.nombreVersion.setText(listaVersiones.get(posicio));

    }



    //Mètode obligatori que retorna el número d'elements total de la llista

    @Override public int getItemCount() {

//TO DO: retornar el número d'elements de llistaVersions


        return  0;
//END TO DO

    }

}