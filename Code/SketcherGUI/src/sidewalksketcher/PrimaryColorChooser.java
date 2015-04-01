/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/**
 *
 * @author nibasabin
 */

    
    
 
 
/* ColorChooserDemo.java requires no other files. */
public class PrimaryColorChooser extends JFrame implements ActionListener
{
    private Color SelectColor1;
    public PrimaryColorChooser()
    {
        super("Welcome To Sidewalk Sketcher Color Chooser");
        
    }
                             
      @Override
    public void actionPerformed(ActionEvent e) {
        SelectColor1=JColorChooser.showDialog(null,"Please Choose Color", SelectColor1);
        int Color1= 1*SelectColor1.getRGB();
        SidewalkSketcherGUI.ColorArray[0]=Color1;
        SidewalkSketcherGUI.imageDB[0]=ImageFilter.Filter(SidewalkSketcherGUI.imageDB[0],SidewalkSketcherGUI.ColorArray[0],0);
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
        
        System.out.println(Color1);
        
    }
    
 
   
}
    
    

