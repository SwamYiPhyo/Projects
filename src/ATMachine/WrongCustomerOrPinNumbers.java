package ATMachine;

public class WrongCustomerOrPinNumbers extends Exception{
    public WrongCustomerOrPinNumbers(String message)
    {
        super(message);
    }
}
