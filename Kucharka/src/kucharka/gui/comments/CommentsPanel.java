package kucharka.gui.comments;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import kucharka.model.Comment;


/**
 *  Trida s panelem komentářů
 *  @author Jakub Josef
 */

public class CommentsPanel extends javax.swing.JPanel{
    
    private int restrictItems=0;

    public CommentsPanel() {super();}
    /**
     * Vykreslovaci fce pro kolekci komentaru
     * @param comments 
     */
    public void setData(List<Comment> comments){
       removeAll();
      if(comments!=null){
        //potrebujeme box layout aby byly elementy pod sebou
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(restrictItems==0){
            for (Comment comment : comments) {
                add(new CommentRow(comment));
            }
        }else{
           if(comments.size()>=restrictItems){
                for(int i=0;i<=restrictItems;i++){
                    add(new CommentRow(comments.get(i)));
                }
             }else{
                    for (Comment comment : comments) {
                        add(new CommentRow(comment));
                    }
                }
            }
      }else{
          //tady naopak border layout aby se mohla jedna komponenta roztahnout na cely panel
          setLayout(new BorderLayout());
          JLabel lblNoComments = new JLabel("Žádné komentáře",JLabel.CENTER);
          lblNoComments.setFont(new Font("Trebuchet MS", 0, 16));
          lblNoComments.setPreferredSize(new Dimension(620,120));
          lblNoComments.setHorizontalAlignment(SwingConstants.CENTER);
          lblNoComments.setVerticalAlignment(SwingConstants.CENTER);
          add(lblNoComments);
      }
      validate();
      repaint();
    }
    public void restrictItems(int count){
        this.restrictItems=count;
    }
 
}