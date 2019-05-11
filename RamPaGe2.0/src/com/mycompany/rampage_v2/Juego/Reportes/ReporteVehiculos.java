/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rampage_v2.Juego.Reportes;

import com.mycompany.rampage_v2.Juego.Vehiculos.Enemigo;
import com.mycompany.rampage_v2.Juego.Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marito
 */
public class ReporteVehiculos {
    private Vehiculo mejor;
    private Vehiculo peor;
    private ArrayList<Date> fehcas = new ArrayList<>();
    private ArrayList<Enemigo> enemigosderrotados = new ArrayList<>();
}
