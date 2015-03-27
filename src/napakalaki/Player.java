/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author braulio
 */
public class Player {
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    private boolean dead = false;
    private String name;
    private int level;
    
    private final int MAXHIDDENTREASURES = 4;
    
    private void bringToLife() {
        dead = true;
    }
    
    private void incrementLevels(int levels) {
        level += levels;
        level = Math.max(10, level);
    }
    
    private void decrementLevels(int levels) {
        level -= levels;
        level = Math.min(1, level);
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    private void die() {
        dead = true;
    }
    
    private void discardNecklaceVisible() {
    
    }
    
    private void dieIfNoTreasures() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) {
            die();
        }
    }
        
    private boolean canBuyLevels(int levels) {
        return level + levels < 10; // The player is able to buy more levels whenever those levels do not make him win
    }
    
    protected float computeGoldCoinsValue(Treasure[] treasures) { return -1; }
    
    public void applyPrize(Prize p) {}
    
    public CombatResult combat(Monster t) { return null; }
    
    public void applyBadConsequence(BadConsequence bq) {}
    
    public boolean makeTreasureVisible(Treasure t) { return false; }

    public void discardVisibleTreasure(Treasure t) {}
    
    public void discardHiddenTreasure(Treasure t) { }
    
    public boolean buyLevels(Treasure[] visible,  Treasure[] hidden) { return false; } 

    public int getCombatLevel() { 
        boolean has_necklace = isNecklaceVisible();
        int combatLevel = level;
        
        for (Treasure t : visibleTreasures) {
            combatLevel += has_necklace? t.getMaxBonus() : t.getMinBonus();
        }
        
        return combatLevel; 
    } 

    public boolean validState() { 
        return (pendingBadConsequence == null) && hiddenTreasures.size() < 4;
    }
    public boolean initTreasures() { return false; }
    
    public boolean isDead() {
        return dead; 
    }
    
    public boolean hasVisibleTreasures() { 
        return !visibleTreasures.isEmpty();
    }
    public Player(String name) {
        this.name = name;
    }
    public Treasure[] getVisibleTreasures() {
        return null;
    }
    public Treasure[] getHiddenTreasures() {
        return null;
    }
    
    public Boolean isNecklaceVisible(){
        for(Treasure t : visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE)
                return true;
        }
        
        return false;
    }
}
