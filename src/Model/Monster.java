/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.BadConsequences.BadConsequence;

/**
 *
 * @author braulio
 */
public class Monster implements Card {
    private String name;
    private int combatLevel;
    private int levelChangeAgainstCultistPlayer;
    private Prize prize;
    private BadConsequence badConsequence;
    
    
    public Monster(String name, int combatLevel,
            BadConsequence bc, 
            Prize prize){
        this(name, combatLevel, 0, bc, prize);
        
    }
    
    public Monster(String name, int combatLevel, int levelChangeAgainstCultistPlayer,
            BadConsequence bc, 
            Prize prize){
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = bc;
        this.levelChangeAgainstCultistPlayer = levelChangeAgainstCultistPlayer;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLevel(){
        return this.combatLevel;
    }
    
    public Prize getPrize(){
        return this.prize;
    }
    
    public BadConsequence getBadConsequence(){
        return this.badConsequence;
    }
                
    public String toString(){
        return this.name + " [lvl " + Integer.toString(this.combatLevel) + "]\n"
                + this.badConsequence.getText();
    }

    @Override
    public int getBasicValue() {
        return getLevel();
    }

    @Override
    public int getSpecialValue() {
        return getLevel() + levelChangeAgainstCultistPlayer;
    }
    
}
