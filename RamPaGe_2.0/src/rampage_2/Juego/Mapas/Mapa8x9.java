/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampage_2.Juego.Mapas;

import java.util.Random;
import rampage_2.Juego.Mapas.Terrenos.Agua;
import rampage_2.Juego.Mapas.Terrenos.Montaña;
import rampage_2.Juego.Mapas.Terrenos.Terreno;

/**
 *
 * @author marito
 */
public class Mapa8x9 extends Mapa {
    private final int FILAS = 8;
    private final int COLUMNAS = 9;
    public Mapa8x9() {
        primerTerreno();
        super.mapa = new Terreno[8][9];
    }

    public void ingresarTerrenos() {
        int agua = 0;
        int montaña = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                Random random = new Random();
                int elegido = random.nextInt(3);
                if (elegido == 2) {
                    super.mapa[i][j] = new Agua();
                } else if (elegido == 1) {
                    super.mapa[i][j] = new Montaña();
                } else {
                    super.mapa[][]
                }
            }
        }
    }

    private void primerTerreno() {
        
    }
}
