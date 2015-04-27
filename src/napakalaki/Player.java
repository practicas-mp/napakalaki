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
    
    private boolean dead = true;  // hack for first turn
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
        this.dead = true;
        this.level = 1;
        this.visibleTreasures.clear();
        this.hiddenTreasures.clear();
    }
    
    private void discardNecklaceVisible(){
        for(int i = 0; i < this.visibleTreasures.size(); ++i){
            if(this.visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                CardDealer.getInstance().giveTreasureBack(this.visibleTreasures.get(i));
                this.visibleTreasures.remove(i);                        
            }
        }
    }
    
    private void dieIfNoTreasures() {
        if (this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()) {
            die();
        }
    }
        
    private boolean canIBuyLevels(int levels) {
        return this.level + levels < 10; // The player is able to buy more levels whenever those levels do not make him win
    }
    
    protected float computeGoldCoinsValue(ArrayList <Treasure> treasures){
        int value = 0;
        
        for(Treasure t: treasures){
            value += t.getGoldCoins();
        }
        
        return value / 1000;
        
    }
    
    public void applyPrize(Prize prize){
        this.incrementLevels(prize.getLevels());
        int total = prize.getTreasures();
        
        while(total-- > 0){
            this.hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
        
    }
    
    public CombatResult combat(Monster monster){ 
        int lvl = this.getCombatLevel(), monsterLevel = monster.getLevel();
        
        if(lvl > monsterLevel){
            this.applyPrize(monster.getPrize());
            
            return this.level < 10 ? CombatResult.WIN : CombatResult.WINANDWINGAME;
        } else {
            if(Dice.getInstance().nextNumber() >= 5){
                return CombatResult.LOSEANDESCAPE;
            } else if(monster.getBadConsequence().kills()){
                this.die();
                return CombatResult.LOSEANDDIE;
            } else {
                this.applyBadConsequence(monster.getBadConsequence());
                return CombatResult.LOSE;
            }
        }
        
    }
    
    public void applyBadConsequence(BadConsequence bc){
        if(bc.kills()){
            this.die();
        } else {
            this.decrementLevels(bc.getLevels());
            BadConsequence adjusted = bc.adjustToFitTreasureLists(this.visibleTreasures, this.hiddenTreasures);
            this.setPendingBadConsequence(adjusted);
        }
    
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        TreasureKind curr_type, t_type = t.getType();
        int hands_used = 0;
        
        for(Treasure curr: this.visibleTreasures){
            curr_type = curr.getType();
            
            if(curr_type == TreasureKind.ONEHAND){
                ++hands_used;
            } else if(curr_type == TreasureKind.BOTHHANDS){
                hands_used += 2;
            } else if(t_type == curr_type){
                return false;
            }
        }
        
        if(t_type == TreasureKind.ONEHAND){
            ++hands_used;
        } else if(t_type == TreasureKind.BOTHHANDS){
            hands_used += 2;
        }
        
        return hands_used <= 2;
    }
    
    public boolean makeTreasureVisible(Treasure t){
        if(this.canMakeTreasureVisible(t)){
            this.visibleTreasures.add(t);
            return true;
        }
        
        return false;
    }

    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t) { }
    
    public boolean buyLevels(ArrayList<Treasure> visible,  ArrayList<Treasure> hidden) {
        double levels = this.computeGoldCoinsValue(visible);
        levels += this.computeGoldCoinsValue(hidden);
        levels = (int) Math.floor(levels);
        
        if(this.canIBuyLevels(levels)){
            this.incrementLevels(levels);
            
            for(Treasure t: visible){
                this.discardVisibleTreasure(t);
            }
            
            for(Treasure t: hidden){
                this.discardHiddenTreasure(t);
            }
            
            return true;
        }
        
        return false;    
    } 

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
    public void initTreasures(){
        int roll = Dice.getInstance().nextNumber(), treasures;
        
        switch(roll){
            case 1:
                treasures = 1;
            break;
            case 6:
                treasures = 3;
            break;
            default:
                treasures = 2;
        }
        
        while(treasures-- > 0){
            this.hiddenTreasures.add(CardDealer.getInstance().nextTreasure());
        }
    }
    
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
    
    // EXAMEN
    
    public void setVisibleTreasureList(ArrayList<Treasure> treasures){
        this.visibleTreasures = treasures;
    }
    
    public void setHiddenTreasureList(ArrayList<Treasure> treasures){
        this.hiddenTreasures = treasures;
    }
    
    // FIN EXAMEN
}
