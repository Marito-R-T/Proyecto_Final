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
        empezarEnemigos();
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
        escoger.setSize(new Dimension(300, 400));
        escoger.setLocationRelativeTo(visual);
        escoger.setResizable(false);
        escoger.add(visual.getPnlVehiculos());
        escoger.setVisible(true);
        //while(escoger.is)
    }

    private void empezarEnemigos() {
        for (int i = 0; i < 3; i++) {
            int referencia = vehiculos[i].getNivel();
            enemigos[1] = new Enemigo(vehiculos[i].getVida() + (10 * referencia), vehiculos[i].getDaño() + (2*referencia), vehiculos[i].getDefensaNeta() + (3*referencia));
        }
        mapa.ingresarEnemigos(enemigos);
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

}
