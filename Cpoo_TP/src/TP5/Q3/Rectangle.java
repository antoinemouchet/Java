package TP5.Q3;

/**
 * @overview Rectangle représente un polygone à 4 cotes égaux 2 à 2
 * et 4 angles droits.
 * C'est un type mutable
 * Rectangle représenté par <hauteur, largeur>
 * Un rectangle est typiquement défini par une hauteur et une largeur tq
 * @specfield hauteur: float // hauteur du rectangle
 * @specfield largeur: float // largeur du rectangle
 * @derivedfield surface: float = largeur * hauteur // aire du rectangle
 * @invariant hauteur > 0 && largeur > 0
 */
public class Rectangle {
    private float largeur;
    private float hauteur;

    /**
     * @requires l > 0 && h > 0
     * @effects initialise un rectangle avec this.largeur = l et this.hauteur = h
     */
    public Rectangle(float l, float h){
        largeur = l;
        hauteur = h;
    }

    /**
     * @return this.hauteur
     */
    public float donneHauteur() {
        return hauteur;
    }

    /**
     * @return this.largeur
     */
    public float donneLargeur() {
        return largeur;
    }

    /**
     * @requires h > 0
     * @modifies this
     * @effects this_post.hauteur = h
     */
    public void fixeHauteur(float h) {
        hauteur = h;
    }

    /**
     * @requires l > 0
     * @modifies this
     * @effects this_post.largeur = l
     */
    public void fixeLargeur(float l) {
        largeur = l;
    }

    /**
     * @return this.largeur * this.hauteur (surface)
     */
    public float donneSurface(){
        return largeur * hauteur;
    }
}
