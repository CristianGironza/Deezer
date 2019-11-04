package com.example.deezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.deezer.control.HTTPSWebUtilDomi;
import com.example.deezer.control.PlayListAdaptador;
import com.example.deezer.modelo.PlayList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageButton cerrar;
    private EditText buscarEt;
    private ImageButton buscarIb;
    private ListView buscarLv;
    private PlayListAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cerrar = findViewById(R.id.cerrar_Ib);
        buscarEt = findViewById(R.id.buscar_Et);
        buscarIb = findViewById(R.id.buscar_B);
        buscarLv = findViewById(R.id.buscar_Lv);
        adaptador = new PlayListAdaptador();
        buscarLv.setAdapter(adaptador);

        PlayList p = new PlayList(1,null,"Rock","Cris",8,null,"Chupa");
        adaptador.agregarPlay(p);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        buscarIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
                            String url = "https://api.deezer.com/search/playlist?q="+buscarEt.getText();
                            String json = util.GETrequest(url);
                            JsonParser jp = new JsonParser();

                            Gson g = new Gson();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        buscarLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent continuar = new Intent(MainActivity.this,Canciones.class);
                startActivity(continuar);
                finish();
            }
        });
    }
}
