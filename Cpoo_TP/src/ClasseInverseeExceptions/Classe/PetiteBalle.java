package ClasseInverseeExceptions.Classe;

/**
 *
 * @overview Exception verifiee
 *
 */
public class PetiteBalle extends Exception {
    /**
     * Constructeur de l'exception
     */
    public PetiteBalle() {
        super();
    }
    /**
     * Constructeur de l'exception avec plus de précision
     * @param emplacement permet de passer un message en plus
     */
    public PetiteBalle(String emplacement) {
        super(emplacement);
    }

}

