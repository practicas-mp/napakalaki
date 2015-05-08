/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author braulio
 */
public class Napakalaki {
    private static Napakalaki instance;
    private Monster currentMonster;
    private Player currentPlayer;
    int currentPlayerIndex = -1;
    private List<Player> players;
    
    private void initPlayers(ArrayList<String> names){
        this.players = new ArrayList<Player>();
        
        for(String name : names){
            this.players.add(new Player(name));
        }
    }
    
    private Player nextPlayer(){
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
        
        return this.currentPlayer;
    }
    
    public CombatResult combat(){
        CombatResult result = this.currentPlayer.combat(this.currentMonster);
        CardDealer.getInstance().giveMonsterBack(this.currentMonster);
        return result;
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.currentPlayer.discardVisibleTreasure(t);
    }
    
    public void discarHiddenTreasure(Treasure t){
        this.currentPlayer.discardHiddenTreasure(t);
    }
    
    public boolean makeTreasureVisible(Treasure t){
        boolean allowed = this.canMakeTreasureVisible(t);
        
        if(allowed){
            this.currentPlayer.makeTreasureVisible(t);
        }
        
        return allowed;    
    }
    
    public void buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        this.currentPlayer.buyLevels(visible, hidden);
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        CardDealer.getInstance().initCards();
        
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return this.currentPlayer.canMakeTreasureVisible(t);
    }
    
    public ArrayList <Treasure> getVisibleTreasures(){
        return this.currentPlayer.getVisibleTreasures();
    }
    
    public ArrayList <Treasure> getHiddenTreasures(){
        return this.currentPlayer.getHiddenTreasures();
    }
    
    public boolean nextTurn(){
        if(this.nextTurnIsAllowed()){
            this.nextPlayer();
            this.currentMonster = CardDealer.getInstance().nextMonster();
            
            if(this.currentPlayer.isDead()){
                this.currentPlayer.initTreasures();
            }
            
            return true;
        }
        
        return false;
    }
    
    public boolean nextTurnIsAllowed(){
        return this.currentPlayer == null || this.currentPlayer.validState();  
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINANDWINGAME;
    }
    
    public static Napakalaki getInstance(){
        if (instance == null)
            instance = new Napakalaki();
        
        return instance;
    }
    
}
