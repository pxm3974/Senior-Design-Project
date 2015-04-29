/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author nibasabin
 */
public class SecondaryColorChooser extends JFrame implements ActionListener {

    private Color SelectColor2;

    public SecondaryColorChooser() {
        super("Welcome To Sidewalk Sketcher Color Chooser");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SelectColor2 = JColorChooser.showDialog(null, "Please Choose Color", SelectColor2);
        int Color2 = 1 * SelectColor2.getRGB();
        SidewalkSketcherGUI.ColorArray[1] = Color2;
        SidewalkSketcherGUI.imageDB[0] = ImageFilter.Filter(SidewalkSketcherGUI.imageDB[0], SidewalkSketcherGUI.ColorArray[0], SidewalkSketcherGUI.ColorArray[1]);
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

    }

}
