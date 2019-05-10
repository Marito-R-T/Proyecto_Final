/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Enemigo extends JLabel {

    private float vida, daño, defensa;
    private final float vidaTope;
    private ImageIcon imagen;
    private Terreno terreno;
    private String agua = "";

    public Enemigo(float vida, float defensa, float daño) {
        this.vidaTope = vida;
        this.vida = vida;
        this.defensa = defensa - 6;
        this.daño = daño;
        this.setSize(200, 200);
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + ".png"));
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
        if (this.terreno instanceof Agua) {
            agua = "A";
        }
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + ".png"));
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        this.setLocation(((this.terreno.getColumnas() - 1) * 200) + 10, ((this.terreno.getFilas() - 1) * 200) + 10);
        this.terreno.getMapa().agregarEnemigos(this);
    }

    public void serDañado(float daño, Vehiculo vehiculo) {
        if (daño > this.defensa) {
            if (daño > vida) {
                vida = 0;
                vehiculo.setExperiencia();
            } else {
                if (defensa < daño) {
                    vida -= (daño - defensa);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "me has dañado, \n  me has quitado: " + daño + "  de vida! \n y mi vida total es de: " + vidaTope + " \n ahorita tengo: " + vida + " \n defensa: " + defensa);

    }

    public void comprobarImagen() {
        if (vida / vidaTope == 0) {
            this.setIcon(null);
        } else if (vida / vidaTope < 0.2) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + "4.png"));
            this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } else if (vida / vidaTope < 0.4) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + "3.png"));
            this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } else if (vida / vidaTope < 0.6) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + "2.png"));
            this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } else if (vida / vidaTope < 0.8) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + "1.png"));
            this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        } else {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo" + agua + ".png"));
            this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        }
    }

    public float getVida() {
        return vida;
    }

    public float getDaño() {
        return daño;
    }

    public float getDefensa() {
        return defensa;
    }

    public Terreno getTerreno() {
        return terreno;
    }
}
