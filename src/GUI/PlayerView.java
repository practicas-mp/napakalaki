/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Player;
import Model.Treasure;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author braulio
 */
public class PlayerView extends javax.swing.JPanel {

    Player playerModel;
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }

    public void setPlayer(Player p){
        playerModel = p;
        
        name.setText(p.getName());
        level.setText(p.getLevel() + "");
        
        fillTreasurePanel(visibleTreasures, p.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, p.getHiddenTreasures());
        
        
        repaint();
        revalidate();
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        buyLevelsButton = new javax.swing.JButton();
        discardTreasuresButton = new javax.swing.JButton();
        makeVisibleButton = new javax.swing.JButton();

        name.setText("jLabel1");

        level.setText("jLabel1");

        jLabel1.setText("Nombre");

        jLabel2.setText("Nivel");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Visible Treasures"));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Hidden Treasures"));

        buyLevelsButton.setText("Buy levels");

        discardTreasuresButton.setText("Discard Treasures");

        makeVisibleButton.setText("Make Visible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(level, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(makeVisibleButton)
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(discardTreasuresButton)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buyLevelsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)))
                                .addGap(56, 56, 56))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(level)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buyLevelsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discardTreasuresButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisibleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevelsButton;
    private javax.swing.JButton discardTreasuresButton;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisibleButton;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
