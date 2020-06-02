package TP3.Q3;

/**
* @overview C'est un compteur mutable qui commence à 2.
* Il peut augmenter (en doublant la valeur actuelle)
* ou diminuer (de 1) mais jamais descendre sous 0.
* @invariant compteur est toujours positif
*/
public class Compteur1 {
    int compte = 2;

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur * 2
     */
    public void incr(){
        compte *= 2;
    }

    /**
     * @modifies this.compteur
     * @effects this_post.compteur = this.compteur - 1 (si this.compteur >= 1 sinon rien)
     */
    public void decr(){
        if (compte > 0){
            compte--;
        }
    }
}
