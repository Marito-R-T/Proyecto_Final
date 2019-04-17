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
public abstract class Terreno extends JLabel{
    private Vehiculo vehiculo;

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
}
