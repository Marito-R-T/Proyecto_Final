/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampage_2.Juego.Mapas.Terrenos;

import javax.swing.JLabel;
import rampage_2.Juego.Vehiculos.Vehiculo;

/**
 *
 * @author marito
 */
public abstract class Terreno extends JLabel{
    private Vehiculo vehiculo;

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
}
