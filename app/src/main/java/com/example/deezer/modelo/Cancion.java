package com.example.deezer.modelo;

import android.util.Log;

import com.example.deezer.control.HTTPSWebUtilDomi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URL;
import java.util.Date;

public class Cancion {

    private String id;
    private String nombre;
    private String artista;
    private String fecha;
    private URL imagen;
    private String album;
    private String duracion;
    private String link;

    public Cancion() {
    }

    public Cancion(String id, String nombre, String artista, String fecha, URL imagen, String album, String duracion, String link) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.fecha = fecha;
        this.imagen = imagen;
        this.album = album;
        this.duracion = duracion;
        this.link = link;
    }

    public static Cancion getCancionesFromJson(JsonObject jsonObject) {
        String id = jsonObject.get("id").getAsString();
        String nombre = jsonObject.get("title").getAsString();
        JsonObject artista = jsonObject.get("artist").getAsJsonObject();
        String conpositor = artista.get("name").getAsString();
        //Falta Fecha

        //Falta Imagen

        JsonObject album = jsonObject.get("album").getAsJsonObject();
        String pertenece = album.get("title").getAsString();
        String duracion = jsonObject.get("duration").getAsString();
        String Slink = jsonObject.get("link").getAsString();
        URL imagen= null;
        Cancion cargando = new Cancion(id,nombre, conpositor, null, imagen, pertenece, duracion, Slink);
        return cargando;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public URL getImagen() {
        return imagen;
    }

    public void setImagen(URL imagen) {
        this.imagen = imagen;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
