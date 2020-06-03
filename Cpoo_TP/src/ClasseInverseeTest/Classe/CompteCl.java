package ClasseInverseeTest.Classe;

import Exceptions.UnauthorizedOperation;

/**
 * Compte
 */
public class CompteCl {
    protected NumeroDeCompte numero;
    protected float solde, ligneCredit;
    protected boolean credit;

    public CompteCl(String n, float s, float lc, boolean c){
        this.numero = new NumeroDeCompte(n);
        this.solde = s;
        this.ligneCredit = lc;
        this.credit = c;
    }

    public void retirer (float somme) throws UnauthorizedOperation{
        if(credit && somme > solde + ligneCredit) {
            throw new UnauthorizedOperation();
        }
        else{
            solde -= somme;
        }
    }

    public void depose (float somme) {
        solde += somme;
    }

    public float solde(){
        return solde;
    }

    public void annulerCredit(){
        credit = false;
    }

    public void fixeDecouvert(float plafond){
        ligneCredit = plafond;
    }

    public float decouvert(){
        return ligneCredit;
    }

    public boolean credit(){
        return credit;
    }

   /*@Override
    public String toString(){
        return numero.toString() + " : " + String.valueOf(solde) + "€";
    }*/

    @Override
    public String toString(){
        return "{(" + numero + ", " + solde + ", " +
                ligneCredit + ", " + credit + ")}";
    }

}
