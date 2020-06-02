package Exceptions;

/**
 * @overview Verified exception
 */
public class NegativeArgumentException extends Exception{
    /**
     * @effects create exception
     */
    public NegativeArgumentException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public NegativeArgumentException(String m){
        super(m);
    }

}
