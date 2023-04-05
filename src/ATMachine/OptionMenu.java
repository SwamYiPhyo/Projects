package ATMachine;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu {
    Scanner scan = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Account> data = new HashMap<>();
    List<String> detail = new ArrayList<>();
    public void mainMenu()
    {
        data.put(162002, new Account(162002, 162, 100000, 500000));
        data.put(12345, new Account(12345, 54321, 10000, 20000));
        boolean isEnd = false;
        do {
           try
           {
               System.out.println("\nType 1 - Login.");
               System.out.println("Type 2 - Create Account.");
               System.out.print("Choose: ");
               int option = scan.nextInt();
               switch (option)
               {
                   case 1:
                       getLogin();
                       isEnd = true;
                       break;
                   case 2:
                       createAccount();
                       isEnd = true;
                       break;
                   default:
                       System.out.println("\nInvalid Choice!!!");break;
               }
           }
           catch (WrongCustomerOrPinNumbers e)
           {
               System.out.println();
               System.out.println("Error: " + e.getMessage());
           }
           catch (InputMismatchException e)
           {
               System.out.println("\nNumber(s) only!!!");
               scan.next();
           }
        }
        while (!isEnd);
    }
    public void getLogin() throws WrongCustomerOrPinNumbers
    {
        boolean isEnd = false;
        do {
            try
            {
                System.out.print("\nEnter customer number: ");
                int cus = scan.nextInt();
                detail.add("Customer Number: " + cus);
                System.out.print("Enter pin number: ");
                int pin = scan.nextInt();
                detail.add("Pin Number: " + pin);

                for(Map.Entry<Integer, Account> entry : data.entrySet())
                {
                    Account acc = entry.getValue();
                    if(cus == entry.getKey() && pin == acc.getPinNumber())
                    {
                        getAccountType(acc);
                        isEnd = true;
                        break;
                    }
                }
                if(!isEnd)
                {
                    throw new WrongCustomerOrPinNumbers("Wrong Customer Number or Pin Number!!!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
            }
        }while (!isEnd);
    }
    public void createAccount()
    {
        boolean isEnd = false;
        int pin = 0;
        int cus = 0;
        do {
            try
            {
                System.out.print("\nCreate Customer Number: ");
                cus = scan.nextInt();
                if(!data.containsKey(cus))
                {
                    System.out.print("Create Pin Number: ");
                    pin = scan.nextInt();
                    data.put(cus, new Account(cus,pin));
                    System.out.println("\nYour account is successfully registered!!!");
                    System.out.print("Loading to login");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println();
                    getLogin();
                    isEnd = true;
                }
                if(!isEnd){
                    System.out.println("\nThe customer number which you entered is already registered!!!");
                }
            }
            catch (WrongCustomerOrPinNumbers e)
            {
                System.out.println("Error: " + e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (!isEnd);
        detail.add("Customer Number: " + cus);
        detail.add("Pin Number: " + pin);
    }
    public void getAccountType(Account acc)
    {
        try
            {
                System.out.println("\n+++ Welcome to Your Account +++" +
                        "\nType 1 - Checking." +
                        "\nType 2 - Saving." +
                        "\nType 3 - Account." +
                        "\nType 4 - Exit.");
                System.out.print("Choose: ");
                int option = scan.nextInt();
                switch (option)
                {
                    case 1: getChecking(acc);break;
                    case 2: getSaving(acc);break;
                    case 3: load(acc);getAccountType(acc);break;
                    case 4: System.out.println("Thanks for using our program <3");System.exit(0);break;
                    default:
                        System.out.println("\nInvalid Choice!!!");break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
                scan.next();
                getAccountType(acc);
            }

    }
    public void getChecking(Account acc)
    {
        boolean isEnd = false;
        do {
           try
           {
               System.out.println("\n+++ Checking Account +++" +
                       "\nType 1 - View Balance." +
                       "\nType 2 - Withdraw." +
                       "\nType 3 - Deposit." +
                       "\nType 4 - Transfer." +
                       "\nType 5 - Exit.");
               System.out.print("Choose: ");
               int option = scan.nextInt();
               switch (option)
               {
                   case 1:
                       System.out.println("\nCurrent balance in your checking account = " + money.format(acc.getCheckingBalance()));
                       break;
                   case 2: acc.checkingWithdraw();break;
                   case 3: acc.checkingDeposit();break;
                   case 4: acc.Transfer("Checking");break;
                   case 5: getAccountType(acc);isEnd = true;break;
                   default:
                       System.out.println("Invalid Choice!!!");break;
               }
           }
           catch (InputMismatchException e)
           {
               System.out.println("\nNumber(s) only!!!");
               scan.next();
           }
        }while(!isEnd);

    }
    public void getSaving(Account acc)
    {
        boolean isEnd = false;
        do {
            try {
                System.out.println("\n+++ Saving Account +++" +
                        "\nType 1 - View Balance." +
                        "\nType 2 - Withdraw." +
                        "\nType 3 - Deposit." +
                        "\nType 4 - Transfer." +
                        "\nType 5 - Exit.");
                System.out.print("Choose: ");
                int option = scan.nextInt();
                switch (option)
                {
                    case 1:
                        System.out.println("\nCurrent balance in your saving account = " + money.format(acc.getSavingBalance()));break;
                    case 2: acc.savingWithdraw();break;
                    case 3: acc.savingDeposit();break;
                    case 4: acc.Transfer("Saving");break;
                    case 5: getAccountType(acc);isEnd = true;break;
                    default:
                        System.out.println("\nInvalid Choice!!!");break;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nNumber(s) only!!!");
            }
        }while (!isEnd);
    }
    public void save(Account acc)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Detail.txt")))
        {
            for(String s : detail)
            {
                writer.write(s + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void load(Account acc)
    {
        System.out.println();
        save(acc);
        try(BufferedReader reader = new BufferedReader(new FileReader("Detail.txt")))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
