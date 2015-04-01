package sidewalksketcher;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;


public class rough extends JPanel implements MouseListener {

    int x, y;
    public JFrame myframe;
    public JPanel myPanel;
    
    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      paintBackground(g2);
      Color[] colors = { Color.YELLOW, Color.MAGENTA, Color.CYAN , Color.RED, Color.BLUE, Color.PINK};
      int colorIndex = 0;

      g2.setStroke(new BasicStroke(2));
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

      for (Shape s : shapes) {
        g2.setPaint(Color.BLACK);
        g2.draw(s);
        g2.setPaint(colors[(colorIndex++) % 6]);
        g2.fill(s);
      }

    public void roughdraw() {
       // super(" this is mouse listener");
        myframe = new JFrame();
        // myframe.setSize(400,400);
        myPanel = new JPanel();
        myframe.add(myPanel);
        myPanel.addMouseListener(this);
                
        myframe.pack();
        myPanel.setSize(500, 500);
        myframe.setSize(600, 600);

        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        myframe.setVisible(true);

    }

    public void myself( Image im)
    {
        
    }

    public static void main(String args[]) {
        rough obj = new rough();
        obj.roughdraw();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x
                = e.getX();
        y
                = e.getY();
        System.out.println("value of x=" + x);
        System.out.println("value of y=" + y);
        myPanel.repaint();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
         x
                = e.getX();
        y
                = e.getY();
        System.out.println("value of pressed x=" + x);
        System.out.println("value of pressed y=" + y);
       myPanel.repaint();
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
