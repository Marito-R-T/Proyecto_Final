/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Armas;

import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public class Arma {

    private Arma a, p;
    private int No;
    private String nombre;
    private float daño, precision;
    private JLabel muestra = new JLabel(), comprar = new JLabel();
    private ImageIcon imagen;
    private String tipo;
    private Vehiculo dueño;
    private Jugador jugador;
    private boolean enuso = false;
    private boolean comprada = false;
    private int precio;

    public Arma(Jugador jugador) {
        this.jugador = jugador;
        muestra.setOpaque(true);
        muestra.setBackground(Color.red);
        ingresarImagen();
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de su Arma", null, JOptionPane.QUESTION_MESSAGE);
        iniciarMuestra();
        comprar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComprarMouseClicked(evt);
            }

        });
    }

    public String getTipo() {
        return tipo;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public Arma getAnterior() {
        return a;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setAnterior(Arma a) {
        this.a = a;
    }

    public Vehiculo getDueño() {
        return dueño;
    }

    public Arma getPosterior() {
        return p;
    }

    public void setPosterior(Arma p) {
        this.p = p;
    }

    public String getNombre() {
        return nombre;
    }

    public char getPrimerLetra() {
        char[] arreglo = nombre.toCharArray();
        if (arreglo.length == 0) {
            String devolver = "a";
            return devolver.toCharArray()[0];
        }
        return arreglo[0];
    }

    public void iniciarMuestra() {
        muestra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        muestra.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        muestra.setText(this.getNombre() + " Arma no: " + this.getNo() + " " + tipo);
        muestra.setToolTipText("Es un/a " + tipo + " \n tiene de daño " + daño + " \n tiene de presicion: " + ((precision - 1) * 100));
        muestra.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muestraMouseClicked(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                muestraMouseExited(evt);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                muestraMouseEntered(evt);
            }
        });
    }

    public void ingresarImagen() {
        //setNo(dueño.getDueño().getArmas().getContador());
        String[] tipos = {"Pistola", "Subfusil", "Bazooka", "FrancoTirador"};
        tipo = (String) JOptionPane.showInputDialog(null, "Que tipo de arma requiere?", "Imagen", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        if (null != tipo) {
            switch (tipo) {
                case "Pistola":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Armas/pistola.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    daño = 5;
                    precision = (float) 1.6;
                    precio = 100;
                    break;
                case "Subfusil":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Armas/subfusil.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    daño = 7;
                    precision = (float) 1.5;
                    precio = 120;
                    break;
                case "Bazooka":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Armas/bazooka.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    daño = 10;
                    precision = (float) 1.6;
                    precio = 160;
                    break;
                case "FrancoTirador":
                    imagen = new ImageIcon(getClass().getResource("/Imagenes/Armas/francotirador.png"));
                    muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                    daño = 14;
                    precision = (float) 1.8;
                    precio = 220;
                    break;
            }
        }

        if (tipo == null) {
            dueño.getArmas().eliminarUltimo();
            dueño.getDueño().getArmas();
        }
    }

    public void setNo(int No) {
        this.No = No;
    }

    public int getNo() {
        return No;
    }

    public JLabel getMuestra() {
        return muestra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void muestraMouseClicked(MouseEvent evt) {
        if (comprada && !enuso) {
            Vehiculo[] vehiculos = jugador.getGarage().ordenarPorFecha();
            Vehiculo vehiculo = (Vehiculo) JOptionPane.showInputDialog(null, "A que vehiculo deseas ingresarlo", "vehiculo",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)), vehiculos, vehiculos[0]);
            if (vehiculo != null) {
                vehiculo.ingresarArma(this);
                enuso = true;
            }
        }
    }

    private void muestraMouseExited(MouseEvent evt) {
    }

    private void muestraMouseEntered(MouseEvent evt) {
    }

    public boolean isEnuso() {
        return enuso;
    }

    public void setEnuso(boolean enuso) {
        this.enuso = enuso;
    }

    public boolean isComprada() {
        return comprada;
    }

    public void setComprada(boolean comprada) {
        muestra.setOpaque(true);
        muestra.setBackground(Color.CYAN);
        this.comprada = comprada;
    }

    public float dañoHecho() {
        float dañototal = daño * precision;
        return dañototal;
    }

    public String toString() {
        return "nombre: " + nombre + "No: " + tipo + "de tipo: " + tipo;
    }

    public JLabel getComprar() {
        return comprar;
    }

    private void ComprarMouseClicked(MouseEvent evt) {
        if(jugador.getDinero() > precio){
            if(JOptionPane.showConfirmDialog(comprar, "seguro quiere comprar esta arma?") == 1){
            setComprada(true);
            jugador.comprarObjeto(precio);
            }
        }
    }
}
