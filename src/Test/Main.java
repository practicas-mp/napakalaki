package Test;

import Model.Napakalaki;
import Model.Dice;
import GUI.NapakalakiView;

/**
 *
 * @author nacho
 */
public class Main {
    public static void main(String[] args){
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
        //GameTester.getInstance().play(Napakalaki.getInstance(), 2);
    }
}
