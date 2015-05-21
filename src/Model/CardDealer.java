/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import Model.BadConsequences.BadConsequence;
import Model.BadConsequences.DeathBadConsequence;
import Model.BadConsequences.SpecificBadConsequence;
import Model.BadConsequences.UnspecificBadConsequence;

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
    
    private ArrayList<Cultist> unusedCultist;
    
    private CardDealer() {
        this.unusedMonsters = new ArrayList<Monster>();
        this.usedMonsters = new ArrayList<Monster>();
        
        this.unusedTreasures = new ArrayList<Treasure>();
        this.usedTreasures = new ArrayList<Treasure>();
        
        this.unusedCultist = new ArrayList<Cultist>();
    }
    
    private void shuffleTreasures() {
        Collections.shuffle(this.unusedTreasures);
    }
    
    private void shuffleMonsters () {
        Collections.shuffle(this.unusedMonsters);
    }
    
    private void shuffleCultists () {
        Collections.shuffle(this.unusedCultist);
    }
    
    public static CardDealer getInstance(){
        if (instance == null)
            instance = new CardDealer();
        
        return instance;
    }
    
    public Treasure nextTreasure(){
        if(this.unusedTreasures.isEmpty()){
           this.initTreasureCardDeck();
        }
        
        return this.unusedTreasures.remove(0);
    }
    
    public Monster nextMonster() {
        if(this.unusedMonsters.isEmpty()){
           this.initMonsterCardDeck();
        }
        
        Monster last = this.unusedMonsters.remove(0);
        this.usedMonsters.add(last);
        return last;
    }
    
    public Cultist nextCultist(){
        this.shuffleCultists();
        return this.unusedCultist.get(0);
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
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
    }
    
    
    private void initCultistCardDeck() {
        this.unusedCultist.add(new Cultist("Sectario", 1));
        this.unusedCultist.add(new Cultist("Sectario", 2));
        this.unusedCultist.add(new Cultist("Sectario", 1));
        this.unusedCultist.add(new Cultist("Sectario", 2));
        this.unusedCultist.add(new Cultist("Sectario", 1));
        this.unusedCultist.add(new Cultist("Sectario", 1));
    }
    private void initTreasureCardDeck(){         
        this.usedTreasures.clear();
        
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
     
        this.shuffleTreasures();
    }
    
    private void initMonsterCardDeck(){
        this.usedMonsters.clear();
        
        Prize prize = new Prize(2,1);      
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",
                        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        this.unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));

        prize = new Prize(1,1);
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio, "
                        + "te descartas de tu casco visible", 0,
                        new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        this.unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. "
                        + "Pierdes el calzado visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        this.unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        prize = new Prize(4,1);
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y "
                        + "te dejan caer en mitad del vuelo. Descarta una mano visible y "
                        + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        this.unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        prize = new Prize(3,1);
        badConsequence = new UnspecificBadConsequence("Pierdes todos tus tesoros visibles",
                        0, 5, 0);
        this.unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. "
                        + "Descarta la armadura visible", 0, 
                        new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));
        
        prize = new Prize(4,2);
        badConsequence = new UnspecificBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",
                        5, 3, 0);
        this.unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new UnspecificBadConsequence("Toses los pulmones y pierdes 2 niveles",
                        2, 0, 0);
        this.unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new DeathBadConsequence("Estos mostruos resultan bastante "
                        + "superficiales y te aburren mortalmente. Estas muerto");
        this.unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new UnspecificBadConsequence("Pierdes dos niveles y dos tesoros "
                        + "ocultos.", 2, 0, 2);
        this.unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una"
                        + " mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new UnspecificBadConsequence("Da mucho asquito. Pierdes 3 niveles",
                        3, 0, 0);
        this.unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        prize = new Prize(3,1);
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal "
                        + "su nombre. Estás muerto");
        this.unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        prize = new Prize(4,1);
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto");
        this.unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        prize = new Prize(2,1);
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga"
                        + " a perder dos niveles y un tesoro de dos manos visible", 
                        2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un"
                        + " casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                        new ArrayList());
        this.unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        prize = new Prize(1,1);
        badConsequence = new UnspecificBadConsequence("Menudo susto te llevas. Pierdes 2"
                        + " niveles y 5 tesoros visibles", 2, 5, 0);
        this.unusedMonsters.add(new Monster("El lenguas", 20, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. "
                        + "Pierdes 3 niveles y tus tesoros visibles de las manos",
                        3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
                        new ArrayList());
        prize = new Prize(1,1);
        this.unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
        
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 1, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        this.unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, -2, badConsequence, prize));
        
        badConsequence = new UnspecificBadConsequence("Pierdes tus tesoros visibles. Jajaja", 1, 100, 0);
        prize = new Prize(2, 1);
        this.unusedMonsters.add(new Monster("Testigos Oculares", 6, 2, badConsequence, prize));
        
        badConsequence = new DeathBadConsequence("Hoy no es tu día. Mueres.");
        prize = new Prize(2,  5);
        this.unusedMonsters.add(new Monster("El gran cthulhu", 20, 4, badConsequence, prize));
        
        badConsequence = new UnspecificBadConsequence("Tu gobierno te recorta dos niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        this.unusedMonsters.add(new Monster("Serpiente político", 8, -2, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas", 
                0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR, TreasureKind.HELMET)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS))
        );
        prize = new Prize(1, 1);
        this.unusedMonsters.add(new Monster("Felpuggoth", 2, 5, badConsequence, prize));
        
        badConsequence = new UnspecificBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        this.unusedMonsters.add(new Monster("Shoggoth", 16, -4, badConsequence, prize));
        
        badConsequence = new UnspecificBadConsequence("Pintalabios negro. Pierdes dos niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        this.unusedMonsters.add(new Monster("Lolitagooth", 2, 3, badConsequence, prize));
        
        
        this.shuffleMonsters();
    }
    
    
    
}
