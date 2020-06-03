package Divers;

public class Eleve {
    String nom;
    String prenom;
    boolean sexe;
    int age;

    public Eleve(String n, String p, boolean s, int a) {
        nom=n;
        prenom=p;
        sexe=s;
        age=a;
    }
    public String toString() {
        return prenom + " " +nom+" "+sexe+" "+age ;
    }
}
