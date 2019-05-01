/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

/**
 *
 * @author marito
 */
public class Tanque extends Vehiculo {

    public Tanque(int[] porcentajes) {
        this.porcentajes = porcentajes;
        vida = 50 * porcentajes[0];
        daño = 12 * porcentajes[1];
        defensa = 7 * porcentajes[2];
        defensaNeta = vida * (defensa / 100);
    }

    @Override
    public void revisarSubirNivel() {
        if (experiencia >= experienciaTope) {
            super.revisarSubirNivel();
            daño = (10 + 2 * nivel) * porcentajes[1];
            defensa = (6 + (1 * nivel)) * porcentajes[2];
            defensaNeta = vida * (defensa / 100);
        }
    }
}
