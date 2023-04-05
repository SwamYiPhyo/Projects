package ATMachine;

public class Main extends OptionMenu{
    public static void main(String[] args) {
        OptionMenu menu = new OptionMenu();
        introduction();
        menu.mainMenu();
    }
    public static void introduction()
    {
        System.out.println("Welcome to ATM Project!!!");
    }
}

