import java.util.*;
import javax.swing.JOptionPane;
 
 
public class ex {
    private int matriks[][];
    private int result[][];
   // private int razmer; //избыточная переменная
 
ex(int n){
        //razmer=n;
 
        matriks= new int [n][n];
        /*Вводятся случайные значения*/
        for (int i=0;i<matriks.length ;i++)
            
            for (int j=0;j<matriks[i].length ;j++)
                
                matriks[i][j]=(int) (Math.random()*10);
        
            /*Вывод элементов*/
        System.out.println("Случайное заполнение матрицы: ");
        for (int i=0;i<matriks.length;i++)
        {
            
                for (int j=0;j<matriks[i].length ;j++)
                {
                    System.out.print(matriks[i][j]+"   ");
      
                }
                
                System.out.println();
        }
        
}
/*Метод сумма матриц*/
public  void sum(ex m1,ex m2){
    System.out.println ("Сумма двух матриц: ");
 
    for (int i=0;i<matriks.length ;i++)
        {
            for (int j=0;j<matriks[i].length ;j++)
            {
            
                System.out.print (m1.matriks[i][j]+m2.matriks[i][j]+ "  ");
            }
            System.out.println();
        }
 
}
 
//Метод умножения матриц: M1 X M2   
public  void multiply(ex m1,ex m2, int M_level){
    result = new int [M_level][M_level];
    System.out.println ("Произведение двух матриц: ");
 
int res =0;
    for (int z =0; z< M_level; z++)
    {
        System.out.print ("|  ");
        for (int j =0; j<M_level;j++)
        {
            res =0;
            for (int i =0; i<M_level;i++)
            {
                res = res + m1.matriks[z][i] * m2.matriks[i][j];
                if (i!=M_level-1)
                    System.out.print (m1.matriks[z][i]+ " * "+ m2.matriks[i][j]+ " + ");
                else
                    System.out.print (m1.matriks[z][i]+ " * "+ m2.matriks[i][j]+ "   ");
            }
            result[z][j] = res;
        }
        System.out.print ("|");
        System.out.println();
    }
    
            System.out.println();
            
            System.out.println ("Результат: ");
            for (int j=0;j<M_level;j++)
            {
                for (int i =0; i<M_level;i++)
                {
                
                    System.out.print (result[j][i] +" ");
                }
                System.out.println();
            }
}
 
//*второй класс создание матриц*/
public static void main(String[] args) {
 
            String nam=JOptionPane.showInputDialog("Введите размерность матрицы:");
            int m=Integer.parseInt(nam);
            System.out.println("Размерность матрицы = "+m+" на "+m);
            ex m1=new  ex(m);
            ex m2=new  ex(m);
            m1.sum(m1,m2);
            m1.multiply(m1, m2, m);
            //System.out.println(m1.sum(m1, m2));
        }
      }
