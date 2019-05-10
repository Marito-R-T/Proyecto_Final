/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marito
 */
public class Bibliotecario {

    private FileOutputStream salida;
    private ObjectOutputStream guardar;
    private FileInputStream entrada;
    private ObjectInputStream lectura;

    public Bibliotecario() {
    }

    public void guardarJugadores(Jugador jugador) {
        try {
            File archivo = new File(Integer.toString(jugador.getNO()) + ".rpg");
            this.salida = new FileOutputStream(archivo);
            this.guardar = new ObjectOutputStream(this.salida);
            guardar.writeObject(jugador);
            guardar.close();
        } catch (IOException ex) {
        }

    }

    public void recuperarJugadores(Listado<Jugador> jugadores) {
        try {
            int x = 1;
            File archivo = new File(Integer.toString(x) + ".rpg");
            //JOptionPane.showMessageDialog(null, archivo.exists());
            while (archivo.exists()) {
                this.entrada = new FileInputStream(Integer.toString(x) + ".rpg");
                this.lectura = new ObjectInputStream(new FileInputStream(Integer.toString(x) + ".rpg"));
                if (jugadores.getContador() == 0) {
                    Jugador nuevo = (Jugador) lectura.readObject();
                    lectura.close();
                    jugadores.agregar(nuevo);
                } else {
                    Jugador siguiente = (Jugador) lectura.readObject();
                    siguiente.setAnterior(jugadores.getUltimo());
                    jugadores.getUltimo().setPosterior(siguiente);
                    jugadores.agregar(siguiente);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public void devolverJugador(Jugador jugador, int no) {
        try {
            File archivo = new File(Integer.toString(no) + ".rpg");
            this.entrada = new FileInputStream(archivo);
            this.lectura = new ObjectInputStream(this.entrada);
            Jugador a = jugador.getAnterior();
            Jugador p = jugador.getPosterior();
            jugador = (Jugador) this.lectura.readObject();
            lectura.close();
            jugador.setAnterior(a);
            jugador.setPosterior(p);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
