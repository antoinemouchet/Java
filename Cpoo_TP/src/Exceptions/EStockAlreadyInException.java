package Exceptions;

/**
 * @overview Verified exception
 */
public class EStockAlreadyInException extends Exception{
    /**
     * @effects create exception
     */
    public EStockAlreadyInException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public EStockAlreadyInException(String m){
        super(m);
    }

}
