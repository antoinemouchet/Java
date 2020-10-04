package Examens.Juin2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Exceptions.EStockAlreadyInException;
import Exceptions.CodeCoursNonValideException;

/**
 * @overview Un Portefeuille sert à contenir un ensemble d'EStock(s) détenu(s) par un Porteur.
 * C'est un type mutable.
 * Il est représenté comme <Porteur du portefeuille, liste d'EStocks>
 * @specfield Porteur du portefeuille: Porteur // Personne qui possède le portefeuille
 * @specfield liste d'EStocks: liste d'EStocks // Les EStocks possédés par la personne
 * @invariant liste d'estocks >= 0
 */
public class Portefeuille {
    private Porteur owner;
    private ArrayList<EStock> wallet;


    /**
     * FA(c): <FA'(c.owner), {FA''(c.wallet.get(i)) | 0 <= i < wallet.size()}
     *
     * où FA'(b) = FA de Porteur correspondante
     * et FA''(a) = <a.codeCours, a.idAction> (FA d'EStock)
     */

    /**
     * IR(c): c.owner != null && c.wallet != null &&
     * c.wallet.size() >= 0 &&
     * for all i, 0 <= i < wallet.size(), wallet.get(i) != null &&
     * for all i, 0 <= i < wallet.size(), wallet.get(i) is a EStock
     */

    /**
    * @requires owner != null
    * @effects initialise this avec this.owner = owner et wallet as an empty ArrayList
    */
    public Portefeuille(Porteur owner){
        this.owner = owner;
        wallet = new ArrayList<>();
    }

    /**
     * @requires portefeuille != null
     * @effects initialise this avec les valeurs de portefeuille
     */
    public Portefeuille(Portefeuille portefeuille){
        this.owner = portefeuille.getOwner();
        this.wallet = portefeuille.getWallet();
    }

    /**
    * @requires stock != null
    * @modifies this
    * @effects add EStock to wallet. this_post.wallet = this.wallet U {stock}
    * @throws EStockAlreadyInException si l'EStock est déjà dans wallet
    */
    public void ajouterEstock(EStock stock) throws EStockAlreadyInException{
        if(wallet.contains(stock)) throw new EStockAlreadyInException("EStock already in wallet");

        wallet.add(stock);
    }

    /**
     * @requires stock != null
     * @modifies this
     * @effects remove EStock from wallet. this_post.wallet = this.wallet \ {stock}
     */
    public void retirerEStock(EStock stock){
        wallet.remove(stock);
    }

    /**
     * @return la valeur du portefeuille en fonction des valeurs des EStocks
     */
    public float donneValeurPortefeuille(){
        float result = 0f;

        for (EStock e:wallet) {
            try{
                result += Bourse.donneCours(e.donneCode());
            }
            catch (CodeCoursNonValideException exception){
                exception.printStackTrace();
            }
        }

        return result;
    }

    /**
     * @requires codeCours != null
     * @return la valeur cumulée des EStocks de type codeCours
     */
    public float donneValeur(String codeCours){
        float result = 0f;

        for (EStock e:wallet) {
            if(e.donneCode().equals(codeCours)) {
                try {
                    result += Bourse.donneCours(e.donneCode());
                } catch (CodeCoursNonValideException exception) {
                    exception.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * @return un générateur qui génère une et une seule fois dans l'orde d'apparition
     * les EStocks contenu dans la liste stocks
     */
    public Iterator<EStock> elements(){
        return Collections.unmodifiableCollection(wallet).iterator();
    }

    /**
     * @return this.wallet
     */
    public ArrayList<EStock> getWallet() {
        ArrayList<EStock> tmp = new ArrayList<>();

        for (EStock e:wallet) {
            tmp.add(e);
        }

        return tmp;
    }

    /**
     * @return this.owner
     */
    public Porteur getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Portefeuille{ owner=" + owner);

        for (EStock e:wallet) {
            sb.append(e.toString());
        }

        return sb.toString();
    }

    public boolean repOK(){
        if(this.owner == null || this.wallet == null) return false;
        if(this.wallet.size() < 0) return false;
        if(!(this.owner instanceof Porteur)) return false;
        for (int i = 0; i < this.wallet.size(); i++) {
            if(wallet.get(i) == null || !(wallet.get(i) instanceof EStock)) return false;
        }

        return true;
    }
}


