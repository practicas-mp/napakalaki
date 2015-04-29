/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
    public Player(String name){
        this.level = 1;
        this.name = name;
        this.visibleTreasures = new ArrayList <Treasure>();
        this.hiddenTreasures = new ArrayList <Treasure>();
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    private void incrementLevels(int levels) {
        level += levels;
        level = Math.min(10, level);
    }
    
    private void decrementLevels(int levels) {
        level -= levels;
        level = Math.max(1, level);
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    private void die() {
        this.dead = true;
        this.level = 1;
        
        for(Treasure t: this.visibleTreasures){
            CardDealer.getInstance().giveTreasureBack(t);
        }
        
        for(Treasure t: this.hiddenTreasures){
            CardDealer.getInstance().giveTreasureBack(t);
        }
        
        this.visibleTreasures.clear();
        this.hiddenTreasures.clear();
    }
    
    private void discardNecklaceIfVisible(){
        for(int i = 0; i < this.visibleTreasures.size(); ++i){
            if(this.visibleTreasures.get(i).getType() == TreasureKind.NECKLACE){
                CardDealer.getInstance().giveTreasureBack(this.visibleTreasures.get(i));
                this.visibleTreasures.remove(i);                        
            }
        }
    }
    
    private void dieIfNoTreasures() {
        if (this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()) {
            this.die();
        }
    }
        
    private boolean canIBuyLevels(int levels) {
        return this.level + levels < 10;  // The player is able to buy more levels whenever those levels do not make him win
    }
    
    protected double computeGoldCoinsValue(ArrayList <Treasure> treasures){
        int value = 0;
        
        for(Treasure t: treasures){
            value += t.getGoldCoins();
        }
        
        return value / (double) 1000;
        
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
        CombatResult result;
        
        if(lvl > monsterLevel){
            this.applyPrize(monster.getPrize());
            
            return this.level < 10 ? CombatResult.WIN : CombatResult.WINANDWINGAME;
        } else {
            if(Dice.getInstance().nextNumber() >= 5){
                result = CombatResult.LOSEANDESCAPE;
            } else if(monster.getBadConsequence().kills()){
                this.die();
                result = CombatResult.LOSEANDDIE;
            } else {
                this.applyBadConsequence(monster.getBadConsequence());
                result = CombatResult.LOSE;
            }
        }
        
        this.discardNecklaceIfVisible();
        
        return result;
        
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
            this.hiddenTreasures.remove(t);
            return true;
        }
        
        return false;
    }

    public void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t);
        
        if(this.pendingBadConsequence != null){
            this.pendingBadConsequence.substractVisibleTreasure(t);
        }
    }
    
    public void discardHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t);
        
        if(this.pendingBadConsequence != null){
            this.pendingBadConsequence.substractHiddenTreasure(t);
        }
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible,  ArrayList<Treasure> hidden) {
        double levels = this.computeGoldCoinsValue(visible);
        levels += this.computeGoldCoinsValue(hidden);
        
        int int_levels = (int) levels;
        
        if(this.canIBuyLevels(int_levels)){
            this.incrementLevels(int_levels);
            
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
        if(this.hiddenTreasures.size() > 4){
            System.out.println("muxios teosoros!!1!");
        }
        
        return (this.pendingBadConsequence == null || this.pendingBadConsequence.isEmpty()) 
                    && this.hiddenTreasures.size() <= 4;
    }
    public void initTreasures(){
        this.bringToLife();
        
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
        return !this.visibleTreasures.isEmpty();
    }
    
    public ArrayList <Treasure> getVisibleTreasures() {
        return this.visibleTreasures;
    }
    public ArrayList <Treasure> getHiddenTreasures() {
        return this.hiddenTreasures;
    }
    
    public Boolean isNecklaceVisible(){
        for(Treasure t : visibleTreasures){
            if (t.getType() == TreasureKind.NECKLACE)
                return true;
        }
        
        return false;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return this.getName() + "[lvl " + this.level + "]";
    }
}