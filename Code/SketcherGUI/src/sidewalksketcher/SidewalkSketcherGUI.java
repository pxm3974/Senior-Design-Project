/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 *
 * @author nibasabin
 */
public class SidewalkSketcherGUI extends JFrame {
    /*
    Creates an User Interace with required buttons and options to load image
    
    */

    public static JFrame myframe;
    public static JButton crop;
    public JMenu File, Help;
    public JMenuItem loadPicture, savePicture, exit, About, Hardware, Software;
    public static JPanel panel1, panel2;
    FileBrowser myBrowser = new FileBrowser();
    ImageFilter myFilter = new ImageFilter();
    PrimaryColorChooser primaryColor = new PrimaryColorChooser();
    SecondaryColorChooser SecondaryColor = new SecondaryColorChooser();
    SendFile myFile = new SendFile();
    CropImage ImageCrop = new CropImage();
    ClearWindow Clear = new ClearWindow();
    Resize myResize = new Resize();
    public static BufferedImage[] imageDB = new BufferedImage[1];
    public static int[] ColorArray = new int[2];

    public SidewalkSketcherGUI() {
        ColorArray[0] = 0;
        ColorArray[1] = 16777215;
        myframe = new JFrame("Welcome To Sidewalk Sketcher Interface");
        JMenuBar menuBar = new JMenuBar();
        myframe.setJMenuBar(menuBar);
        File = new JMenu("File");
        loadPicture = new JMenuItem("Load Picture");
        File.add(loadPicture);
        loadPicture.addActionListener(myBrowser);
        exit = new JMenuItem("Exit");
        File.add(exit);
        JMenu Help = new JMenu("Help");
        About = new JMenuItem("About");
        Help.add(About);
        menuBar.add(File);
        menuBar.add(Help);
        Hardware = new JMenuItem("Hardware");
        Help.add(Hardware);
        Software = new JMenuItem("Software");
        Help.add(Software);
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1075, 725));
        panel1.setBackground(Color.lightGray);
        myframe.add(panel1, BorderLayout.LINE_START);
        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(200, 725));
        panel2.setBackground(Color.gray);
        myframe.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(15, 0, 0, 0));
        JButton empty1 = new JButton();
        empty1.setVisible(false);
        panel2.add(empty1);
        JButton empty2 = new JButton();
        empty2.setVisible(false);
        panel2.add(empty2);
        JButton filter = new JButton("Filter Image");
        panel2.add(filter);
        filter.addActionListener((ActionListener) myFilter);
        JButton resize = new JButton("Resize");
        panel2.add(resize);
        resize.addActionListener(myResize);
        crop = new JButton("Crop Image");
        panel2.add(crop);
        crop.addActionListener((ActionListener) ImageCrop);
        JButton chooseColor1 = new JButton("Choose Primary Color");
        panel2.add(chooseColor1);
        chooseColor1.addActionListener((ActionListener) primaryColor);
        JButton chooseColor2 = new JButton("Choose Secondary Color");
        panel2.add(chooseColor2);
        chooseColor2.addActionListener((ActionListener) SecondaryColor);
        JButton clear = new JButton("Clear Window");
        panel2.add(clear);
        clear.addActionListener((ActionListener) Clear);
        JButton empty3 = new JButton();
        empty3.setVisible(false);
        panel2.add(empty3);
        JButton empty4 = new JButton();
        empty4.setVisible(false);
        panel2.add(empty4);
        JButton empty5 = new JButton();
        empty5.setVisible(false);
        panel2.add(empty5);
        JButton complete = new JButton("Send to SidewalkSketcher");
        complete.addActionListener((ActionListener) myFile);
        complete.setBackground(Color.blue);
        panel2.add(complete);
        panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        myframe.pack();
        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
         myframe.setVisible(true);
}

    public static void main(String args[]) {
        SidewalkSketcherGUI obj = new SidewalkSketcherGUI();
    }
}
