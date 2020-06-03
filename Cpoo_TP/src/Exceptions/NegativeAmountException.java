package Exceptions;

/**
 * @overview Verified exception
 */
public class NegativeAmountException extends Exception{
    /**
     * @effects create exception
     */
    public NegativeAmountException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public NegativeAmountException(String m){
        super(m);
    }

}
