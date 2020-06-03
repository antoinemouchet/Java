package TP4.IntSets;

import Exceptions.EmptyException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn}
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet
 * @invariant size toujours positif
 */
public class IntSet2 {
    private List<Integer> els;

    /**
     * FA(c): {c.els.get(i) | 0 <= i < c.els.size()}
     */

    /**
     * IR(c): c.els is not null &&
     * for all integer i, 0 <= i < c.els.size(), c.els[i] is an Integer (only integers)
     */

    /** Constructeurs */

    /**
     * @effects initialise this à l'ensemble vide
     */
    public IntSet2() {
        els = new ArrayList<>();
    }

    /** Methodes */

    /**
     * @modifies this
     * @effects this_post = this U {x}
     */
    public void insert(int x) {
        els.add(x);
    }

    /**
     * @modifies this
     * @effects this_post = this \ {x} (every occurrences of x)
     */
    public void remove(int x) {
        while (isIn(x)){
            els.remove((Object) x);
        }
    }

    /**
     * @return true si x appartient à this; renvoie false sinon
     */
    public boolean isIn(int x) {
        return els.contains(x);
    }

    /**
     * @return la cardinalité de this.
     */
    public int size() {
        LinkedHashSet<Integer> tmp = new LinkedHashSet<>();
        tmp.addAll(els);
        return tmp.size();
    }

    /**
     * @return x t.q. x appartient à this.
     * @throws EmptyException  si this = {}
     */
    public int choose() throws EmptyException {
        if (els.size()==0) {
            throw new EmptyException("IntSet.choose()");
        }
        return els.get(0);
    }
}
