/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Dados;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marito
 */
public abstract class Dado extends JLabel implements Runnable{

    protected Random numero;
    protected ImageIcon figurita;
    protected boolean estaGirando;
    protected int topenumero;
    private int escogido;

    public abstract int obtenerNumero();

    public void girarDado() {
        try {
            while (estaGirando) {
                String x = Integer.toString(numero.nextInt(topenumero) + 1);
                figurita = new ImageIcon(getClass().getResource("/Imagenes/Dados/" + x + ".png"));
                this.setIcon(new ImageIcon(figurita.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST)));
                System.gc();
                this.getParent().repaint();
                Thread.sleep(100);

            }
            escogido = numero.nextInt(topenumero) +1;
            String x = Integer.toString(escogido);
            figurita = new ImageIcon(getClass().getResource("/Imagenes/Dados/" + x + ".png"));
            this.setIcon(new ImageIcon(figurita.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST)));
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        try {
            estaGirando = true;
            girarDado();
        } catch (Exception e) {
        }
    }

    public void parardeGirar() {
        this.estaGirando = false;
    }

    public int getEscogido() {
        return escogido;
    }

    public boolean isEstaGirando() {
        return estaGirando;
    }

    public void setEstaGirando(boolean estaGirando) {
        this.estaGirando = estaGirando;
    }

}
