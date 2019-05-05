/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Juego.*;
import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Juego.listado.Armeria;
import com.mycompany.rampage_v2.Juego.listado.Garage;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import com.mycompany.rampage_v2.Ventanas.Inicio;
import com.mycompany.rampage_v2.Ventanas.VisualJugador;
import java.awt.event.MouseEvent;
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
    private String nombre;
    private VisualJugador iu;
    private Inicio inicio;
    private final Listado<Vehiculo> vehiculos;
    private final Garage garage;
    private final Listado<Arma> armas;
    private final Armeria armeria;
    private int nivel, experiencia, experienciaTope, kills, muertes;

    public Jugador(int no) {
        vehiculos = new Listado<>();
        garage = new Garage(vehiculos);
        armas = new Listado<>();
        armeria = new Armeria(armas);
        NO = no;
        ingresarVehiculos();
        ingresarArmas();
        nivel = 1;
        experiencia = 0;
        experienciaTope = 300;
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

    public void setPosterior(Jugador posterior) {
        this.p = posterior;
    }

    public int getNO() {
        return NO;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void perzonalizarlbl() {
        lblnombre.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        lblnombre.setText(nombre);
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblnombre.setForeground(new java.awt.Color(0, 204, 204));
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

    private void ingresarVehiculos() {
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Seguidamente seleccionara cuantos puntes le dejara a \n 1. Vida, 2. Ataque, 3. Defensa,  4. Especialidad del tipo de vehiculo");
            int[] porcentajes = new int[4];
            for (int j = 0; j < 4; j++) {
                int lleva = 0;

                for (int l = 0; l < porcentajes.length; l++) {
                    lleva += porcentajes[l];
                }
                Integer[] enteros = new Integer[13 - lleva];
                for (int k = 0; k < enteros.length; k++) {
                    enteros[k] = k;
                }

                porcentajes[j] = (int) JOptionPane.showInputDialog(null, "", "puntos a la caracteristica: " + (j + 1), 1, null, enteros, enteros[0]);
            }
            if (i == 0) {
                Vehiculo primero = new Avion(porcentajes);
                primero.setNo(1);
                vehiculos.agregar(primero);
                primero.agregarNombre();
                primero.ingresarImagen();
                JOptionPane.showMessageDialog(null, "Se ha creado su avion");
            } else {
                Vehiculo siguiente = new Tanque(porcentajes);
                siguiente.setNo(vehiculos.getContador() + 1);
                siguiente.setAnterior(vehiculos.getUltimo());
                vehiculos.getUltimo().setPosterior(siguiente);
                vehiculos.agregar(siguiente);
                siguiente.agregarNombre();
                siguiente.ingresarImagen();
                JOptionPane.showMessageDialog(null, "Se ha creado su tanque");
            }
        }
    }

    public void nuevoVehiculo() {
        int[] porcentajes = new int[4];
        int lleva = 0;
        for (int j = 0; j < 4; j++) {
            for (int l = 0; l < porcentajes.length; l++) {
                lleva += porcentajes[l];
            }
            Integer[] enteros = new Integer[12 - lleva];
            for (int i = 0; i < enteros.length; i++) {
                enteros[i] = i + 1;
            }
            porcentajes[j] = (int) JOptionPane.showInputDialog(null, "Cuantos puntos desea en la vida", "punteos", 1, null, enteros, enteros[0]);
        }
        Vehiculo primero = new Avion(porcentajes);
        vehiculos.agregar(primero);
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
        iu.iniciarPnlVehiculos();
    }

    public void setIU(VisualJugador iu) {
        this.iu = iu;
    }
    
    public void setInicio(Inicio inicio){
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

    private void ingresarArmas() {
        if(armas.getContador() == 0){
        Arma nueva = new Arma();
        armas.agregar(nueva);
        }else{
            Arma siguiente = new Arma();
            armas.agregar(siguiente);
        }
    }

    public VisualJugador getIu() {
        return iu;
    }
    
}
