/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Ventanas.VisualJuego;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class Juego implements Runnable {

    private boolean segano = false, seperdio = false;
    private Vehiculo[] vehiculos;
    private VisualJuego visual;
    private Vehiculo enjuego;
    private Enemigo[] enemigos;
    private Mapa mapa;

    public Juego(Vehiculo[] vehiculos, VisualJuego visual) {
        this.vehiculos = vehiculos;
        this.visual = visual;
        Random numero = new Random();
        enemigos = new Enemigo[numero.nextInt(3) + 3];
    }

    @Override
    public void run() {
        try {
            empezarelJuego();
            while (!segano && !seperdio) {
                turnopropio();
                Thread.sleep(100);
                turnoenemigo();
            }
        } catch (Exception e) {

        }
    }

    private void turnopropio() {
    }

    private void turnoenemigo() {
    }

    JDialog escoger = new JDialog(visual, true);
    JPanel panel = new JPanel();

    private void empezarelJuego() {
        /*escoger.setSize(new Dimension(300, 400));
        escoger.setLocationRelativeTo(visual);
        escoger.setResizable(false);
        escoger.add(visual.getPnlVehiculos());
        escoger.setVisible(true);*/
        mapa.ingresarEnemigos(enemigos);
        elegirVehiculo();
        mapa.ingresarprimerVehiculo(enjuego);
        //while(escoger.is)
    }

    public void empezarEnemigos() {
        Random numerorandom = new Random();
        for (int i = 0; i < enemigos.length; i++) {
            int u = numerorandom.nextInt(3);
            int referencia = vehiculos[u].getNivel();
            enemigos[i] = new Enemigo(vehiculos[u].getVida() + (10 * referencia), vehiculos[u].getDaño() + (2*referencia), vehiculos[u].getDefensaNeta() + (3*referencia));
        }
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    private void elegirVehiculo() {
        Random numerorandom = new Random();
        int randomvehiculo = numerorandom.nextInt(vehiculos.length);
        enjuego = vehiculos[randomvehiculo];
    }

}
