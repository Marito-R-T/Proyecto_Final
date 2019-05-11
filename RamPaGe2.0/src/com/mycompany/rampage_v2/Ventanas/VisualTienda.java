/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Ventanas;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.awt.Color;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marito
 */
public class VisualTienda extends javax.swing.JFrame {

    private Jugador jugador;
    private Vehiculo[] porcomprar;
    private Arma[] sincomprar;
    private Listado<Arma> armas;
    private Listado<Vehiculo> vehiculos;
    private VisualJugador visual;
    /**
     * Creates new form VisualTienda
     */
    private Inicio inicio;

    public VisualTienda(Inicio inicio, Jugador jugador, VisualJugador visual) {
        this.setLocationRelativeTo(null);
        this.visual = visual;
        this.setResizable(false);
        this.jugador = jugador;
        initComponents();
        this.inicio = inicio;
        revisarArmasPorComprar();
        revisarVehiculosporComprar();
        iniciarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_jugador = new javax.swing.JPanel();
        spnl_vehiculos = new javax.swing.JScrollPane();
        pnl_vehiculos = new javax.swing.JPanel();
        spnl_armas = new javax.swing.JScrollPane();
        pnl_armas = new javax.swing.JPanel();
        pnlBots = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));
        setResizable(false);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout pnl_jugadorLayout = new javax.swing.GroupLayout(pnl_jugador);
        pnl_jugador.setLayout(pnl_jugadorLayout);
        pnl_jugadorLayout.setHorizontalGroup(
            pnl_jugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        pnl_jugadorLayout.setVerticalGroup(
            pnl_jugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_jugador);
        pnl_jugador.setBounds(10, 10, 460, 100);

        pnl_vehiculos.setLayout(null);
        spnl_vehiculos.setViewportView(pnl_vehiculos);

        getContentPane().add(spnl_vehiculos);
        spnl_vehiculos.setBounds(10, 120, 460, 470);

        pnl_armas.setLayout(null);
        spnl_armas.setViewportView(pnl_armas);

        getContentPane().add(spnl_armas);
        spnl_armas.setBounds(480, 10, 310, 400);

        pnlBots.setLayout(null);
        getContentPane().add(pnlBots);
        pnlBots.setBounds(480, 420, 200, 170);

        btn_salir.setText("Salir");
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salirMouseClicked(evt);
            }
        });
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir);
        btn_salir.setBounds(690, 420, 100, 170);
        getContentPane().add(lblfondo);
        lblfondo.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        visual.setVisible(true);
    }//GEN-LAST:event_btn_salirMouseClicked
        JLabel lbl_armeria;
        JLabel lbl_garage;
        JLabel lbl_bots;
    public void iniciarComponentes() {
        lbl_armeria = new JLabel();
        lbl_garage = new JLabel();
        lbl_bots = new JLabel();
        lbl_armeria.setSize(pnl_armas.getSize());
        lbl_garage.setSize(pnl_vehiculos.getSize());
        lbl_bots.setSize(pnlBots.getSize());
        ImageIcon figurita1 = new ImageIcon(getClass().getResource("/Imagenes/tienda.jpg"));
        lblfondo.setIcon(new ImageIcon(figurita1.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST)));
        ImageIcon figurita2 = new ImageIcon(getClass().getResource("/Imagenes/armeria.jpg"));
        lbl_armeria.setIcon(new ImageIcon(figurita2.getImage().getScaledInstance(lbl_armeria.getWidth(), lbl_armeria.getHeight(), Image.SCALE_FAST)));
        ImageIcon figurita3 = new ImageIcon(getClass().getResource("/Imagenes/garage.jpeg"));
        lbl_garage.setIcon(new ImageIcon(figurita3.getImage().getScaledInstance(lbl_garage.getWidth(), lbl_garage.getHeight(), Image.SCALE_FAST)));
        ImageIcon figurita4 = new ImageIcon(getClass().getResource("/Imagenes/bot.png"));
        lbl_bots.setIcon(new ImageIcon(figurita4.getImage().getScaledInstance(lbl_bots.getWidth(), lbl_bots.getHeight(), Image.SCALE_FAST)));
        System.gc();
        pnlBots.add(lbl_bots);
        pnl_armas.add(lbl_armeria);
        pnl_vehiculos.add(lbl_garage);
        lblfondo.setIcon(null);
        lbldinero = new JLabel();
        lbldinero.setBounds(0, 0, pnl_jugador.getWidth(), pnl_jugador.getHeight() / 2);
        lblnombre = new JLabel();
        lblnombre.setBounds(0, pnl_jugador.getHeight() / 2, pnl_jugador.getWidth(), pnl_jugador.getHeight() / 2);
        lblnombre.setText(jugador.getNombre());
        lbldinero.setText("Tiene " + Integer.toString(jugador.getDinero()) + " De Oro");
        lbldinero.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblnombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblnombre.setFont(new java.awt.Font("Comic Sans MS", 1, 30));
        lbldinero.setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        lbldinero.setOpaque(true);
        lbldinero.setBackground(Color.YELLOW);
        lblnombre.setBackground(Color.LIGHT_GRAY);
        pnl_jugador.add(lbldinero);
        pnl_jugador.add(lblnombre);
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JPanel pnlBots;
    private javax.swing.JPanel pnl_armas;
    private javax.swing.JPanel pnl_jugador;
    private javax.swing.JPanel pnl_vehiculos;
    private javax.swing.JScrollPane spnl_armas;
    private javax.swing.JScrollPane spnl_vehiculos;
    // End of variables declaration//GEN-END:variables

    private JLabel lbldinero;
    private JLabel lblnombre;

    private void revisarArmasPorComprar() {
        Arma[] generales = jugador.getArmeria().ordenarPorFecha();
        int x = 0;
        for (int i = 0; i < generales.length; i++) {
            if (!generales[i].isComprada()) {
                //armas.agregar(generales[i]);
                JLabel nuevo = generales[i].getComprar();
                nuevo.setBounds(10, 100 * x + 10, pnl_armas.getWidth() - 20, 100);
                nuevo.setIcon(new ImageIcon(generales[i].getImagen().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                nuevo.setText(generales[i].toString());
                nuevo.setFont(new java.awt.Font("Negrita", 1, 18));
                pnl_armas.add(nuevo);
                x++;
            }
        }
    }

    private void revisarVehiculosporComprar() {
        Vehiculo[] generales = jugador.getGarage().ordenarPorFecha();
        for (int i = 0; i < generales.length; i++) {
            int x = 0;
            if (!generales[i].isComprada()) {
                JLabel nuevo = generales[i].getMuestra2();
                nuevo.setBounds(10, 100 * x + 10, pnl_vehiculos.getWidth() - 20, 100);
                nuevo.setIcon(new ImageIcon(generales[i].getImagen().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                nuevo.setText(generales[i].toString());
                pnl_vehiculos.add(nuevo);
                x++;
            }
        }
    }
}
