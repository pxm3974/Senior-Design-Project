/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author nibasabin
 */
public class SendFile implements ActionListener {
    GetPathFromSVG svgPath= new GetPathFromSVG();

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        String currentDirectory = System.getProperty(("user.dir"));
        try {
            BufferedImage bi = SidewalkSketcherGUI.imageDB[0];
            File outputfile = new File(currentDirectory+"/potrace/nibasabin.bmp");
            System.out.println("file should be here");
            ImageIO.write(bi, "bmp", outputfile);
        } catch (Exception f) {

        }

  String path = "cd " + currentDirectory + "/potrace\n./potrace -s -o Image.svg nibasabin.bmp";
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path});
        } catch (IOException ex) {
            Logger.getLogger(ImageFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            svgPath.path(); // CAlling the path function to get the path
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String path1 = "cd " + currentDirectory + "/potrace/\n python client.py";
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path1});
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = " ";
        try {
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    }
    
    

