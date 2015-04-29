/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author braulio
 */
public class Prize {
    private int treasures;
    private int levels;
    
    public Prize(int treasures, int levels){
        this.treasures = treasures;
        this.levels = levels;
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    public int getTreasures(){
        return this.treasures;
    }
    
    @Override
    public String toString(){
        return Integer.toString(this.treasures) + " treasures & " +
                Integer.toString(this.levels) + " levels";
    }
    
}
