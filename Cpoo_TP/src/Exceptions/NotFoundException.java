package Exceptions;

/**
 * @overview Verified exception
 */
public class NotFoundException extends Exception{
    /**
     * @effects create exception
     */
    public NotFoundException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public NotFoundException(String m){
        super(m);
    }

}
