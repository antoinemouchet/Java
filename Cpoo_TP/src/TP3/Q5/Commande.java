package TP3.Q5;

/**
 * @overview Une commande représente un ensemble de DetailCommande.
 * Une commande est mutable.
 * De manière générale, une commande est définie comme {d1,di,...,dn}
 * où di est le ième DetailCommande de la Commande
 */
public class Commande {

    private DetailCommande[] commande;
    private int nbDetails;

    /**
     * @effects Initializes this by creating an array for nbDetails of DetailCommande.
     * this.nbDetails = nbDetails
     */
    public Commande(int nbDetails){
        commande = new DetailCommande[nbDetails];
        this.nbDetails = nbDetails;
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande U {d}
     */
    public void insert(DetailCommande d){
        for (int i = 0; i < commande.length; i++) {
            if(commande[i] == null){
                commande[i] = new DetailCommande(d);
                return;
            }
        }
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande \ {d} (every occurrences)
     */
    public void remove(DetailCommande d){
        for (int i = 0; i < commande.length; i++) {
            if(commande[i] != null){
                if(commande[i].equals(d)){
                    commande[i] = null;
                }
            }
        }
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande with every occurrences of currentD
     * replaced by newD.
     */
    public void update(DetailCommande currentD, DetailCommande newD){
        for (int i = 0; i < commande.length; i++) {
            if(commande[i] != null){
                if(commande[i].equals(currentD)){
                    commande[i] = new DetailCommande(newD);
                }
            }
        }
    }

    /**
     * @return this.Commande
     * renvoie une liste contenant les détails des commandes équivalente à celle de this mais
     * de manière à ne pas exposer la rep.
     */
    public DetailCommande[] listContent(){
        DetailCommande[] content = new DetailCommande[nbDetails];

        // Create new DetailCommande for every DetailCommande in this.commande
        // in order to protect the rep.
        for (int i = 0; i < commande.length; i++) {
            if(commande[i] != null){
                content[i] = new DetailCommande(commande[i]);
            }
        }

        return content;
    }

}
