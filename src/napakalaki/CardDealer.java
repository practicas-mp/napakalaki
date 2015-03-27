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
public class CardDealer {
    private static CardDealer instance;
    
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    private CardDealer() {
    
    }
    
    private void initTreasureCardDeck() {
        
    }
    
    private void initMonsterCardDeck() {
    
    }
    
    private void shuffleTreasures() {
    
    }
    
    private void shuffleMonsters () {
    
    }
    
    public CardDealer getInstance(){
        if (instance == null)
            instance = new CardDealer();
        
        return instance;
    }
    
    public Treasure nextTreasure() {
        return null;
    }
    
    public Monster nextMonster() {
        return null;
    }
    
    public void giveTreasureBack(Treasure t){
    
    }
    
    public void giveMonsterBack(Treasure t){
    
    }
    
    public void initCards() {
    
    }
    
}
