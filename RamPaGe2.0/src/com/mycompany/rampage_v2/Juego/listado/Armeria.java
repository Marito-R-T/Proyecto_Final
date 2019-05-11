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
public class Armeria {

    private final Listado<Arma> listado;
    private Arma[] fecha, nombre;

    public Armeria(Listado listado) {
        this.listado = listado;
    }

    public Arma[] ordenarPorFecha() {
        fecha = new Arma[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            Arma referencia = listado.devolver(i + 1);
            fecha[i] = referencia;
        }
        return fecha;
    }

    public Arma[] ordenarPorNombre() {
        nombre = new Arma[listado.getContador()];
        for (int i = 0; i < listado.getContador(); i++) {
            nombre[i] = listado.devolver(i+1);
        }
        for (int i = 0; i < nombre.length; i++) {
            int x = i;
            Arma referencia = nombre[i];
            while((x > 0) && (nombre[x - 1].getPrimerLetra() > referencia.getPrimerLetra())){
                nombre[x] = nombre[x-1];
                x--;
            }
            nombre[x] = referencia;
        }
        return nombre;
    }


}
