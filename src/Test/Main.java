package Test;

import Model.Napakalaki;
import Model.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class Main {
    public static void main(String[] args){
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        
        ArrayList<String> playerNames;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        playerNames = namesCapture.getNames();
        napakalakiModel.initGame(playerNames);
        
        
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
        //GameTester.getInstance().play(Napakalaki.getInstance(), 2);
    }
}
