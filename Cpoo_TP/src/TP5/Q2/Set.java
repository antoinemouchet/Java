package TP5.Q2;

/**
 * @overview Un Set est un ensemble mutable et non borné d'objets
 * Un Set est mutable.
 * De manière générale, un Set est défini comme {x1,...,xi,xn}
 * avec 1 <= i <= n
 * @invariant la cardinalité de this est toujours croissante
 */
public abstract class Set {

    /**
     * @effects intialise this à l'emsemble vdie {}
     */
    public Set() { }


    /**
     * @modifies this
     * @effects ajoute el aux elements de this tel que
     *             this_post = this U {el}
     * @return true ssi el n'est pas égal à un élément de this
     * (determiné par un appel a un boolean equals(Object o ))
     */
    public abstract boolean add(Object el);

    /**
     * @return retourne le nombre d'éléments de this
     */
    public int size() {
        return 0;
    }


}
