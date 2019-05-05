/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Oyentes;

import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.event.MouseEvent;

/**
 *
 * @author marito
 */
public class OyenteVehiculos extends java.awt.event.MouseAdapter{
    private Vehiculo[] escogidos = new Vehiculo[3];
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        MouseClick(evt);
                    }

    private void MouseClick(MouseEvent evt) {
        int x = 0;
        while(escogidos[x] != null && x < 3){
            x++;
        }
        if(x < 3){
            escogidos[x] = (Vehiculo) evt.getSource();
        }else{
            escogidos[0] = escogidos[1];
            escogidos[1] = escogidos[2];
            escogidos[2] = (Vehiculo) evt.getSource();
        }
    }
}
