/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author nibasabin
 */
public class ClearWindow extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SidewalkSketcherGUI.imageDB[0]=null;
        SidewalkSketcherGUI.ColorArray[0]=0;
        SidewalkSketcherGUI.ColorArray[1]=16777215;
        SidewalkSketcherGUI.panel1.removeAll();
        SidewalkSketcherGUI.panel1.setSize(600, 600);

        SidewalkSketcherGUI.myframe.setSize(600, 600);
        SidewalkSketcherGUI.myframe.pack();
        SidewalkSketcherGUI.myframe.setResizable(false);
        SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SidewalkSketcherGUI.myframe.setVisible(true);
    
}
}
