/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.listado;

import com.mycompany.rampage_v2.Juego.Jugador;

/**
 *
 * @author marito
 */
public class Identificador {
    private final Listado listado;
    private Jugador[] fecha, kills, nivel, muertes, nombre;

    public Identificador(Listado listado) {
        this.listado = listado;
    }

    public Jugador[] ordenarPorFecha() { // ordenar por fecha de cracion
        fecha = new Jugador[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            Jugador referencia = (Jugador) listado.devolver(i + 1);
            fecha[i] = referencia;
        }
        return fecha;
    }

    public Jugador[] ordenarPorKills() { // ordenar del menor al mayor por kills
        kills = new Jugador[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            kills[i] = (Jugador) listado.devolver(i + 1);
        }
        for (int i = 0; i < kills.length; i++) {
            int x = i;
            Jugador referencia = kills[i];
            while ((x > 0) && (kills[x - 1].getKills() > referencia.getKills())) {
                kills[x] = kills[x - 1];
                x--;
            }
            kills[x] = referencia;
        }
        return kills;
    }

    public Jugador[] ordenarPorNivel() { // ordenar del menor al mayor por nivel
        nivel = new Jugador[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            nivel[i] = (Jugador) listado.devolver(i + 1);
        }
        for (int i = 0; i < nivel.length; i++) {
            int x = i;
            Jugador referencia = nivel[i];
            while ((x > 0) && (nivel[x - 1].getNivel() > referencia.getNivel())) {
                nivel[x] = nivel[x - 1];
                x--;
            }
            nivel[x] = referencia;
        }
        return nivel;
    }

    public Jugador[] ordenarPorMuertes() { // ordenar del menor al mayor por muertes 
        muertes = new Jugador[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            muertes[i] = (Jugador) listado.devolver(i + 1);
        }
        for (int i = 0; i < muertes.length; i++) {
            int x = i;
            Jugador referencia = muertes[i];
            while ((x > 0) && (muertes[x - 1].getMuertes() > referencia.getMuertes())) {
                muertes[x] = muertes[x - 1];
                x--;
            }
            muertes[x] = referencia;
        }
        return muertes;
    }

    public Jugador[] ordenarPorNombre() { // ordenar por orden alfabetico
        nombre = new Jugador[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            nombre[i] = (Jugador) listado.devolver(i + 1);
        }
        for (int i = 0; i < nombre.length; i++) {
            int x = i;
            Jugador referencia = nombre[i];
            while ((x > 0) && (nombre[x - 1].getPrimerLetra() > referencia.getPrimerLetra())) {
                nombre[x] = nombre[x - 1];
                x--;
            }
            nombre[x] = referencia;
        }
        return nombre;
    }

    public void ingresarListado() {
    }
}
