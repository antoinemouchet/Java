package Divers;

/**
 * @overview joueur partipant à un tournoi * @invariant points >=0
 *
 */
public class Joueur {
    private String classement;
    private String nom;
    private int points;

    public Joueur(String c, String n, int p) {
        classement=c;
        nom = n;
        points = p; }

    public String getClassement() {
        return classement;
    }

    public String toString() {
        return nom + " " + classement + " : "+points;
    }

    public void setPoints(int p) {
        points=p;
    }
}
