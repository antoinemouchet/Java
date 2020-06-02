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
	 * Constructeur de l'exception avec plus de pr�cision
	 * @param emplacement permet de passer un message en plus
	 */
	public PetiteBalle(String emplacement) {
		super(emplacement);
	}

}
	