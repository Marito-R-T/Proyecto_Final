/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas.Terrenos;

import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import javax.swing.JLabel;

/**
 *
 * @author marito
 */
public abstract class Terreno /*extends JLabel*/{
    private Vehiculo vehiculo;
    private Terreno N,S,E,O,NE,NO,SE,SO;
    private int columnas, filas;

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
    
}
