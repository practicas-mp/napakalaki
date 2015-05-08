package Test;

import Model.Napakalaki;

/**
 *
 * @author nacho
 */
public class Main {
    public static void main(String[] args){
        GameTester.getInstance().play(Napakalaki.getInstance(), 2);
    }
}
