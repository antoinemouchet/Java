package TP3.Q3;

/**
* @overview C'est un compteur mutable qui commence à 0.
* Il peut augmenter ou diminuer mais jamais descendre sous 0.
* @invariant compteur est toujours positif
*/
public class Compteur0 {
    // represents compteur
    int compte = 0;

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur + 1
     */
    public void incr(){
        compte++;
    }

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur - 1 (si this.compteur > 0 sinon rien)
     */
    public void decr(){
        if (compte > 0){
            compte--;
        }
    }
}
