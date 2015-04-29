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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String name, int combatLevel,
            BadConsequence bc, 
            Prize prize){
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = bc;
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
    
}
