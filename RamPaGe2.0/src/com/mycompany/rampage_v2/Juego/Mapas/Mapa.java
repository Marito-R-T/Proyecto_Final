/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Mapas;

import com.mycompany.rampage_v2.Juego.Mapas.Terrenos.Terreno;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author marito
 */
public class Mapa /*extends JPanel*/{
    protected Terreno[][] mapa;
    protected Random random = new Random();
    protected int agua = 0, montaña = 0;
    protected int FILAS;
    protected int COLUMNAS;
    protected Terreno anterior, referencia;
}
