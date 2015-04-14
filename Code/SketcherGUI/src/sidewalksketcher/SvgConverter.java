/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author nibasabin
 */
public class SvgConverter {

    public static void main(String[] args) throws IOException {

        String currentDirectory = System.getProperty(("user.dir"));
      //  System.out.println("lalala"+currentDirectory);
        String path = "cd " + currentDirectory + "/potrace\n./potrace -s -o apple.svg lamo.bmp";
        Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path});

        //Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","cd /Users/nibasabin/Desktop/potrace\n ./potrace -s -o apple.svg lamo.bmp"});
        BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = " ";
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }

    }
}
