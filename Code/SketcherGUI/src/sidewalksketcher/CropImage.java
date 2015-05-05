/*
 * Class: CropImage,Crop
 * Methods: Methods inherited from class java.awt.Container,java.awt.Component
 * Interface: MouseListener, ActionListener
 * Description: Allows user to crop and image of desired size and creates new JFrame

 */
package sidewalksketcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 *
 * @author nibasabin
 * Source: StackOverFlow
 * http://stackoverflow.com/questions/7822202/drawing-a-rectangle-over-an-existing-graphics-page
 */
public class CropImage extends JPanel implements ActionListener {

    int x = 0;
    int y = 0;
    int width = 0;
    int height = 0;
    private static final Color DRAWING_RECT_COLOR = new Color(200, 200, 000);
    private static final Color DRAWN_RECT_COLOR = Color.green;

    public class Crop extends JPanel {

        private BufferedImage image;
        private Rectangle rect = null;
        private boolean drawing = false;

        public Crop() {
            image = SidewalkSketcherGUI.imageDB[0];
            MyMouseAdapter mouseAdapter = new MyMouseAdapter();
            addMouseListener(mouseAdapter);
            addMouseMotionListener(mouseAdapter);
        }

        @Override
        public Dimension getPreferredSize() {
            if (image != null) {
                return new Dimension(image.getWidth(), image.getHeight());
            }
            return super.getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            if (image != null) {
                g.drawImage(image, 0, 0, null);
            }
            if (rect == null) {
                return;
            } else if (drawing) {
                g2.setColor(DRAWING_RECT_COLOR);
                g2.draw(rect);
            } else {
                g2.setColor(DRAWN_RECT_COLOR);
                g2.draw(rect);
            }
        }

        private class MyMouseAdapter extends MouseAdapter {

            private Point mousePress = null;

            @Override
            public void mousePressed(MouseEvent e) {
                mousePress = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                drawing = true;
                x = Math.min(mousePress.x, e.getPoint().x);
                y = Math.min(mousePress.y, e.getPoint().y);
                width = Math.abs(mousePress.x - e.getPoint().x);
                height = Math.abs(mousePress.y - e.getPoint().y);

                rect = new Rectangle(x, y, width, height);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
                repaint();
                System.out.println("x " + x + "y " + y + "width " + width + "height" + height);
                
          
                
                int response = JOptionPane.showConfirmDialog(null, "Do you want to crop selected image");
                if (response==JOptionPane.YES_OPTION) {
                    image = image.getSubimage(x, y, width, height);
                    SidewalkSketcherGUI.imageDB[0] = image;
                    SidewalkSketcherGUI.panel1.removeAll();
                    ImageIcon imageIcon = new ImageIcon(SidewalkSketcherGUI.imageDB[0]);
                    JLabel label = new JLabel(imageIcon);
                    SidewalkSketcherGUI.panel1.removeAll();
                    SidewalkSketcherGUI.panel1.add(label);
                    SidewalkSketcherGUI.panel1.setBackground(Color.lightGray);
                    SidewalkSketcherGUI.myframe.setSize(1275, 725);
                    SidewalkSketcherGUI.myframe.pack();
                    SidewalkSketcherGUI.myframe.setLocationRelativeTo(null);
                    SidewalkSketcherGUI.myframe.setResizable(true);
                    SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    SidewalkSketcherGUI.myframe.setVisible(true);
                    System.out.println("Image croped");
                } else {
                    SidewalkSketcherGUI.imageDB[0] = image;
                    SidewalkSketcherGUI.panel1.removeAll();
                    ImageIcon imageIcon = new ImageIcon(SidewalkSketcherGUI.imageDB[0]);
                    JLabel label = new JLabel(imageIcon);
                    SidewalkSketcherGUI.panel1.removeAll();
                    SidewalkSketcherGUI.panel1.add(label);
                    SidewalkSketcherGUI.panel1.setBackground(Color.lightGray);
                    SidewalkSketcherGUI.myframe.setSize(1275, 725);
                    SidewalkSketcherGUI.myframe.pack();
                    SidewalkSketcherGUI.myframe.setLocationRelativeTo(null);
                    SidewalkSketcherGUI.myframe.setResizable(true);
                    SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    SidewalkSketcherGUI.myframe.setVisible(true);
                }

            }

        }

        private void createAndShowGui() {
            SidewalkSketcherGUI.panel1.setPreferredSize(new Dimension(1075, 725));
            SidewalkSketcherGUI.panel1.add(new Crop());
            SidewalkSketcherGUI.panel1.setBackground(Color.lightGray);
            SidewalkSketcherGUI.myframe.setSize(1275, 725);
            SidewalkSketcherGUI.myframe.pack();
            SidewalkSketcherGUI.myframe.setLocationRelativeTo(null);
            SidewalkSketcherGUI.myframe.setResizable(true);
            SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
            SidewalkSketcherGUI.myframe.setVisible(true);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(SidewalkSketcherGUI.myframe, "Cropping Function Enabled.");
        SidewalkSketcherGUI.panel1.removeAll();
        Crop myCrop = new Crop();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                myCrop.createAndShowGui();
            }
        });

    }
}
