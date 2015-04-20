/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kucharka.tests;

import java.util.Arrays;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import kucharka.gui.comments.CommentsPanel;
import kucharka.model.Comment;

/**
 *
 * @author JaKoB
 */
public class panelTest{
    public static void main(String[] args){
    JFrame testFrame= new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    CommentsPanel pnlComments = new CommentsPanel();
    pnlComments.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    pnlComments.setData(Arrays.asList(new Comment("Pavel vomáčka", "Ahoj duky", (byte) 5, new Date(), 150)));
    testFrame.add(pnlComments);
    testFrame.setVisible(true);        
    testFrame.pack();
    
    
    }
    
    
}
