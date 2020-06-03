package TP5.Q1;

/**
 * @overview C'est un compteur mutable qui commence à 2.
 * Il peut augmenter (doubler), diminuer (par pas de 1)
 * il peut être aussi multiplié par lui-même
 */
public class Compteur2 extends Compteur1{

    /**
     * effects this_post = 2
     */
    public Compteur2(){
        super();
    }

    /**
     * @modifies this
     * @effects this_post = this * this
     */
    public void mult(){
        compte *= compte;
    }
}
