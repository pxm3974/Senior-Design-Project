/*
 * Class: ClearWindow
 * Interface: ActionPerformed(ActionEvent e)
 * Description: Clears the JPanel and Creates new JFrame
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author sabin Raj Bajracharya
 */
public class ClearWindow extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SidewalkSketcherGUI.imageDB[0]=null;
        SidewalkSketcherGUI.ColorArray[0]=0;
        SidewalkSketcherGUI.ColorArray[1]=16777215;
        SidewalkSketcherGUI.panel1.removeAll();
        SidewalkSketcherGUI.panel1.setSize(1075, 725);
        SidewalkSketcherGUI.myframe.dispose();
        SidewalkSketcherGUI.myframe.pack();
        SidewalkSketcherGUI.myframe.setResizable(false);
        SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SidewalkSketcherGUI.myframe.setVisible(true);
    
}
}
