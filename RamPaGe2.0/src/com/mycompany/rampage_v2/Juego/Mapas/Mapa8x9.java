/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas;

import java.util.Random;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.*;
import java.awt.Dimension;

/**
 *
 * @author marito
 */
public final class Mapa8x9 extends Mapa {

    private final int TOPECAJAS = 15;

    public Mapa8x9() {
        FILAS = 8;
        COLUMNAS = 9;
        super.topecajas = TOPECAJAS;
        super.mapa = new Terreno[FILAS][COLUMNAS];
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1820, 1620));
        //ingresarTerrenos();
        super.ingresarTerrenos();
        super.colocarCuadros();
    }

    /*public void ingresarTerrenos() {
     for (int i = 0; i < FILAS; i++) {
     int elegida = super.random.nextInt(3);
     Terreno primero;
     if (elegida == 0 && agua < 22) {
     primero = new Agua();
     agua++;
     } else if (elegida == 1 && montaña < 22) {
     primero = new Montaña();
     montaña++;
     } else {
     primero = new Llanura();
     }
     referencia = null;
     referencia = primero;
     super.mapa[i][0] = primero;
     primero.setColumnas(1);
     primero.setFilas(i + 1);
     if (i > 0) {
     primero.setN(anterior);
     anterior.setS(primero);
     if (primero.getN().getE() != null) {
     primero.setNE(primero.getN().getE());
     primero.getNE().setSO(primero);
     }
     }
     anterior = primero;
     for (int j = 1; j < COLUMNAS; j++) {
     elegida = super.random.nextInt(3);
     Terreno nuevo;
     if (elegida == 0 && agua < 22) {
     nuevo = new Agua();
     agua++;
     } else if (elegida == 1 && montaña < 22) {
     nuevo = new Montaña();
     montaña++;
     } else {
     nuevo = new Llanura();
     }
     nuevo.setColumnas(j + 1);
     nuevo.setFilas(i + 1);
     super.mapa[i][j] = nuevo;
     crearConexiones(nuevo);
     }
     }
     }

     /*private void primerTerreno() {
     int elegida = super.random.nextInt(3);
     Terreno primero;
     if (elegida == 0) {
     primero = new Agua();
     agua++;
     } else if (elegida == 1) {
     primero = new Montaña();
     montaña++;
     } else {
     primero = new Llanura();
     }
     primero.setColumnas(1);
     primero.setFilas(1);
     referencia = primero;
     anterior = primero;
     super.mapa[0][0] = primero;
     seguirConstruccion();
     }

     private void seguirConstruccion() {

     }
     private void crearConexiones(Terreno nuevo) {
     nuevo.setO(referencia);
     referencia.setE(nuevo);
     referencia = nuevo;
     if (nuevo.getO().getN() != null) {
     nuevo.setNO(nuevo.getO().getN());
     nuevo.getNO().setSE(nuevo);
     if (nuevo.getNO().getE() != null) {
     nuevo.setN(nuevo.getNO().getE());
     nuevo.getN().setS(nuevo);
     if (nuevo.getN().getE() != null) {
     nuevo.setNE(nuevo.getN().getE());
     nuevo.getNE().setSO(nuevo);
     }
     }
     }
     }*/
}
