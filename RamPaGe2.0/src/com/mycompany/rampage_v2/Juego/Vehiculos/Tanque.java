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
public class Tanque extends Vehiculo {

    public Tanque(int[] porcentajes) {
        this.porcentajes = porcentajes;
        vida = 50 * porcentajes[0];
        daño = 12 * porcentajes[1];
        defensa = 7 * porcentajes[2];
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
        if (experiencia >= experienciaTope) {
            super.revisarSubirNivel();
            daño = (10 + 2 * nivel) * porcentajes[1];
            defensa = (6 + (1 * nivel)) * porcentajes[2];
            defensaNeta = vida * (defensa / 100);
        }
    }

    @Override
    public void iniciarMuestra() {
        muestra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        super.muestra.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        super.muestra.setText(this.getNombre() + " Vehiculo no: " + this.getNo());
    }

    @Override
    public void ingresarImagen() {
        String[] tipos = {"Pequeño", "Pesado", "Ligero", "Papel"};
        String x = (String) JOptionPane.showInputDialog(null, "Ingrese como se representara su vehiculo", "Imagen", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        if (null != x) {
            switch (x) {
                case "Pequeño":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePequeño.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Pesado":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePesado.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Ligero":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/Tanque.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
                case "Papel":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePapel.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    break;
            }
        }
    }

    private void mostrarMouseClicked(MouseEvent evt) {
        super.dueño.getIu().ingresarVehiculo(this);
    }
}
