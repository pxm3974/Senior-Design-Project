/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
//import static javafx.scene.paint.Color.color;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author nibasabin
 */
public class ImageFilter implements ActionListener {

    final static int THERSOLD = 20;

    public static BufferedImage Filter(BufferedImage picture, int Color1, int Color2) {

        int column = picture.getWidth();
        int row = picture.getHeight();
        //int[][] pixelArray = new int[column][row];

        for (int x = 0; x < row - 1; x++) {
            for (int y = 0; y < column; y++) {
                /*
                 int p = picture.getRGB(y, x);
                 int alpha = (p >> 24) & 0xff;
                 int red = (p >> 16) & 0xff;
                 int green = (p >> 8) & 0xff;
                 int blue = p & 0xff;
                 int avg = (red + green + blue) / 3;
                 System.out.println(avg);
                 p = (alpha << 24) | (avg << 16) | (avg << 8) | avg;
                 picture.setRGB(y, x, p);
                
                 */

                int p = picture.getRGB(y, x);
                int p2 = picture.getRGB(y, x + 1);
                int alpha = (p >> 24) & 0xff;
                int alpha2 = (p2 >> 24) & 0xff;
                int red = (p >> 16) & 0xff;
                int red2 = (p2 >> 16) & 0xff;
                int green = (p >> 8) & 0xff;
                int green2 = (p2 >> 8) & 0xff;
                int blue = p & 0xff;
                int blue2 = p2 & 0xff;

                double ta = (red + green + blue + alpha) / 3.0;
                double ba = (red2 + green2 + blue2 + alpha2) / 3.0;

                if (abs(ta - ba) < THERSOLD) {
                    picture.setRGB(y, x, SidewalkSketcherGUI.ColorArray[1]);

//16777215
                } else {

                    picture.setRGB(y, x, SidewalkSketcherGUI.ColorArray[0]);
                    //System.out.println("( " + y + "," + x + " )");
                    //System.out.println(" y coordinate"+x);
                }

            }
        }
        return picture;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            // retrieve image
            BufferedImage bi = SidewalkSketcherGUI.imageDB[0];
            File outputfile = new File("/Users/nibasabin/Desktop/lamo2.bmp");
            System.out.println("file should be here");
            ImageIO.write(bi, "bmp", outputfile);
        } catch (Exception f) {

        }

        SidewalkSketcherGUI.imageDB[0] = Filter(SidewalkSketcherGUI.imageDB[0], SidewalkSketcherGUI.ColorArray[0], SidewalkSketcherGUI.ColorArray[1]);

        try {
            // retrieve image
            BufferedImage bi = SidewalkSketcherGUI.imageDB[0];
            String path = System.getProperty("user.dir");
            String saveImageAt = path + "/potrace/nibasabin.bmp";
            File outputfile = new File(saveImageAt);
            // System.out.println("file should be here");
            ImageIO.write(bi, "bmp", outputfile);
        } catch (Exception f) {
        }

        String currentDirectory = System.getProperty(("user.dir"));
        String path = "cd " + currentDirectory + "/potrace\n./potrace -s -o Image.svg nibasabin.bmp";
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path});
        } catch (IOException ex) {
            Logger.getLogger(ImageFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

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
