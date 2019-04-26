/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Ventanas.Inicio;
import com.mycompany.rampage_v2.Ventanas.VisualJugador;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Jugador {
    private final int NO;
    private Jugador a,p;
    private JLabel lblnombre = new JLabel();
    private String nombre;
    private VisualJugador iu;
    private Inicio inicio;
    
    public Jugador(int no){
        NO = no;
        lblnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClicked(evt);
            }
        });
    }

    public Jugador getAnterior() {
        return a;
    }

    public void setAnterior(Jugador anterior) {
        this.a = anterior;
    }

    public Jugador getPosterior() {
        return p;
    }

    public void setPosterior(Jugador posterior) {
        this.p = posterior;
    }

    public int getNO() {
        return NO;
    }
    public void mouseClicked(MouseEvent e){
        if(JOptionPane.showConfirmDialog(lblnombre, "Seguro que desea continuar con: " + nombre, "Seguro?", 2) == 1){
            iu.setJugador(this);
            iu.setVisible(true);
            inicio.setVisible(false);
        }
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void perzonalizarlbl(){
        lblnombre.setSize(100, 60);
        lblnombre.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        lblnombre.setText(nombre);
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblnombre.setForeground(new java.awt.Color(0, 204, 204));
    }

    public JLabel getLblnombre() {
        return lblnombre;
    }
    
}
