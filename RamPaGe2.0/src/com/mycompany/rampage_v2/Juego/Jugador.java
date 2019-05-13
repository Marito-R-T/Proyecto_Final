/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Juego.*;
import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Boots.Bot;
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Juego.listado.Armeria;
import com.mycompany.rampage_v2.Juego.listado.Garage;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import com.mycompany.rampage_v2.Ventanas.Inicio;
import com.mycompany.rampage_v2.Ventanas.VisualJugador;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Jugador extends JLabel {

    private final int NO;
    private Jugador a, p;
    private JLabel lblnombre = new JLabel();
    private final String nombre;
    private VisualJugador iu;
    private Inicio inicio;
    private final Listado<Vehiculo> vehiculos;
    private final Garage garage;
    private final Listado<Arma> armas;
    private final Armeria armeria;
    private int nivel, experiencia, experienciaTope, kills, muertes, perdidas, ganadas, dinero;
    private int bots;

    public Jugador(int no, String nombre) {
        bots = 2;
        dinero = 600;
        this.perdidas = 0;
        this.ganadas = 0;
        vehiculos = new Listado<>();
        garage = new Garage(vehiculos);
        armas = new Listado<>();
        armeria = new Armeria(armas);
        NO = no;
        nuevoVehiculo();
        nuevoVehiculo();
        nuevoVehiculo();
        ingresarArmas();
        ingresarArmas();
        nivel = 1;
        experiencia = 0;
        experienciaTope = 300;
        this.nombre = nombre;
    }

    public Jugador getAnterior() {
        return a;
    }

    public void setAnterior(Jugador anterior) {
        this.a = anterior;
    }

    public Jugador getPosterior() {
        return p;
    }
    
    @Override
    public String toString(){
        return nombre + " " + Integer.toString(NO) ;
    }
    public void setPosterior(Jugador posterior) {
        this.p = posterior;
    }

    public int getNO() {
        return NO;
    }

    public void perzonalizarlbl() {
        lblnombre.setFont(new java.awt.Font("Comic Sans MS", 1, 22));
        lblnombre.setText(nombre);
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblnombre.setForeground(Color.BLACK);
        lblnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblnombreMouseClicked(evt);
            }
        });
    }

    public JLabel getLblnombre() {
        return lblnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void nuevoVehiculo() {
        String[] tipos = {"Avion", "Tanque"};
        String nuevo = (String) JOptionPane.showInputDialog(null, "Se creara un nuevo vehiculo, que tipo desea", "vehiculo", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        float[] porcentajes = new float[4];
        int lleva = 0;
        for (int j = 0; j < 4; j++) {
            lleva = 0;
            for (int l = 0; l < porcentajes.length; l++) {
                lleva += porcentajes[l];
            }
            Integer[] enteros = new Integer[13 - lleva];
            for (int i = 0; i < enteros.length; i++) {
                enteros[i] = i;
            }
            porcentajes[j] = (int) JOptionPane.showInputDialog(null, "", "puntos a la caracteristica: " + (j + 1), 1, null, enteros, enteros[0]);
        }
        if (null != nuevo.toLowerCase()) {
            switch (nuevo.toLowerCase()) {
                case "avion":
                    Vehiculo avion = new Avion(porcentajes);
                    avion.setDueño(this);
                    avion.setNo(vehiculos.getContador() + 1);
                    if (vehiculos.getContador() != 0) {
                        avion.setAnterior(vehiculos.getUltimo());
                        vehiculos.getUltimo().setPosterior(avion);
                    }
                    vehiculos.agregar(avion);
                    avion.agregarNombre();
                    avion.ingresarImagen();
                    JOptionPane.showMessageDialog(null, "Se ha creado su avion");
                    if (vehiculos.getContador() < 4) {
                        avion.setComprada(true);
                    }
                    break;
                case "tanque":
                    Vehiculo tanque = new Tanque(porcentajes);
                    tanque.setDueño(this);
                    tanque.setNo(vehiculos.getContador() + 1);
                    if (vehiculos.getContador() != 0) {
                        tanque.setAnterior(vehiculos.getUltimo());
                        vehiculos.getUltimo().setPosterior(tanque);
                    }
                    vehiculos.agregar(tanque);
                    tanque.agregarNombre();
                    tanque.ingresarImagen();
                    JOptionPane.showMessageDialog(null, "Se ha creado su tanque");
                    if (vehiculos.getContador() < 4) {
                        tanque.setComprada(true);
                    }
                    break;
            }
        }
    }

    public Listado<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getExperienciaTope() {
        return experienciaTope;
    }

    public char getPrimerLetra() {
        char[] arreglo = nombre.toCharArray();
        return arreglo[0];
    }

    public int getKills() {
        return kills;
    }

    public int getMuertes() {
        return muertes;
    }

    private void lblnombreMouseClicked(MouseEvent evt) {
        iu.setJugador(this);
        //iu.ordenarFecha();
        inicio.setVisible(false);
        iu.setVisible(true);
        iu.iniciarComponentes();
        iu.setX(0);
        iu.iniciarPnlVehiculos();
        iu.setU(0);
        iu.iniciarpnlArmas();
    }

    public void setIU(VisualJugador iu) {
        this.iu = iu;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public Garage getGarage() {
        return garage;
    }

    public Armeria getArmeria() {
        return armeria;
    }

    public Listado<Arma> getArmas() {
        return armas;
    }

    public int getDinero() {
        return dinero;
    }

    public void ingresarArmas() {
        if (armas.getContador() == 0) {
            Arma nueva = new Arma(this);
            armas.agregar(nueva);
            nueva.setNo(armas.getContador());
            if (armas.getContador() < 3) {
                nueva.setComprada(true);
            }
        } else {
            Arma siguiente = new Arma(this);
            siguiente.setNo(armas.getContador() + 1);
            siguiente.setAnterior(armas.getUltimo());
            armas.getUltimo().setPosterior(siguiente);
            armas.agregar(siguiente);
            if (armas.getContador() < 3) {
                siguiente.setComprada(true);
            }
        }
    }

    public VisualJugador getIu() {
        return iu;
    }

    public void setPerdida() {
        this.perdidas++;
    }

    public void setGanada() {
        this.ganadas++;
        experiencia += 300;
        dinero += 350;
        if (experiencia >= experienciaTope) {
            nivel++;
            experienciaTope += 300 * nivel;
            experiencia = 0;
            dinero += 600;
            JOptionPane.showMessageDialog(null, "Ha subido de nivel \n junto a eso suben todas sus caracteristicas!", "nivel+", JOptionPane.OK_OPTION);
        }
    }

    public void setKills() {
        kills++;
    }

    public void setMuertes() {
        muertes++;
    }

    public void comprarObjeto(int valor) {
        if (valor <= dinero) {
            dinero -= valor;
        }
    }

    public int getBots() {
        return bots;
    }
    
    public void agregarBots(){
        bots++;
    }
    
    public void eliminarBots(){
        bots--;
    }
    
}
