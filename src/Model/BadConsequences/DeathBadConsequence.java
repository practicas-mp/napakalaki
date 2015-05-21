/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BadConsequences;

import Model.Treasure;
import java.util.ArrayList;

/**
 *
 * @author braulio
 */
public class DeathBadConsequence extends BadConsequence {
    
    
    public DeathBadConsequence(String text){
        super(text, 0);
    }
    
    @Override
    public Boolean kills() {
        return true;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vTreasures, ArrayList<Treasure> hTreasures) {
        return this; // No sense here
    }

    @Override
    public boolean isEmpty() {
        return true; // No sense here
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        // no sense here
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        // no sense here
    }
    

    
    
}
