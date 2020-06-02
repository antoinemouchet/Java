import exceptions.NegativeAmountException;

/**
* @overview BankAccount représente un compte bancaire qui est composé de:
 * nom du propríetaire, IBAN du compte, un compte de d́ebits et le solde
 * type mutable
* @invariant si debits alors solde >= 0
*/

public class BankAccount {
    private String name, IBAN;
    private float solde;
    private boolean debit;

    /**
     * FA(c) : <c.name, c.IBAN, c.debit, c.solde>
     */

    /**
     * IR : (debit && solde >= 0) &&
     *      name not null &&
     *      IBAN not null et correct &&
     *      name.length >= 2
     */


    /** @requires proprio n'est pas null et proprio.length >= 2, accNb iban valide
     * @effects initialise this avec
     *  this.iban = accNb,
     *  this.nom = proprio
     *  this.compte_debit = debit
     *  this.solde = 0
     */
    public BankAccount(String proprio, String NBaccount, boolean debit){
        name = proprio;
        IBAN = NBaccount;
        this.debit = debit;
        solde = 0.0F;
    }

    /**
    * @requires newName != null && newName.length >= 2
    * @modifies this.nom
    * @effects this.nom = newName
    */
    public void  setName(String newName){
        this.name = newName;
    }

    /**
     * @return solde du compte (this.solde)
     */
    public float getSolde(){
        return solde;
    }

    /**
     * @modifies this.montant
     * @throws NegativeAmountException s'il s'agit d'un compte bancaire à crédit
     *          et que le montant - amount < 0
     * @effects this_post.montant = this.montant - amount
     */
    public void changeAmount(float amount) throws NegativeAmountException {
        if(!debit && this.solde - amount < 0) {
            throw new NegativeAmountException("Opération non permise");
        }
        this.solde += amount;
    }

    @Override
    public String toString() {
        String credit;
        if (debit){
            credit = "debit";
        }
        else{
            credit = "credit";
        }

        return "BankAccount{" + '\n' +
                "name='" + name + '\n' +
                ", IBAN='" + IBAN + '\n' +
                ", solde=" + solde + '\n' +
                ", type=" + credit + '}';
    }

    // Créé une copie de ba.
    public BankAccount(BankAccount ba){
        name = ba.name;
        IBAN = ba.IBAN;
        debit = ba.debit;
        solde = ba.solde;
    }

    /**
     * IR : (debit && solde >= 0) &&
     *      name not null &&
     *      IBAN not null et correct &&
     *      name.length >= 2
     */
    public boolean repOK(){
        if(debit && solde < 0){
            return  false;
        }
        if(name == null || IBAN == null){
            return false;
        }
        if (name.length() < 2 ){
            return  false;
        }

        return  true;
    }
}
