/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas.Terrenos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author marito
 */
public class Llanura extends Terreno{
    public Llanura(){
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/llanura.jpg")); 
        this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_FAST)));
    }
}
