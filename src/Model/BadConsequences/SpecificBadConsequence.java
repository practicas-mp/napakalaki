/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BadConsequences;

import Model.Treasure;
import Model.TreasureKind;
import java.util.ArrayList;

/**
 *
 * @author braulio
 */
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public SpecificBadConsequence(String text, 
            int levels, 
            ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        
        super(text, levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
    }
    
    
    @Override
    public Boolean kills() {
        return false;
    }

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visible, ArrayList<Treasure> hidden) {
        boolean found;
            
        ArrayList <TreasureKind> new_specificVisible = new ArrayList <TreasureKind>(),
                                 new_specificHidden = new ArrayList <TreasureKind>();

        for(TreasureKind type: this.specificVisibleTreasures){
            found = false;

            for(int j = 0; !found && j < visible.size(); ++j){
                if(visible.get(j).getType() == type){
                    found = true;
                }
            }

            if(found){
                new_specificVisible.add(type);
            }
        }

        for(TreasureKind type: this.specificHiddenTreasures){
            found = false;

            for(int j = 0; !found && j < hidden.size(); ++j){
                if(hidden.get(j).getType() == type){
                    found = true;
                }
            }

            if(found){
                new_specificHidden.add(type);
            }
        }
            
        return new SpecificBadConsequence(this.getText(), 0, new_specificVisible, new_specificHidden);
    }

    @Override
    public boolean isEmpty() {
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        for(int i = 0; i < this.specificVisibleTreasures.size(); ++i){
            if(this.specificVisibleTreasures.get(i) == t.getType()){
                this.specificVisibleTreasures.remove(i);
                break;
            }
        }
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        for(int i = 0; i < this.specificHiddenTreasures.size(); ++i){
            if(this.specificHiddenTreasures.get(i) == t.getType()){
                this.specificHiddenTreasures.remove(i);
                break;
            }
        }
    }
    
}
