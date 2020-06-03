package TP5.Q3;

/**
 * @overview Un carrée est une forme géométrique de 4 cotés égaux et possède 4 angles droit
 *
 * Un carée est mutable.
 *
 * Un example type de carrée est c= <largeur, hauteur>
 *
 * @invariant (largeur = hauteur) > 0
 */

public class Carre extends Rectangle {


    /**
     * @requires c > 0
     * @effects initialise un carrée ou this.largeur = c && this.hauteur = c
     */
    public Carre(float c) { super(c,c); }

    /**
     * @requires c > 0
     * @modifies this
     * @effects fixe this.largeur à c et this.hauteur à c
     */

    public void fixeLargeur(float c) {
        super.fixeLargeur(c);
        super.fixeHauteur(c);
    }

    /**
     * @requires c > 0
     * @modifies this
     * @effects  fixe this.largeur à c et this.hauteur à c
     */
    public void fixeHauteur(float c) {
        this.fixeLargeur(c);
    }


}
