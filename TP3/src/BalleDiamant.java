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
	 * Constructeur de l'exception avec plus de pr�cision
	 * @param emplacement permet de passer un message en plus
	 */
	public BalleDiamant(String emplacement) {
		super(emplacement);
	}
}
