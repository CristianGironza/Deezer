package com.example.deezer.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.deezer.R;
import com.example.deezer.modelo.PlayList;
import java.util.ArrayList;

public class PlayListAdaptador extends BaseAdapter {

    private ArrayList<PlayList> playLists;

    public PlayListAdaptador(){
        playLists = new ArrayList<PlayList>();
    }

    @Override
    public int getCount() {
        return playLists.size();
    }

    @Override
    public Object getItem(int i) {
        return playLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.play_list,null);
        ImageView imagen = v.findViewById(R.id.play_Iv);
        TextView nombre = v.findViewById(R.id.play_nombre_Tv);
        TextView usuario = v.findViewById(R.id.play_creador_Tv);
        TextView numero = v.findViewById(R.id.play_canciones_Tv);

        final PlayList play = playLists.get(i);
        //imagen.setBackground();
        nombre.setText(play.getTitle());
        usuario.setText(play.getCreador());
        numero.setText(""+play.getNumero());

        return v;
    }

    public void agregarPlay(PlayList play){
        playLists.add(play);
        notifyDataSetChanged();
    }

    public void limpiar(){
        playLists = new ArrayList<PlayList>();
    }
}
