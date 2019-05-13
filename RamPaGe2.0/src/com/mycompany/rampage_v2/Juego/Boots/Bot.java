/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Boots;

import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Bot extends JLabel implements Runnable, MouseListener {

    private final ImageIcon imagen;
    private Jugador dueño;
    private Terreno terreno;
    private final float daño;
    private int turnos;
    private Mapa enjuego;
    private boolean activo, sepuede;
    private int No;
    private float porcentaje;

    public Bot(float daño) {
        turnos = 0;
        porcentaje = daño;
        this.daño = 5 * (1 + (daño/100));
        this.setSize(200, 200);
        imagen = new ImageIcon(getClass().getResource("/Imagenes/bot.png"));
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST)));
    }

    public int getTurnos() {
        return turnos;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void atacar() {
        turnos++;
        Object[] objetos = enjuego.getComponents();
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i] instanceof Terreno) {
                Terreno ref = ((Terreno) objetos[i]);
                Integer filas = ref.getFilas() - terreno.getFilas();
                Integer columnas = ref.getColumnas() - terreno.getColumnas();
                if ((filas < 4 && filas > -4) && (columnas < 4 && columnas > -4)) {
                    if (ref.getEnemigo() != null) {
                        ref.getEnemigo().dañadoporBot(this.daño, dueño);
                    }
                }
            }
        }
        enjuego.repaint();
    }

    public void explotar() {
        JOptionPane.showMessageDialog(null, "Tu bot ha explotado!!!");
        Object[] objetos = enjuego.getComponents();
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i] instanceof Terreno) {
                Terreno ref = ((Terreno) objetos[i]);
                Integer filas = ref.getFilas() - terreno.getFilas();
                Integer columnas = ref.getColumnas() - terreno.getColumnas();
                if ((filas < 3 && filas > -3) && (columnas < 3 && columnas > -3)) {
                    if (ref.getEnemigo() != null) {
                        ref.getEnemigo().dañadoporBot(40, dueño);
                    } else if (ref.getVehiculo() != null) {
                        ref.getVehiculo().dañadoporBot(40);
                    }
                }
            }
        }
        enjuego.repaint();
    }
    private boolean empezo = false;

    public boolean isSepuede() {
        return sepuede;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (enjuego.getComponentAt(e.getPoint()) instanceof Terreno) {
            terreno = (Terreno) enjuego.getComponentAt(e.getPoint());
            enjuego.removeMouseListener(this);
        }
        if (enjuego.getComponentAt(e.getPoint()) instanceof Terreno && sepuedeingresar()) {
            this.setLocation(terreno.getLocation());
            Terreno ref = (Terreno) enjuego.getComponentAt(e.getPoint());
            enjuego.remove(ref);
            this.setSize(ref.getSize());
            enjuego.add(this);
            enjuego.add(ref);
            enjuego.removeMouseListener(this);
            empezo = true;
            enjuego.repaint();
            sepuede = true;
        } else {
            empezo = true;
            sepuede = false;
        }
    }

    public void setSepuede(boolean sepuede) {
        this.sepuede = sepuede;
    }

    public void setEmpezo(boolean empezo) {
        this.empezo = empezo;
    }

    public boolean isEmpezo() {
        return empezo;
    }

    public void setEnjuego(Mapa enjuego) {
        this.enjuego = enjuego;
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    @Override
    public void run() {
        /*try {
         for (int j = 0; j < 2; j++) {
         atacar();
         Thread.sleep(8000);
         }
         explotar();
         } catch (InterruptedException ex) {
         Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
         }*/

    }

    public boolean sepuedeingresar() {
        Object[] objetos = enjuego.getComponents();
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i] instanceof Vehiculo) {
                Terreno ref = ((Vehiculo) objetos[i]).getPosicion();
                Integer filas = ref.getFilas() - terreno.getFilas();
                Integer columnas = ref.getColumnas() - terreno.getColumnas();
                if ((filas < 3 && filas > -3) && (columnas < 3 && columnas > -3)) {
                    return false;
                }
            }
        }
        return true;
    }

}
