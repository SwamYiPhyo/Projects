package Special;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int num1 = 0 ;
        int num2 = 0;
        String ope = "";
        boolean isCorrect = true;
        do {
            try
            {
                if(isCorrect)
                {
                    System.out.print("Enter first integer: ");
                }
                num1 = new Scanner(System.in).nextInt();
                isCorrect = true;
            }
            catch (InputMismatchException e)
            {
                System.out.print("Input cannot be String format. This time actual number: ");
                isCorrect = false;
            }
            catch (Exception e)
            {
                System.out.print("Are you serious? Try again.....");
                isCorrect = false;
            }
        }
        while(!isCorrect);
        do {
            try
            {
                if(isCorrect)
                {
                    System.out.print("Enter second integer: ");
                }
                num2 = new Scanner(System.in).nextInt();
                isCorrect = true;

                while(!(ope.equals("+") || ope.equals("-")|| ope.equals("*") || ope.equals("/") || ope.equals("%")))
                {
                    if(isCorrect)
                    {
                        System.out.print("Choose one operation (+, -, *, /) => ");
                    }
                    ope = new Scanner(System.in).nextLine();
                    isCorrect = true;

                    switch (ope)
                    {
                        case "+" -> System.out.println(num1 + num2);
                        case "-" -> System.out.println(num1 - num2);
                        case "*" -> System.out.println(num1 * num2);
                        case "/" -> System.out.println(num1 / num2);
                        case "%" -> System.out.println(num1 % num2);
                    }
                    if(!(ope.equals("+") || ope.equals("-")|| ope.equals("*") || ope.equals("/") || ope.equals("%")))
                    {
                        System.out.print("Choose ONE VALID operation => ");
                        isCorrect = false;
                    }
                }
            }
            catch (InputMismatchException e)
            {
                System.out.print("Input cannot be String format. This time actual number: ");
                isCorrect = false;
            }
            catch (ArithmeticException e)
            {
                System.out.print("You attempt to divide by zero.");
            }
            catch (Exception e)
            {
                System.out.print("TF??? Try again.....");
                isCorrect = false;
            }
        }while(!isCorrect);
    }
}
