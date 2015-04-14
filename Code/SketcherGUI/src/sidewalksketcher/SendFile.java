/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nibasabin
 */
public class SendFile implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentDirectory = System.getProperty(("user.dir"));
        String path = "cd " + currentDirectory + "/potrace/\n python client.py";
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path});
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","cd /Users/nibasabin/Desktop/potrace\n ./potrace -s -o apple.svg lamo.bmp"});
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
    
    

