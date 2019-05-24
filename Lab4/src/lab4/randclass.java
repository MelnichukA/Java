/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Random;

/**
 *
 * @author 1710512
 */
public class randclass {
       public int random(int max){
    Random random = new Random();
            int j = random.nextInt(max + 1);
            return j;
    }
    
}
