package TP4.Bankable;

import Exceptions.NegativeAmountException;

import java.util.Objects;

/**
 * @overview Un BankAccount représente un compte en banque. Il comprend le nom du propriétaire,
 * le numéro IBAN du compte, le fait que c'est un compte à débit et le solde du compte.
 * C'est un type mutable.
 * Il est défini comme <NomProprio, NuméroIBAN, CompteDebit, Solde> tq
 * @specfield NomProprio : String // Nom du propriétaire de BankAccount
 * @specfield NuméroIBAN: String // Numéro IBAN du compte
 * @specfield CompteDebit: boolean // Le compte est-il un compte à débit?
 * @specfield Solde: float // Le solde du compte
 * @invariant CompteDebit = true => solde >= 0
 */
public class BankAccount {
    private String owner;
    private final String IBAN;
    private final boolean debit;
    private float balance;

    /**
     * FA(c): <c.owner, c.IBAN, c.debit, c.balance>
     */

    /**
     * IR(c): (debit && solde >= 0) && owner != null && (IBAN != null && valid)
     */

    /**
     * @effects initialise un BankAccount avec:
     * this.owner = NomProprio
     * this.IBAN = NuméroIban
     * this.debit = CompteDebit
     * this.balance = Solde (= 0 de base)
     */
    public BankAccount(String owner, String IBAN, boolean debit){
        this.owner = owner;
        this.IBAN = IBAN;
        this.debit = debit;
        this.balance = 0.0f;
    }

    /**
     * Constructeur par copie
     */
    public BankAccount(BankAccount b){
        this.owner = b.getOwner();
        this.IBAN = b.getIBAN();
        this.debit = b.getDebit();
        this.balance = b.getBalance();
    }

    /** Getters */

    /**
     * @return this.balance (solde du compte)
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @return this.IBAN (numéro IBAN du compte)
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * @return this.owner (nom du propriétaire du compte)
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @return this.debit (true si compte à débit, false sinon)
     */
    public boolean getDebit(){
        return debit;
    }

    /** Setters */

    /**
     * @requires newOwner != null
     * @modifies this.owner
     * @effects this_post.owner = newOwner
     */
    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    /**
     * @modifies this.balance
     * @throws NegativeAmountException if debit && newBalance < 0
     * @effects this_post.balance = newBalance
     */
    public void setBalance(float newBalance) throws NegativeAmountException{
        if(debit && newBalance < 0){
            throw new NegativeAmountException("BankAccount.setBalance() - Opération non permise");
        }
        this.balance = newBalance;
    }

    /**
     * @modifies this.balance
     * @throws NegativeAmountException if amount < 0
     * @effects this_post.balance = this.balance + amount
     */
    public void deposit(float amount) throws NegativeAmountException{
        if(amount < 0){
            throw new NegativeAmountException("BankAccount.deposit() - Opération non permise");
        }
        this.balance += amount;
    }

    /**
     * @modifies this.balance
     * @throws NegativeAmountException if amount < 0 || (debit && this_post.balance - amount < 0)
     * @effects this_post.balance = this.balance - amount
     */
    public void withdraw(float amount) throws NegativeAmountException {
        if (amount < 0 || (debit && this.balance - amount < 0)) {
            throw new NegativeAmountException("BankAccount.withdraw() - Opération non permise");
        }
        this.balance -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return debit == that.debit &&
                Float.compare(that.balance, balance) == 0 &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(IBAN, that.IBAN);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + owner.hashCode();
        result = 31 * result + IBAN.hashCode();
        result = 31 * result + (debit ? 1:0);
        result = 31 * result + Float.floatToIntBits(balance);

        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", debit=" + debit +
                ", balance=" + balance +
                '}';
    }

    public boolean repOK() {
        if(debit && balance < 0) return false;
        if(owner == null || IBAN == null) return false;

        return true;
    }
}
