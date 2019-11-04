package com.example.deezer.modelo;

import java.util.ArrayList;

public class Deezer {

    private PlayList playA;
    private static Deezer unico;
    private ArrayList<PlayList> listas;

    public Deezer() {
        listas = new ArrayList<PlayList>();
    }

    public static Deezer getInstance(){
        if(unico == null){
            unico = new Deezer();
        }
        return unico;
    }

    public PlayList getPlayA() {
        return playA;
    }

    public void setPlayA(PlayList playA) {
        this.playA = playA;
    }

    public ArrayList<PlayList> getListas() {
        return listas;
    }

    public void setListas(ArrayList<PlayList> listas) {
        this.listas = listas;
    }
}
