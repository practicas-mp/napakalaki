package Model;

import Model.Player;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author braulio
 */
public class CultistPlayer extends Player {

    private Cultist myCultistCard;
    private static int totalCultistPlayers = 0;
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    public CultistPlayer(String name) {
        super(name);
        totalCultistPlayers++;
    }
    
    public CultistPlayer(Player other, Cultist card){
        super(other);
        myCultistCard = card;
        totalCultistPlayers++;
    }
    
    @Override
    public int getCombatLevel(){
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    }
    
    @Override
    public int getOponentLevel(Monster m){
        return m.getSpecialValue();
    }
    
    @Override
    public Boolean shouldConvert(){
        return false; 
    }
    
    @Override
    protected double computeGoldCoinsValue(ArrayList<Treasure> treasures){
        return super.computeGoldCoinsValue(treasures) * 2;
    }
    
    
}
