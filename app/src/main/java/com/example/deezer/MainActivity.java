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
import com.example.deezer.modelo.Deezer;
import com.example.deezer.modelo.PlayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton cerrar;
    private EditText buscarEt;
    private ImageButton buscarIb;
    private ListView buscarLv;
    private PlayListAdaptador adaptador;
    private Deezer deezer = Deezer.getInstance();

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

        ArrayList<PlayList> listas = deezer.getListas();
        for(int i =0; i<listas.size();i++){
            adaptador.agregarPlay(listas.get(i));
        }

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
                            adaptador.limpiar();
                            deezer.setListas(new ArrayList<PlayList>());
                            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
                            String url = "https://api.deezer.com/search/playlist?q="+buscarEt.getText();
                            String json = util.GETrequest(url);
                            JsonObject jo = new JsonParser().parse(json).getAsJsonObject();
                            JsonArray data = jo.get("data").getAsJsonArray();
                            for (int i = 0; i < data.size(); i++){
                                final PlayList playList = PlayList.getPlayListFromJson(data.get(i).getAsJsonObject());
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        adaptador.agregarPlay(playList);
                                        deezer.getListas().add(playList);
                                    }
                                });
                            }
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
                final PlayList actual = (PlayList)adapterView.getItemAtPosition(i);
                deezer.setPlayA(actual);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
                        String url = "https://api.deezer.com/search/playlist?q="+deezer.getPlayA().getId();
                        String json = util.GETrequest(url);
                        JsonObject jo = new JsonParser().parse(json).getAsJsonObject();
                        String descripcion =jo.get("description").getAsString();
                            Log.e(">>>>>>>>",descripcion);
                        deezer.getPlayA().setDescripcion(descripcion);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                Intent continuar = new Intent(MainActivity.this,Canciones.class);
                startActivity(continuar);
                finish();
            }
        });
    }
}
