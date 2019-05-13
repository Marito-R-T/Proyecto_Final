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
public class Montaña extends Terreno {

    private int vida = 15;

    public Montaña() {
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Terrenos/montaña.jpg"));
        this.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
    }

    @Override
    public void quitarVida() {
        if (vida > 0) {
            vida -= 3;
        } if(vida == 0){
            convertirenLLanura();
        }
    }

    public void convertirenLLanura() {
        if (vida == 0) {
            Terreno terreno = new Llanura();
            terreno.setColumnas(super.getColumnas());
            terreno.setFilas(super.getFilas());
            terreno.setMapa(super.getMapa());
            if(super.getEnemigo() != null){
                terreno.setEnemigo(super.getEnemigo());
            }
            if (this.getN() != null) {
                terreno.setN(this.getN());
                this.getN().setS(terreno);
            }
            if (this.getE() != null) {
                terreno.setE(this.getE());
                this.getE().setO(terreno);
            }
            if (this.getO() != null) {
                terreno.setO(this.getO());
                this.getO().setE(terreno);
            }
            if (this.getS() != null) {
                terreno.setS(this.getS());
                this.getS().setN(terreno);
            }
            if (this.getNE() != null) {
                terreno.setNE(this.getNE());
                this.getNE().setSO(terreno);
            }
            if (this.getNO() != null) {
                terreno.setNO(this.getNO());
                this.getNO().setSE(terreno);
            }
            if (this.getSE() != null) {
                terreno.setSE(this.getSE());
                this.getSE().setNO(terreno);
            }
            if (this.getSO() != null) {
                terreno.setSO(this.getSO());
                terreno.getSO().setNE(terreno);
            }
            terreno.setBounds(10 + (200*(this.getColumnas()-1)),10 + (200*(this.getFilas()-1)), 200, 200);
            super.getMapa().add(terreno);
            super.getMapa().remove(this);
            super.getMapa().getMapa()[this.getFilas()-1][this.getColumnas()-1] = terreno;
            System.gc();
        }
    }
}
