package TP3.Q5;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @overview Une commande représente un ensemble de DetailCommande.
 * Une commande est mutable.
 * De manière générale, une commande est définie comme {d1,di,...,dn}
 * où di est le ième DetailCommande de la Commande
 */
public class Commande {

    private ArrayList<DetailCommande> commande;

    /**
     * @effects Initializes this by creating an array for  DetailCommande.
     */
    public Commande(){
        commande = new ArrayList<>();
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande U {d}
     */
    public void insert(DetailCommande d){
        commande.add(new DetailCommande(d));
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande \ {d} (every occurrences)
     */
    public void remove(DetailCommande d){
        for (int i = 0; i < commande.size(); i++) {
            if(commande.get(i).similar(d)){
                commande.remove(i);
            }
        }
    }

    /**
     * @modifies this.Commande
     * @effects this_post.Commande = this.Commande with every occurrences of currentD
     * replaced by newD.
     */
    public void update(DetailCommande currentD, DetailCommande newD){
        for (int i = 0; i < commande.size(); i++) {
            if(commande.get(i).similar(currentD)){
                commande.set(i, new DetailCommande(newD));
            }
        }
    }

    /**
     * @return this.Commande
     * renvoie une liste contenant les détails des commandes équivalente à celle de this mais
     * de manière à ne pas exposer la rep.
     */
    public DetailCommande[] listContent(){
        DetailCommande[] content = new DetailCommande[commande.size()];

        int index = 0;
        // Create new DetailCommande for every DetailCommande in this.commande
        // in order to protect the rep.
        for (DetailCommande d:commande) {
            content[index] = new DetailCommande(d);
            index++;
        }

        return content;
    }

    /**
     * @requires c != null
     * @return true if c is similar to this, false otherwise
     */
    public boolean similar(Commande c){
        DetailCommande[] contentC = c.listContent();
        int index = 0;

        for (DetailCommande d: commande) {
            if(!contentC[index].similar(d)){
                return false;
            }
            index++;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commande:");

        for (DetailCommande d:commande) {
            sb.append(d.toString());
        }

        return sb.toString();
    }
}
