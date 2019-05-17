/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author 1710517
 */
import java.util.Random;
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {




    Random rand = new Random();
    double p = 9;
    double x = 2.0, a = 0.75, b = 1.1, c = 0.4;
    double r = Math.sin((a*x-1)/b*Math.pow(x*x-c, 1.0/3)), t = Math.tan(b/ a*x* x +c);
    double y = 1/r + 1/t;
    System.out.println(y);

    double x1 = p * rand.nextDouble();
    double a1 = p * rand.nextDouble();
    double b1 = p * rand.nextDouble();
    double c1 = p * rand.nextDouble();

    double z = Math.pow(a1, -b1 * x1), n = Math.abs(c1 * x1 - a1), v = (b1 * x1 * x1 + c1);
    double y1 = z * Math.cos(n / v);

    System.out.println(y1);
 
    }
    
}
