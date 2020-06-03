package TP5.Q1;

/**
 * @overview C'est un compteur mutable qui commence à 2.
 * Il peut augmenter (doubler la valeur actuelle) ou diminuer (de 1)
 * @invariant il ne peut plus augmenter quand sa valeur est sous 1
 */
public class Compteur1 extends Compteur0{

    /**
     * @effects this_post = 2;
     */
    public Compteur1(){
        super();
    }

    /**
     * @requires this > 1
     * @modifies this
     * @effects this_post = this * 2
     */
    public void incr() {
        if(compte > 1){
            compte *= 2;
        }
    }

    /**
     * @modifies this
     * @effects this_post = this - 1
     */
    public void decr(){
        compte--;
    }
}
