package ClasseInverseeExceptions.Classe;

/**
 *
 * @overview Exception verifiee
 *
 */
public class GrosBallon extends Exception {
    /**
     * Constructeur de l'exception
     */
    public GrosBallon() {
        super();
    }
    /**
     * Constructeur de l'exception avec plus de précision
     * @param emplacement permet de passer un message en plus
     */
    public GrosBallon(String emplacement) {
        super(emplacement);
    }
}

