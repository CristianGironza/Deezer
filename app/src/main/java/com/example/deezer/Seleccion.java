package com.example.deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Seleccion extends AppCompatActivity {

    private ImageButton canciones;
    private ImageView imagen;
    private TextView nombre;
    private TextView artista;
    private TextView album;
    private TextView duracion;
    private Button escuchar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        canciones = findViewById(R.id.volver_Canciones);
        imagen = findViewById(R.id.cancionA_Iv);
        nombre = findViewById(R.id.cancionA_nombre_Tv);
        artista = findViewById(R.id.cancionA_artista_Tv);
        album = findViewById(R.id.cancion_album_Tv);
        duracion = findViewById(R.id.cancion_duracion_Tv);
        escuchar = findViewById(R.id.escuchar_B);

        canciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(Seleccion.this,Canciones.class);
                startActivity(atras);
                finish();
            }
        });

        escuchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent escuchar = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(escuchar);
            }
        });
    }
}
