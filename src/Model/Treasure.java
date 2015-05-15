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
public class Treasure implements Card {
    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    TreasureKind type;
    
    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type){
        this.name = name;
        this.goldCoins = goldCoins;
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    
    public int getGoldCoins(){
        return goldCoins;
    }
    
    public int getMinBonus(){
        return minBonus;
    }
    
    public int getMaxBonus(){
        return maxBonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    @Override
    public String toString(){
        return this.name + " [" + this.minBonus + "/" + this.maxBonus + "] ::" + this.type
                + " $" + this.goldCoins;
    }

    @Override
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return getMaxBonus();
    }
    
}
