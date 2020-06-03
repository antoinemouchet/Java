package Exceptions;

/**
 * Exception non-vérifiée
 */
public class FailureException extends RuntimeException{
    public FailureException(){super();}

    public FailureException(String m){super(m);}

}