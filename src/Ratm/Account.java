package Ratm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account
{
    Scanner scan = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    public double getCustomerNumber()
    {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(int checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(int savingBalance) {
        this.savingBalance = savingBalance;
    }
    public double calcCheckingWithdraw(double amount)
    {
        checkingBalance -= amount;
        return checkingBalance;
    }
    public double calcCheckingDeposit(double amount)
    {
        checkingBalance += amount;
        return checkingBalance;
    }
    public double calcSavingWithdraw(double amount)
    {
        savingBalance -= amount;
        return savingBalance;
    }
    public double calcSavingDeposit(double amount)
    {
        savingBalance += amount;
        return savingBalance;
    }
    public void checkingWithdraw()
    {
        System.out.println("Your current balance = " + money.format(checkingBalance));
        System.out.print("Enter money amount you would like to withdraw: ");
        double amount = scan.nextDouble();
        if((checkingBalance - amount) >= 0)
        {
            calcCheckingWithdraw(amount);
            System.out.println("Your new balance = " + money.format(checkingBalance));
        }
        else {
            System.out.println("Insufficient money amount in your account!!!");
        }
    }
    public void checkingDeposit()
    {
        System.out.println("Your current balance = " + money.format(checkingBalance));
        System.out.print("Enter money amount: ");
        double amount = scan.nextDouble();
        if((checkingBalance + amount) >= 0)
        {
            calcCheckingDeposit(amount);
            System.out.println("Your new balance = " + money.format(checkingBalance));
        }
        else{
            System.out.println("Money amount cannot be negative!!!");
        }
    }
    public void savingWithdraw()
    {
        System.out.println("Your current balance = " + money.format(savingBalance));
        System.out.print("Enter money amount you would like to withdraw: ");
        double amount = scan.nextDouble();
        if((savingBalance - amount) >= 0)
        {
            calcSavingWithdraw(amount);
            System.out.println("Your new balance = " + money.format(savingBalance));
        }
        else {
            System.out.println("Insufficient money amount in your account!!!");
        }
    }
    public void savingDeposit()
    {
        System.out.println("Your current balance = " + money.format(savingBalance));
        System.out.print("Enter money amount: ");
        double amount = scan.nextDouble();
        if((savingBalance + amount) >= 0)
        {
            calcSavingDeposit(amount);
            System.out.println("Your new balance = " + money.format(savingBalance));
        }
        else {
            System.out.println("Money amount cannot be negative!!!");
        }
    }
}