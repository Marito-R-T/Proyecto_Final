/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Oyentes;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.event.MouseEvent;

/**
 *
 * @author marito
 */
public class OyenteMapas extends java.awt.event.MouseAdapter {

    private Terreno[] terreno;

    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        MouseClick(evt);
    }

    private void MouseClick(MouseEvent evt) {
        
    }
}
