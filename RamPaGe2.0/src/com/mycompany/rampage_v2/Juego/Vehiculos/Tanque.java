/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import java.awt.Image;
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
    public void iniciarMuestra(){
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Tanque.png"));
        muestra.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(60, muestra.getHeight(), Image.SCALE_SMOOTH)));
        muestra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        super.muestra.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        super.muestra.setText(this.getNombre() + " Vehiculo no: " + this.getNo());
    }
    
    @Override
    public void ingresarImagen(){
        String[] tipos = {"Pequeño", "Pesado", "Ligero", "Grande"};
        String x = (String) JOptionPane.showInputDialog(null, "Ingrese como se representara su vehiculo", "Imagen", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
    }
}
