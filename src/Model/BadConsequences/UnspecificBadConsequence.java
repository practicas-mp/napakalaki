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
public class UnspecificBadConsequence extends BadConsequence {

    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public UnspecificBadConsequence(String text, int level, int vTreasuresToLose, int hTreasuresToLose){
        super(text, level);
        nVisibleTreasures = vTreasuresToLose;
        nHiddenTreasures = hTreasuresToLose;
    }
    
    @Override
    public Boolean kills() {
        return false;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        int new_nVisibleTreasures = Math.min(this.nVisibleTreasures, visible.size());
        int new_nHiddenTreasures = Math.min(this.nHiddenTreasures, hidden.size());

        return new UnspecificBadConsequence(this.getText(), 0, new_nVisibleTreasures, new_nHiddenTreasures);
    }

    @Override
    public boolean isEmpty() {
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        --this.nVisibleTreasures;
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        --this.nHiddenTreasures;
    }
    
}
