/**
 * 
 * @overview classe pour tester les exceptions cr��es
 *
 */
public class Tester {
	/**
	 *  M�thode g�n�rant une exception v�rifi�e de mani�re al�atoire
	 * @throws PetiteBalle si valeur g�n�r�e<= 5 
	 * @throws GrosBallon si valeur g�nr�e > 5
	 */
	public static void lancer() throws PetiteBalle, GrosBallon{
		// Generate random value between 1 and 10
		int value = (int) (Math.random() * 10);
		
		if (value <= 5) {
			throw new PetiteBalle("Petite balle ici!");
		}
		else {
			throw new GrosBallon("Gros ballon l�!");
		}
	}
	/**
	 * M�thode attrapant et montrant l'exception v�rifi�e g�n�r�e par la m�thode lancer().
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
