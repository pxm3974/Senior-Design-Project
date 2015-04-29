package sidewalksketcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;
import java.io.PrintWriter;
import java.util.*;

public class FileInput {

    static final Matcher matchPoint = Pattern.compile("\\s*(\\d+)[^\\d]+(\\d+)\\s*").matcher("");
public static void path(String in){
  
        final Matcher matchPathCmd = Pattern.compile("([MmLlHhVvAaQqTtCcSsZz])|([-+]?((\\d*\\.\\d+)|(\\d+))([eE][-+]?\\d+)?)").matcher(in);
        Vector<Double> xcor = new Vector<Double>(3, 2);
        Vector<Double> ycor = new Vector<Double>(3, 2);
      List<Double> distance = new ArrayList(Arrays.asList());
LinkedList<String> tokens = new LinkedList<String>();
        while (matchPathCmd.find()) {
            tokens.addLast(matchPathCmd.group());
        }

        char curCmd = 'Z';

        /* adding the origin to the vector */
        xcor.add(0.00);
        ycor.add(0.00);

        while (tokens.size() != 0) {
            String curToken = tokens.removeFirst();
            char initChar = curToken.charAt(0);
            if ((initChar >= 'A' && initChar <= 'Z') || (initChar >= 'a' && initChar <= 'z')) {
                curCmd = initChar;
            } else {
                tokens.addFirst(curToken);
            }

            switch (curCmd) {
                case 'M':
                    
                    xcor.add(nextFloat(tokens));
                    ycor.add(nextFloat(tokens));
                    curCmd = 'L';
                    break;
                case 'm':
                    xcor.add(xcor.lastElement() + nextFloat(tokens));
                    ycor.add(ycor.lastElement() + nextFloat(tokens));
                    curCmd = 'l';
                    break;
                case 'L':
                    xcor.add(nextFloat(tokens));
                    ycor.add(nextFloat(tokens));
                    break;
                case 'l':
                    xcor.add(xcor.lastElement() + nextFloat(tokens));
                    ycor.add(ycor.lastElement() + nextFloat(tokens));
                    break;
                case 'H':
                    xcor.add(nextFloat(tokens));
                    ycor.add((Double) ycor.lastElement());
                    break;
                case 'h':
                    xcor.add(nextFloat(tokens));
                    ycor.add((Double) ycor.lastElement());
                    break;
                case 'V':
                    xcor.add((Double) xcor.lastElement());

                    ycor.add(nextFloat(tokens));

                    break;
                case 'v':
                    xcor.add((Double) xcor.lastElement());

                    ycor.add(nextFloat(tokens));

                    break;
                case 'A':
                case 'a':
                    break;
                case 'Q':
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    break;
                case 'q':
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    break;
                case 'T':
                    xcor.add(nextFloat(tokens));

                    ycor.add(nextFloat(tokens));
                    break;
                case 't':
                    xcor.add(nextFloat(tokens));
                    ycor.add(nextFloat(tokens));
                    break;
                case 'C': case 'c':
                    double point1X=xcor.lastElement();
                    double point2X=nextFloat(tokens);
                    double point2Y=nextFloat(tokens);
                    double point3X=nextFloat(tokens);
                    double point3Y=nextFloat(tokens);
                    double point4X=nextFloat(tokens);
                    double point4Y=nextFloat(tokens);
                    double point1Y=ycor.lastElement();
                    double x,
                     y;
                    double step = 0.01;

                    for (double t = 0; t < 1.0; t = t + step) {
                        x = Math.pow((1 - t), 3) * point1X + 3 * (Math.pow((1 - t), 2) * t) * point2X
                                + (3 * (1 - t) * Math.pow(t, 2)) * point3X + Math.pow(t, 3) * point4X;
                        xcor.add(x);

                        y = Math.pow((1 - t), 3) * point1Y + 3 * (Math.pow((1 - t), 2) * t) * point2Y
                                + (3 * (1 - t) * Math.pow(t, 2)) * point3Y + (Math.pow(t, 3)) * point4Y;
                        ycor.add(y);

                    }
 break;
                case 'S':
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    break;
                case 's':
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    System.out.println(nextFloat(tokens));
                    break;
                case 'Z':
                case 'z':

                    break;
                default:
                    throw new RuntimeException("Invalid path element");
            }

        }

        Double[] xarray = {};
        xarray = xcor.toArray(xarray);

        Double[] yarray = {};
        yarray = ycor.toArray(yarray);
        System.out.println("Start coordinates:");
        for (int a = 0; a < xarray.length; a++) {
            System.out.print("("+xarray[a] + ",");
            System.out.print(yarray[a]+")");
            System.out.println();
        }
        
        System.out.println("end");
        double prev_angle = 0;
        double new_current_angle = 0;
        double curr_angle = 0;

        System.out.println("Angle:");
        PrintWriter writer = null;
        prev_angle = calcAngle(0, 0, (double) xarray[0], (double) yarray[0]);
        try {
            writer = new PrintWriter("/Users/nibasabin/Documents/NetbeansWorkspace/SidewalkSketcher/instruction.txt", "UTF-8");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("**********************");

        for (int r = 0; r < xarray.length - 1; r++) {
distance.add(Math.sqrt((xarray[r] - xarray[r + 1]) * (xarray[r] - xarray[r + 1]) + (yarray[r] - yarray[r + 1]) * (yarray[r] - yarray[r + 1])));
            curr_angle = calcAngle((double) xarray[r], (double) yarray[r], (double) xarray[r + 1], (double) yarray[r + 1]);
            new_current_angle = curr_angle - prev_angle;
            prev_angle = curr_angle;
            System.out.println(new_current_angle + ", " + distance.get(r));
            writer.println(new_current_angle + ", " + distance.get(r));		
        }
        writer.close();

    }

    static protected double nextFloat(LinkedList<String> l) {
        String s = l.removeFirst();
        return Double.parseDouble(s);
    }

    public void print(String args) {
        System.out.println(args);
    }

    /**
     * This function return angle between two points provided
     *
     *
     */

    public static double calcAngle(double point1X, double point1Y, double point2X, double point2Y) {

        double xDiff = point2X - point1X;
        double yDiff = point2Y - point1Y;
        System.out.println("("+point1X+"," + point1Y +")");
        double angle = Math.toDegrees(Math.atan2(yDiff, xDiff));
        return angle;
    }

}
