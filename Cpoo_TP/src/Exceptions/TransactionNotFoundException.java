package Exceptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException()
    {
        super();
    }
    public TransactionNotFoundException(String s)
    {
        super(s);
    }
}
