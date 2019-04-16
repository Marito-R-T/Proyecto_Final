/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampage_2.Ventanas;

import java.applet.AudioClip;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author marito
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    private AudioClip sonido;
    private final VisualJuego JUEGO = new VisualJuego(this);
    private final VisualJugador JUGADOR = new VisualJugador(this);
    private final VisualReportes REPORTES = new VisualReportes(this);
    private final VisualTienda TIENDA = new VisualTienda(this);
    public Inicio() {
        initComponents();
        iniciarComponentes();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        btnmusica.setSelected(true);
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/inicio.mp3"));
        sonido.loop(); //ubuntu
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
        btnmusica = new javax.swing.JRadioButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setSize(new java.awt.Dimension(900, 700));

        jPanel1.setLayout(null);

        lbljuegonuevo.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lbljuegonuevo.setForeground(new java.awt.Color(204, 204, 255));
        lbljuegonuevo.setText(" Nuevo");
        lbljuegonuevo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbljuegonuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbljuegonuevoMouseClicked(evt);
            }
        });
        jPanel1.add(lbljuegonuevo);
        lbljuegonuevo.setBounds(370, 240, 180, 90);

        lbljuegocargar.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        lbljuegocargar.setForeground(new java.awt.Color(153, 153, 255));
        lbljuegocargar.setText(" Cargar");
        lbljuegocargar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbljuegocargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbljuegocargarMouseClicked(evt);
            }
        });
        jPanel1.add(lbljuegocargar);
        lbljuegocargar.setBounds(370, 340, 180, 90);

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
        lblayuda.setBounds(380, 450, 160, 50);

        btnmusica.setForeground(new java.awt.Color(255, 255, 255));
        btnmusica.setText("Volumen");
        btnmusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmusicaMouseClicked(evt);
            }
        });
        jPanel1.add(btnmusica);
        btnmusica.setBounds(790, 10, 111, 28);
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

    private void lbljuegonuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbljuegonuevoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        JUGADOR.setVisible(true);
    }//GEN-LAST:event_lbljuegonuevoMouseClicked

    private void lbljuegocargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbljuegocargarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbljuegocargarMouseClicked

    private void lblayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblayudaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblayudaMouseClicked

    private void btnmusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmusicaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmusicaMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnmusica;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblayuda;
    private javax.swing.JLabel lbljuegocargar;
    private javax.swing.JLabel lbljuegonuevo;
    // End of variables declaration//GEN-END:variables

    private void iniciarComponentes() {
        ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo inicio.jpg")); //Ubuntu
        //ImageIcon fondo = new ImageIcon("C:\\Users\\50254\\Documents\\Proyecto_Final\\RamPaGe_2.0\\src\\Imagenes\\Fondo inicio.jpg"); //Windows
        lblFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH)));
    }
}
