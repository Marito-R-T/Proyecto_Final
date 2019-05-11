/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas;

import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Llanura;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Montaña;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.Oyentes.OyenteMapas;
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class Mapa extends JPanel{

    private int No;
    protected Terreno[][] mapa;
    protected Random random = new Random();
    protected int agua = 0, montaña = 0;
    protected int FILAS;
    protected int COLUMNAS;
    protected int topecajas, cajas;
    protected Terreno anterior, referencia;
    protected int topeenemigos;

    public void colocarCuadros() {
        for (int i = 0; i < FILAS; i++) {
            for (int u = 0; u < COLUMNAS; u++) {
                this.add(mapa[i][u], 2);
                mapa[i][u].setBounds((u * 200) + 10, (i * 200) + 10, 200, 200);
                mapa[i][u].setMapa(this);
                //mapa[i][u].setimage();
            }
        }
    }

    public int getTopeenemigos() {
        return topeenemigos;
    }

    public void ingresarTerrenos() {
        for (int i = 0; i < FILAS; i++) {
            int elegida = random.nextInt(3);
            Terreno primero;
            if (elegida == 0 && agua < topecajas * 2) {
                primero = new Agua();
                agua++;
            } else if (elegida == 1 && montaña < topecajas * 2) {
                primero = new Montaña();
                montaña++;
            } else {
                primero = new Llanura();
            }
            referencia = null;
            referencia = primero;
            mapa[i][0] = primero;
            primero.setColumnas(1);
            primero.setFilas(i + 1);
            if (random.nextInt(3) == 0) {
                primero.setCaja();
                cajas++;
            }
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
                elegida = random.nextInt(3);
                Terreno nuevo;
                if (elegida == 0 && agua < topecajas * 2) {
                    nuevo = new Agua();
                    agua++;
                } else if (elegida == 1 && montaña < topecajas * 2) {
                    nuevo = new Montaña();
                    montaña++;
                } else {
                    nuevo = new Llanura();
                }
                nuevo.setColumnas(j + 1);
                nuevo.setFilas(i + 1);
                mapa[i][j] = nuevo;
                if (random.nextInt(2) == 0) {
                    nuevo.setCaja();
                    cajas++;
                }
                crearConexiones(nuevo);
            }
        }
    }

    private void crearConexiones(Terreno nuevo) {
        nuevo.setO(referencia);
        referencia.setE(nuevo);
        referencia = nuevo;
        this.add(referencia);
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
    }

    public void ingresarprimerVehiculo(Vehiculo vehiculo) {
        Random numerorandom = new Random();
        int filarandom = numerorandom.nextInt(this.FILAS);
        int columnarandom = numerorandom.nextInt(this.COLUMNAS);
        if (mapa[filarandom][columnarandom].getEnemigo() == null) {
            if((vehiculo instanceof Tanque && !(mapa[filarandom][columnarandom] instanceof Agua))|| (vehiculo instanceof Avion && !(mapa[filarandom][columnarandom] instanceof Montaña))){
             mapa[filarandom][columnarandom].setVehiculo(vehiculo);
             vehiculo.setPosicion(mapa[filarandom][columnarandom]);}
             else{
             ingresarprimerVehiculo(vehiculo);
             }
            /*mapa[filarandom][columnarandom].setVehiculo(vehiculo);
            vehiculo.setPosicion(mapa[filarandom][columnarandom]);*/
        } else {
            ingresarprimerVehiculo(vehiculo);
        }
    }

    public void ingresarEnemigos(Enemigo[] enemigos) {
        for (int i = 0; i < enemigos.length; i++) {
            Random numerorandom = new Random();
            int filarandom = numerorandom.nextInt(this.FILAS);
            int columnarandom = numerorandom.nextInt(this.COLUMNAS);
            if (mapa[filarandom][columnarandom].getEnemigo() == null) {
                mapa[filarandom][columnarandom].setEnemigo(enemigos[i]);
                enemigos[i].setTerreno(mapa[filarandom][columnarandom]);
            } else {
                i--;
            }
        }
    }


    public void agregarComponente(Vehiculo enjuego) {
        this.add(enjuego, 1);
        this.repaint();
    }

    public Terreno[][] getMapa() {
        return mapa;
    }
    public void agregarEnemigos(Enemigo enemigo){
        this.add(enemigo, 1);
        this.repaint();
    }
}
