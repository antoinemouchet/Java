package Exceptions;

/**
 * @overview Verified exception
 */
public class SoldeInsuffisantException extends Exception{
    /**
     * @effects create exception
     */
    public SoldeInsuffisantException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public SoldeInsuffisantException(String m){
        super(m);
    }

}
