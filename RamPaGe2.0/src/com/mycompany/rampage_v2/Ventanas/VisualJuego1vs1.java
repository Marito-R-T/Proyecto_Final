/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Ventanas;

import com.mycompany.rampage_v2.Juego.Dados.D100;
import com.mycompany.rampage_v2.Juego.Dados.D3;
import com.mycompany.rampage_v2.Juego.Dados.D6;
import com.mycompany.rampage_v2.Juego.Dados.Dado;
import com.mycompany.rampage_v2.Juego.Juego;
import com.mycompany.rampage_v2.Juego.Juego1vs1;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class VisualJuego1vs1 extends javax.swing.JFrame {

    /**
     * Creates new form VisualJuego1vs1
     */
    private VisualJugadores2 regreso;
    private Mapa mapa;
    private Vehiculo[] vehiculos1;
    private Vehiculo[] vehiculos2;
    private Juego1vs1 backendjuego;
    private Dado dado;

    public VisualJuego1vs1(VisualJugadores2 regreso) {
        this.regreso = regreso;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnl_Mapa = new javax.swing.JScrollPane();
        pnl_Dado2 = new javax.swing.JPanel();
        spnlVehiculos2 = new javax.swing.JScrollPane();
        pnl_Vehiculos2 = new javax.swing.JPanel();
        pnl_Dado1 = new javax.swing.JPanel();
        spnl_Vehiculos1 = new javax.swing.JScrollPane();
        pnl_Vehiculos1 = new javax.swing.JPanel();
        btn_rendirse1 = new javax.swing.JButton();
        btn_rendirse2 = new javax.swing.JButton();
        btn_Dado2 = new javax.swing.JButton();
        btn_dado2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 650));
        setPreferredSize(new java.awt.Dimension(1100, 650));
        setResizable(false);

        pnl_Dado2.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout pnl_Dado2Layout = new javax.swing.GroupLayout(pnl_Dado2);
        pnl_Dado2.setLayout(pnl_Dado2Layout);
        pnl_Dado2Layout.setHorizontalGroup(
            pnl_Dado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_Dado2Layout.setVerticalGroup(
            pnl_Dado2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_Vehiculos2Layout = new javax.swing.GroupLayout(pnl_Vehiculos2);
        pnl_Vehiculos2.setLayout(pnl_Vehiculos2Layout);
        pnl_Vehiculos2Layout.setHorizontalGroup(
            pnl_Vehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        pnl_Vehiculos2Layout.setVerticalGroup(
            pnl_Vehiculos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        spnlVehiculos2.setViewportView(pnl_Vehiculos2);

        pnl_Dado1.setBackground(new java.awt.Color(153, 0, 255));

        javax.swing.GroupLayout pnl_Dado1Layout = new javax.swing.GroupLayout(pnl_Dado1);
        pnl_Dado1.setLayout(pnl_Dado1Layout);
        pnl_Dado1Layout.setHorizontalGroup(
            pnl_Dado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_Dado1Layout.setVerticalGroup(
            pnl_Dado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_Vehiculos1Layout = new javax.swing.GroupLayout(pnl_Vehiculos1);
        pnl_Vehiculos1.setLayout(pnl_Vehiculos1Layout);
        pnl_Vehiculos1Layout.setHorizontalGroup(
            pnl_Vehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );
        pnl_Vehiculos1Layout.setVerticalGroup(
            pnl_Vehiculos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        spnl_Vehiculos1.setViewportView(pnl_Vehiculos1);

        btn_rendirse1.setText("Rendirse");
        btn_rendirse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rendirse1MouseClicked(evt);
            }
        });

        btn_rendirse2.setText("Rendirse");
        btn_rendirse2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rendirse2MouseClicked(evt);
            }
        });

        btn_Dado2.setText("stop2");
        btn_Dado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Dado2MouseClicked(evt);
            }
        });

        btn_dado2.setText("stop1");
        btn_dado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dado2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnl_Vehiculos1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnl_Dado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_rendirse1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnl_Mapa, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spnlVehiculos2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnl_Dado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Dado2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_rendirse2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnl_Dado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnl_Vehiculos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_rendirse1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(btn_dado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(spnl_Mapa)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_Dado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnlVehiculos2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Dado2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(btn_rendirse2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Dado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Dado2MouseClicked
        // TODO add your handling code here:
        if (dado != null) {
            dado.parardeGirar();
            dado.setEstaGirando(false);
            pnl_Dado1.removeAll();
            pnl_Dado1.repaint();
        }
    }//GEN-LAST:event_btn_Dado2MouseClicked

    private void btn_dado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dado2MouseClicked
        // TODO add your handling code here:
        if (dado != null) {
            dado.parardeGirar();
            dado.setEstaGirando(false);
            pnl_Dado2.removeAll();
            pnl_Dado2.repaint();
        }
    }//GEN-LAST:event_btn_dado2MouseClicked

    private void btn_rendirse1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rendirse1MouseClicked
        // TODO add your handling code here:
        try {
            if(dado != null && dado.isEstaGirando()){
                dado.setEstaGirando(false);
            }
            backendjuego.setSeperdio(true);
            regreso.getPrimero().setMuertes();
            this.setVisible(false);
            regreso.setVisible(true);
            regreso.iniciarComponentes();
            regreso.empezarJugador1();
            regreso.empezarJugador2();
            juego.interrupt();
            //juego = null;

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_rendirse1MouseClicked

    private Thread juego;
    private void btn_rendirse2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rendirse2MouseClicked
        // TODO add your handling code here:
         try {
            if(dado != null && dado.isEstaGirando()){
                dado.setEstaGirando(false);
            }
            backendjuego.setSeperdio(true);
            regreso.getSegundo().setMuertes();
            this.setVisible(false);
            regreso.setVisible(true);
            regreso.iniciarComponentes();
            regreso.empezarJugador1();
            regreso.empezarJugador2();
            //juego.interrupt();
            //juego = null;

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_rendirse2MouseClicked

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
        spnl_Mapa.setViewportView(this.mapa);
    }

    public Vehiculo[] getVehiculos1() {
        return vehiculos1;
    }

    public void setVehiculos1(Vehiculo[] vehiculos1) {
        this.vehiculos1 = vehiculos1;
    }

    public Vehiculo[] getVehiculos2() {
        return vehiculos2;
    }

    public void setVehiculos2(Vehiculo[] vehiculos2) {
        this.vehiculos2 = vehiculos2;
    }

    public void empezarDado3(int i) {
        dado = new D3();
        dado.setSize(pnl_Dado1.getWidth(), pnl_Dado1.getHeight());
        if (i == 0) {
            pnl_Dado1.removeAll();
            pnl_Dado1.add(dado);
        } else {
            pnl_Dado2.removeAll();
            pnl_Dado2.add(dado);
        }
        dado.setEstaGirando(true);
        Thread hilo = new Thread(dado);
        hilo.start();
    }

    public void empezarDado6(int i) {
        dado = new D6();
        dado.setSize(pnl_Dado1.getWidth(), pnl_Dado1.getHeight());
        if (i == 0) {
            pnl_Dado1.removeAll();
            pnl_Dado1.add(dado);
        } else {
            pnl_Dado2.removeAll();
            pnl_Dado2.add(dado);
        }
        dado.setEstaGirando(true);
        Thread hilo = new Thread(dado);
        hilo.start();
    }

    public void empezarDado100(int i) {
        dado = new D100();
        dado.setSize(pnl_Dado1.getWidth(), pnl_Dado1.getHeight());
        if (i == 0) {
            pnl_Dado1.removeAll();
            pnl_Dado1.add(dado);
        } else {
            pnl_Dado2.removeAll();
            pnl_Dado2.add(dado);
        }
        dado.setEstaGirando(true);
        Thread hilo = new Thread(dado);
        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dado2;
    private javax.swing.JButton btn_dado2;
    private javax.swing.JButton btn_rendirse1;
    private javax.swing.JButton btn_rendirse2;
    private javax.swing.JPanel pnl_Dado1;
    private javax.swing.JPanel pnl_Dado2;
    private javax.swing.JPanel pnl_Vehiculos1;
    private javax.swing.JPanel pnl_Vehiculos2;
    private javax.swing.JScrollPane spnlVehiculos2;
    private javax.swing.JScrollPane spnl_Mapa;
    private javax.swing.JScrollPane spnl_Vehiculos1;
    // End of variables declaration//GEN-END:variables

    public void mostrarVehiculos() {
        spnl_Vehiculos1.setViewportView(pnl_Vehiculos1);
        pnl_Vehiculos1.setPreferredSize(new Dimension(400, 200));
        pnl_Vehiculos1.setBackground(new java.awt.Color(204, 204, 204));
        int i = 0;
        for (Vehiculo vehiculo : vehiculos1) {
            vehiculo.getMuestra().setBounds(10, (60 * i) + 10, pnl_Vehiculos1.getWidth(), 60);
            vehiculo.iniciarMuestra();
            pnl_Vehiculos1.add(vehiculo.getMuestra());
            i++;
        }
        spnlVehiculos2.setViewportView(pnl_Vehiculos2);
        spnlVehiculos2.setPreferredSize(new Dimension(400, 200));
        spnlVehiculos2.setBackground(new java.awt.Color(204, 204, 204));
        int y = 0;
        for (Vehiculo vehiculo : vehiculos2) {
            vehiculo.getMuestra().setBounds(10, (60 * y) + 10, pnl_Vehiculos2.getWidth(), 60);
            vehiculo.iniciarMuestra();
            pnl_Vehiculos2.add(vehiculo.getMuestra());
            y++;
        }
    }
    public void setVehiculos(Vehiculo[] vehiculos1, Vehiculo[] vehiculos2) {
        this.vehiculos1 = vehiculos1;
        this.vehiculos2 = vehiculos2;
        mostrarVehiculos();
        backendjuego = new Juego1vs1(this, vehiculos1, vehiculos2);
        backendjuego.setMapa(mapa);
        backendjuego.setBots(regreso.getPrimero().getBots(), regreso.getSegundo().getBots());
        //pnl_Dado1.add(dado);
        //pnl_Dado2.add(dado);
        //dado.setBounds(0, 0, pnl_Dado1.getWidth(), pnl_Dado1.getHeight());
        Thread juego = new Thread(backendjuego);
        backendjuego.setSeperdio(false);
        juego.start();
    }

    public Dado getDado() {
        return dado;
    }

    public VisualJugadores2 getRegreso() {
        return regreso;
    }
}