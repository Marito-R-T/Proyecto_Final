/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas.Terrenos;

import com.mycompany.rampage_v2.Juego.Comodines.Comodin;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author marito
 */
public abstract class Terreno extends JLabel{
    private Vehiculo vehiculo;
    private Terreno N,S,E,O,NE,NO,SE,SO;
    private int columnas, filas;
    private Comodin caja;
    private Enemigo enemigo;
    
    public Terreno(){
        this.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.gray, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        //this.setBounds((columnas-1)*60 + 10,(filas-1)*60 +10, 60, 60);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    accionTerreno(evt);
                }
        });
    }
    private void accionTerreno(MouseEvent evt){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Terreno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Terreno getN() {
        return N;
    }

    public void setN(Terreno N) {
        this.N = N;
    }

    public Terreno getS() {
        return S;
    }

    public void setS(Terreno S) {
        this.S = S;
    }

    public Terreno getE() {
        return E;
    }

    public void setE(Terreno E) {
        this.E = E;
    }

    public Terreno getO() {
        return O;
    }

    public void setO(Terreno O) {
        this.O = O;
    }

    public Terreno getNE() {
        return NE;
    }

    public void setNE(Terreno NE) {
        this.NE = NE;
    }

    public Terreno getNO() {
        return NO;
    }

    public void setNO(Terreno NO) {
        this.NO = NO;
    }

    public Terreno getSE() {
        return SE;
    }

    public void setSE(Terreno SE) {
        this.SE = SE;
    }

    public Terreno getSO() {
        return SO;
    }

    public void setSO(Terreno SO) {
        this.SO = SO;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public Comodin getCaja() {
        return caja;
    }

    public void setCaja(int numerocaja, int tope) {
        this.caja = caja;
    }
    
    public void setEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }
}
