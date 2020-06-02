/**
 * 
 * @overview classe pour tester les exceptions créées
 *
 */
public class Tester {
	/**
	 *  Méthode générant une exception vérifiée de manière aléatoire
	 * @throws PetiteBalle si valeur générée<= 5 
	 * @throws GrosBallon si valeur génrée > 5
	 */
	public static void lancer() throws PetiteBalle, GrosBallon{
		// Generate random value between 1 and 10
		int value = (int) (Math.random() * 10);
		
		if (value <= 5) {
			throw new PetiteBalle("Petite balle ici!");
		}
		else {
			throw new GrosBallon("Gros ballon là!");
		}
	}
	/**
	 * Méthode attrapant et montrant l'exception vérifiée générée par la méthode lancer().
	 */
	public static void attraper() {
		try {
			lancer();
		}
		catch(PetiteBalle | GrosBallon e){
			// Display error caught
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			attraper();
		}
	}
}
