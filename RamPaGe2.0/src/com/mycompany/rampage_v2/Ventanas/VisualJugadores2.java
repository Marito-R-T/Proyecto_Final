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
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marito
 */
public class VisualJugadores2 extends javax.swing.JFrame {

    private Inicio inicio;
    private Jugador primero;
    private Jugador segundo;
    private  Vehiculo[] vehiculos1;
    private Vehiculo[] vehiculos2;
    private final VisualJuego1vs1 jugar;
    private Bibliotecario biblioteca;
    private VisualTienda tienda;

    /**
     * Creates new form VisualJugadores2
     *
     * @param inicio
     */
    public VisualJugadores2(Inicio inicio) {
        // modelo.
        jugar = new VisualJuego1vs1(this);
        vehiculos1 = new Vehiculo[3];
        vehiculos2 = new Vehiculo[3];
        this.inicio = inicio;
        initComponents();
        iniciarComponentes();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("VS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugador2 = new javax.swing.JPanel();
        jugador1 = new javax.swing.JPanel();
        btn_Tienda2 = new javax.swing.JButton();
        btn_Tienda1 = new javax.swing.JButton();
        spnl_Armas2 = new javax.swing.JScrollPane();
        info_Armas2 = new javax.swing.JTable();
        spnl_Vehiculos2 = new javax.swing.JScrollPane();
        info_Vehiculos2 = new javax.swing.JTable();
        spnl_Armas1 = new javax.swing.JScrollPane();
        info_Armas1 = new javax.swing.JTable();
        spnl_Vehiculos1 = new javax.swing.JScrollPane();
        info_Vehiculos1 = new javax.swing.JTable();
        btn_Salir = new javax.swing.JButton();
        btn_Jugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 500));
        setResizable(false);

