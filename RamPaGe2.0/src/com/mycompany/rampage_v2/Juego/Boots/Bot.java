/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Boots;

import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marito
 */
public class Bot extends JLabel implements Runnable{
    private int cantidad_de_Bots;
    private final ImageIcon imagen;
    private Jugador dueño;
    private Terreno terreno;
    private int daño;
    private int turnos;
    
    public Bot(){
        cantidad_de_Bots = 0;
        this.setSize(200, 200);
        imagen = new ImageIcon(getClass().getResource("/Imagenes/tienda.jpg"));
        this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST)));
    }
    
    public void agregarBot(){
        cantidad_de_Bots++;
    }
    
    public void quitarCantidaddeBots(){
        cantidad_de_Bots--;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    @Override
    public void run() {
        if(cantidad_de_Bots > 0){
            terreno.add(labelFor);
            cantidad_de_Bots--;
        }
    }
    int i = 0;
    public void atacar(Terreno ref, int veces){
        if(ref.getE() != null && i<3){
            Terreno referencia = ref.getE();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getO() != null && i<3){
            Terreno referencia = ref.getO();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getS() != null && i<3){
            Terreno referencia = ref.getS();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getN() != null && i<3){
            Terreno referencia = ref.getN();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getSO() != null && i<3){
            Terreno referencia = ref.getSO();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getSE() != null && i<3){
            Terreno referencia = ref.getSE();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getNO() != null && i<3){
            Terreno referencia = ref.getNO();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
        if(ref.getNE() != null && i<3){
            Terreno referencia = ref.getNE();
            if(referencia.getEnemigo() != null){
                referencia.getEnemigo().obtenerdaño();
            }
            i++;
            atacar(referencia, i);
        } i=0;
    }
    
    public void explotar(){
        
    }
    
    
}
