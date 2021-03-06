/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Vehiculos;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Comodines.Comodin;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Montaña;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.listado.Armeria;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public abstract class Vehiculo extends JLabel implements Serializable {

    private Vehiculo a, p;
    protected ImageIcon imagen;
    protected int nivel = 1;
    protected int experiencia = 0;
    protected int experienciaTope = 200;
    protected int No;
    private int kills = 0, muertes = 0;
    protected float vida, daño, defensa, defensaNeta;
    protected float vidatope;
    protected JLabel muestra = new JLabel(), muestra2 = new JLabel();
    protected float[] porcentajes;
    private final Listado<Arma> armas = new Listado<>();
    private final Armeria armeria = new Armeria(armas);
    private String nombre;
    private boolean estaActivo = true, Comprada = false;
    protected Jugador dueño;
    private Terreno posicion;
    protected int precio;
    private Comodin comodin;

    public boolean isComprada() {
        return Comprada;
    }

    public void setComodin(Comodin comodin) {
        this.comodin = comodin;
    }

    public void setComprada(boolean Comprada) {
        muestra.setOpaque(true);
        muestra.setBackground(Color.LIGHT_GRAY);
        this.Comprada = Comprada;
    }

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
        vida = ( 50 * (1+(porcentajes[0]/12)));
    }

    public void agregarNombre() {
        this.nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre que desea ponerle a su vehiculo", "Nombre", 1);
        this.setToolTipText("mi dueño es: "+ dueño.getNombre() + "\n No: " + dueño.getNO());
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

    public void setKills() {
        this.kills ++;
    }

    public void setMuertes() {
        this.muertes ++;
    }

    public abstract void iniciarMuestra();

    public abstract void ingresarImagen();

    public Listado<Arma> getArmas() {
        return armas;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    public JLabel getMuestra2() {
        muestra2.setSize(400, 100);
        muestra2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComprarVehiculo(evt);
            }
        });
        muestra2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        muestra2.setText(nombre);
        muestra2.setText(" vida: " + Integer.toString((int) vida));
        muestra2.setText(" daño: " + Integer.toString((int) daño));
        muestra2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        muestra2.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        return muestra2;
    }

    public float getVida() {
        return vida;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public Comodin getComodin() {
        return comodin;
    }

    public void setVida(float vida) {
        if (vida <= vidatope) {
            this.vida = vida;
        }
    }

    public float getDaño() {
        float dañocomodin = 0;
        if (comodin != null) {
            if (comodin.getNumero() == 2 && "ataque".equals(comodin.getDecision())) {
                JOptionPane.showMessageDialog(null, "tu comodin te esta dando daño extra!! ");
                dañocomodin = daño * (float) comodin.maximizarDañoEscudo();
                if(comodin.getX() >=3){
                    comodin = null;
                }
            }
        }
        float dañoarma = 0;
        Arma[] listadoarmas = armeria.ordenarPorFecha();
        if (listadoarmas.length != 0) {
            Arma armaAusar = (Arma) JOptionPane.showInputDialog(null, "Escoja arma para hacer daño", "Arma", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)), listadoarmas, listadoarmas[0]);
            if (armaAusar != null) {
                dañoarma = armaAusar.dañoHecho();
            }
        }
        return dañoarma + this.daño + dañocomodin;
    }

    public float getDañoEnemigos() {
        return daño;
    }

    public float getDefensaNeta() {
        return defensaNeta;
    }

    public void setPosicion2(Terreno posicion) {
        this.posicion = posicion;
    }

    public boolean setPosicion(Terreno posicion) {
        if (((this instanceof Tanque && !(posicion instanceof Agua)) || (this instanceof Avion && !(posicion instanceof Montaña))) && posicion != null) {
            this.posicion = posicion;
            this.setBounds(((this.posicion.getColumnas() - 1) * 200) + 10, (((this.posicion.getFilas() - 1) * 200) + 10), 200, 200);
            this.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
            this.posicion.getMapa().agregarComponente(this);
            return true;
        }
        if (posicion == null) {
            this.posicion = posicion;
        }
        return false;
    }

    public Terreno getPosicion() {
        return posicion;
    }

    public void mostrarMouseClicked(MouseEvent evt) {
        dueño.getIu().ingresarVehiculo(this);
        JOptionPane.showMessageDialog(null, "   daño:   " + daño
                + " \n     vida:  " + vida + " \n     defensa: " + defensaNeta + " \n Activo: "
                + estaActivo + "\n Kills: " + kills, nombre, JOptionPane.INFORMATION_MESSAGE);
    }

    public void dañadoporBot(float daño){
        if(daño > vida){
            vida = 0;
        } else{
            vida -= daño;
        }
    }
    
    public void serDañado(float daño) {
        float escudocomodin = 0;
        if (comodin != null) {
            if (comodin.getNumero() == 2 && "defensa".equals(comodin.getDecision())) {
                JOptionPane.showMessageDialog(null, "tu comodin te esta protegiendo mas!! ");
                escudocomodin = defensa * (float) comodin.maximizarDañoEscudo();
            }
        }
        if (daño > this.defensa) {
            if (daño > vida + defensa +escudocomodin) {
                vida = 0;
                dueño.setMuertes();
                estaActivo = false;
                muestra.setOpaque(true);
                muestra.setBackground(Color.red);
            } else {
                if (defensa + escudocomodin < daño) {
                    vida -= (daño - defensa - escudocomodin);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "he sido dañado  "+ nombre+" \n cuidado pueden matarme,"
                + " \n  me has quitado: " + daño + "  de vida! \n y mi vida total es de: " + vidatope + " \n ahorita tengo: " + vida + " \n defensa: " + defensa);

    }

    public void setExperiencia() {
        kills++;
        dueño.setKills();
        this.experiencia += 200;
        if (experiencia >= experienciaTope) {
            nivel++;
            experienciaTope += 200 * nivel;
            experiencia = 0;
            revisarSubirNivel();
            JOptionPane.showMessageDialog(null, "Tu vehiculo " + nombre + "a subido de nivel!", "nivel+", JOptionPane.OK_OPTION);
        }
    }

    public void ingresarArma(Arma arma) {
        armas.agregar(arma);
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + "No. " + No;
    }

    private void ComprarVehiculo(MouseEvent evt) {
        if (dueño.getDinero() > precio) {
            if (JOptionPane.showConfirmDialog(muestra2, "seguro quiere comprar este vehiculo?", toString(), JOptionPane.OK_OPTION) == 0) {
                setComprada(true);
                dueño.comprarObjeto(precio);
            }
        }
    }

    public void ingresarPrecio() {
        int lleva = 0;
        lleva += porcentajes[0] * 50 + (porcentajes[1]);
        precio = lleva;
    }

    public abstract String getTipo();
}
