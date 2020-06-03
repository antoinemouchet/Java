package Exceptions;

/**
 * @overview Verified exception
 */
public class UndefinedTitulaire extends Exception{
    /**
     * @effects create exception
     */
    public UndefinedTitulaire(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public UndefinedTitulaire(String m){
        super(m);
    }

}