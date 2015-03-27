/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author braulio
 */
public class Napakalaki {
    private static Napakalaki instance;
    private Monster currentMonster;
    private Player currentPlayer;
    private Player[] players;
    
    private void initPlayers(String[] names){
        
    }
    
    private Player nextPlayer(){
        return null;
    }
    
    public CombatResult combat(){
        return null;
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discarHiddenTreasure(Treasure t){
    
    }
    
    public void makeTreasureVisible(Treasure t){
    
    }
    
    public void buyLevels(Treasure[] visible, Treasure[] hidden){
    
    }
    
    public void initGame(String[] players){
    
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        return false;
    }
    
    public Treasure[] getVisibleTreasures(){
        return null;
    }
    
    public Treasure[] getHiddenTreasures(){
        return null;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean nextTurnAllowed(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
        return false;
    }
    
    public static Napakalaki getInstance(){
        if (instance == null)
            instance = new Napakalaki();
        
        return instance;
    }
    
}
