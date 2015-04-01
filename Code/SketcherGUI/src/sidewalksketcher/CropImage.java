/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author nibasabin
 */
public class CropImage  implements ActionListener{
    
    public  class myCrop extends JPanel{
    @Override
    public void paint(Graphics g) {
    g.drawRect(0, 0, 200, 200);
  }
    public void dimension(Graphics g)
    {
        
    }
        
    }


    
  @Override
    public void actionPerformed(ActionEvent e) {
        myCrop crop= new myCrop();
        SidewalkSketcherGUI.panel1.add(crop);
       //SidewalkSketcherGUI.panel1.setSize(600, 600);
        //SidewalkSketcherGUI.myframe.setSize(400, 400);
        SidewalkSketcherGUI.myframe.pack();
        SidewalkSketcherGUI.myframe.setResizable(true);
        SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SidewalkSketcherGUI.myframe.setVisible(true);
}
}
