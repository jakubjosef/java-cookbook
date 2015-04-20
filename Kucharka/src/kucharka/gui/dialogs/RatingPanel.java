package kucharka.gui.dialogs;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import kucharka.helpers.LevelBar;
import kucharka.helpers.SelectedImageFilter;

/**
 * Pomocný panel s hodnocením
 * @author Jakub Josef
 */
public class RatingPanel extends JPanel{
   private ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/kucharka/res/img/star.png"));
   private ImageProducer ip = null;
   private ImageIcon yStar = null;
   private List<ImageIcon> list = null;
   private LevelBar lBar = null;

    public RatingPanel() {
        ip=defaultIcon.getImage().getSource();
        yStar = makeStarImageIcon(ip,new float[]{1.0f,1.0f,.0f});
        list = Arrays.asList(yStar, yStar, yStar, yStar, yStar);
        lBar = new LevelBar(defaultIcon, list, 1);
        add(makeStarRatingPanel("Hodnocení", lBar));
    }   
    public int getRating(){
        return lBar.getLevel()+1;
    }
     private  JPanel makeStarRatingPanel(String title, final LevelBar label) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.setBorder(BorderFactory.createTitledBorder(title));
        p.add(new JButton(new AbstractAction("Smazat") {
            @Override public void actionPerformed(ActionEvent e) {
                label.clear();
            }
        }));
        p.add(label);
        return p;
    }
    private ImageIcon makeStarImageIcon(ImageProducer ip, float[] filter) {
        return new ImageIcon(createImage(new FilteredImageSource(ip, new SelectedImageFilter(filter))));
    }
}
