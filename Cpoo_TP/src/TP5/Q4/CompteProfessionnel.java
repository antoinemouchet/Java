package TP5.Q4;

import Exceptions.NegativeAmountException;
import Exceptions.NumeroExisteDejaException;
import Exceptions.SoldeInsuffisantException;
import Exceptions.UndefinedTitulaire;

/**
 * @overview Un CompteProfessionnel est un Compte qui peut etre utilise
 * dans le cadre d'une activité professionnelle (cad, il autorise un decouvert)
 * Un CompteProfessionnel est mutable.
 * De manière général, il est défini comme <num, solde, titulaire, decouvert> tq
 * @specfield num: String // Le numéro de compte au format BEXX-XXXX-XXXX-XXXX
 * @specfield solde: float // Le solde du compte (précision au cent)
 * @specfield titulaire: Personne // le titulaire du compte
 * @specfield decouvert: float // le montant autorisé du découvert
 */
public class CompteProfessionnel extends Compte{

    private String numero;
    private Personne titulaire;
    private float solde;
    private float decouvert;

    /**
     * @throws UndefinedTitulaire si le titulaire n'est pas enregistré à la banque
     * @throws NumeroExisteDejaException si numero est déjà attribué à un Compte
     * @effects sinon cree un Compte vide avec this.num = numero et this.solde = 0
     * et this.titulaire = titulaire et this.decouvert = 25 000
     */
    public CompteProfessionnel(String numero, Personne titulaire) throws UndefinedTitulaire, NumeroExisteDejaException{
        super(numero, titulaire);
        this.decouvert = 25000;
    }

    /**
     * @requires dec >= 0
     * @requires this.solde >= -dec
     * @modifies this
     * @effects this_post.decouvert = dec
     */
    public void fixerMontantDecouvert(float dec) {
        decouvert = dec;
    }

    /**
     * @requires montant > 0
     * @requires numCptBeneficiaire != null et au format BEXX-XXXX-XXXX-XXXX
     * @modifies this
     * @throws SoldeInsuffisantException si this.solde + this.decouvert - montant < 0
     * @effects sinon cree une nouvelle Transaction t dont la valeur est égale à
     * montant et this_post.solde = this.solde - montant
     * @return t
     */
    public Transaction virer(float montant, String numCptBeneficiare) throws SoldeInsuffisantException{
        if(solde + decouvert - montant < 0){
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
