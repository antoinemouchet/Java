package TP3.Q2;

/**
 * @overview Les ImmuMultiSets sont des ensembles non bornés d'entiers
 * qui peuvent contenir des doublons.
 * Ils sont mutables.
 * De manière générale, un  MultiSet est défini comme {x1,...,xn} où x1...xn sont des entiers.
 * @invariant size = #this
 */
public interface MultiSet {

    /**
    * @modifies this
    * @effects this_post = this U {x}
    */
    public void insert(int x);

    /**
     * @modifies this
     * @effects this_post = this \ {x} (every occurrences)
     */
    public void remove(int x);

    /**
     * @return true if x inside this, false otherwise
     */
    public boolean isIn(int x);

    /**
     * @return size of this
     */
    public int getSize();

    /**
     * @requires this != null && this.size > 0 => this is not empty
     * @return an element of this
     */
    public int choose();

    /**
     * @requires x is an element of this (so this is not empty)
     * @return Number of times x is inside this
     */
    public int getNbOccurrences(int x);
}
