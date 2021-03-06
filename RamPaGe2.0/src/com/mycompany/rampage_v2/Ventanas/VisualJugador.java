/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Ventanas;

import com.mycompany.rampage_v2.Juego.Armas.Arma;
import com.mycompany.rampage_v2.Juego.Bibliotecario;
import com.mycompany.rampage_v2.Juego.Jugador;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa4x4;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa6x4;
import com.mycompany.rampage_v2.Juego.Mapas.Mapa8x9;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import com.mycompany.rampage_v2.Juego.listado.Listado;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class VisualJugador extends javax.swing.JFrame {

    /**
     * Creates new form VisualJugador
     */
    private Inicio inicio;
    private Jugador jugador;
    private VisualJuego JUEGO;
    private VisualTienda TIENDA;
    private Bibliotecario biblioteca;

    public VisualJugador(Inicio inicio) {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JUEGO = new VisualJuego(inicio);
        initComponents();
        //iniciarComponentes();
        this.inicio = inicio;
        this.setLocationRelativeTo(null);
        iniciarOyentes();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo inicio.jpg"));
        this.setIconImage(fondo.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        btnjugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlInfo2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblExp = new javax.swing.JLabel();
        btnTienda = new javax.swing.JButton();
        spnlVehiculos = new javax.swing.JScrollPane();
        pnlVehiculos = new javax.swing.JPanel();
        spnlArmas = new javax.swing.JScrollPane();
        pnlArmas = new javax.swing.JPanel();
        pnlVcontrolador = new javax.swing.JPanel();
        btnVcrear = new javax.swing.JButton();
        btnVestado = new javax.swing.JButton();
        btnVFecha = new javax.swing.JButton();
        btnVkills = new javax.swing.JButton();
        btnVnivel = new javax.swing.JButton();
        btnVmuertes = new javax.swing.JButton();
        btnVnombre = new javax.swing.JButton();
        pnlAcontrolador = new javax.swing.JPanel();
        btnAfecha = new javax.swing.JButton();
        btnAnombre = new javax.swing.JButton();
        btnAcrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(1000, 800));

        btnjugar.setFont(new java.awt.Font("DejaVu Serif Condensed", 2, 18)); // NOI18N
        btnjugar.setForeground(new java.awt.Color(0, 153, 153));
        btnjugar.setText("J        U        G        A        R");
        btnjugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjugarMouseClicked(evt);
            }
        });
        btnjugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjugarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("DejaVu Serif Condensed", 2, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 153, 153));
        btnSalir.setText("S A L I R");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnTienda.setBackground(new java.awt.Color(153, 153, 0));
        btnTienda.setText("TIENDA");
        btnTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiendaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInfo2Layout = new javax.swing.GroupLayout(pnlInfo2);
        pnlInfo2.setLayout(pnlInfo2Layout);
        pnlInfo2Layout.setHorizontalGroup(
            pnlInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTienda))
        );
        pnlInfo2Layout.setVerticalGroup(
            pnlInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfo2Layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(btnTienda, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addComponent(btnjugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
            .addComponent(pnlInfo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnjugar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlVehiculos.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnlVehiculosLayout = new javax.swing.GroupLayout(pnlVehiculos);
        pnlVehiculos.setLayout(pnlVehiculosLayout);
        pnlVehiculosLayout.setHorizontalGroup(
            pnlVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        pnlVehiculosLayout.setVerticalGroup(
            pnlVehiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        spnlVehiculos.setViewportView(pnlVehiculos);

        pnlArmas.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlArmasLayout = new javax.swing.GroupLayout(pnlArmas);
        pnlArmas.setLayout(pnlArmasLayout);
        pnlArmasLayout.setHorizontalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        pnlArmasLayout.setVerticalGroup(
            pnlArmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        spnlArmas.setViewportView(pnlArmas);

        pnlVcontrolador.setBackground(new java.awt.Color(0, 153, 153));

        btnVcrear.setText("C     R     E     A     R");
        btnVcrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVcrearMouseClicked(evt);
            }
        });

        btnVestado.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnVestado.setText("Estado");

        btnVFecha.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnVFecha.setText("Fecha");
        btnVFecha.setBorderPainted(false);

        btnVkills.setText("Kills");

        btnVnivel.setText("Nivel");

        btnVmuertes.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnVmuertes.setText("Muertes");

        btnVnombre.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btnVnombre.setText("Nombre");

        javax.swing.GroupLayout pnlVcontroladorLayout = new javax.swing.GroupLayout(pnlVcontrolador);
        pnlVcontrolador.setLayout(pnlVcontroladorLayout);
        pnlVcontroladorLayout.setHorizontalGroup(
            pnlVcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVcontroladorLayout.createSequentialGroup()
                .addGroup(pnlVcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVcontroladorLayout.createSequentialGroup()
                        .addComponent(btnVcrear, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVestado, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVcontroladorLayout.createSequentialGroup()
                        .addComponent(btnVFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVkills, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVmuertes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlVcontroladorLayout.setVerticalGroup(
            pnlVcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVcontroladorLayout.createSequentialGroup()
                .addGroup(pnlVcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVcrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVestado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVkills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVnivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVcontroladorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVmuertes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlAcontrolador.setBackground(new java.awt.Color(204, 204, 204));

        btnAfecha.setText("Fecha");

        btnAnombre.setText(" Nombre");

        btnAcrear.setText("C  R  E  A  R");
        btnAcrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAcrearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAcontroladorLayout = new javax.swing.GroupLayout(pnlAcontrolador);
        pnlAcontrolador.setLayout(pnlAcontroladorLayout);
        pnlAcontroladorLayout.setHorizontalGroup(
            pnlAcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcontroladorLayout.createSequentialGroup()
                .addComponent(btnAfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAcrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAcontroladorLayout.setVerticalGroup(
            pnlAcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAcontroladorLayout.createSequentialGroup()
                .addGroup(pnlAcontroladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAcrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnlArmas, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlAcontrolador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnlVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlVcontrolador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlVcontrolador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnlVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnlArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlAcontrolador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private JDialog dialogo;
    private int mapa;
    private Vehiculo[] elegidos = new Vehiculo[3];

    public void setBiblioteca(Bibliotecario biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void ingresarVehiculo(Vehiculo vehiculo) {
        int z = 0;
        if (vehiculo.isComprada() && vehiculo.isEstaActivo()) {
            while ( z < 3 && elegidos[z] != null) {
                if (elegidos[z] == vehiculo) {
                    break;
                }
                z++;
            }
            if (z < 3) {
                elegidos[z] = vehiculo;
            } else {
                elegidos[0] = elegidos[1];
                elegidos[1] = elegidos[2];
                elegidos[2] = vehiculo;
            }
        }
    }

    public void setElegidos() {
        this.elegidos = null;
        this.elegidos = new Vehiculo[3];
    }
    private void btnjugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjugarMouseClicked
        // TODO add your handling code here:
        if (elegidos[2] != null) {
            dialogo = new JDialog(this, true);
            dialogo.setSize(350, 150);
            dialogo.setResizable(false);
            dialogo.setLayout(null);
            dialogo.setLocationRelativeTo(this);
            JLabel[] mapas = new JLabel[3];
            for (int i = 0; i < mapas.length; i++) {
                mapas[i] = new JLabel();
                dialogo.add(mapas[i]);
                mapas[i].setBounds((110 * i) + 20, 10, 100, 100);
                mapas[i].setBorder(javax.swing.BorderFactory.createTitledBorder(""));
                mapas[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnsmapasMouseClicked(evt);
                    }

                    private void btnsmapasMouseClicked(MouseEvent evt) {
                        JUEGO = new VisualJuego(inicio);
                        Mapa mapa;
                        if (evt.getSource() == mapas[0]) {
                            mapa = new Mapa4x4();
                            JUEGO.setMapa(mapa);
                            dialogo.setVisible(false);
                        } else if (evt.getSource() == mapas[1]) {
                            mapa = new Mapa6x4();
                            JUEGO.setMapa(mapa);
                            dialogo.setVisible(false);
                        } else {
                            mapa = new Mapa8x9();
                            JUEGO.setMapa(mapa);
                            dialogo.setVisible(false);
                        }
                        setVisible(false);
                        dialogo.setVisible(false);
                        JUEGO.setVisible(true);
                        JUEGO.setVehiculos(elegidos);
                        JUEGO.mostrarVehiculos();
                        System.gc();
                    }
                });
            }
            mapas[0].setText(" MAPA 4*4");
            mapas[1].setText(" MAPA 6*4");
            mapas[2].setText(" Mapa 9*8");
            mapas[0].setFont(new java.awt.Font("Comic Sans MS", 1, 13));
            mapas[1].setFont(new java.awt.Font("Comic Sans MS", 1, 13));
            mapas[2].setFont(new java.awt.Font("Comic Sans MS", 1, 13));
            dialogo.setVisible(true);
            //this.setVisible(false);
            //JUEGO.setVisible(true);
            //JUEGO.setMapa(new Mapa6x4());
        } else {
            JOptionPane.showMessageDialog(this, "No puede ingresar, ya que no ha elegido vehiculos", "Error", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btnjugarMouseClicked

    private void btnjugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnjugarActionPerformed

    public Jugador getJugador() {
        return jugador;
    }

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        inicio.setVisible(true);
        inicio.setOrdenado(inicio.getPosicionamiento().ordenarPorFecha());
        jugador.setIU(null);
        jugador.setInicio(null);
        //this.guardarJugador();
        biblioteca.guardarListado(inicio.getJugadores());
        elegidos = null;
//guardar.guardarJugadores(jugador);

    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnAcrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcrearMouseClicked
        // TODO add your handling code here:
        jugador.ingresarArmas();
        jugador.getArmas().getUltimo().getMuestra().setBounds(10, (60 * jugador.getArmas().getContador()) + 10, pnlArmas.getWidth() - 10, 60);
        jugador.getArmas().getUltimo().iniciarMuestra();
        pnlArmas.add(jugador.getArmas().getUltimo().getMuestra());
        armas = null;
        armas = jugador.getArmeria().ordenarPorFecha();
        u = 1;
        iniciarpnlArmas();
    }//GEN-LAST:event_btnAcrearMouseClicked

    private void btnVcrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVcrearMouseClicked
        // TODO add your handling code here:
        jugador.nuevoVehiculo();
        jugador.getVehiculos().getUltimo().getMuestra().setBounds(10, (60 * jugador.getVehiculos().getContador()), pnlVehiculos.getWidth() - 10, 60);
        jugador.getVehiculos().getUltimo().iniciarMuestra();
        pnlVehiculos.add(jugador.getVehiculos().getUltimo().getMuestra());
        vehiculos = null;
        vehiculos = jugador.getGarage().ordenarPorFecha();
        x = 1;
        iniciarPnlVehiculos();
    }//GEN-LAST:event_btnVcrearMouseClicked

    private void btnTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiendaMouseClicked
        // TODO add your handling code here:
        TIENDA = new VisualTienda(inicio, jugador, this);
        TIENDA.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTiendaMouseClicked

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
        elegidos = new Vehiculo[3];
    }

    private int x = 0;

    public void setX(int x) {
        this.x = x;
    }

    public void iniciarPnlVehiculos() {
        pnlVehiculos = new JPanel();
        spnlVehiculos.setViewportView(pnlVehiculos);
        pnlVehiculos.setPreferredSize(new Dimension(spnlVehiculos.getWidth() - 10, jugador.getVehiculos().getContador() * 100));
        pnlVehiculos.setBackground(new java.awt.Color(0, 153, 153));
        //pnlVehiculos.setLayout(null);
        if (x == 0) {
            for (int i = 0; i < vehiculos.length; i++) {
                vehiculos[i].getMuestra().setBounds(10, (60 * i) + 10, pnlVehiculos.getWidth() -20, 60);
                vehiculos[i].iniciarMuestra();
                pnlVehiculos.add(vehiculos[i].getMuestra());
            }
            x = 5;
        } else if (x == 5) {
            int y = vehiculos.length - 1;
            for (int i = 0; i < vehiculos.length; i++) {
                vehiculos[y].getMuestra().setBounds(10, (60 * i) + 10, pnlVehiculos.getWidth(), 60);
                vehiculos[y].iniciarMuestra();
                pnlVehiculos.add(vehiculos[y].getMuestra());
                y--;
            }
            x = 1;
        } else {
            for (int i = 0; i < vehiculos.length; i++) {
                vehiculos[i].getMuestra().setBounds(10, (60 * i) + 10, pnlVehiculos.getWidth(), 60);
                vehiculos[i].iniciarMuestra();
                pnlVehiculos.add(vehiculos[i].getMuestra());
            }
            x = 5;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcrear;
    private javax.swing.JButton btnAfecha;
    private javax.swing.JButton btnAnombre;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTienda;
    private javax.swing.JButton btnVFecha;
    private javax.swing.JButton btnVcrear;
    private javax.swing.JButton btnVestado;
    private javax.swing.JButton btnVkills;
    private javax.swing.JButton btnVmuertes;
    private javax.swing.JButton btnVnivel;
    private javax.swing.JButton btnVnombre;
    private javax.swing.JButton btnjugar;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlAcontrolador;
    private javax.swing.JPanel pnlArmas;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlInfo2;
    private javax.swing.JPanel pnlVcontrolador;
    private javax.swing.JPanel pnlVehiculos;
    private javax.swing.JScrollPane spnlArmas;
    private javax.swing.JScrollPane spnlVehiculos;
    // End of variables declaration//GEN-END:variables

    int u = 0;

    public void iniciarpnlArmas() {
        pnlArmas = new JPanel();
        spnlArmas.setViewportView(pnlArmas);
        pnlArmas.setPreferredSize(new Dimension(spnlArmas.getWidth() - 10, jugador.getArmas().getContador() * 100));
        pnlArmas.setBackground(new java.awt.Color(204, 204, 204));
        if (u == 0) {
            for (int i = 0; i < armas.length; i++) {
                armas[i].getMuestra().setBounds(10, (60 * i) + 10, pnlArmas.getWidth() - 10, 60);
                armas[i].iniciarMuestra();
                pnlArmas.add(armas[i].getMuestra());
            }
            u = 5;
        } else if (u == 5) {
            int y = armas.length - 1;
            for (int i = 0; i < armas.length; i++) {
                armas[y].getMuestra().setBounds(10, (60 * i) + 10, pnlArmas.getWidth(), 60);
                armas[y].iniciarMuestra();
                pnlArmas.add(armas[y].getMuestra());
                y--;
            }
            u = 1;
        } else {
            for (int i = 0; i < armas.length; i++) {
                armas[i].getMuestra().setBounds(10, (60 * i) + 10, pnlArmas.getWidth(), 60);
                armas[i].iniciarMuestra();
                pnlArmas.add(armas[i].getMuestra());
            }
            u = 5;
        }
    }

    public void iniciarComponentes() {
        pnlArmas.setPreferredSize(new Dimension(spnlArmas.getWidth(), spnlArmas.getHeight()));
        lblNombre.setText("Nombre: " + jugador.getNombre());
        lblExp.setText("Exp: " + jugador.getExperiencia());
        lblNivel.setText("Nivel: " + jugador.getNivel());
        lblNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        lblExp.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        lblNivel.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        verificarExperiencia();
        vehiculos = jugador.getGarage().ordenarPorFecha();
        armas = jugador.getArmeria().ordenarPorFecha();
    }

    private void verificarExperiencia() {
        lblExp.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.1) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.1.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.2) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.2.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.3) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.3.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.4) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.4.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.5) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.5.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.6) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.6.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.7) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.7.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.8) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.8.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        } else if (jugador.getExperiencia() / jugador.getExperienciaTope() < 0.9) {
            ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/exp/0.9.jpg"));
            lblExp.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblExp.getWidth() - 100, lblExp.getHeight() - 20, Image.SCALE_SMOOTH)));
            lblExp.setText("Exp: " + jugador.getExperiencia());
        }
    }

    private void iniciarOyentes() {
        btnVFecha.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVestado.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVkills.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVmuertes.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVmuertes.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVnivel.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnVnombre.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarVehiculos(evt);
        });
        btnAfecha.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarArmas(evt);
        });
        btnAnombre.addActionListener((java.awt.event.ActionEvent evt) -> {
            ordenarArmas(evt);
        });
    }

    private Vehiculo[] vehiculos;

    private void ordenarVehiculos(java.awt.event.ActionEvent evt) {
        vehiculos = null;
        if ("fecha".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorFecha();
        } else if ("estado".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorEstado();
        } else if ("kills".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorKills();
        } else if ("muertes".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorMuertes();
        } else if ("nivel".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorNivel();
        } else if ("nombre".equals(evt.getActionCommand().toLowerCase())) {
            vehiculos = jugador.getGarage().ordenarPorNombre();
        }
        //initComponents();
        iniciarPnlVehiculos();
    }

    public JPanel getPnlVehiculos() {
        return pnlVehiculos;
    }

    private Arma[] armas;

    private void ordenarArmas(ActionEvent evt) {
        armas = null;
        if ("fecha".equals(evt.getActionCommand().toLowerCase())) {
            armas = jugador.getArmeria().ordenarPorFecha();
        } else {
            armas = jugador.getArmeria().ordenarPorNombre();
        }
        iniciarpnlArmas();
    }

    public void setU(int u) {
        this.u = u;
    }

    private FileOutputStream salida;
    private ObjectOutputStream guardar;
    private void guardarJugador() {
       try {
            File archivo = new File(Integer.toString(jugador.getNO()) + ".rpg");
            this.salida = new FileOutputStream(archivo);
            this.guardar = new ObjectOutputStream(this.salida);
            guardar.writeObject(jugador);
            guardar.flush();
            guardar.close();
        } catch (IOException ex) {
        }
    }
    public void guardarListado() {
        try {
            File archivo = new File("jugadores.rpg");
            this.salida = new FileOutputStream(archivo);
            this.guardar = new ObjectOutputStream(this.salida);
            guardar.writeObject(inicio.getJugadores());
            guardar.flush();
            guardar.close();
        } catch (IOException ex) {
        }
    }
}
