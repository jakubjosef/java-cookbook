/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kucharka.app;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import kucharka.gui.KucharkaFrame;
/**
 *
 * @author Jakub Josef
 */
public class Kucharka {
private final static String TITLE = "Kuchařka - Jakub Josef";
private final static String LF = "SystemLookAndFeel";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
               javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
                java.util.logging.Logger.getLogger(KucharkaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                  JFrame frame = new KucharkaFrame();
                  frame.setVisible(true);
                  frame.setTitle(TITLE);
            }
        });
        
      
    }
}
