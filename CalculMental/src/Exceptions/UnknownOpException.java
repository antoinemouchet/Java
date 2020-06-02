package Exceptions;

/**
* @overview verified exception for an unknown operation
*/

public class UnknownOpException extends Exception{
    /**
     * @effects create a new UnknownOperationException
     */
    public UnknownOpException(){
        super();
    }

    /**
     * @effects create a new UnknownOperationException with more detail
     */
    public UnknownOpException(String message){
        super(message);
    }
}
