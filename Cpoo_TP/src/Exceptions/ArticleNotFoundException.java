package Exceptions;

/**
 * @overview Verified exception
 */
public class ArticleNotFoundException extends Exception{
    /**
     * @effects create exception
     */
    public ArticleNotFoundException(){
        super();
    }

    /**
     * @requires m: String using as a message for the exception.
     * @effects create exception
     */
    public ArticleNotFoundException(String m){
        super(m);
    }

}
