/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Armas.Arma;

/**
 *
 * @author marito
 */
public abstract class Vehiculo {

    private Vehiculo a, p;
    protected int nivel = 1;
    protected int experiencia = 0;
    protected int experienciaTope = 200;
    protected int No;
    protected float vida;
    protected float daño;
    protected float defensa;
    protected float defensaNeta;
    protected float[] porcentajes;
    private Arma arma;

    public Vehiculo getAnterior() {
        return a;
    }

    public void setAnterior(Vehiculo a) {
        this.a = a;
    }

    public Vehiculo getPosterior() {
        return p;
    }

    public void setPosterior(Vehiculo p) {
        this.p = p;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public void revisarSubirNivel() {
        experienciaTope += 100 * (nivel++);
        vida = (50 * nivel)*porcentajes[0];
    }
}
