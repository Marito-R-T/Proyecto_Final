/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import java.awt.Dimension;

/**
 *
 * @author marito
 */
public final class Mapa4x4 extends Mapa {
    private final int TOPECAJAS = 4, TOPEENEMIGOS = 2;
    public Mapa4x4() {
        super.topeenemigos = TOPEENEMIGOS;
        FILAS = 4;
        COLUMNAS = 4;
        super.topecajas = TOPECAJAS;
        super.mapa = new Terreno[FILAS][COLUMNAS];
        this.setLayout(null);
        this.setPreferredSize(new Dimension(820, 820));
        //ingresarTerrenos();
        super.ingresarTerrenos();
        super.colocarCuadros();
    }
    
    /*public void ingresarTerrenos() {
        for (int i = 0; i < FILAS; i++) {
            int elegida = super.random.nextInt(3);
            Terreno primero;
            if (elegida == 0 && agua < 5) {
                primero = new Agua();
                agua++;
            } else if (elegida == 1 && montaña < 5) {
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
                if (elegida == 0 && agua < 5) {
                    nuevo = new Agua();
                    agua++;
                } else if (elegida == 1 && montaña < 5) {
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
