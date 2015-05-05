/*
 * Class: FileBrowser
 * Interface: ActionListener
 * Description: Allows user to open selected image and creates a JFrame to display.
 */
package sidewalksketcher;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Sabin Raj Bajracharya
 */
public class FileBrowser implements ActionListener {
 BufferedImage image = null;
 public static ImageIcon imageIcon;

    @Override
    public void actionPerformed(ActionEvent e) {
        SidewalkSketcherGUI.myframe.dispose();
        JFileChooser chooser = new JFileChooser("/Users/nibasabin/Desktop");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "jpeg","png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File path = chooser.getSelectedFile();
            try {
                image = ImageIO.read(path);
            } catch (Exception f) {
                f.printStackTrace();

            }
            SidewalkSketcherGUI.imageDB[0]=image;
            ImageIcon imageIcon = new ImageIcon(SidewalkSketcherGUI.imageDB[0]);
            JLabel label = new JLabel(imageIcon);
            SidewalkSketcherGUI.panel1.removeAll();
            SidewalkSketcherGUI.panel1.add(label);
            SidewalkSketcherGUI.panel1.setSize(1075, 725);
            SidewalkSketcherGUI.myframe.pack();
            SidewalkSketcherGUI.myframe.setResizable(false);
            SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
            SidewalkSketcherGUI.myframe.setVisible(true);

        }
    }

}
