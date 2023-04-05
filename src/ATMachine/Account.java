package ATMachine;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    Scanner scan = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");
    LocalDateTime dT = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String format = formatter.format(dT);
    int customerNumber;
    int pinNumber;
    double checkingBalance = 0;
    double savingBalance = 0;
    public Account(int customerNumber, int pinNumber)
    {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }
    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance)
    {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }
    public int getCustomerNumber()
    {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber)
    {
        this.customerNumber = customerNumber;
    }
    public int getPinNumber()
    {
        return pinNumber;
    }
    public void setPinNumber(int pinNumber)
    {
        this.pinNumber = pinNumber;
    }
    public double getCheckingBalance()
    {
        return checkingBalance;
    }
    public double getSavingBalance()
    {
        return savingBalance;
    }
    public double calCheckingWithdraw(double amount)
    {
        checkingBalance -= amount;
        return checkingBalance;
    }
    public double calCheckingDeposit(double amount)
    {
        checkingBalance += amount;
        return checkingBalance;
    }
    public void calCheckingTransfer(double amount)
    {
        checkingBalance -= amount;
        savingBalance += amount;
    }
    public double calSavingWithdraw(double amount)
    {
        savingBalance -= amount;
        return savingBalance;
    }
    public double calSavingDeposit(double amount)
    {
        savingBalance += amount;
        return savingBalance;
    }
    public void calSavingTransfer(double amount)
    {
        savingBalance -= amount;
        checkingBalance += amount;
    }
    public void checkingWithdraw()
    {
        boolean isEnd = false;
        do {
            try
            {
                System.out.println("\nCurrent balance in your checking account : " + money.format(checkingBalance));
                System.out.print("Enter money amount to withdraw : ");
                double amount = scan.nextDouble();
                if((checkingBalance - amount) >= 0 && amount >=0)
                {
                    calCheckingWithdraw(amount);
                    System.out.println("\nYour new balance in your checking account = " + money.format(checkingBalance));
                    isEnd = true;
                }
                else {
                    System.out.println("\nBalance cannot be Negative!!!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Number(s) only!!!");
                scan.next();
            }
        }while (!isEnd);
    }
    public void checkingDeposit()
    {
        boolean isEnd = false;
        do {
            try {
                System.out.println("\nCurrent balance in your checking account : " + money.format(checkingBalance));
                System.out.print("Enter money amount to deposit to your checking account : ");
                double amount = scan.nextDouble();
                if((checkingBalance + amount) >= 0 && amount >= 0)
                {
                    calCheckingDeposit(amount);
                    System.out.println("\nYour new balance in your checking account = " + money.format(checkingBalance));
                    isEnd = true;
                }
                else {
                    System.out.println("\nBalance cannot be Negative!!!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
            }
        }while (!isEnd);
    }
    public void savingWithdraw()
    {
        boolean isEnd = false;
        do {
            try
            {
                System.out.println("\nCurrent balance in your saving account : " + money.format(savingBalance));
                System.out.print("Enter money amount to withdraw : ");
                double amount = scan.nextDouble();
                if((savingBalance - amount) >= 0 && amount >=0)
                {
                    calSavingWithdraw(amount);
                    System.out.println("\nYour new balance in your saving account = " + money.format(savingBalance));
                    isEnd = true;
                }
                else {
                    System.out.println("\nBalance cannot be Negative!!!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Number(s) only!!!");
                scan.next();
            }
        }while (!isEnd);
    }
    public void savingDeposit()
    {
        boolean isEnd = false;
        do {
            try {
                System.out.println("\nCurrent balance in your saving account : " + money.format(savingBalance));
                System.out.print("Enter money amount to deposit to your saving account : ");
                double amount = scan.nextDouble();
                if((savingBalance + amount) >= 0 && amount >= 0)
                {
                    calCheckingDeposit(amount);
                    System.out.println("\nYour new balance in your saving account = " + money.format(savingBalance));
                    isEnd = true;
                }
                else {
                    System.out.println("\nBalance cannot be Negative!!!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
            }
        }while (!isEnd);
    }
    public void Transfer(String accType)
    {
        boolean isEnd = false;
        do {
            try
            {
                if(accType.equals("Checking"))
                {
                    System.out.println("Choose one option to make a transfer process....." +
                            "\nType 1 - Saving." +
                            "\nType 2 - Exit.");
                    System.out.print("Choose: ");
                    int option = scan.nextInt();
                    switch (option)
                    {
                        case 1:
                            System.out.println("\nCurrent balance in your checking account: " + money.format(checkingBalance));
                            System.out.print("Enter money amount to transfer: ");
                            double amount = scan.nextDouble();
                            if((checkingBalance - amount) >= 0 && (savingBalance + amount) >= 0 && amount >=0)
                            {
                                calCheckingTransfer(amount);
                                System.out.println("Transaction is successfully completed at\t" + format);
                                System.out.println("Amount: " + money.format(amount));
                                isEnd = true;
                            }
                            else {
                                System.out.println("\nBalance cannot be negative!!!");
                            }
                            break;
                        case 2:
                            isEnd = true;
                            return;
                        default:
                            System.out.println("Invalid Choice!!!");break;
                    }
                } else if (accType.equals("Saving")) {
                    System.out.println("\nChoose one option to make a transfer process....." +
                            "\nType 1 - Checking." +
                            "\nType 2 - Exit.");
                    System.out.print("Choose: ");
                    int option = scan.nextInt();
                    switch (option)
                    {
                        case 1:
                            System.out.println("\nCurrent balance in your saving account: " + money.format(savingBalance));
                            System.out.print("Enter money amount to transfer: ");
                            double amount = scan.nextDouble();
                            if((savingBalance - amount) >= 0 && (checkingBalance + amount) >= 0 && amount >=0)
                            {
                                calSavingTransfer(amount);
                                System.out.println("Transaction is successfully completed at\t" + format);
                                System.out.println("Amount: " + money.format(amount));
                                isEnd = true;
                            }
                            else {
                                System.out.println("\nBalance cannot be negative!!!");
                            }
                            break;
                        case 2:
                            isEnd = true;
                            return;
                        default:
                            System.out.println("Invalid Choice!!!");break;
                    }
                }
            }catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
            }
        }while(!isEnd);
    }
}
