package TP5.Q4;

import Exceptions.NegativeAmountException;
import Exceptions.UndefinedTitulaire;
import Exceptions.NumeroExisteDejaException;
import Exceptions.SoldeInsuffisantException;


/**
 * @overview Un compte est un dépôt d'argent d'un client qui peut être utilisé
 * comme moyen de paiement.
 * Un compte est mutable.
 * De manière générale, un Compte est défini comme <num, solde, titulaire> avec
 * @specfield num: String // Le numéro de compte au format BEXX-XXXX-XXXX-XXXX
 * @specfield solde: float // Le solde du compte (précision au cent)
 * @specfield titulaire: Personne // le titulaire du compte
 * @invariant solde >= 0
 */
public class Compte {

    private String numero;
    private Personne titulaire;
    private float solde;

    /**
     * @throws UndefinedTitulaire si le titulaire n'est pas enregistré à la banque
     * @throws NumeroExisteDejaException si numero est déjà attribué à un Compte
     * @effects sinon cree un Compte vide avec this.num = numero et this.solde == 0
     * et this.titulaire = titulaire
     */
    public Compte(String numero, Personne titulaire) throws UndefinedTitulaire, NumeroExisteDejaException{
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = 0.00f;
    }

    /**
     * @return this.titulaire
     */
    public Personne getTitulaire() {
        return titulaire;
    }

    /**
     * @requires montant > 0
     * @modifies this
     * @effects this_post.solde = this.solde + montant
     */
    public void verser(float montant){
        solde += montant;
    }

    /**
     * @requires montant > 0
     * @requires numCptBeneficiaire != null et au format BEXX-XXXX-XXXX-XXXX
     * @modifies this
     * @throws SoldeInsuffisantException si this.solde - montant < 0
     * @effects sinon cree une nouvelle Transaction t dont la valeur est égale à
     * montant et this_post.solde = this.solde - montant
     * @return t
     */
    public Transaction virer(float montant, String numCptBeneficiare) throws SoldeInsuffisantException{
        if(solde - montant < 0){
            throw new SoldeInsuffisantException("Compte.virer() - Solde insuffisant");
        }
        solde -= montant;
        Transaction t;
        try {
            t = new Transaction("2020-03-06", numero, numCptBeneficiare, montant);
        }catch (NegativeAmountException e){
            throw new SoldeInsuffisantException("Compte.virer() - montant négatif");
        }

        return t;
    }
}
