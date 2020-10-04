package Exceptions;

/**
 * @overview Verified exception
 */
public class CodeCoursNonValideException extends Exception{
    /**
     * @effects create exception
     */
    public CodeCoursNonValideException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public CodeCoursNonValideException(String m){
        super(m);
    }

}
