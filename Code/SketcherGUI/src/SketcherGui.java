/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

/**
 *
 * @author nibasabin
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SketcherGui extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1;
    private JMenu File, Help;
    public JMenuItem loadPicture, savePicture, exit;
    private JFrame myframe;
    public JPanel panel1;

    public SketcherGui() {
        //super("Welcome To Sidewalk Sketcher Interface");
        myframe = new JFrame("Welcome To Sidewalk Sketcher Interface");
        JMenuBar menuBar = new JMenuBar();
        myframe.setJMenuBar(menuBar);

        File = new JMenu("File");
        loadPicture = new JMenuItem("Load Picture");
        File.add(loadPicture);
        loadPicture.addActionListener(this);
        savePicture = new JMenuItem("Save Picture");
        File.add(savePicture);
        savePicture.addActionListener(this);
        exit = new JMenuItem("Exit");
        File.add(exit);
        exit.addActionListener(this);

        JMenu help = new JMenu("Help");
        menuBar.add(File);
        menuBar.add(help);

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1000, 700));
        panel1.setBackground(Color.lightGray);
        myframe.add(panel1, BorderLayout.LINE_START);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(200, 700));

        panel2.setBackground(Color.gray);
        myframe.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(15, 0, 0, 0));

        JButton empty1 = new JButton();
        empty1.setVisible(false);
        panel2.add(empty1);

        JButton empty2 = new JButton();
        empty2.setVisible(false);
        panel2.add(empty2);

        JButton resize = new JButton("Resize");
        panel2.add(resize);
        resize.addActionListener(this);
        JButton crop = new JButton("Crop Image");
        panel2.add(crop);
        JButton chooseColor = new JButton("Choose Color");
        panel2.add(chooseColor);
        panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        panel1.setSize(500, 500);

        myframe.setSize(600, 600);
        myframe.pack();
        myframe.setResizable(false);
        myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

        myframe.setVisible(true);

    }

    public void myImage(File image, SketcherGui obj) {

    }

    public void MakeGui() {

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loadPicture)) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "jpeg");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File path = chooser.getSelectedFile();
                BufferedImage image = null;
                try {
                    image = ImageIO.read(path);
                } catch (Exception f) {
                    f.printStackTrace();

                }

                ImageIcon imageIcon = new ImageIcon(image);
                JLabel label = new JLabel(imageIcon);
                panel1.removeAll();
                panel1.add(label);
                panel1.setSize(500, 500);
                panel1.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
                myframe.setSize(600, 600);
                myframe.pack();
                myframe.setResizable(false);
                myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);

                myframe.setVisible(true);
                myframe.repaint();
                panel1.repaint();

                System.out.println("path kjkj" + path);

            }

        } else if (e.getSource()
                .equals(savePicture)) {

        } else if (e.getSource()
                .equals(exit)) {
            System.exit(0);
        }

    }

    public static void main(String args[]) {
        SketcherGui obj = new SketcherGui();
        obj.MakeGui();

    }
}
