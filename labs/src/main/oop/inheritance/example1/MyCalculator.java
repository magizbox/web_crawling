package oop.inheritance.example1;

/**
 * Created by rain on 12/8/2016.
 */
public class MyCalculator extends Calculator {
   public void multiplication(int x, int y) {
      z = x * y;
      System.out.println("The product of the given numbers:"+z);
   }

   public static void main(String args[]) {
      int a = 20, b = 10;
      MyCalculator calculator = new MyCalculator();
      calculator.addition(a, b);
      calculator.Subtraction(a, b);
      calculator.multiplication(a, b);
   }
}
