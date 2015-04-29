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
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        
        specificHiddenTreasures = new ArrayList<TreasureKind>();
        specificVisibleTreasures = new ArrayList<TreasureKind>();
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        
        specificHiddenTreasures = new ArrayList<TreasureKind>();
        specificVisibleTreasures = new ArrayList<TreasureKind>();
    }
    
    public BadConsequence(
            String text, 
            int levels, 
            ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden
    ){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();
        
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        
    }
    
    public String getText(){
        return this.text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNumberOfVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNumberOfHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean kills(){
        return death;
    }
    
    public ArrayList <TreasureKind> getVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public ArrayList <TreasureKind> getHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList <Treasure> visible, ArrayList <Treasure> hidden){
        if(this.nVisibleTreasures != 0 || this.nHiddenTreasures != 0){  // number of treasures
            int new_nVisibleTreasures = Math.min(this.nVisibleTreasures, visible.size());
            int new_nHiddenTreasures = Math.min(this.nHiddenTreasures, hidden.size());
            
            return new BadConsequence(this.text, 0, new_nVisibleTreasures, new_nHiddenTreasures);
        } else {  // specific treasures
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
            
            return new BadConsequence(this.text, 0, new_specificVisible, new_specificHidden);
        }
    }
    
    public boolean isEmpty(){        
        return levels == 0 &&
                nVisibleTreasures == 0 &&
                nHiddenTreasures == 0 &&
                death == false &&
                specificHiddenTreasures.isEmpty() &&
                specificVisibleTreasures.isEmpty();
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(!this.specificVisibleTreasures.isEmpty()){
            for(int i = 0; i < this.specificVisibleTreasures.size(); ++i){
                if(this.specificVisibleTreasures.get(i) == t.getType()){
                    this.specificVisibleTreasures.remove(i);
                    break;
                }
            }
        } else if(this.nVisibleTreasures > 0){
            --this.nVisibleTreasures;
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(!this.specificHiddenTreasures.isEmpty()){
            for(int i = 0; i < this.specificHiddenTreasures.size(); ++i){
                if(this.specificHiddenTreasures.get(i) == t.getType()){
                    this.specificHiddenTreasures.remove(i);
                    break;
                }
            }
        } else if(this.nHiddenTreasures > 0){
            --this.nHiddenTreasures;
        }
    }

    @Override
    public String toString(){
        return this.text;
    }
    
}
