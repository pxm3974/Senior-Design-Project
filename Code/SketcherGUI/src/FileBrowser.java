/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

public class FileBrowser implements ActionListener {
 BufferedImage image = null;
 public static ImageIcon imageIcon;
 


    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        //SidewalkSketcherGUI myGUI= new SidewalkSketcherGUI();
        JFileChooser chooser = new JFileChooser("/Users/nibasabin/Desktop");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "jpeg","png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File path = chooser.getSelectedFile();
           // BufferedImage image = null;
            try {
                image = ImageIO.read(path);
            } catch (Exception f) {
                f.printStackTrace();

            }
            SidewalkSketcherGUI.imageDB[0]=image;
            ImageIcon imageIcon = new ImageIcon(SidewalkSketcherGUI.imageDB[0]);
            JLabel label = new JLabel(imageIcon);
        
            
   
            SidewalkSketcherGUI.panel1.add(label);
            SidewalkSketcherGUI.panel1.removeAll();
            SidewalkSketcherGUI.panel1.add(label);
            SidewalkSketcherGUI.panel1.setSize(600, 600);
          
            SidewalkSketcherGUI.myframe.setSize(600, 600);
            SidewalkSketcherGUI.myframe.pack();
            SidewalkSketcherGUI.myframe.setResizable(false);
            SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
            SidewalkSketcherGUI.myframe.setVisible(true);
           

            System.out.println("path kjkj" + path);

        }
    }

}
