package exceptions;

/**
 * Exception v�rifi�e
 */
public class NegativeArgumentException extends Exception{
    public NegativeArgumentException(){
        super();
    }

    public NegativeArgumentException(String m){
        super(m);
    }
}
