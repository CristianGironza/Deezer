package com.example.deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deezer.control.CancionAdaptador;
import com.example.deezer.modelo.Cancion;
import com.example.deezer.modelo.Deezer;

import java.util.Date;

public class Canciones extends AppCompatActivity {

    private ImageButton main;
    private ImageView imagen;
    private TextView nombre;
    private TextView descripcion;
    private TextView numero;
    private ListView seleccion;
    private CancionAdaptador adaptador;
    private Deezer deezer = Deezer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);

        main = findViewById(R.id.volver_Main);
        imagen = findViewById(R.id.playA_Iv);
        nombre = findViewById(R.id.playA_nombre_Tv);
        descripcion = findViewById(R.id.play_descripcion_Tv);
        numero = findViewById(R.id.playA_canciones_Tv);
        seleccion = findViewById(R.id.seleccionar_Lv);
        adaptador = new CancionAdaptador();
        seleccion.setAdapter(adaptador);
        nombre.setText(deezer.getPlayA().getTitle());
        descripcion.setText((deezer.getPlayA().getDescripcion()));
        numero.setText(""+deezer.getPlayA().getNumero());

        Cancion c = new Cancion(1, "La Viuda", "Mago de OZ", new Date(119,3,20,20,0,0), null, "GAIA", 10, null);
        adaptador.agregarCancion(c);
        c = new Cancion(1, "La Viuda", "Mago de OZ", new Date(119,3,20,20,0,0), null, "GAIA", 10, null);
        adaptador.agregarCancion(c);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(Canciones.this,MainActivity.class);
                startActivity(atras);
                finish();
            }
        });

        seleccion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent continuar = new Intent(Canciones.this,Seleccion.class);
                startActivity(continuar);
                finish();
            }
        });
    }
}
