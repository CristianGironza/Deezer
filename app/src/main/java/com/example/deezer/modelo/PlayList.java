package com.example.deezer.modelo;

import android.util.Log;

import com.google.gson.JsonObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PlayList {

    private String id;
    private Cancion cancionA;
    private String titulo;
    private String creador;
    private int numero;
    private URL imagen;
    private String descripcion;
    private ArrayList<Cancion> canciones;
    private Boolean cambio;

    public PlayList() {
    }

    public PlayList(String id, Cancion cancionA, String title, String creador, int numero, URL imagen, String descripcion) {
        this.id = id;
        this.cancionA = cancionA;
        this.titulo = title;
        this.creador = creador;
        this.numero = numero;
        this.imagen = imagen;
        this.descripcion = descripcion;
        canciones = new ArrayList<Cancion>();
        cambio=false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cancion getCancionA() {
        return cancionA;
    }

    public void setCancionA(Cancion cancionA) {
        this.cancionA = cancionA;
    }

    public String getTitle() {
        return titulo;
    }

    public void setTitle(String title) {
        this.titulo = title;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public URL getImagen() {
        return imagen;
    }

    public void setImagen(URL imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getCambio() {
        return cambio;
    }

    public void setCambio(Boolean cambio) {
        this.cambio = cambio;
    }

    public static PlayList getPlayListFromJson(JsonObject jsonObject){
        String id  = jsonObject.get("id").getAsString();
        String title  = jsonObject.get("title").getAsString();
        JsonObject user  = jsonObject.get("user").getAsJsonObject();
        String creador  = user.get("name").getAsString();
        int numero  = jsonObject.get("nb_tracks").getAsInt();

        String stringUrl  = jsonObject.get("picture").getAsString();
        URL url = null;
        try{
            url  = new URL(stringUrl);
        } catch (MalformedURLException ex){

        }

        PlayList playlist = new PlayList(id, null, title, creador, numero, url, "");
        return playlist;
    }
}