        javax.swing.GroupLayout jugador2Layout = new javax.swing.GroupLayout(jugador2);
        jugador2.setLayout(jugador2Layout);
        jugador2Layout.setHorizontalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jugador2Layout.setVerticalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jugador1Layout = new javax.swing.GroupLayout(jugador1);
        jugador1.setLayout(jugador1Layout);
        jugador1Layout.setHorizontalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jugador1Layout.setVerticalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_Tienda2.setText("T");
        btn_Tienda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Tienda2MouseClicked(evt);
            }
        });

        btn_Tienda1.setText("T");
        btn_Tienda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_Tienda1MouseClicked(evt);
            }
        });

        spnl_Armas2.setForeground(new java.awt.Color(255, 255, 255));

        info_Armas2.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        info_Armas2.setForeground(new java.awt.Color(102, 0, 153));
        info_Armas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Nombre", "Tipo", "Daño", "No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        info_Armas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_Armas2MouseClicked(evt);
            }
        });
        spnl_Armas2.setViewportView(info_Armas2);

        spnl_Vehiculos2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        info_Vehiculos2.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        info_Vehiculos2.setForeground(new java.awt.Color(0, 102, 102));
        info_Vehiculos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Nombre", "Tipo", "Daño", "Vida", "No", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        info_Vehiculos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_Vehiculos2MouseClicked(evt);
            }
        });
        spnl_Vehiculos2.setViewportView(info_Vehiculos2);

        info_Armas1.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        info_Armas1.setForeground(new java.awt.Color(102, 0, 153));
        info_Armas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Nombre", "Tipo", "Daño", "No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        spnl_Armas1.setViewportView(info_Armas1);

        spnl_Vehiculos1.setFocusTraversalPolicyProvider(true);

        info_Vehiculos1.setFont(new java.awt.Font("Chandas", 1, 18)); // NOI18N
        info_Vehiculos1.setForeground(new java.awt.Color(0, 153, 153));
        info_Vehiculos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Nombre", "Tipo", "Vida", "Daño", "No", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        info_Vehiculos1.setToolTipText("");
        info_Vehiculos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                info_Vehiculos1MouseClicked(evt);
            }
        });
        spnl_Vehiculos1.setViewportView(info_Vehiculos1);

        btn_Salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_Salir.setText("S  A  L  I  R");
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });

        btn_Jugar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_Jugar.setText("J U G A R");
        btn_Jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_JugarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Tienda1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnl_Vehiculos1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Tienda2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnl_Vehiculos2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(spnl_Armas1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_Jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnl_Armas2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Tienda2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Tienda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnl_Vehiculos1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(spnl_Vehiculos2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnl_Armas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(spnl_Armas2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btn_Jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setVehiculos1(){
        vehiculos1 = null;
        vehiculos1 = new Vehiculo[3];
    }
    
    public void setVehiculos2(){
        vehiculos2 = null;
        vehiculos2 = new Vehiculo[3];
    }
    
    public void setBiblioteca(Bibliotecario biblioteca) {
        this.biblioteca = biblioteca;
    }

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        inicio.setVisible(true);
        inicio.setOrdenado(inicio.getPosicionamiento().ordenarPorFecha());
        biblioteca.guardarListado(inicio.getJugadores());
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void info_Armas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_Armas2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_info_Armas2MouseClicked

    private void info_Vehiculos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_Vehiculos2MouseClicked
        // TODO add your handling code here:
        int seleccion = info_Vehiculos2.getSelectedRow();
        int posicion_vehiculo = (int) info_Vehiculos2.getValueAt(seleccion, 4);
        ingresarVehiculos2(posicion_vehiculo);
    }//GEN-LAST:event_info_Vehiculos2MouseClicked

    private void info_Vehiculos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_info_Vehiculos1MouseClicked
        // TODO add your handling code here:
        int seleccion = info_Vehiculos1.getSelectedRow();
        int posicion_vehiculo = (int) info_Vehiculos1.getValueAt(seleccion, 4);
        ingresarVehiculos1(posicion_vehiculo);
    }//GEN-LAST:event_info_Vehiculos1MouseClicked

    private void btn_JugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JugarMouseClicked
        // TODO add your handling code here:
        if (vehiculos1[2] != null && vehiculos2[2] != null) {
            Mapa mapajugar = null;
            String[] mapas = {"MAPA 4*4", "MAPA 6*4", "MAPA 8*9"};
            String mapa = null;
            mapa = (String) JOptionPane.showInputDialog(this, "Escoja el Mapa a jugar", "MAPAS", JOptionPane.OK_OPTION, null, mapas, mapas[0]);
            if (mapa != null && !"".equals(mapa)) {
                switch (mapa) {
                    case "MAPA 4*4":
                        mapajugar = new Mapa4x4();
                        break;
                    case "MAPA 6*4":
                        mapajugar = new Mapa6x4();
                        break;
                    case "MAPA 8*9":
                        mapajugar = new Mapa8x9();
                        break;
                }
                jugar.setMapa(mapajugar);
                jugar.setVehiculos1(vehiculos1);
                jugar.setVehiculos2(vehiculos2);
                jugar.setVehiculos(vehiculos1, vehiculos2);
                jugar.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btn_JugarMouseClicked

    private void btn_Tienda1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Tienda1MouseClicked
        // TODO add your handling code here:
        tienda = new VisualTienda(this, primero);
        tienda.setJugador(primero);
        tienda.revisarArmasPorComprar();
        tienda.revisarVehiculosporComprar();
        tienda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Tienda1MouseClicked

    private void btn_Tienda2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Tienda2MouseClicked
        // TODO add your handling code here:
        tienda = new VisualTienda(this, segundo);
        tienda.setJugador(segundo);
        tienda.revisarArmasPorComprar();
        tienda.revisarVehiculosporComprar();
        tienda.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_Tienda2MouseClicked

    public Jugador getPrimero() {
        return primero;
    }

    public Jugador getSegundo() {
        return segundo;
    }

    public void iniciarNombres(){
        JLabel nombre1 = new JLabel();
        JLabel nombre2 = new JLabel();
        nombre1.setSize(jugador1.getSize());
        nombre2.setSize(jugador2.getSize());
        nombre1.setText(primero.getNombre() + primero.getNO() + "  ha hecho: " + primero.getKills() + " Kills");
        nombre2.setText(segundo.getNombre() + segundo.getNO() + "  ha hecho: " + segundo.getKills() + " Kills");
        nombre1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        nombre1.setFont(new java.awt.Font("Comic Sans MS", 1, 22));
        nombre2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        nombre2.setFont(new java.awt.Font("Comic Sans MS", 1, 22));
        jugador1.add(nombre1);
        jugador2.add(nombre2);
    }
    public void iniciarComponentes() {
        modelo1 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Tipo", "Daño", "Vida", "No", "Activo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        //Modelo 2
        ////////////////////////////////////
        modelo2 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Tipo", "Daño", "Vida", "No", "Activo"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        ////////////////////////////////////
        //modelo 3
        modelo3 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Tipo", "Daño", "No", "En uso"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        ////////////////////////////////////
        //modelo 4
        modelo4 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nombre", "Tipo", "Daño", "No", "En uso"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        ////////////////////////////////////
        info_Vehiculos1.setModel(modelo1);
        info_Vehiculos1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        info_Vehiculos1.setAutoscrolls(false);
        info_Vehiculos1.setCellSelectionEnabled(true);
        info_Vehiculos1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        info_Vehiculos1.setRowHeight(50);
        info_Vehiculos1.setRowMargin(5);
        info_Vehiculos1.setSelectionBackground(new java.awt.Color(115, 126, 106));
        info_Vehiculos1.setSelectionForeground(new java.awt.Color(37, 255, 191));
        info_Vehiculos1.setGridColor(Color.gray);
        info_Vehiculos1.getColumn("Nombre").setMaxWidth(150);
        info_Vehiculos1.getColumn("Nombre").setMinWidth(150);
        info_Vehiculos1.getColumn("Tipo").setMaxWidth(75);
        info_Vehiculos1.getColumn("Tipo").setMinWidth(75);
        info_Vehiculos1.getColumn("Daño").setMaxWidth(100);
        info_Vehiculos1.getColumn("Daño").setMinWidth(100);
        info_Vehiculos1.getColumn("No").setMaxWidth(50);
        info_Vehiculos1.getColumn("No").setMinWidth(50);
        info_Vehiculos1.getColumn("Activo").setMaxWidth(75);
        info_Vehiculos1.getColumn("Activo").setMinWidth(75);
        //panel1.add(panel1);
        spnl_Vehiculos1.setViewportView(info_Vehiculos1);
        //ahora empiezo con el vehiculo 2
        info_Vehiculos2.setModel(modelo2);
        info_Vehiculos2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        info_Vehiculos2.setAutoscrolls(false);
        info_Vehiculos2.setCellSelectionEnabled(true);
        info_Vehiculos2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        info_Vehiculos2.setRowHeight(50);
        info_Vehiculos2.setRowMargin(5);
        info_Vehiculos2.setSelectionBackground(new java.awt.Color(115, 126, 106));
        info_Vehiculos2.setSelectionForeground(new java.awt.Color(37, 255, 191));
        info_Vehiculos2.setGridColor(Color.gray);
        info_Vehiculos2.getColumn("Nombre").setMaxWidth(150);
        info_Vehiculos2.getColumn("Nombre").setMinWidth(150);
        info_Vehiculos2.getColumn("Tipo").setMaxWidth(75);
        info_Vehiculos2.getColumn("Tipo").setMinWidth(75);
        info_Vehiculos2.getColumn("Daño").setMaxWidth(100);
        info_Vehiculos2.getColumn("Daño").setMinWidth(100);
        info_Vehiculos2.getColumn("No").setMaxWidth(50);
        info_Vehiculos2.getColumn("No").setMinWidth(50);
        info_Vehiculos2.getColumn("Activo").setMaxWidth(75);
        info_Vehiculos2.getColumn("Activo").setMinWidth(75);
        spnl_Vehiculos2.setViewportView(info_Vehiculos2);
        //Empiezo con las armas
        //Empiezo con el del jugador 1
        info_Armas1.setModel(modelo3);
        info_Armas1.setSize(500, 500);
        info_Armas1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        info_Armas1.setAutoscrolls(false);
        info_Armas1.setCellSelectionEnabled(true);
        info_Armas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        info_Armas1.setRowHeight(50);
        info_Armas1.setRowMargin(5);
        info_Armas1.setSelectionBackground(new java.awt.Color(115, 126, 106));
        info_Armas1.setSelectionForeground(new java.awt.Color(37, 255, 191));
        info_Armas1.setGridColor(Color.gray);
        info_Armas1.getColumn("Nombre").setMaxWidth(150);
        info_Armas1.getColumn("Nombre").setMinWidth(150);
        info_Armas1.getColumn("Tipo").setMaxWidth(75);
        info_Armas1.getColumn("Tipo").setMinWidth(75);
        info_Armas1.getColumn("Daño").setMaxWidth(100);
        info_Armas1.getColumn("Daño").setMinWidth(100);
        info_Armas1.getColumn("En uso").setMaxWidth(75);
        info_Armas1.getColumn("En uso").setMinWidth(75);
        spnl_Armas1.setViewportView(info_Armas1);
        // sigue el jugador 2

        info_Armas2.setModel(modelo4);
        info_Armas2.setSize(500, 500);
        info_Armas2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        info_Armas2.setAutoscrolls(false);
        info_Armas2.setCellSelectionEnabled(true);
        info_Armas2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        info_Armas2.setRowHeight(50);
        info_Armas2.setRowMargin(5);
        info_Armas2.setSelectionBackground(new java.awt.Color(115, 126, 106));
        info_Armas2.setSelectionForeground(new java.awt.Color(37, 255, 191));
        info_Armas2.setGridColor(Color.gray);
        info_Armas2.getColumn("Nombre").setMaxWidth(150);
        info_Armas2.getColumn("Nombre").setMinWidth(150);
        info_Armas2.getColumn("Tipo").setMaxWidth(75);
        info_Armas2.getColumn("Tipo").setMinWidth(75);
        info_Armas2.getColumn("Daño").setMaxWidth(100);
        info_Armas2.getColumn("Daño").setMinWidth(100);
        info_Armas2.getColumn("En uso").setMaxWidth(75);
        info_Armas2.getColumn("En uso").setMinWidth(75);
        spnl_Armas2.setViewportView(info_Armas2);
    }

    public void setIncio(Inicio inicio) {
        this.inicio = inicio;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Jugar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_Tienda1;
    private javax.swing.JButton btn_Tienda2;
    private javax.swing.JTable info_Armas1;
    private javax.swing.JTable info_Armas2;
    private javax.swing.JTable info_Vehiculos1;
    private javax.swing.JTable info_Vehiculos2;
    private javax.swing.JPanel jugador1;
    private javax.swing.JPanel jugador2;
    private javax.swing.JScrollPane spnl_Armas1;
    private javax.swing.JScrollPane spnl_Armas2;
    private javax.swing.JScrollPane spnl_Vehiculos1;
    private javax.swing.JScrollPane spnl_Vehiculos2;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo1;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    private DefaultTableModel modelo4;

    public void empezarJugador1() {
        Vehiculo[] vehiculosprimero = primero.getGarage().ordenarPorFecha();
        Arma[] armasprimero = primero.getArmeria().ordenarPorFecha();
        for (Vehiculo vehiculosprimero1 : vehiculosprimero) {
            Object[] datos = new Object[6];
            datos[0] = vehiculosprimero1.getNombre();
            datos[1] = vehiculosprimero1.getTipo();
            datos[2] = (int) vehiculosprimero1.getDaño();
            datos[3] = (int) vehiculosprimero1.getVida();
            datos[4] = vehiculosprimero1.getNo();
            datos[5] = vehiculosprimero1.isEstaActivo();
            modelo1.addRow(datos);
        }
        for (Arma armasprimero1 : armasprimero) {
            Object[] datos = new Object[5];
            datos[0] = armasprimero1.getNombre();
            datos[1] = armasprimero1.getTipo();
            datos[2] = (int) armasprimero1.dañoHecho();
            datos[3] = armasprimero1.getNo();
            datos[4] = armasprimero1.isEnuso();
            modelo3.addRow(datos);
        }
    }

    public void empezarJugador2() {
        Vehiculo[] vehiculosprimero = segundo.getGarage().ordenarPorFecha();
        Arma[] armasprimero = segundo.getArmeria().ordenarPorFecha();
        for (Vehiculo vehiculosprimero1 : vehiculosprimero) {
            Object[] datos = new Object[6];
            datos[0] = vehiculosprimero1.getNombre();
            datos[1] = vehiculosprimero1.getTipo();
            datos[2] = (int) vehiculosprimero1.getDaño();
            datos[3] = (int) vehiculosprimero1.getVida();
            datos[4] = vehiculosprimero1.getNo();
            datos[5] = vehiculosprimero1.isEstaActivo();
            modelo2.addRow(datos);
        }
        for (Arma armas2 : armasprimero) {
            Object[] datos = new Object[5];
            datos[0] = armas2.getNombre();
            datos[1] = armas2.getTipo();
            datos[2] = (int) armas2.dañoHecho();
            datos[3] = armas2.getNo();
            datos[4] = armas2.isEnuso();
            modelo4.addRow(datos);
        }
    }

    public void setPrimero(Jugador primero) {
        this.primero = primero;
    }

    public void setSegundo(Jugador segundo) {
        this.segundo = segundo;
    }

    private void ingresarVehiculos2(int no) {
        int z = 0;
        Vehiculo vehiculo = segundo.getVehiculos().devolver(no);
        if (vehiculo.isComprada() && vehiculo.isEstaActivo()) {
            while ( z < 3 && vehiculos2[z] != null ) {
                if (vehiculos2[z] == vehiculo) {
                    break;
                }
                z++;
            }
            if (z < 3) {
                vehiculos2[z] = vehiculo;
            } else {
                vehiculos2[0] = vehiculos2[1];
                vehiculos2[1] = vehiculos2[2];
                vehiculos2[2] = vehiculo;
            }
        }
    }

    private void ingresarVehiculos1(int no) {
        int z = 0;
        Vehiculo vehiculo = primero.getVehiculos().devolver(no);
        if (vehiculo.isComprada() && vehiculo.isEstaActivo()) {
            while ( z < 3 && vehiculos1[z] != null) {
                if (vehiculos1[z] == vehiculo) {
                    break;
                }
                z++;
            }
            if (z < 3) {
                vehiculos1[z] = vehiculo;
            } else {
                vehiculos1[0] = vehiculos1[1];
                vehiculos1[1] = vehiculos1[2];
                vehiculos1[2] = vehiculo;
            }
        }
    }
}
