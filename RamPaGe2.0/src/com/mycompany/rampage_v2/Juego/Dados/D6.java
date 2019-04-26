/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Dados;

import java.util.Random;

/**
 *
 * @author marito
 */
public class D6 extends Dado{
    public D6(){
        numero = new Random();
    }
    
    @Override
    public int obtenerNumero(){
        return numero.nextInt(6) + 1;
    }
}
