/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.listado;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;

/**
 *
 * @author marito
 * @param <T>
 *
 */
public class Listado<T> {

    private T primero;
    private T ultimo;
    private int contador;

    public Listado() {
        contador = 0;
    }

    public void agregar(T nuevo) {
        if (contador == 0) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo = nuevo;
        }
        contador++;
        /*if (contador == 0) {
         primero = nuevo;
         ultimo = nuevo;
         } else {
         if (primero instanceof Jugador) {
         ((Jugador) nuevo).setAnterior((Jugador) ultimo);
         //((Jugador)nuevo).setNo(contador + 1);
         ((Jugador) ultimo).setPosterior((Jugador) nuevo);
         } else if (primero instanceof Arma) {
         ((Arma) nuevo).setAnterior((Arma) ultimo);
         //((Jugador)nuevo).setNo(contador + 1);
         ((Arma) ultimo).setPosterior((Arma) nuevo);
         } else if (primero instanceof Mapa) {
         ((Mapa) nuevo).setAnterior((Mapa) ultimo);
         //((Jugador)nuevo).setNo(contador + 1);
         ((Mapa) ultimo).setPosterior((Mapa) nuevo);
         } else if (primero instanceof Vehiculo) {
         ((Vehiculo) nuevo).setAnterior((Vehiculo) ultimo);
         //((Jugador)nuevo).setNo(contador + 1);
         ((Vehiculo) ultimo).setPosterior((Vehiculo) nuevo);

         }
         ultimo = nuevo;
         contador++;
         }*/
    }

    public T devolver(int i) {
        T referencia = primero;
        if (contador > 1) {
            for (int u = 1; u < i; u++) {
                if (primero instanceof Jugador) {
                    referencia = (T) ((Jugador) referencia).getPosterior();
                } else if (primero instanceof Arma) {
                    referencia = (T) ((Arma) referencia).getPosterior();
                } else if (primero instanceof Mapa) {
                    referencia = (T) ((Mapa) referencia).getPosterior();
                } else if (primero instanceof Vehiculo) {
                    referencia = (T) ((Vehiculo) referencia).getPosterior();
                }
            }
        }
        return referencia;
    }

    public void eliminar(int i) {
        T referencia = primero;
        for (int u = 1; u < i; i++) {
            if (primero instanceof Jugador) {
                referencia = (T) ((Jugador) referencia).getPosterior();
            } else if (primero instanceof Arma) {
                referencia = (T) ((Arma) referencia).getPosterior();
            } else if (primero instanceof Mapa) {
                referencia = (T) ((Mapa) referencia).getPosterior();
            } else if (primero instanceof Vehiculo) {
                referencia = (T) ((Vehiculo) referencia).getPosterior();// seguir aqui eliminando los objetos.
            }
        }
        contador--;
    }

    public T getUltimo() {
        return ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void eliminarUltimo() {
        if (primero instanceof Jugador) {
            ultimo = (T) ((Jugador) ultimo).getAnterior();
            ((Jugador) ultimo).setPosterior(null);
        } else if (primero instanceof Arma) {
            ultimo = (T) ((Arma) ultimo).getAnterior();
            ((Arma) ultimo).setPosterior(null);
        } else if (primero instanceof Mapa) {
            ultimo = (T) ((Mapa) ultimo).getAnterior();
            ((Mapa) ultimo).setPosterior(null);
        } else if (primero instanceof Vehiculo) {
            ultimo = (T) ((Vehiculo) ultimo).getAnterior();// seguir aqui eliminando los objetos.
            ((Vehiculo) ultimo).setPosterior(null);
        }
    }

    public T getPrimero() {
        return primero;
    }
    
}
