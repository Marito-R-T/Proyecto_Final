/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.listado;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;

/**
 *
 * @author marito
 */
public class Garage {

    private final Listado<Vehiculo> listado;
    private Vehiculo[] fecha, kills, nivel, muertes, nombre, estado;

    public Garage(Listado listado) {
        this.listado = listado;
    }

    public Vehiculo[] ordenarPorFecha() { // ordenar por fecha de cracion
        fecha = new Vehiculo[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            Vehiculo referencia = listado.devolver(i + 1);
            fecha[i] = referencia;
        }
        return fecha;
    }

    public Vehiculo[] ordenarPorKills() { // ordenar del menor al mayor por kills
        kills = new Vehiculo[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            kills[i] = listado.devolver(i + 1);
        }
        for (int i = 0; i < kills.length; i++) {
            int x = i;
            Vehiculo referencia = kills[i];
            while ((x > 0) && (kills[x - 1].getKills() > referencia.getKills())) {
                kills[x] = kills[x - 1];
                x--;
            }
            kills[x] = referencia;
        }
        return kills;
    }

    public Vehiculo[] ordenarPorNivel() { // ordenar del menor al mayor por nivel
        nivel = new Vehiculo[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            nivel[i] = listado.devolver(i + 1);
        }
        for (int i = 0; i < nivel.length; i++) {
            int x = i;
            Vehiculo referencia = nivel[i];
            while ((x > 0) && (nivel[x - 1].getNivel() > referencia.getNivel())) {
                nivel[x] = nivel[x - 1];
                x--;
            }
            nivel[x] = referencia;
        }
        return nivel;
    }

    public Vehiculo[] ordenarPorMuertes() { // ordenar del menor al mayor por muertes 
        muertes = new Vehiculo[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            muertes[i] = listado.devolver(i + 1);
        }
        for (int i = 0; i < muertes.length; i++) {
            int x = i;
            Vehiculo referencia = muertes[i];
            while ((x > 0) && (muertes[x - 1].getMuertes() > referencia.getMuertes())) {
                muertes[x] = muertes[x - 1];
                x--;
            }
            muertes[x] = referencia;
        }
        return muertes;
    }

    public Vehiculo[] ordenarPorNombre() { // ordenar por orden alfabetico
        nombre = new Vehiculo[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            nombre[i] = listado.devolver(i + 1);
        }
        for (int i = 0; i < nombre.length; i++) {
            int x = i;
            Vehiculo referencia = nombre[i];
            while((x > 0) && (nombre[x-1].getNombre().compareToIgnoreCase(referencia.getNombre()) > 0)){
                nombre[x] = nombre[x-1];
                x--;
            }
            /*while ((x > 0) && (nombre[x - 1].getPrimerLetra() > referencia.getPrimerLetra())) {
                nombre[x] = nombre[x - 1];
                x--;
            }*/
            nombre[x] = referencia;
        }
        return nombre;
    }

    public Vehiculo[] ordenarPorEstado() { // primero activos despues destruidos
        estado = new Vehiculo[listado.getContador()];
        int x = 0, y = listado.getContador() - 1;
        for (int u = 0; u < listado.getContador(); u++) {
            Vehiculo referencia = listado.devolver(u + 1);
            if (referencia.isEstaActivo()) {
                estado[x] = referencia;
                x++;
            } else {
                estado[y] = referencia;
                y--;
            }

        }
        return estado;
    }

}
