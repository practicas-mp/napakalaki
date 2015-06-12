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
public abstract class BadConsequence {
    
    protected static String PROMPT = "Esto es un mal rollo con el siguiente contenido";

    private final String text;
    private final int levels;
    
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }

    public abstract Boolean kills();
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> vTreasures, ArrayList<Treasure> hTreasures);
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    @Override
    public String toString(){
        return PROMPT + ": " + text;
    }
    
}

