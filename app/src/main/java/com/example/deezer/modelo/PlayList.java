package com.example.deezer.modelo;

import java.net.URL;

public class PlayList {

    private int id;
    private Cancion cancionA;
    private String titulo;
    private String creador;
    private int numero;
    private URL imagen;
    private String descripcion;

    public PlayList() {
    }

    public PlayList(int id, Cancion cancionA, String title, String creador, int numero, URL imagen, String descripcion) {
        this.id = id;
        this.cancionA = cancionA;
        this.titulo = title;
        this.creador = creador;
        this.numero = numero;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
