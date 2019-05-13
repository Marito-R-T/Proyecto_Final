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
import com.mycompany.rampage_v2.Juego.Vehiculos.Avion;
import com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades.CampoBatalla;
import com.mycompany.rampage_v2.Juego.Vehiculos.Capacidades.Volante;
import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Tanque;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Ventanas.VisualJuego;
import java.awt.Color;
import java.util.Random;
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
public class Juego implements Runnable {

    private boolean segano = false, seperdio = false;
    private Vehiculo[] vehiculos;
    private VisualJuego visual;
    private Vehiculo enjuego;
    private Enemigo[] enemigos;
    private Mapa mapa;
    private int bots;

    public Juego(Vehiculo[] vehiculos, VisualJuego visual) {
        this.posibilidades = new JLabel[4];
        this.vehiculos = vehiculos;
        this.visual = visual;
        Random numero = new Random();
    }

    public void setSegano(boolean segano) {
        this.segano = segano;
    }

    public void setSeperdio(boolean seperdio) {
        this.seperdio = seperdio;
    }

    public void setBots(int bots) {
        this.bots = bots;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            empezarelJuego();
            while (!segano && !seperdio) {
                turnopropio();
                revisarComodin();
                revisarVida();
                if (segano || seperdio) {
                    break;
                }
                atacarBot();
                Thread.sleep(800);
                if (!segano && !seperdio) {
                    turnoenemigo();
                    revisarVidaAliada();
                }
                Thread.sleep(200);
            }
            if (segano) {
                ganarPartida();
            } else {
                perderPartida();
            }
            visual.setVisible(false);
            visual.getInicio().getJUGADOR().setVisible(true);
            visual.getInicio().getJUGADOR().iniciarPnlVehiculos();
        } catch (InterruptedException ex) {
        }

    }

    private final Volante movimiento = new Volante();
    private final JLabel[] posibilidades;

    private void revisarComodin() {
        if (enjuego.getPosicion().getCaja() != null) {
            JOptionPane.showMessageDialog(null, "has encontrado un comodin \n presiona el boton del dado \n para saber que te toca :3");
            visual.empezarDado3();
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
                enjuego.setVida((float) (enjuego.getVida() * enjuego.getComodin().recuperarVida()));
                enjuego.setComodin(null);
            } else if(enjuego.getComodin().getNumero() == 3){
                enjuego.setComodin(null);
            }
        }
    }

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
                ingresarBot();
                break;
        }
    }

    private void turnoenemigo() {
        // disparan todos los enemigos, se manda a la clase donde lo haran,
        for (int i = 0; i < enemigos.length; i++) {
            Random numero = new Random();
            int x = numero.nextInt(100) + 1;
            atacar.atacaraAliado(enemigos[i], x);
            System.gc();
        }
    }

    public VisualJuego getVisual() {
        return visual;
    }

    JDialog escoger = new JDialog(visual, true);
    JPanel panel = new JPanel();

    private void empezarelJuego() {
        /*escoger.setSize(new Dimension(300, 400));
         escoger.setLocationRelativeTo(visual);
         escoger.setResizable(false);
         escoger.add(visual.getPnlVehiculos());
         escoger.setVisible(true);*/
        mapa.ingresarEnemigos(enemigos);
        elegirVehiculo();
        mapa.ingresarprimerVehiculo(enjuego);
        //while(escoger.is)
    }

    public void setMapa(Mapa mapa) {
        Random numero = new Random();
        this.mapa = mapa;
        enemigos = new Enemigo[numero.nextInt(3) + mapa.getTopeenemigos()];
    }

    private void elegirVehiculo() {
        //elige el vehiculo con el que empezara aleatoriamente
        Random numerorandom = new Random();
        int randomvehiculo = numerorandom.nextInt(vehiculos.length);
        enjuego = vehiculos[randomvehiculo];
    }

    public void empezarEnemigos() {
        // inicializa a los enemigos
        Random numerorandom = new Random();
        for (int i = 0; i < enemigos.length; i++) {
            int u = numerorandom.nextInt(3);
            int referencia = vehiculos[u].getNivel();
            enemigos[i] = new Enemigo(referencia);
        }
    }

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

    public void moverseVehiculos() {
        /*Thread moverse = new Thread(movimiento);
         moverse.start();*/
        visual.empezarDado6();
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
        //aqui verifico si donde se quedo el vehiculo hay una cajacomodin;
/*        if (enjuego.getPosicion().getCaja() != null) {
         visual.empezarDado3();
         while (visual.getDado().isEstaGirando()) {
         try {
         Thread.sleep(100);
         } catch (InterruptedException ex) {
         Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
         }

         }

         }*/

        //movimiento.colocarFlechas(this);
        /*while (movimiento.getDireccion() == null) {
         }
         movimiento.moverVehiculo(enjuego, visual.getDado().getEscogido());*/
    }

    public Volante getMovimiento() {
        return movimiento;
    }

    private CampoBatalla atacar = new CampoBatalla();

    public void atacarVehiculo() {
        //empiezo el ataque a los enemigos, primero escogiendo a que direccion desea atacar!!!
        visual.empezarDado100();
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
        atacar.setJuego(this);
        atacar.atacaraEnemigo(enjuego, porcentaje, direccion);
    }

    public void cambiarVehiculo() {
        //aqui lo que hare es poner un Joption para que eija el vehiculo que desee
        int x = 0;
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i].getVida() == 0) {
                x++;
            }
        }
        Vehiculo cambiar = null;
        if (x < 2) {
            while (cambiar == null) {
                cambiar = (Vehiculo) JOptionPane.showInputDialog(null, "Que vehiculo desea cambiar", "vehiculo",
                        JOptionPane.INFORMATION_MESSAGE, null, vehiculos, vehiculos[0]);
                if (cambiar != null && (cambiar.getVida() == 0 || cambiar == enjuego)) {
                    cambiar = null;
                }
            }
            if ((cambiar instanceof Tanque && !(enjuego.getPosicion() instanceof Agua)) || (cambiar instanceof Avion && !(enjuego.getPosicion() instanceof Montaña))) {
                enjuego.getPosicion().setVehiculo(null);
                mapa.remove(enjuego);
                cambiar.setPosicion(enjuego.getPosicion());
                enjuego.getPosicion().setVehiculo(cambiar);
                enjuego = cambiar;
                //mapa.add(cambiar);
            } else {
                JOptionPane.showMessageDialog(null, "no se puede cambiar \n ya que esta en un terreno que no puede ingresar");
            }
        } else {
            JOptionPane.showMessageDialog(visual, "No puede cambiar su auto, porque todos estan de baja");
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Vehiculo getEnjuego() {
        return enjuego;
    }

    private void revisarVida() {
        //reviso si los enemigos ya muerieron, para poder ganar
        for (int i = 0; i < enemigos.length; i++) {
            if (enemigos[i].getVida() == 0) {
                mapa.remove(enemigos[i]);
                enemigos[i].getTerreno().setEnemigo(null);
                enemigos[i] = null;
                Enemigo[] nuevos = new Enemigo[enemigos.length - 1];
                int l = 0;
                for (int j = 0; j < enemigos.length; j++) {
                    if (enemigos[j] != null) {
                        nuevos[l] = enemigos[j];
                        l++;
                    }
                }
                enemigos = nuevos;
                break;
            }
        }
        if (enemigos.length == 0) {
            segano = true;
        }
    }

    private void revisarVidaAliada() {
        //se revisa la vida de todos los alidados, cuando el del juego perdio, para ver si se sigue o se perdio;
        if (enjuego.getVida() == 0) {
            int vehiculoderrotado = 0;
            for (int i = 0; i < vehiculos.length; i++) {
                if (vehiculos[i].getVida() == 0) {
                    vehiculoderrotado = i;
                    vehiculos[i].setEstaActivo(false);
                    vehiculos[i].getMuestra().setOpaque(false);
                    vehiculos[i].getMuestra().setBackground(Color.red);
                    vehiculos[i].getPosicion().setVehiculo(null);
                    mapa.remove(enjuego);
                    break;
                }
            }
            seperdio = true;
            /*Vehiculo[] nuevos = new Vehiculo[vehiculos.length - 1];
             int j = 0;
             for (int i = 0; i < nuevos.length; i++) {
             if (vehiculos[i] != null) {
             nuevos[i] = vehiculos[j];
             }
             j++;
             }
             vehiculos = nuevos;*/
        }

    }

    private void perderPartida() {
        visual.getInicio().getJUGADOR().getJugador().setPerdida();
        JOptionPane.showMessageDialog(visual, "Ha perdido \n  Para la siguiente sera!", "perdio", JOptionPane.OK_OPTION);
    }

    private void ganarPartida() {
        visual.getInicio().getJUGADOR().getJugador().setGanada();
        JOptionPane.showMessageDialog(visual, "Ha ganado \n  felicidades, ha ganado: \n experiencia!", "gano", JOptionPane.OK_OPTION);
    }
    private Bot bot;

    private void ingresarBot() {
        if (bots > 0 && bot == null) {
            bots--;
            visual.getInicio().getJUGADOR().getJugador().eliminarBots();
            visual.empezarDado100();
            while (visual.getDado().isEstaGirando()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Bot nuevo = new Bot(visual.getDado().getEscogido());
            bot = nuevo;
            nuevo.setEnjuego(mapa);
            nuevo.setDueño(visual.getInicio().getJUGADOR().getJugador());
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

    /*private boolean hayBots() {
     //sirve para ver si hay bots para usar aun.
     int i = 0;
     for (int j = 0; j < bots.length; j++) {
     if (bots[j] != null && !bots[i].isActivo()) {
     i++;
     }
     /*if (!bots[j].isActivo()) {
     bots[j] = null;
     /*for (int k = 0; k < bots.length; k++) {
     bots[k] = bots[k+1];
     }
     }
     }
     return i != 0;
     }*/
    private void atacarBot() {
        if (bot != null && bot.getTurnos() < 4 && bot.isSepuede()) {
            if (bot.isSepuede()) {
                bot.atacar();
            }
            if (bot.getTurnos() == 3) {
                bot.explotar();
                mapa.remove(bot);
                bot = null;
            }
        }
        mapa.repaint();
    }
}
