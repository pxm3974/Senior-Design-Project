/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JFrame.HIDE_ON_CLOSE;
import javax.swing.JPanel;
import java.awt.Rectangle; 
import java.awt.Robot; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import java.awt.image.BufferedImage; 
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;


/**
 *
 * @author nibasabin
 */
public class CropImage extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    
	 int drag_status=0,c1,c2,c3,c4; 
	   BufferedImage image = null;
	   public static ImageIcon imageIcon;
    
    public void draggedScreen()throws Exception 
	{ 
		int w = c1 - c3; 
		int h = c2 - c4; 
		w = w * -1; 
		h = h * -1; 
		Robot robot = new Robot(); 
		BufferedImage img = robot.createScreenCapture(new Rectangle(c1, c2,w,h)); 
		SidewalkSketcherGUI.imageDB[0]=img;
 		 
        ImageIcon imageIcon = new ImageIcon(img);
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
		
		System.out.println("Cropped image."); 
		} 
	@Override 
	public void mouseClicked(MouseEvent arg0)
	 {	}
	
	@Override 
	public void mouseEntered(MouseEvent arg0) {	} 
	@Override 
	
	public void mouseExited(MouseEvent arg0)
	 {	}
	
	@Override 
	public void mousePressed(MouseEvent arg0) 
	{ 	repaint(); 
		c1=arg0.getX(); 
		c2=arg0.getY(); 
		} 
	
	@Override 
	public void mouseReleased(MouseEvent arg0) 
	{ 	repaint(); 
		if(drag_status==1) 
		{ 	c3=arg0.getX(); 
			c4=arg0.getY(); 
		try 
		{
			draggedScreen();
				 
		} 
		catch(Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		}
	 }
	
	@Override 
	public void mouseDragged(MouseEvent arg0) 
	{ 	repaint(); 
		drag_status=1; 
		c3=arg0.getX(); 
		c4=arg0.getY(); 
	}
	
	@Override 
	public void mouseMoved(MouseEvent arg0) 
	{ 
	}
	 
	public void paint(Graphics g) 
	{ 	super.paint(g); 
		int w = c1 - c3; 
		int h = c2 - c4; 
		w = w * -1; 
		h = h * -1; 
		if(w<0) 
			w = w * -1; 
			g.drawRect(c1, c2, w, h);	
		} 

    
  @Override
    public void actionPerformed(ActionEvent e) {
	  	image =SidewalkSketcherGUI.imageDB[0];
	  	ImagePanel im=new ImagePanel(image); 
		add(im);
		setSize(600,600); 
		setVisible(true); 
		addMouseListener(this); 
		addMouseMotionListener( this ); 
		setDefaultCloseOperation(HIDE_ON_CLOSE); 
		
}

}

class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}

