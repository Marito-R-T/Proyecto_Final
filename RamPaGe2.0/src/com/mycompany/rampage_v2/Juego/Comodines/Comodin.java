/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Comodines;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public final class Comodin {

    private int numero;
    private String decision = null;

    public Comodin(int numero) {
        if (numero == 3) {
            JOptionPane.showMessageDialog(null, "tu comodin no tiene nada :,c! ");
        }
        this.numero = numero;
        empezarComodin();
        x = 0;
    }

    public Comodin() {
    }

    public void empezarComodin() {
        //decide que tipo de comodin sera
        if (numero == 2) {
            if (x == 0) {
                String[] y = {"defensa", "ataque"};
                while (decision == null || "".equals(decision)) {
                    decision = (String) JOptionPane.showInputDialog(null, "decida que caracteristica tomar", "Comodin", JOptionPane.OK_OPTION, null, y, y[0]);
                }
            }
        }
    }

    public double recuperarVida() {
        if (x == 0) {
            x++;
            return 1.25;
        }
        return 1;
    }

    private int x;

    public double maximizarDañoEscudo() {
        if (x <= 3) {
            x++;
            return 1.5;
        } 
        return 1;
    }

    public int getNumero() {
        return numero;
    }

    public String getDecision() {
        return decision;
    }

    public int getX() {
        return x;
    }
}
