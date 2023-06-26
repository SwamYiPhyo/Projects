package Special;

import java.util.Random;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        int PlayerS = 0;
        int EnemyS = 0;
        String input = "";

        while(PlayerS != 3 && EnemyS != 3)
        {
            System.out.println("'r' for Rock, 'p' for Paper and 's' for Scissors.");
            System.out.print("You choice: ");
            input = scan.nextLine();
            int Einput = rnd.nextInt(0, 3);
            if(Einput == 0)
            {
                System.out.println("Enemy choose rock!!!");

                switch (input)
                {
                    case "r":
                        System.out.println("Tie!!!");
                        break;
                    case "p":
                        System.out.println("You win this round!!!");
                        PlayerS++;
                        break;
                    case "s":
                        System.out.println("Enemy win this round!!!");
                        EnemyS++;
                        break;
                    default:
                        System.out.println("Wrong Input!!!");
                        break;
                }
            }
            else if(Einput == 1)
            {
                System.out.println("Enemy choose paper!!!");

                switch (input)
                {
                    case "r":
                        System.out.println("Enemy win this round!!!");
                        EnemyS++;
                        break;
                    case "p":
                        System.out.println("Tie!!!");break;
                    case "s":
                        System.out.println("You win this round!!!");
                        PlayerS++;
                        break;
                    default:
                        System.out.println("Wrong Input!!!");break;
                }
            }
            else {
                System.out.println("Enemy choose scissors!!!");

                switch (input)
                {
                    case "r":
                        System.out.println("You win this round!!!");
                        PlayerS++;
                        break;
                    case "p":
                        System.out.println("Enemy this round!!!");
                        EnemyS++;
                        break;
                    case "s":
                        System.out.println("Tie!!!");
                        break;
                    default:
                        System.out.println("Wrong Input!!!");
                        break;
                }
            }
        }
        if(PlayerS > EnemyS)
        {
            System.out.println("Congratulations!!!");
        }
        else {
            System.out.println("Not this time :(");
        }
    }
}
