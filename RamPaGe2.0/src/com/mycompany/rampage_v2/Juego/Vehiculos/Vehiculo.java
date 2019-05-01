/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public abstract class Vehiculo extends JLabel{

    private Vehiculo a, p;
    protected int nivel = 1;
    protected int experiencia = 0;
    protected int experienciaTope = 200;
    protected int No;
    protected float vida, daño, defensa, defensaNeta;
    private JLabel muestra = new JLabel();
    protected int[] porcentajes;
    private Arma arma;
    private String nombre;

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
        vida = (50 * nivel)*porcentajes[0];
    }
    
    public void agregarNombre(){
        this.nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre que desea ponerle a su vehiculo", "Nombre", 1);
    }

    public JLabel getMuestra() {
        return muestra;
    }

    public String getNombre() {
        return nombre;
    }
    
}
