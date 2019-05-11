/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Montaña;
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;

/**
 *
 * @author marito
 */
public class Volante{

    private String direccion = null;

    public Volante() {
    }

    public String getDireccion() {
        return direccion;
    }
    private Vehiculo enjuego;
    private int espacios;

    public void moverVehiculo(Vehiculo enJuego, int espacios, String direccion) {
        this.enjuego = enJuego;
        this.espacios = espacios;
        switch (direccion) {
            case "abajo":
                bajar();
                break;
            case "arriba":
                subir();
                break;
            case "izquierda":
                irIzquierda();
                break;
            case "derecha":
                irDerecha();
                break;
        }
    }

    private void bajar() {
        int y = enjuego.getY() + (200 * espacios);
        int espacios = 0;
        boolean seguir = true;
        try {
            while (enjuego.getY() != y) {
                if (espacios % 200 == 0) {
                    if (enjuego.getPosicion().getS() != null && enjuego.getPosicion().getS().getEnemigo() == null) {
                        if ((enjuego instanceof Tanque && !(enjuego.getPosicion().getS() instanceof Agua)) || (enjuego instanceof Avion && !(enjuego.getPosicion().getS() instanceof Montaña))) {
                            enjuego.getPosicion().setVehiculo(null);
                            enjuego.getPosicion().getS().setVehiculo(enjuego);
                        } else {
                            seguir = false;
                            y = enjuego.getY();
                        }
                    } else {
                        seguir = false;
                        y = enjuego.getY();
                    }
                }
                if (seguir) {
                    espacios++;
                    enjuego.setLocation(enjuego.getX(), enjuego.getY() + 1);
                    Thread.sleep(20);
                    if (espacios % 200 == 0) {
                        enjuego.setPosicion(enjuego.getPosicion().getS());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void subir() {
        int y = enjuego.getY() - (200 * espacios);
        int espacios = 0;
        boolean seguir = true;
        try {
            while (enjuego.getY() != y) {
                if (espacios % 200 == 0) {
                    if (enjuego.getPosicion().getN() != null && enjuego.getPosicion().getN().getEnemigo() == null) {
                        if ((enjuego instanceof Tanque && !(enjuego.getPosicion().getN() instanceof Agua)) || (enjuego instanceof Avion && !(enjuego.getPosicion().getN() instanceof Montaña))) {
                            enjuego.getPosicion().setVehiculo(null);
                            enjuego.getPosicion().getN().setVehiculo(enjuego);
                        } else {
                            seguir = false;
                            y = enjuego.getY();
                        }
                    } else {
                        seguir = false;
                        y = enjuego.getY();
                    }
                }
                if (seguir) {
                    espacios++;
                    enjuego.setLocation(enjuego.getX(), enjuego.getY() - 1);
                    Thread.sleep(20);
                    if (espacios % 200 == 0) {
                        enjuego.setPosicion(enjuego.getPosicion().getN());
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void irIzquierda() {
        int x = enjuego.getX() - (200 * espacios);
        int espacios = 0;
        boolean seguir = true;
        try {
            while (enjuego.getX() != x) {
                if (espacios % 200 == 0) {
                    if (enjuego.getPosicion().getO() != null && enjuego.getPosicion().getO().getEnemigo() == null) {
                        if ((enjuego instanceof Tanque && !(enjuego.getPosicion().getO() instanceof Agua)) || (enjuego instanceof Avion && !(enjuego.getPosicion().getO() instanceof Montaña))) {
                            enjuego.getPosicion().setVehiculo(null);
                            enjuego.getPosicion().getO().setVehiculo(enjuego);
                        } else {
                            seguir = false;
                            x = enjuego.getX();
                        }
                    } else {
                        seguir = false;
                        x = enjuego.getX();
                    }
                }
                if (seguir) {
                    espacios++;
                    enjuego.setLocation(enjuego.getX() - 1, enjuego.getY());
                    Thread.sleep(20);
                    if (espacios % 200 == 0) {
                        enjuego.setPosicion(enjuego.getPosicion().getO());
                    }
                }
            }
        } catch (Exception e) {
        }

    }

    private void irDerecha() {
        int x = enjuego.getX() + (200 * espacios);
        int espacios = 0;
        boolean seguir = true;
        try {
            while (enjuego.getX() != x) {
                if (espacios % 200 == 0) {
                    if (enjuego.getPosicion().getE() != null && enjuego.getPosicion().getE().getEnemigo() == null) {
                        if ((enjuego instanceof Tanque && !(enjuego.getPosicion().getE() instanceof Agua)) || (enjuego instanceof Avion && !(enjuego.getPosicion().getE() instanceof Montaña))) {
                            enjuego.getPosicion().setVehiculo(null);
                            enjuego.getPosicion().getE().setVehiculo(enjuego);
                        } else {
                            seguir = false;
                            x = enjuego.getX();
                        }
                    } else {
                        seguir = false;
                        x = enjuego.getX();
                    }
                }
                if (seguir) {
                    espacios++;
                    enjuego.setLocation(enjuego.getX() + 1, enjuego.getY());
                    Thread.sleep(20);
                    if (espacios % 200 == 0) {
                        enjuego.setPosicion(enjuego.getPosicion().getE());
                    }
                }
            }
        } catch (Exception e) {
        }

    }
}
