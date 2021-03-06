/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NapakalakiView.java
 *
 * Created on May 29, 2015, 12:51:00 PM
 */
package GUI;

import Model.Napakalaki;
import Model.CombatResult;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author nacho
 */
public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel;
    CombatResult lastCombatResult;
    
    public void setNapakalaki(Napakalaki napakalaki){
        
        
        this.napakalakiModel = napakalaki;
        
        currentPlayer.setPlayer(napakalaki.getCurrentPlayer());
        currentPlayer.setNapakalaki(napakalaki);
        currentMonster.setMonster(napakalaki.getCurrentMonster());
        
        repaint();
    }
    
    private String combatResultText(CombatResult result){
        String message;
        
        switch(result){
            case WINANDWINGAME:
                message = "¡Has ganado la partida!";
            break;
            case WIN:
                message = "Le has ganado al monstruo";
            break;
            case LOSE:
                message = "Has perdido contra el monstruo: te toca cumplir el mal rollo";
            break;
            case LOSEANDESCAPE:
                message = "Has perdido pero lograste escapar";
            break;
            case LOSEANDCONVERT:
                message = "Has perdido pero te has convertido en sectario";
            break;
            case LOSEANDDIE:
                message = "Estás muerto";
            break;
            default:
                message = "";  // avoid compiler warning in return
        }
        
        return message;
    }
    
    /** Creates new form NapakalakiView */
    public NapakalakiView() {
        initComponents();
        this.setTitle("Napakalaki");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentMonster = new GUI.MonsterView();
        currentPlayer = new GUI.PlayerView();
        showMonsterButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        combatResultMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        showMonsterButton.setText("Show monster");
        showMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMonsterButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Combat");
        combatButton.setEnabled(false);
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Next turn");
        nextTurnButton.setEnabled(false);
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(currentPlayer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(currentMonster, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 475, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(348, 348, 348)
                        .add(showMonsterButton)
                        .add(18, 18, 18)
                        .add(combatButton)
                        .add(18, 18, 18)
                        .add(nextTurnButton))
                    .add(layout.createSequentialGroup()
                        .add(188, 188, 188)
                        .add(combatResultMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 503, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(combatResultMessage)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(currentMonster, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 402, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(currentPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 448, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(showMonsterButton)
                    .add(combatButton)
                    .add(nextTurnButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMonsterButtonActionPerformed
        this.currentMonster.setVisible(true);
        this.currentMonster.setLevelDisplay(this.currentPlayer.playerModel);  // assure proper monster level display
        this.showMonsterButton.setEnabled(false);
        this.combatButton.setEnabled(true);
        this.currentPlayer.setEnabledControls(false);
    }//GEN-LAST:event_showMonsterButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        this.lastCombatResult = this.napakalakiModel.combat();  // TODO: manage combat result
        this.combatResultMessage.setText(this.combatResultText(this.lastCombatResult));
        showMessageDialog(null, this.combatResultText(this.lastCombatResult));
        this.combatResultMessage.setVisible(true);
        this.combatButton.setEnabled(false);
        this.currentPlayer.setEnabledControls(true);
        this.nextTurnButton.setEnabled(true);
        this.currentPlayer.setPlayer(this.currentPlayer.playerModel);  // redraw UI (new treasures)
    }//GEN-LAST:event_combatButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        if(this.lastCombatResult == CombatResult.WINANDWINGAME){
            System.exit(0);
        } else if(this.napakalakiModel.nextTurn()){
            this.combatResultMessage.setVisible(false);
            this.currentMonster.setVisible(false);
            this.nextTurnButton.setEnabled(false);
            this.showMonsterButton.setEnabled(true);
            this.setNapakalaki(this.napakalakiModel);
        } else {
            showMessageDialog(null, "Asegúrate de cumplir el mal rollo y de no tener mas de 4 tesoros escondidos");
        }
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    public void showView() {
        this.setVisible(true);
        this.currentMonster.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JLabel combatResultMessage;
    private GUI.MonsterView currentMonster;
    private GUI.PlayerView currentPlayer;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JButton showMonsterButton;
    // End of variables declaration//GEN-END:variables
}
