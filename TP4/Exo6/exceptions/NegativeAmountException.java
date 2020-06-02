package exceptions;

public class NegativeAmountException extends Exception{
    /**
     * Constructeur de l'exception
     */
    public NegativeAmountException(){
        super();
    }

    /**
     * Constructeur de l'exception
     * @param m message supplementaire
     */
    public NegativeAmountException(String m){
        super(m);
    }
}
