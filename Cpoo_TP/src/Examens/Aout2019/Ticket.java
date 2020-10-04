package Examens.Aout2019;

import Exceptions.ArticleNotFoundException;

import java.util.ArrayList;
import java.util.Objects;


public class Ticket {

    private ArrayList<Article> listeArticles;

    private Ticket(){
        listeArticles = new ArrayList<>();
    }

    /**
     * @requires a != null
     * @effects initialise this avec
     */
    public Ticket(Article a){
        new Ticket();
        listeArticles.add(a);
    }

    /**
     * @requires a != null
     * @modifies this.listeArticle
     * @effects this_post = this avec a en plus
     */
    public void ajouterArticle(Article a){
        listeArticles.add(a);
    }

    /**
    * @requires a != null
    * @modifies this.listeArticle
    * @effects remove a from this; this_post = this \ {a} (every occurrences)
    * @throws
    */
    public void retirerArticle(Article a) throws ArticleNotFoundException {
        int[] index = new int[listeArticles.size()];
        int j = 0;

        for (int i = 0; i < listeArticles.size(); i++) {
            if(listeArticles.get(i).equals(a)){
                index[j] = i;
                j++;

            }
        }
        if(index.length == 0) throw new ArticleNotFoundException("Article not on ticket");


        for (int k: index) {
            listeArticles.remove(k);
        }
    }

    /**
    * @return somme des prix des articles du ticket
    */
    public float calculerSomme(){
        float total = 0;
        for (Article a:listeArticles) {
            total += a.getPrice();
        }

        return total;
    }

    public boolean repOK(){
        if(listeArticles == null) return false;
        if(listeArticles.size() < 1) return false;
        for (int i = 0; i < listeArticles.size(); i++) {
            if(listeArticles.get(i) == null || !(listeArticles.get(i) instanceof Article)){
                return false;
            }
        }
        return true;
    }


}
