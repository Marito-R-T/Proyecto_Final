/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades;

import com.mycompany.rampage_v2.Juego.Juego;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Montaña;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class CampoBatalla {

    private Vehiculo enjuego;
    private Enemigo enemigo;
    private float dañoahacer;

    public void setJuego(Juego juego) {
    }

    public void atacaraEnemigo(Vehiculo enJuego, float porcentajedaño, String direccion) {
        this.enjuego = enJuego;
        dañoahacer = enjuego.getDaño() * (porcentajedaño / 100 + 1);
        switch (direccion) {
            case "abajo":
                atacarAbajo();
                break;
            case "arriba":
                atacarArriba();
                break;
            case "izquierda":
                atacarIzquierda();
                break;
            case "derecha":
                atacarDerecha();
                break;
        }
    }

    private void atacarAbajo() {
        Terreno referencia = enjuego.getPosicion();
        boolean atacar = true;
        Enemigo enemigo = null;
        while (referencia.getEnemigo() == null && referencia.getVehiculo() == null || referencia.getVehiculo() == enjuego) {
            if (referencia.getS() != null) {
                referencia = referencia.getS();
                dañoahacer = (float) (dañoahacer * 0.96);
                if (referencia instanceof Agua || referencia instanceof Montaña) {
                    referencia.quitarVida();
                }
            } else {
                atacar = false;
                break;
            }
            //juego.getMapa().repaint();
            System.gc();
        }
        if (atacar) {
            if (referencia.getEnemigo() != null) {
                enemigo = referencia.getEnemigo();
                enemigo.serDañado(dañoahacer, enjuego);
                enemigo.comprobarImagen();
                if (referencia.getEnemigo().getVida() == 0) {
                    referencia.setEnemigo(null);
                    referencia.getMapa().remove(enemigo);
                    referencia.getMapa().repaint();
                    enemigo = null;
                }
            } else {
                Vehiculo daño = referencia.getVehiculo();
                daño.serDañado(dañoahacer);
                if (daño.getVida() == 0) {
                    enjuego.setKills();
                    enjuego.getDueño().setKills();
                    daño.getPosicion().setVehiculo(null);
                    referencia.getMapa().remove(daño);
                    daño.setPosicion(null);
                    referencia.getMapa().repaint();
                }
            }
        }
    }

    private void atacarArriba() {
        Terreno referencia = enjuego.getPosicion();
        boolean atacar = true;
        Enemigo enemigo = null;
        while (referencia.getEnemigo() == null && referencia.getVehiculo() == null || referencia.getVehiculo() == enjuego) {
            if (referencia.getN() != null) {
                referencia = referencia.getN();
                dañoahacer = (float) (dañoahacer * 0.96);
                if (referencia instanceof Agua || referencia instanceof Montaña) {
                    referencia.quitarVida();
                }
            } else {
                atacar = false;
                break;
            }
            //juego.getMapa().repaint();
            System.gc();
        }
        if (atacar) {
            if (referencia.getEnemigo() != null) {
                enemigo = referencia.getEnemigo();
                enemigo.serDañado(dañoahacer, enjuego);
                enemigo.comprobarImagen();
                if (referencia.getEnemigo().getVida() == 0) {
                    referencia.setEnemigo(null);
                    referencia.getMapa().remove(enemigo);
                    referencia.getMapa().repaint();
                    enemigo = null;
                }
            } else {
                Vehiculo daño = referencia.getVehiculo();
                daño.serDañado(dañoahacer);
                if (daño.getVida() == 0) {
                    enjuego.setKills();
                    enjuego.getDueño().setKills();
                    daño.getPosicion().setVehiculo(null);
                    referencia.getMapa().remove(daño);
                    daño.setPosicion(null);
                    referencia.getMapa().repaint();
                }
            }
        }
    }

    private void atacarIzquierda() {
        Terreno referencia = enjuego.getPosicion();
        boolean atacar = true;
        Enemigo enemigo = null;
        while (referencia.getEnemigo() == null && referencia.getVehiculo() == null || referencia.getVehiculo() == enjuego) {
            if (referencia.getO() != null) {
                referencia = referencia.getO();
                dañoahacer = (float) (dañoahacer * 0.96);
                if (referencia instanceof Agua || referencia instanceof Montaña) {
                    referencia.quitarVida();
                }
            } else {
                atacar = false;
                break;
            }
            //juego.getMapa().repaint();
            System.gc();
        }
        if (atacar) {
            if (referencia.getEnemigo() != null) {
                enemigo = referencia.getEnemigo();
                enemigo.serDañado(dañoahacer, enjuego);
                enemigo.comprobarImagen();
                if (referencia.getEnemigo().getVida() == 0) {
                    referencia.setEnemigo(null);
                    referencia.getMapa().remove(enemigo);
                    referencia.getMapa().repaint();
                    enemigo = null;
                }
            } else {
                Vehiculo daño = referencia.getVehiculo();
                daño.serDañado(dañoahacer);
                if (daño.getVida() == 0) {
                    enjuego.setKills();
                    enjuego.getDueño().setKills();
                    daño.getPosicion().setVehiculo(null);
                    referencia.getMapa().remove(daño);
                    daño.setPosicion(null);
                    referencia.getMapa().repaint();
                }
            }
        }

    }

    private void atacarDerecha() {
        Terreno referencia = enjuego.getPosicion();
        boolean atacar = true;
        Enemigo enemigo = null;
        while (referencia.getEnemigo() == null && referencia.getVehiculo() == null || referencia.getVehiculo() == enjuego) {
            if (referencia.getE() != null) {
                dañoahacer = (float) (dañoahacer * 0.96);
                referencia = referencia.getE();
                if (referencia instanceof Agua || referencia instanceof Montaña) {
                    referencia.quitarVida();
                }
            } else {
                atacar = false;
                break;
            }
            //juego.getMapa().repaint();
            System.gc();
        }
        if (atacar) {
            if (referencia.getEnemigo() != null) {
                enemigo = referencia.getEnemigo();
                enemigo.serDañado(dañoahacer, enjuego);
                enemigo.comprobarImagen();
                if (referencia.getEnemigo().getVida() == 0) {
                    referencia.setEnemigo(null);
                    referencia.getMapa().remove(enemigo);
                    referencia.getMapa().repaint();
                    enemigo = null;
                }
            } else {
                Vehiculo daño = referencia.getVehiculo();
                daño.serDañado(dañoahacer);
                if (daño.getVida() == 0) {
                    enjuego.setKills();
                    enjuego.getDueño().setKills();
                    daño.getPosicion().setVehiculo(null);
                    referencia.getMapa().remove(daño);
                    daño.setPosicion(null);
                    referencia.getMapa().repaint();
                }
            }
        }

    }

    public void atacaraAliado(Enemigo enemigo, float porcentajedaño) {
        this.enemigo = enemigo;
        dañoahacer = enemigo.getDaño() * (porcentajedaño / 100 + 1);
        Random numero = new Random();
        int x = numero.nextInt(4);
        switch (x) {
            case 0:
                JOptionPane.showMessageDialog(null, "el enemigo disparo hacia el sur");
                enemigoAbajo();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "el enemigo disparo hacia el norte");
                enemigoArriba();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "el enemigo disparo hacia el este");
                enemigoDerecha();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "el enemigo disparo hacia el oeste");
                enemigoIzquierda();
                break;
        }
    }

    private void enemigoAbajo() {
        Terreno referencia = enemigo.getTerreno();
        while (referencia.getS() != null) {
            referencia = referencia.getS();
            if (referencia.getVehiculo() != null) {
                referencia.getVehiculo().serDañado(dañoahacer);
                if (referencia.getVehiculo().getVida() == 0) {
                    referencia.setVehiculo(null);
                    referencia.getMapa().remove(enjuego);
                    referencia.getMapa().repaint();
                    enjuego = null;
                }
            }
        }
    }

    private void enemigoArriba() {
        Terreno referencia = enemigo.getTerreno();
        while (referencia.getN() != null) {
            referencia = referencia.getN();
            if (referencia.getVehiculo() != null) {
                referencia.getVehiculo().serDañado(dañoahacer);
                if (referencia.getVehiculo().getVida() == 0) {
                    referencia.setVehiculo(null);
                    referencia.getMapa().remove(enjuego);
                    referencia.getMapa().repaint();
                    enjuego = null;
                }
            }
        }
    }

    private void enemigoDerecha() {
        Terreno referencia = enemigo.getTerreno();
        while (referencia.getE() != null) {
            referencia = referencia.getE();
            if (referencia.getVehiculo() != null) {
                referencia.getVehiculo().serDañado(dañoahacer);
                if (referencia.getVehiculo().getVida() == 0) {
                    referencia.setVehiculo(null);
                    referencia.getMapa().remove(enjuego);
                    referencia.getMapa().repaint();
                    enjuego = null;
                }
            }
        }
    }

    private void enemigoIzquierda() {
        Terreno referencia = enemigo.getTerreno();
        while (referencia.getO() != null) {
            referencia = referencia.getO();
            if (referencia.getVehiculo() != null) {
                referencia.getVehiculo().serDañado(dañoahacer);
                if (referencia.getVehiculo().getVida() == 0) {
                    referencia.setVehiculo(null);
                    referencia.getMapa().remove(enjuego);
                    referencia.getMapa().repaint();
                    enjuego = null;
                }
            }
        }
    }

    public Vehiculo getEnjuego() {
        return enjuego;
    }
}
