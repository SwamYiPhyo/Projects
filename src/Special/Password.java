package Special;

import java.util.Scanner;
import java.util.*;
public class Password {

    public static void main(String[] args) {
        final String PASS_VALID = "^(?=.[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8}$";
        String str = "";
        boolean isCorrect = true;
        do
        {
            System.out.print("Enter: ");
            str = new Scanner(System.in).nextLine();
            if(str.equals("Stop"))
            {
                break;
            }
            else if(str.matches(PASS_VALID))
            {
                System.out.println("Valid");
                isCorrect = true;
            }
            else {
                System.out.println("Invalid");
                isCorrect = false;
            }
        }
        while(!isCorrect);
    }
}
