package TP5.Q1;

/**
 * @overview C'est un compteur mutable qui commence à 2.
 * Il peut augmenter (par pas de 1) ou diminuer (de 1)
 * mais jamais descendre sous 0.
 * @invariant compteur est toujours positif
 */
public class Compteur0 {

    int compte;
    /**
     * @effects this_post = 2
     */
    public Compteur0(){
        compte = 2;
    }

    /**
     * @requires this > 0
     * @modifies this
     * @effects this_post > this
     */
    public void incr(){
        if(compte > 0){
            compte++;
        }
    }

    /**
     * @requires this > 0
     * @modifies this
     * @effects this_post < this
     */
    public void decr(){
        if (compte > 0){
            compte--;
        }
    }
}
