/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.listado.Armeria;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public abstract class Vehiculo extends JLabel {
    
    private Vehiculo a, p;
    protected ImageIcon imagen;
    protected int nivel = 1;
    protected int experiencia = 0;
    protected int experienciaTope = 200;
    protected int No;
    private int kills = 0, muertes = 0;
    protected float vida, daño, defensa, defensaNeta;
    protected JLabel muestra = new JLabel(), muestra2 = new JLabel();
    protected float[] porcentajes;
    private final Listado<Arma> armas = new Listado<>();
    private final Armeria armeria = new Armeria(armas);
    private Arma arma;
    private String nombre;
    private boolean estaActivo = true;
    protected Jugador dueño;
    
    public Vehiculo getAnterior() {
        return a;
    }
    
    public void setAnterior(Vehiculo a) {
        this.a = a;
    }
    
    public Vehiculo getPosterior() {
        return p;
    }
    
    public void setPosterior(Vehiculo p) {
        this.p = p;
    }
    
    public int getNo() {
        return No;
    }
    
    public void setNo(int No) {
        this.No = No;
    }
    
    public void revisarSubirNivel() {
        experienciaTope += 100 * (nivel++);
        vida = (50 * nivel) * porcentajes[0];
    }
    
    public void agregarNombre() {
        this.nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre que desea ponerle a su vehiculo", "Nombre", 1);
        if (nombre == null) {
            dueño.getVehiculos().eliminarUltimo();
        }
    }
    
    public JLabel getMuestra() {
        return muestra;
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
    
    public int getNivel() {
        return nivel;
    }
    
    public int getKills() {
        return kills;
    }
    
    public boolean isEstaActivo() {
        return estaActivo;
    }
    
    public int getMuertes() {
        return muertes;
    }
    
    public abstract void iniciarMuestra();
    
    public abstract void ingresarImagen();    
    
    public Listado<Arma> getArmas() {
        return armas;
    }
    
    public Jugador getDueño() {
        return dueño;
    }
    
    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }
    private JDialog dialogo;
    public JLabel getMuestra2(JDialog dialogo) {
        this.dialogo = dialogo;
        muestra2.setSize(150, 80);
        muestra2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        muestra2.setText(nombre);
        muestra2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarMouseClicked(evt);
            }

            
        });
        return muestra2;
    }
    private void iniciarMouseClicked(MouseEvent evt) {
        
        //evt.getComponent().getParent().getParent().setVisible(false);
        dialogo.setVisible(false);
        dialogo = null;
    }

    public float getVida() {
        return vida;
    }

    public float getDaño() {
        return daño;
    }

    public float getDefensaNeta() {
        return defensaNeta;
    }
}
