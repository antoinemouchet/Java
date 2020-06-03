package TP5.Q2;

import java.io.File;

/**
 * @overview Un PersistentSet est un Set dont l'etat peut etre sauvegarde
 * sur le disque entre deux executions
 */
public class PersistentSet extends Set{

    /**
     * @modifies this
     * @throws ClassCastException si el n'est pas un sous-type de PersistentObject
     * @effects sinon, ajoute el aux elements de this tq this_post = this U {el}
     * @return true si et seulement si el n'est pas egal à un élement de this
     * (déterminé par un appel à boolean equals(Object o))
     */
    public boolean add(Object el) throws ClassCastException{
        return false;
    }

    /**
     * @modifies f
     * @effects sauve l'état de this dans le fichier f (le contenu précédent de f est effacé)
     * @return true en cas de réussite, false en cas d'erreur
     * (le contenu de f est non précisé)
     */
    public boolean save(File f){
        return false;
    }

    /**
     * @modifies f
     * @effects le curseur de lecture est place à la fin du fichier f
     * @return le PersistentSet sauvegarde dans f.
     * Si f ne contient pas un PersistentSet retourne null.
     */
    public static Set load(File f){

    }
}

