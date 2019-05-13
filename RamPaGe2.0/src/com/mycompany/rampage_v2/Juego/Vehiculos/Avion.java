/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Avion extends Vehiculo {

    public Avion(float[] porcentajes) {
        this.setSize(200, 200);
        precio = 1000;
        super.porcentajes = porcentajes;
        vidatope = 50 * (1+(porcentajes[0]/12));
        vida = 50 * (1+(porcentajes[0]/12));
        daño = 9 * (1+(porcentajes[1]/12));
        defensa = 4 * (1+(porcentajes[2]/12));
        defensaNeta = vida * (defensa / 100);
        muestra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarMouseClicked(evt);
            }
        });
    }

    @Override
    public void revisarSubirNivel() {
            super.revisarSubirNivel();
            daño = (7 + 2 * nivel) * porcentajes[1];
            defensa = (3 + (1 * nivel)) * porcentajes[2];
            defensaNeta = vida * (defensa / 100);
    }

    @Override
    public void iniciarMuestra() {
        muestra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        super.muestra.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        super.muestra.setText(this.getNombre() + "      Vehiculo no:      " + this.getNo());
    }

    @Override
    public void ingresarImagen() {
        String[] tipos = {"Caza", "Pesado", "Ligero", "Papel"};
        String x = (String) JOptionPane.showInputDialog(null, "Ingrese como se representara su vehiculo", "Imagen", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        if (null != x) {
            switch (x) {
                case "Caza":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/Avion.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Pesado":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/AvionPesado.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Ligero":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/AvionLigero.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Papel":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/AvionPapel.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
            }
        }
        this.setIcon(imagen);
    }

    @Override
    public String getTipo() {
        return "Avion";
    }

}
