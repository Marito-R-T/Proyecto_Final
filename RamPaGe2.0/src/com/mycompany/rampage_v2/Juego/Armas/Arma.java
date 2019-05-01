/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Armas;

/**
 *
 * @author marito
 */
public class Arma {
    
    private Arma a, p;
    private int No;
    private String nombre;

    public Arma getAnterior() {
        return a;
    }

    public void setAnterior(Arma a) {
        this.a = a;
    }

    public Arma getPosterior() {
        return p;
    }

    public void setPosterior(Arma p) {
        this.p = p;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public char getPrimerLetra(){
        char[] arreglo = nombre.toCharArray();
        return arreglo[0];
    }
}
