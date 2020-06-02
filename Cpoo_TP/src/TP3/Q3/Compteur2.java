package TP3.Q3;

/**
* @overview C'est un compteur mutable qui commence à -5.
* Il peut augmenter (par pas de 2) ou diminuer (par pas de 1)
*/
public class Compteur2 {
    // represents compteur
    int compte = -5;

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur + 2
     */
    public void incr(){
        compte += 2;
    }

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur - 1 (si this.compteur > 0 sinon rien)
     */
    public void decr(){
        compte--;
    }
}

