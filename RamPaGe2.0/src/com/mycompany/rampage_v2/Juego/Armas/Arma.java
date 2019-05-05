/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Armas;

import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    private double daño, precision;
    private JLabel muestra = new JLabel();
    private ImageIcon imagen;
    private String tipo;
    private Vehiculo dueño;

    public Arma(){
        ingresarImagen();
        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de su vehiculo", null, JOptionPane.QUESTION_MESSAGE);
        iniciarMuestra();
    }
    
    public Arma getAnterior() {
        return a;
    }

    public void setAnterior(Arma a) {
        this.a = a;
    }

    public Arma getPosterior() {
        return p;
    }

    public void setPosterior(Arma p) {
        this.p = p;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public char getPrimerLetra(){
        char[] arreglo = nombre.toCharArray();
        return arreglo[0];
    }
    
    public void iniciarMuestra(){
        muestra.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        muestra.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        muestra.setText(this.getNombre() + " Arma no: " + this.getNo()+ " " + tipo);
    }
    
    public void ingresarImagen(){
        String[] tipos = {"Pistola", "Subfusil", "Bazooka", "FrancoTirador"};
        tipo = (String) JOptionPane.showInputDialog(null, "Que tipo de arma requiere?", "Imagen", JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        if (null != tipo)switch (tipo) {
            case "Pistola":
                imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePequeño.png"));
                muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                break;
            case "Subfusil":
                imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePesado.png"));
                muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                break;
            case "Bazooka":
                imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/Tanque.png"));
                muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                break;
            case "FrancoTirador":
                imagen = new ImageIcon(getClass().getResource("/Imagenes/Vehiculos/TanquePapel.png"));
                muestra.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                break;
        }
        
        if(tipo == null){
            dueño.getArmas().eliminarUltimo();
            dueño.getDueño().getArmas();
        }
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
    
}
