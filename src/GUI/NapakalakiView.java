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

/**
 *
 * @author nacho
 */
public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel;
    
    public void setNapakalaki(Napakalaki napakalaki){
        this.napakalakiModel = napakalaki;
    }
    
    /** Creates new form NapakalakiView */
    public NapakalakiView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void showView() {
        this.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
