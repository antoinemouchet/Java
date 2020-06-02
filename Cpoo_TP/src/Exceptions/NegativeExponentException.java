package Exceptions;

/**
 * @overview Verified exception
 */
public class NegativeExponentException extends Exception{
    /**
     * @effects create exception
     */
    public NegativeExponentException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public NegativeExponentException(String m){
        super(m);
    }

}
