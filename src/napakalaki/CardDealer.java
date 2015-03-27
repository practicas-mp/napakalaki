/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
        this.unusedMonsters = new ArrayList<Monster>();
        this.usedMonsters = new ArrayList<Monster>();
        
        this.unusedTreasures = new ArrayList<Treasure>();
        this.usedTreasures = new ArrayList<Treasure>();
        
        initCards();
    }
    
    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters () {
        Collections.shuffle(unusedMonsters);
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
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }
    
    public void initCards() {
        initTreasureCardDeck();
        initMonsterCardDeck();
    }
    
    
    
    void initTreasureCardDeck(){
         
        this.unusedTreasures.add(new Treasure("¡Sí mi amo!", 0, 4, 7, TreasureKind.HELMET));
        this.unusedTreasures.add(new Treasure("Botas de investigación", 600, 3, 4, TreasureKind.SHOE));
        this.unusedTreasures.add(new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.HELMET));   
        this.unusedTreasures.add(new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.ARMOR));   
        this.unusedTreasures.add(new Treasure("Botas de lluvia ácida", 800, 1, 1, TreasureKind.SHOE));   
        this.unusedTreasures.add(new Treasure("Casco minero", 400, 2, 4, TreasureKind.HELMET));   
        this.unusedTreasures.add(new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.BOTHHANDS));   
        this.unusedTreasures.add(new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.ARMOR));   
        this.unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.ONEHAND));   
        this.unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.ONEHAND));   
        this.unusedTreasures.add(new Treasure("Fez alópodo", 700, 3, 5, TreasureKind.HELMET));   
        this.unusedTreasures.add(new Treasure("Hacha prehistórica", 500, 2, 5, TreasureKind.ONEHAND));   
        this.unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 900, 4, 8, TreasureKind.ARMOR));
        this.unusedTreasures.add(new Treasure("Gaita", 500, 4, 5, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Insecticida", 300, 2, 3, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Escopeta de tres cañones", 700, 4, 6, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Garabato místico", 300, 2, 2, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.NECKLACE));
        this.unusedTreasures.add(new Treasure("La rebeca metálica", 400, 2, 3, TreasureKind.ARMOR));
        this.unusedTreasures.add(new Treasure("Mazo de los antiguos", 200, 3, 4, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Necroplayboycon", 300, 3, 5, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Necrocomicón", 100, 1, 1, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Necronomicón", 800, 5, 7, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Linterna a dos manos", 400, 3, 6, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Necrognomicón", 200, 2, 4, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.HELMET));
        this.unusedTreasures.add(new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.ONEHAND));
        this.unusedTreasures.add(new Treasure("Tentáculo de pega", 200, 0, 1, TreasureKind.HELMET));
        this.unusedTreasures.add(new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.SHOE));
        this.unusedTreasures.add(new Treasure("Shogulador", 600, 1, 1, TreasureKind.BOTHHANDS));
        this.unusedTreasures.add(new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.ONEHAND));
        
    }
    
    void initMonsterCardDeck(){
        
        Prize prize = new Prize(2,1);      
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        this.unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Embobados con el lindo primigenio, "
                        + "te descartas de tu casco visible", 0,
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        this.unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
                        + "Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        this.unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        prize = new Prize(4,1);
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y "
                        + "te dejan caer en mitad del vuelo. Descarta una mano visible y "
                        + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        this.unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        prize = new Prize(3,1);
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                        0, 5, 0);
        this.unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                        + "Descarta la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        prize = new Prize(4,2);
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",
                        5, 3, 0);
        this.unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles",
                        2, 0, 0);
        this.unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Estos mostruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estas muerto", true);
        this.unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Pierdes dos niveles y dos tesoros "
                        + "ocultos.", 2, 0, 2);
        this.unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una"
                        + " mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
                        3, 0, 0);
        this.unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        prize = new Prize(3,1);
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal "
                        + "su nombre. Estás muerto", true);
        this.unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        prize = new Prize(4,1);
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        this.unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga"
                        + " a perder dos niveles y un tesoro de dos manos visible", 
                        2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un"
                        + " casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2"
                        + " niveles y 5 tesoros visibles", 2, 5, 0);
        this.unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. "
                        + "Pierdes 3 niveles y tus tesoros visibles de las manos",
                        3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                        new ArrayList());
        prize = new Prize(1,1);
        this.unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    }
    
    
    
}
