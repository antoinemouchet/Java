package Exceptions;

/**
 * @overview Verified exception
 */
public class NumeroExisteDejaException extends Exception{
    /**
     * @effects create exception
     */
    public NumeroExisteDejaException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public NumeroExisteDejaException(String m){
        super(m);
    }

}
