/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marito
 */
public class Enemigo extends JLabel{
    
    private final float vida, daño, defensa;
    private ImageIcon imagen;
    private Terreno terreno;
    private String agua = "";
    
    public Enemigo(float vida, float defensa, float daño){
        this.vida = vida;
        this.defensa = defensa;
        this.daño = daño;
        this.setSize(200, 200);
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo"+agua+".png"));
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
        if(this.terreno instanceof Agua){
            agua = "A";
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Enemigos/enemigo"+agua+".png"));
            this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        }
        this.setLocation((this.terreno.getColumnas()*200)+10,(this.terreno.getFilas()*200)+10);
        terreno.getParent().add(this);
    }
}
