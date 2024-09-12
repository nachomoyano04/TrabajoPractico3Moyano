package com.example.trabajopractico3moyano.modelo;

import java.io.Serializable;

public class Nota implements Serializable {
    private String titulo;
    private String nota;

    public Nota(){}
    public Nota(String titulo, String nota){
        this.titulo = titulo;
        this.nota = nota;
    }

    public String getTitulo(){
        return titulo;
    }
    public String getNota(){
        return nota;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setNota(String nota){
        this.nota = nota;
    }
}
