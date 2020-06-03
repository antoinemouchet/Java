package ClasseInverseeExceptions.Classe;

/**
 *
 * @overview Exception non-verifiee
 *
 */
public class BalleDiamant  extends RuntimeException{
    /**
     * Constructeur de l'exception
     */
    public BalleDiamant() {
        super();
    }
    /**
     * Constructeur de l'exception avec plus de précision
     * @param emplacement permet de passer un message en plus
     */
    public BalleDiamant(String emplacement) {
        super(emplacement);
    }
}

