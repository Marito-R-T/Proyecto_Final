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
public abstract class Dado {
    protected Random numero;
    
    public abstract int obtenerNumero();
}
