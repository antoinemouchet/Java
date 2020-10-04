package TP7;

public class RemplirBoite {

    public static int remplir(String[] objets, double[] poids, int nbObjets, double poidsMaxBoite, int nbBoite,
                        int[] contenuBoite, double[] capacites){
        // Boucle sur les objets
        for (int i = 0; i < nbObjets; i++) {

            // Boucle sur les boites
            int j = 0;
            boolean found = false;
            while (j < capacites.length && !found){
                if(poids[i] <= (poidsMaxBoite - capacites[j])){
                    // if nothing was in the box, add a new box
                    if(capacites[j] == 0){
                        nbBoite++;
                    }
                    capacites[j] += poids[i];
                    found = true;
                    contenuBoite[i] = j + 1;
                }
                j++;
            }
        }
        return nbBoite;
    }

    public static void displayBoiteContent(int nbBoite, int nbObjets, String[] objets, int[] contenuBoite){
        System.out.println("Nombre de boites total: " + nbBoite);
        for (int i = 0; i < nbObjets; i++) {
            System.out.println(objets[i] + " est dans la boite n°" + contenuBoite[i]);
        }
    }

    public static void main(String[] args) {
        int nbObjets = 8;
        String[] objets = {"Concombre","Carotte","Radis","Tomates","Courgette", "Oignons", "Poivrons", "Persil"};
        double[] poids = {9,8,7,6,5,4,3,2};

        double poidsMaxBoite = 11;
        int nbBoite = 0;

        // Indice de la boite dans laquelle chaque objet est
        int[] contenuBoite = new int[nbObjets];

        // Poids dans chaque boite
        double[] capacites = new double[nbObjets];

        nbBoite = remplir(objets, poids, nbObjets, poidsMaxBoite, nbBoite, contenuBoite, capacites);
        displayBoiteContent(nbBoite, nbObjets, objets, contenuBoite);
    }
}
