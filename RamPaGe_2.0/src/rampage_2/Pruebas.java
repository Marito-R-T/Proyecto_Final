/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampage_2;

import com.sun.imageio.spi.RAFImageInputStreamSpi;
import java.util.Random;

/**
 *
 * @author marito
 */
public class Pruebas {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(3));
        if(random.nextInt(3) == 0){
        System.out.println(random.nextInt(3));
        }
    }
}
