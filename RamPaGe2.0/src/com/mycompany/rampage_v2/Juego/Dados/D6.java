/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Dados;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author marito
 */
public class D6 extends Dado {

    public D6() {
        numero = new Random();
        topenumero = 6;
    }

    @Override
    public int obtenerNumero() {
        return numero.nextInt(6) + 1;
    }

}
