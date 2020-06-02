package exceptions;

public class InvalidNameException extends Exception {
    /**
     * Constructeur de l'exception
     */
    public InvalidNameException(){
        super();
    }

    /**
     * Constructeur de l'exception
     * @param m message supplementaire
     */
    public InvalidNameException(String m){
        super(m);
    }
}
