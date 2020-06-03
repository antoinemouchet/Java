package Divers;

import java.util.ArrayList;

public class Tournoi{
    private ArrayList<Joueur> list;

    public Tournoi( ArrayList<Joueur> j) {
        list = j;
    }

    public ArrayList<Joueur> rechercherAdversaire (String a){
        ArrayList<Joueur> listJoueurs = new ArrayList<>();
        for(Joueur j : list) {
            if(j.getClassement().equals(a))listJoueurs.add(j);
        }
        return listJoueurs;
    }

    /**
     * requires b >= 0 */
    public void bonus (Joueur a, int b) {
        a.setPoints(b);
    }

    public static void main( String[] args) {
        ArrayList<Joueur> lists = new ArrayList<Joueur>();
        Joueur j1 = new Joueur("C2","Germain",0);
        Joueur j2 = new Joueur("C2","Thibaut",0);
        Joueur j3 = new Joueur("D4","Celine",0);
        Joueur j4 = new Joueur("D4","Antoine",0);
        Joueur j5 = new Joueur("C6","Gauthier",0);
        Joueur j6 = new Joueur("E2","Tom",0);
        Joueur j7 = new Joueur("E0","Emilie",0);
        Joueur j8 = new Joueur("E0","Laurent",0);
        lists.add(j1);
        lists.add(j2);
        lists.add(j3);
        lists.add(j4);
        lists.add(j5);
        lists.add(j6);
        lists.add(j7);
        lists.add(j8);
        Tournoi t = new Tournoi(lists);
        ArrayList<Joueur> adv = t.rechercherAdversaire("D4");
        for(Joueur j : adv) {
            t.bonus(j, 10);
            System.out.println(j.toString() + "\n");
        }
    }
}
