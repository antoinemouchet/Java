package Exceptions;

/**
 * Exception non-vérifiée
 */
public class UnexpectedException extends RuntimeException{
    public UnexpectedException(){super();}

    public UnexpectedException(String m){super(m);}

}
