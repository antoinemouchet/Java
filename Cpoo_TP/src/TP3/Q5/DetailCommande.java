package TP3.Q5;

import Exceptions.NegativeArgumentException;
import java.util.Objects;

/**
 * @overview Un DetailCommande représente un élément (= une ligne) d'une commande relatif
 * à un article.
 * Un DetailCommande est mutable.
 * De manière générale, un DetailCommande est défini comme <x, y, z> avec
 * @specfield x: Article // l'article commandé.
 * @specfield y: float // le prix de l'article commandé.
 * @specfield z: int // la quantité commandée
 * @invariant y >= 0
 * @invariant z > 0
 */
public class DetailCommande {

    private Article article;
    private float price;
    private int quantity;

    /**
     * @effects Initialise un DetailCommande avec this.article = article
     * this.price = price et this.quantity = quantity
     */
    public DetailCommande(Article article, float price, int quantity){
        this.article = article;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @effects Initialise un DetailCommande avec this.article = d.article
     * this.price = d.price et this.quantity = d.quantity
     */
    public DetailCommande(DetailCommande d){
        this.article = d.getArticle();
        this.price = d.getPrice();
        this.quantity = d.getQuantity();
    }

    /**
     * Changes quantity to newQuantity
     * @modifies this.z
     * @effects this_post.z = newQuantity
     * @throws NegativeArgumentException if newQuantity <= 0
     */
    public void updateQuantity(int newQuantity) throws NegativeArgumentException{
        if(newQuantity <= 0){
            throw new NegativeArgumentException("newQuantity <= 0. DetailCommande.updateQuantity");
        }
        quantity = newQuantity;
    }

    /**
     * Changes price to newPrice
     * @modifies this.y
     * @effects this_post.y = newPrice
     * @throws NegativeArgumentException if newPrice < 0
     */
    public void updatePrice(float newPrice) throws NegativeArgumentException{
        if(newPrice < 0){
            throw new NegativeArgumentException("newPrice < 0. DetailCommande.updatePrice");
        }
        price = newPrice;
    }

    /**
     * @return the article of this (this.x)
     */
    public Article getArticle() {
        return article;
    }

    /**
     * @return the price of this (this.y)
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return quantity of this (this.z)
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailCommande that = (DetailCommande) o;
        return Float.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(article, that.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, price, quantity);
    }
}
