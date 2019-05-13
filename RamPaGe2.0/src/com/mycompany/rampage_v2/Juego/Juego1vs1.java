/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego;

import com.mycompany.rampage_v2.Juego.Boots.Bot;
import com.mycompany.rampage_v2.Juego.Comodines.Comodin;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Agua;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Montaña;
import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades.CampoBatalla;
import com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades.Volante;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Ventanas.VisualJuego;
import com.mycompany.rampage_v2.Ventanas.VisualJuego1vs1;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class Juego1vs1 implements Runnable {

    private boolean segano = false, seperdio = false;
    private Vehiculo[] vehiculos1;
    private Vehiculo[] vehiculos2;
    private VisualJuego1vs1 visual;
    private Vehiculo enjuego;
    private Enemigo[] enemigos;
    private Mapa mapa;
    private int bots1, bots2;
    private int turno_general, turno1, turno2;
    private final JLabel[] posibilidades;

    public Juego1vs1(VisualJuego1vs1 visual, Vehiculo[] vehiculos1, Vehiculo[] vehiculos2) {
        this.posibilidades = new JLabel[4];
        this.vehiculos1 = vehiculos1;
        this.vehiculos2 = vehiculos2;
        this.visual = visual;
        this.visual = visual;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            empezarelJuego();
            turno_general = 0;
            turno1 = 0;
            turno2 = 0;
            while (!segano && !seperdio) {
                if (turno1 >= 3) {
                    turno1 = 0;
                }
                if (turno2 >= 3) {
                    turno2 = 0;
                }
                while (vehiculos1[turno1].getVida() == 0) {
                    turno1++;
                }
                enjuego = vehiculos1[turno1];
                turnopropio();
                revisarComodin();
                revisarVidaAliada();
                atacarBot();
                turno_general++;
                turno1++;
                if (segano || seperdio) {
                    break;
                }
                Thread.sleep(800);
                if (!segano && !seperdio) {
                    while (vehiculos2[turno2].getVida() == 0) {
                        turno2++;
                    }
                    enjuego = vehiculos2[turno2];
                    turnopropio();
                    revisarComodin();
                    revisarVidaAliada();
                    atacarBot();
                    turno_general--;
                    turno2++;
                }
                Thread.sleep(200);
            }
            if (seperdio) {
                ganarPartida();
                perderPartida();
            }
            visual.getRegreso().iniciarComponentes();
            visual.getRegreso().empezarJugador1();
            visual.getRegreso().empezarJugador2();
            visual.setVisible(false);
            visual.getRegreso().setVisible(true);
        } catch (InterruptedException ex) {
        }
    }

    private void empezarelJuego() {
        for (int i = 0; i < vehiculos1.length; i++) {
            mapa.ingresarprimerVehiculo(vehiculos1[i]);
        }
        for (int i = 0; i < vehiculos2.length; i++) {
            mapa.ingresarprimerVehiculo(vehiculos2[i]);
        }
        //while(escoger.is)
    }

    public void setSegano(boolean segano) {
        this.segano = segano;
    }

    public void setSeperdio(boolean seperdio) {
        this.seperdio = seperdio;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void setBots(int bots1, int bots2) {
        this.bots1 = bots1;
        this.bots2 = bots2;
    }

    private void revisarComodin() {
        if (enjuego.getPosicion().getCaja() != null) {
            JOptionPane.showMessageDialog(null, "has encontrado un comodin \n presiona el boton del dado \n para saber que te toca :3");
            visual.empezarDado3(turno_general);
            while (visual.getDado().isEstaGirando()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Comodin nuevo = new Comodin(visual.getDado().getEscogido());
            enjuego.setComodin(nuevo);
            enjuego.getPosicion().setComodin(null);
            if (enjuego.getComodin().getNumero() == 1) {
                JOptionPane.showMessageDialog(null, "tu comodin te ha curado! ");
                enjuego.setVida((float) (enjuego.getVida() + enjuego.getVida() * enjuego.getComodin().recuperarVida()));
                enjuego.setComodin(null);
            }else if(enjuego.getComodin().getNumero() == 3){
                enjuego.setComodin(null);
            }
        }
    }

    JDialog escoger = new JDialog(visual, true);

    private void turnopropio() {
        //empieza el turno propio
        empezarPosibilidades();
        escoger.setResizable(false);
        escoger.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        escoger.setVisible(true);
        escoger.setModal(true);
        while (escoger.isVisible()) {
        }
        System.gc();
        switch (accion) {
            case "mover":
                moverseVehiculos();
                break;
            case "atacar":
                atacarVehiculo();
                break;
            case "cambiar":
                cambiarVehiculo();
                break;
            case "bot":
                if (turno_general == 0) {
                    ingresarBot1();
                } else {
                    ingresarBot2();
                }
                break;
        }
    }

    JPanel panel = new JPanel();

    private void empezarPosibilidades() {
        //empiezo la tabla para hacer un movimiento en especifico
        //donde muestro los labels para las diferentes posibilidades
        escoger.setLocationRelativeTo(visual);
        escoger.setSize(420, 490);
        escoger.setTitle("Eliga");
        panel.setLayout(null);
        panel.setSize(420, 490);
        posibilidades[0] = new JLabel();
        posibilidades[0].setText("                 Moverse");
        posibilidades[0].setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        posibilidades[0].setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        posibilidades[0].setBounds(10, 10, 400, 100);
        panel.add(posibilidades[0]);
        posibilidades[0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion = "mover";
                escoger.setVisible(false);
                escoger.setModal(false);
            }

        });
        posibilidades[1] = new JLabel();
        posibilidades[1].setText("                   Atacar");
        posibilidades[1].setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        posibilidades[1].setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        posibilidades[1].setBounds(10, 120, 400, 100);
        panel.add(posibilidades[1]);
        posibilidades[1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion = "atacar";
                escoger.setVisible(false);
                escoger.setModal(false);
            }

        });
        posibilidades[2] = new JLabel();
        posibilidades[2].setText("                  Cambiar");
        posibilidades[2].setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        posibilidades[2].setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        posibilidades[2].setBounds(10, 230, 400, 100);
        panel.add(posibilidades[2]);
        posibilidades[2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion = "cambiar";
                escoger.setVisible(false);
                escoger.setModal(false);
            }

        });
        posibilidades[3] = new JLabel();
        posibilidades[3].setText("               Ingresar Bot");
        posibilidades[3].setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        posibilidades[3].setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        posibilidades[3].setBounds(10, 340, 400, 100);
        panel.add(posibilidades[3]);
        posibilidades[3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accion = "bot";
                escoger.setVisible(false);
                escoger.setModal(false);
            }

        });
        escoger.add(panel);
    }
    private String accion;

    private CampoBatalla atacar = new CampoBatalla();
    private final Volante movimiento = new Volante();
    
    public void moverseVehiculos() {
        /*Thread moverse = new Thread(movimiento);
         moverse.start();*/
        visual.empezarDado6(turno_general);
        while (visual.getDado().isEstaGirando()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] direcciones = {"arriba", "abajo", "derecha", "izquierda"};
        String direccion = null;
        while (direccion == null || "".equals(direccion)) {
            direccion = (String) JOptionPane.showInputDialog(visual, "A que direccion se movera?", "Dirreccion", JOptionPane.INFORMATION_MESSAGE, null, direcciones, direcciones[0]);
        }
        movimiento.moverVehiculo(enjuego, visual.getDado().getEscogido(), direccion);
    }

    public void atacarVehiculo() {
        //empiezo el ataque a los enemigos, primero escogiendo a que direccion desea atacar!!!
        visual.empezarDado100(turno_general);
        while (visual.getDado().isEstaGirando()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] direcciones = {"arriba", "abajo", "derecha", "izquierda"};
        String direccion = null;
        while (direccion == null || "".equals(direccion)) {
            direccion = (String) JOptionPane.showInputDialog(visual, "A que direccion disparara?", "Dirreccion", JOptionPane.INFORMATION_MESSAGE, null, direcciones, direcciones[0]);
        }
        float porcentaje = visual.getDado().getEscogido();
        atacar.atacaraEnemigo(enjuego, porcentaje, direccion);
    }

    public void cambiarVehiculo() {
        //aqui lo que hare es poner un Joption para que eija el vehiculo que desee
        int x = 0;
        if (turno_general == 0) {
            for (int i = 0; i < vehiculos1.length; i++) {
                if (vehiculos1[i].getVida() == 0) {
                    x++;
                }
            }
        } else {
            for (int i = 0; i < vehiculos2.length; i++) {
                if (vehiculos2[i].getVida() == 0) {
                    x++;
                }
            }
        }
        Vehiculo cambiar = null;
        if (x < 2) {
            while (cambiar == null) {
                if (turno_general == 0) {
                    cambiar = (Vehiculo) JOptionPane.showInputDialog(null, "Que vehiculo desea cambiar", "vehiculo",
                            JOptionPane.INFORMATION_MESSAGE, null, vehiculos1, vehiculos1[0]);
                } else {
                    cambiar = (Vehiculo) JOptionPane.showInputDialog(null, "Que vehiculo desea cambiar", "vehiculo",
                            JOptionPane.INFORMATION_MESSAGE, null, vehiculos2, vehiculos2[0]);
                }
                if (cambiar != null && (cambiar.getVida() == 0 || cambiar == enjuego)) {
                    cambiar = null;
                }
            }
            if ((cambiar instanceof Tanque && !(enjuego.getPosicion() instanceof Agua)) || (cambiar instanceof Avion && !(enjuego.getPosicion() instanceof Montaña))) {
                enjuego.getPosicion().setVehiculo(null);
                mapa.remove(enjuego);
                Terreno ref = cambiar.getPosicion();
                cambiar.setPosicion(enjuego.getPosicion());
                enjuego.getPosicion().setVehiculo(cambiar);
                enjuego.setPosicion(ref);
                ref.setVehiculo(enjuego);
                //mapa.add(cambiar);
            } else {
                JOptionPane.showMessageDialog(null, "no se puede cambiar \n ya que esta en un terreno que no puede ingresar");
            }
        } else {
            JOptionPane.showMessageDialog(visual, "No puede cambiar su auto, porque todos estan de baja");
        }
    }

    private void revisarVidaAliada() {
        //se revisa la vida de todos los alidados, cuando el del juego perdio, para ver si se sigue o se perdio;
            int vehiculoderrotado1 = 0;
            int vehiculoderrotado2 = 0;
            for (int i = 0; i < vehiculos1.length; i++) {
                if (vehiculos1[i].getVida() == 0) {
                    vehiculoderrotado1++;
                    vehiculos1[i].setEstaActivo(false);
                    vehiculos1[i].getMuestra().setOpaque(false);
                    vehiculos1[i].getMuestra().setBackground(Color.red);
                    vehiculos1[i].getPosicion().setVehiculo(null);
                    vehiculos1[i].setPosicion(null);
                    mapa.remove(enjuego);
                    break;
                }
            }
            for (int i = 0; i < vehiculos2.length; i++) {
                if (vehiculos1[i].getVida() == 0) {
                    vehiculoderrotado2++;
                    vehiculos2[i].setEstaActivo(false);
                    vehiculos2[i].getMuestra().setOpaque(false);
                    vehiculos2[i].getMuestra().setBackground(Color.red);
                    vehiculos2[i].getPosicion().setVehiculo(null);
                    vehiculos2[i].setPosicion(null);
                    mapa.remove(enjuego);
                    break;
                }
            }
            if(vehiculoderrotado1 >=3 || vehiculoderrotado2 >=3){
                seperdio = true;
            }

    }

    private void perderPartida() {
        if(turno_general == 1){
            enjuego = vehiculos2[0];
        }else{
            enjuego = vehiculos1[0];
        }
        enjuego.getDueño().setMuertes();
        JOptionPane.showMessageDialog(visual, "Ha perdido: " + enjuego.getDueño().getNombre() + "\n  Para la siguiente sera!", "perdio", JOptionPane.OK_OPTION);

    }

    private void ganarPartida() {
        enjuego.getDueño().setKills();
        JOptionPane.showMessageDialog(visual, "Ha ganado: " + enjuego.getDueño().getNombre() + "\n  felicidades, ha ganado: " + visual.getRegreso().getSegundo().getNombre() + "\n experiencia!", "gano", JOptionPane.OK_OPTION);

    }

    private void ingresarBot1() {
        if (bots1 > 0 && bot1 == null) {
            bots1--;
            visual.getRegreso().getPrimero().eliminarBots();

            visual.empezarDado100(0);
            while (visual.getDado().isEstaGirando()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Bot nuevo = new Bot(visual.getDado().getEscogido());
            bot1 = nuevo;
            nuevo.setEnjuego(mapa);
            nuevo.setDueño(visual.getRegreso().getPrimero());
            nuevo.setLanzador(enjuego);
            mapa.addMouseListener(nuevo);
            JOptionPane.showMessageDialog(null, "Escoja en que casilla colocarse");
            while (!nuevo.isEmpezo()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void ingresarBot2() {
        if (bots2 > 0 && bot2 == null ) {
            bots2--;
            visual.getRegreso().getPrimero().eliminarBots();

            visual.empezarDado100(1);
            while (visual.getDado().isEstaGirando()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Bot nuevo = new Bot(visual.getDado().getEscogido());
            bot2 = nuevo;
            nuevo.setEnjuego(mapa);
            nuevo.setDueño(visual.getRegreso().getSegundo());
            mapa.addMouseListener(nuevo);
            JOptionPane.showMessageDialog(null, "Escoja en que casilla colocarse");
            while (!nuevo.isEmpezo()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void atacarBot() {
        if (bot1 != null && bot1.getTurnos() < 4 && bot1.isSepuede()) {
            if (bot1.isSepuede()) {
                bot1.atacar();
            }
            if (bot1.getTurnos() == 3) {
                bot1.explotar();
                mapa.remove(bot1);
                bot1 = null;
            }
        }
        if (bot2 != null && bot2.getTurnos() < 4 && bot2.isSepuede()) {
            if (bot2.isSepuede()) {
                bot2.atacar();
            }
            if (bot2.getTurnos() == 3) {
                bot2.explotar();
                mapa.remove(bot2);
                bot2 = null;
            }
        }
        mapa.repaint();
    }
    private Bot bot1;
    private Bot bot2;
}
