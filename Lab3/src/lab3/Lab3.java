/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.util.Random;
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int z = 4;
    int u= 20;
    int o= 10;
    int[] a = new int[10];
      for (int i = 0; i < a.length; i++) {
        a[i] =(int)(Math.random()*u-o);
        System.out.println(a[i]);
       }
       System.out.println("\nA positive number that is greater than the specified:");
        for (int value : a) {
            if (value >= z) {
                System.out.println(value);
    }
    
}
}
    }
