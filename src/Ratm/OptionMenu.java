package Ratm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account
{
    Scanner scan = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();
    int option = 0;

    public void getLogin()
    {
        System.out.println("+++ Welcome to ATM program +++");
        boolean isCorrect = true;
        int cus = 0;
        int pin = 0;
        do {
            data.put(12345, 54321);
            data.put(345, 543);

            try
            {
                System.out.print("Enter your Customer number: ");
                cus = scan.nextInt();
                setCustomerNumber(cus);

                System.out.print("Enter your Pin number: ");
                pin = scan.nextInt();
                setPinNumber(pin);

                check(cus , pin);
                isCorrect = false;
                break;
            } catch (WrongInputException | StringFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scan.nextLine(); // clear the scanner buffer
            }
        }while(isCorrect);
        System.out.println("Have a nice day <3");
    }
    public void check(int cus, int pin) throws WrongInputException, StringFormatException
    {
        try
        {
            for(Map.Entry<Integer, Integer> entry : data.entrySet())
            {
                if(cus == entry.getKey() && pin == entry.getValue())
                {
                    getAccountType();
                    break;
                }
                else {
                    throw new WrongInputException("Wrong Customer number or Pin number!!!");
                }
            }
        }
        catch (NumberFormatException e)
        {
            throw new StringFormatException("Input cannot be String Format!!!!");
        }
    }
    public void getAccountType()
    {
        System.out.println("+++ Here are Account Types +++");
        System.out.println("1. Main Account.");
        System.out.println("2. Smurf Account.");
        System.out.println("3. Exit.");
        System.out.print("What would you like to do?.....");
        while (true) {
            try {
                option = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number.");
                scan.next(); // clear the input buffer
            }
        }

        switch (option) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thanks for using our program UwU");
            default -> {
                System.out.println("Wrong Input");
                getAccountType();
            }
        }
    }
    public void getChecking()
    {
        System.out.println("+++ Checking Account +++");
        System.out.println("1. View Balance.");
        System.out.println("2. Withdraw Money.");
        System.out.println("3. Deposit Money.");
        System.out.println("4. Exit.");
        System.out.print("Choose: ");
        while (true) {
            try {
                option = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number.");
                scan.next(); // clear the input buffer
            }
        }

        switch (option)
        {
            case 1:
                System.out.println("Your current balance = " + money.format(getCheckingBalance()));getAccountType();break;
            case 2:checkingWithdraw();getAccountType();break;
            case 3:checkingDeposit();getAccountType();break;
            case 4:getAccountType();break;
            default:getChecking();break;
        }
    }
    public void getSaving()
    {
        System.out.println("+++ Saving Account +++");
        System.out.println("1. View Balance.");
        System.out.println("2. Withdraw Money.");
        System.out.println("3. Deposit Money.");
        System.out.println("4. Exit.");
        System.out.print("Choose: ");
        while (true) {
            try {
                option = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number.");
                scan.next(); // clear the input buffer
            }
        }

        switch (option)
        {
            case 1:
                System.out.println("Your current balance = " + money.format(getSavingBalance()));getAccountType();break;
            case 2:savingWithdraw();getAccountType();break;
            case 3:savingDeposit();getAccountType();break;
            case 4:getAccountType();break;
            default:getSaving();break;
        }
    }
}