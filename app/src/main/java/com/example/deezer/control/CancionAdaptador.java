package com.example.deezer.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezer.R;
import com.example.deezer.modelo.Cancion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CancionAdaptador extends BaseAdapter {

    private ArrayList<Cancion> canciones;


    public CancionAdaptador(){
        canciones = new ArrayList<Cancion>();

    }

    @Override
    public int getCount() {
        return canciones.size();
    }

    @Override
    public Object getItem(int i) {
        return canciones.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.canciones_list,null);
        ImageView imagen = v.findViewById(R.id.cancion_Iv);
        TextView nombre = v.findViewById(R.id.cancion_nombre_Tv);
        TextView artista = v.findViewById(R.id.cancion_artista_Tv);
        TextView fecha = v.findViewById(R.id.cancion_fecha);

        final Cancion cancion = canciones.get(i);
        //imagen.setBackground();
        nombre.setText(cancion.getNombre());
        artista.setText(cancion.getArtista());
        fecha.setText(cancion.getFecha());
        return v;
    }

    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
        notifyDataSetChanged();
    }

    public void limpiar() {
        canciones =new ArrayList<Cancion>();
    }
}
