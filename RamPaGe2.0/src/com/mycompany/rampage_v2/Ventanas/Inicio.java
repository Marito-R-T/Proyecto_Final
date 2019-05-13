/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Ventanas;

import com.mycompany.rampage_v2.Juego.Bibliotecario;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.listado.Identificador;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marito
 */
public final class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    private final VisualJugador JUGADOR = new VisualJugador(this);
    private Listado<Jugador> jugadores = new Listado<>();
    private Bibliotecario biblioteca = new Bibliotecario();
    private final Identificador posicionamiento;
    private final VisualJugadores2 VS2 = new VisualJugadores2(this);
    //private final Seleccion seleccion = new Seleccion(jugadores, this);

    public Inicio() {
        initComponents();
        iniciarComponentes();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jugadores = new Listado<>();
        //this.recuperarJugadores();
        // this.jugadores = this.leerListado();
        this.jugadores = biblioteca.leerListado();
        posicionamiento = new Identificador(jugadores);
        ordenado = posicionamiento.ordenarPorFecha();
        JUGADOR.setBiblioteca(biblioteca);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbljuegonuevo = new javax.swing.JLabel();
        lbljuegocargar = new javax.swing.JLabel();
        lblayuda = new javax.swing.JLabel();
        lbl_Versus = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setSize(new java.awt.Dimension(900, 700));

        jPanel1.setLayout(null);

        lbljuegonuevo.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lbljuegonuevo.setForeground(new java.awt.Color(204, 204, 255));
        lbljuegonuevo.setText("  Nuevo");
        lbljuegonuevo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbljuegonuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbljuegonuevoMouseClicked(evt);
            }
        });
        jPanel1.add(lbljuegonuevo);
        lbljuegonuevo.setBounds(370, 160, 180, 90);

        lbljuegocargar.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lbljuegocargar.setForeground(new java.awt.Color(153, 153, 255));
        lbljuegocargar.setText("  Cargar");
        lbljuegocargar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbljuegocargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbljuegocargarMouseClicked(evt);
            }
        });
        jPanel1.add(lbljuegocargar);
        lbljuegocargar.setBounds(370, 260, 180, 90);

        lblayuda.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lblayuda.setForeground(new java.awt.Color(0, 204, 204));
        lblayuda.setText(" Ayuda");
        lblayuda.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblayudaMouseClicked(evt);
            }
        });
        jPanel1.add(lblayuda);
        lblayuda.setBounds(380, 470, 160, 50);

        lbl_Versus.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Versus.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Versus.setForeground(new java.awt.Color(0, 153, 255));
        lbl_Versus.setText("  Versus");
        lbl_Versus.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbl_Versus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_VersusMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_Versus);
        lbl_Versus.setBounds(370, 360, 180, 100);
        jPanel1.add(lblFondo);
        lblFondo.setBounds(0, 0, 900, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Listado<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador[] getOrdenado() {
        return ordenado;
    }

    public void setOrdenado(Jugador[] ordenado) {
        this.ordenado = ordenado;
    }

    public Identificador getPosicionamiento() {
        return posicionamiento;
    }

    private void lbljuegonuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbljuegonuevoMouseClicked
        // TODO add your handling code here:
        try {
            String nombre = "";
            nombre = JOptionPane.showInputDialog(this, "Que nombre tendra su avatar?", "NOMBRE AVATAR", JOptionPane.QUESTION_MESSAGE);
            if (nombre != null && !"".equals(nombre)) {
                if (jugadores.getContador() == 0) {
                    Jugador nuevo = new Jugador(jugadores.getContador() + 1);
                    jugadores.agregar(nuevo);
                    nuevo.setIU(JUGADOR);
                    JUGADOR.setJugador(nuevo);
                } else {
                    Jugador siguiente = new Jugador(jugadores.getContador() + 1);
                    siguiente.setAnterior(jugadores.getUltimo());
                    siguiente.setIU(JUGADOR);
                    jugadores.getUltimo().setPosterior(siguiente);
                    jugadores.agregar(siguiente);
                    JUGADOR.setJugador(siguiente);
                }
                jugadores.getUltimo().setNombre(nombre);
                jugadores.getUltimo().perzonalizarlbl();
                this.setVisible(false);
                JUGADOR.setVisible(true);
                JUGADOR.setJugador(jugadores.getUltimo());
                JUGADOR.iniciarComponentes();
                //JUGADOR.ordenarFecha();
                JUGADOR.setX(0);
                JUGADOR.iniciarPnlVehiculos();
                JUGADOR.setU(0);
                JUGADOR.iniciarpnlArmas();
                biblioteca.guardarListado(jugadores);
            } else if (nombre != null) {
                JOptionPane.showMessageDialog(this, "No puede dejar vacio el nombre", "nombre", 1);
                lbljuegonuevoMouseClicked(evt);
            }
        } catch (Exception e) {
        }

        /*else /*if (!"".equals(nombre)) {
         }*/
    }//GEN-LAST:event_lbljuegonuevoMouseClicked
    public Jugador[] ordenado;
    private void lbljuegocargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbljuegocargarMouseClicked
        // TODO add your handling code here:
        if (jugadores.getContador() != 0) {
            JDialog cargar = new JDialog(this);
            cargar.setLayout(null);
            cargar.setSize(600, 60 * jugadores.getContador() + 120);
            cargar.setResizable(false);
            cargar.setLocationRelativeTo(this);
            cargar.setVisible(true);
            JButton[] botones = new JButton[5];
            for (int i = 0; i < 5; i++) {
                botones[i] = new JButton();
                botones[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        botonesMouseClicked(evt);
                    }

                    public void botonesMouseClicked(MouseEvent evt) {
                        if (evt.getSource() == botones[0]) {
                            ordenado = posicionamiento.ordenarPorFecha();
                        } else if (evt.getSource() == botones[1]) {
                            ordenado = posicionamiento.ordenarPorKills();
                        } else if (evt.getSource() == botones[2]) {
                            ordenado = posicionamiento.ordenarPorMuertes();
                        } else if (evt.getSource() == botones[3]) {
                            ordenado = posicionamiento.ordenarPorNivel();
                        } else if (evt.getSource() == botones[4]) {
                            ordenado = posicionamiento.ordenarPorNombre();
                        }
                        cargar.setVisible(false);
                        System.gc();
                        lbljuegocargarMouseClicked(evt);
                    }
                });
                botones[i].setBounds(((cargar.getWidth() / 5) * i) + 5, (60 * jugadores.getContador()) + 20, cargar.getWidth() / 5 - 10, 60);
                cargar.add(botones[i]);
            }
            botones[0].setText("Por \n Fecha");
            botones[1].setText("Por \n Kills ");
            botones[2].setText("Por \n Muertes ");
            botones[3].setText("Por \n Nivel");
            botones[4].setText("Por \n nombre");
            for (int i = 0; i < ordenado.length; i++) {
                Jugador jugador = ordenado[i];
                jugador.setInicio(this);
                jugador.setIU(JUGADOR);
                jugador.getLblnombre().setBounds(10, (60 * i) + 10, cargar.getWidth() - 20, 60);
                cargar.add(jugador.getLblnombre());
                //cargar.setVisible(false);
            }
            //this.setVisible(false);
        }
        //JUGADOR.setJugador(jugadores.devolver(1));
    }//GEN-LAST:event_lbljuegocargarMouseClicked

    private void lblayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblayudaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblayudaMouseClicked

    private void lbl_VersusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_VersusMouseClicked
        // TODO add your handling code here:
        /*VS2.setIncio(this);
         VS2.setVisible(true);
         this.setVisible(false);*/
        ordenado = posicionamiento.ordenarPorFecha();
        if (jugadores.getContador() >= 2) {
            while (VS2.getPrimero() == null) {
                Jugador jugador = (Jugador) JOptionPane.showInputDialog(this, "Escoja el jugador 1", "VS2", JOptionPane.OK_OPTION, null, ordenado, ordenado[0]);
                VS2.setPrimero(jugador);
            }
            while (VS2.getSegundo() == null || VS2.getSegundo() == VS2.getPrimero()) {
                Jugador jugador = (Jugador) JOptionPane.showInputDialog(this, "Escoja el jugador 2", "VS2", JOptionPane.OK_OPTION, null, ordenado, ordenado[1]);
                VS2.setSegundo(jugador);
            }
            VS2.setVisible(true);
            this.setVisible(false);
            VS2.iniciarComponentes();
            VS2.empezarJugador1();
            VS2.empezarJugador2();
            /*for (int k = 0; k < 2; k++) {
             int m = k;
             JDialog cargar = new JDialog(this);
             cargar.setLayout(null);
             cargar.setSize(600, 60 * jugadores.getContador() + 120);
             cargar.setResizable(false);
             cargar.setLocationRelativeTo(this);
             cargar.setVisible(true);
             JLabel[] vs2 = new JLabel[ordenado.length];
             for (int i = 0; i < ordenado.length; i++) {
             Jugador jugador = ordenado[i];
             jugador.setInicio(this);
             jugador.setIU(JUGADOR);
             vs2[i] = new JLabel();
             jugador.getLblnombre().setBounds(10, (60 * i) + 10, cargar.getWidth() - 20, 60);
             vs2[i].setBounds(10, 10 + (200 * i), cargar.getWidth() - 20, 60);
             vs2[i].setText(jugador.getNombre() + jugador.getNO());
             vs2[i].setForeground(jugador.getLblnombre().getForeground());
             vs2[i].setBorder(jugador.getLblnombre().getBorder());
             vs2[i].setFont(jugador.getLblnombre().getFont());
             cargar.add(vs2[i]);
             vs2[i].addMouseListener(new java.awt.event.MouseAdapter() {
             @Override
             public void mouseClicked(java.awt.event.MouseEvent evt) {
             lblJugadorMouseClicked(evt);
             for (int j = 0; j < vs2.length; j++) {
             if (vs2[j] == evt.getSource()) {
             if (m == 0) {
             VS2.setPrimero(jugadores.devolver(j));
             } else {
             VS2.setSegundo(jugadores.devolver(j));
             VS2.setVisible(true);
             invisibilisarse();
             }
             cargar.setVisible(false);
             break;
             }
             }
             }

             private void lblJugadorMouseClicked(MouseEvent evt) {
             VS2.setVisible(true);
             cargar.setVisible(false);
             cargar.setModal(false);
             }
             });
             //cargar.setVisible(false);
             }

             /*while (cargar.isVisible()) {
             try {
             Thread.sleep(200);
             } catch (Exception e) {
             }
             }
             }*/

        }
    }//GEN-LAST:event_lbl_VersusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lbl_Versus;
    private javax.swing.JLabel lblayuda;
    private javax.swing.JLabel lbljuegocargar;
    private javax.swing.JLabel lbljuegonuevo;
    // End of variables declaration//GEN-END:variables

    public Inicio referenciarse() {
        return this;
    }

    public void invisibilisarse() {
        this.setVisible(false);
    }

    private void iniciarComponentes() {
        //ImageIcon fondo = new ImageIcon("/home/marito/Documentos/Proyecto_Final/RamPaGe_v2/src/main/java/Imagenes/Fondo inicio.jpg"); //Ubuntu
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo inicio.jpg"));
        //ImageIcon fondo = new ImageIcon("C:\\Users\\50254\\Documents\\Proyecto_Final\\RamPaGe_2.0\\src\\Imagenes\\Fondo inicio.jpg"); //Windows
        lblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(fondo.getImage());
    }

    public VisualJugador getJUGADOR() {
        return JUGADOR;
    }

    /*public void recuperarJugadores() {
     try {
     int x = 1;
     File archivo = new File(Integer.toString(x) + ".rpg");
     //JOptionPane.showMessageDialog(null, archivo.exists());
     this.entrada = new FileInputStream(Integer.toString(x) + ".rpg");
     this.lectura = new ObjectInputStream(entrada);
     Jugador nuevo = (Jugador) lectura.readObject();
     lectura.close();
     jugadores.agregar(nuevo);
     x++;
     archivo = new File(Integer.toString(x) + ".rpg");
     } catch (FileNotFoundException ex) {
     } catch (IOException | ClassNotFoundException ex) {
     }
     }*/
    public Listado<Jugador> leerListado() {
        Listado<Jugador> prueba = new Listado<>();
        try {
            File archivo = new File("jugadores.rpg");
            FileInputStream entrada = new FileInputStream(archivo);
            try (ObjectInputStream lectura = new ObjectInputStream(entrada)) {
                prueba = (Listado<Jugador>) lectura.readObject();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
        return prueba;
    }
}
