package Exceptions;

public class EmptyException extends Exception{
    /**
     * @effects create exception
     */
    public EmptyException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public EmptyException(String m){
        super(m);
    }

}