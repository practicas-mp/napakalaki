/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author braulio
 */
public class Dice {
    private static Dice instance;
    Random rand;
    
    private Dice() {
        rand = new Random();
    }
    
    public static Dice getInstance() {
        if (instance == null)
            instance = new Dice();
        
        return instance;
    }
    
    public int nextNumber(){
        return rand.nextInt(6) + 1;
    }
}
