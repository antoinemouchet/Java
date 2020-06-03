package ClasseInverseeIterateur.Classe;

import Exceptions.NegativeAmountException;

/**
 * @overview Une Transaction représente une transaction financière d'un compte bancaire vers un autre.
 * Les Transactions sont immutables.
 *
 * @specfield date (String) - Date de la transaction (format: yyyy-mm-dd)
 * @specfield sender (String) - IBAN du compte de l'envoyeur
 * @specfield receiver (String) - IBAN du compte receveur
 * @specfield amount (float) - Montant de la transaction
 * @specfield executed (boolean) - Détermine si la transaction a déjà été exécutée
 *
 * @invariant amount > 0
 * @invariant date est formatée comme suit: yyyy-mm-dd
 */
public class Transaction{
    private String txDate;
    private String fromIBAN;
    private String toIBAN;
    private float amount;
    private boolean executed;

    /**
     * FA(c) = <c.txDate, c.fromIBAN,  c.toIBAN, c.amount, c.executed>
     *
     * IR(c) = c.txDate != null &&
     *         c.txDate  est formatée comme suit: yyyy-mm-dd &&
     *         c.fromIBAN != null &&
     *         c.toIBAN != null &&
     *         c.amount > 0
     */

    /**
     * @requires txDate != null &&
     *           txDate est formatée comme suit: yyyy-mm-dd &&
     *           fromIBAN != null &&
     *           toIBAN != null
     * @throws NegativeAmountException si amount <= 0
     * @effects Sinon, crée une nouvelle Transaction tx telle que:
     *    tx.date = txDate &&
     *    tx.sender = fromIBAN &&
     *    tx.receiver = toIBAN &&
     *    tx.amount = amount &&
     *    tx.executed = false
     */
    public Transaction(String txDate, String fromIBAN,  String toIBAN, float amount) throws NegativeAmountException {
        if(amount <= 0)
            throw new NegativeAmountException("Transaction.Transaction(String, String, String, float)");

        this.txDate = txDate;
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.executed = false;
    }

    /**
     * @require original != null
     * @effects Crée une nouvelle Transaction tx qui est une shallow copy de original, telle que:
     *    tx.date = original.date &&
     *    tx.sender = original.sender &&
     *    tx.receiver = original.receiver &&
     *    tx.amount = original.amount &&
     *    tx.executed = original.executed
     */
    public Transaction(Transaction original) {
        this.txDate = original.getDate();
        this.fromIBAN = original.getSender();
        this.toIBAN = original.getReceiver();
        this.amount = original.getAmount();
        this.executed = original.isExecuted();
    }

    /**
     * @return this.date
     */
    public String getDate() { return this.txDate; }

    /**
     * @return this.sender
     */
    public String getSender() { return this.fromIBAN; }

    /**
     * @return this.receiver
     */
    public String getReceiver() { return this.toIBAN; }

    /**
     * @return this.amount
     */
    public float getAmount() { return this.amount; }

    /**
     * @return this.executed
     */
    public boolean isExecuted() { return this.executed; }

    /**
     * @require newDate != null &&
     *          newDate est formatée comme suit: yyyy-mm-dd
     * @return Une nouvelle Transaction tx telle que:
     *    tx.date = newDate &&
     *    tx.sender = this.sender &&
     *    tx.receiver = this.receiver &&
     *    tx.amount = this.amount &&
     *    tx.executed = this.executed
     */
    public Transaction setDate(String newDate) {
        Transaction tx = new Transaction(this);
        tx.txDate = newDate;

        return tx;
    }

    /**
     * @require fromIBAN != null
     * @return Une nouvelle Transaction tx telle que:
     *    tx.date = this.date &&
     *    tx.sender = fromIBAN &&
     *    tx.receiver = this.receiver &&
     *    tx.amount = this.amount &&
     *    tx.executed = this.executed
     */
    public Transaction setSender(String fromIBAN) {
        Transaction tx = new Transaction(this);
        tx.fromIBAN = fromIBAN;

        return tx;
    }

    /**
     * @require toIBAN != null
     * @return Une nouvelle Transaction tx telle que:
     *    tx.date = this.date &&
     *    tx.sender = this.sender &&
     *    tx.receiver = toIBAN &&
     *    tx.amount = this.amount &&
     *    tx.executed = this.executed
     */
    public Transaction setReceiver(String toIBAN) {
        Transaction tx = new Transaction(this);
        tx.toIBAN = toIBAN;

        return tx;
    }

    /**
     * @throws NegativeAmountException si newAmount <= 0
     * @return Sinon, renvoie une nouvelle Transaction tx telle que:
     *    tx.date = this.date &&
     *    tx.sender = this.sender &&
     *    tx.receiver = this.receiver &&
     *    tx.amount = newAmount &&
     *    tx.executed = this.executed
     */
    public Transaction setAmount(float newAmount) throws NegativeAmountException {
        if(newAmount <= 0)
            throw new NegativeAmountException("Transaction.setAmount(float)");

        Transaction tx = new Transaction(this);
        tx.amount = newAmount;

        return tx;
    }

    /**
     * @return Une nouvelle Transaction  tx telle que:
     *    tx.date = this.date &&
     *    tx.sender = this.sender &&
     *    tx.receiver = this.receiver &&
     *    tx.amount = this.amount &&
     *    tx.executed = true
     */
    public Transaction execute() {
        Transaction tx = new Transaction(this);
        tx.executed = true;

        return tx;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;

        if(!(o instanceof Transaction))
            return false;

        return this.equals((Transaction)o);
    }

    public boolean equals(Transaction tx) {
        if(!tx.getDate().equals(this.getDate()))
            return false;

        if(!tx.getSender().equals(this.getSender()))
            return false;

        if(!tx.getReceiver().equals(this.getReceiver()))
            return false;

        if(tx.getAmount() != this.getAmount())
            return false;

        if(tx.isExecuted() != this.isExecuted())
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.txDate.hashCode();
        result = 31 * result + this.getSender().hashCode();
        result = 31 * result + this.getReceiver().hashCode();
        result = 31 * result + (int)this.getAmount();
        result = 31 * result + (this.isExecuted() ? 1 : 0);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Transaction]: { ");
        sb.append("date: " + this.getDate() + ",  ");
        sb.append("sender: " + this.getSender() + ", ");
        sb.append("receiver: " + this.getReceiver() + ", ");
        sb.append("amount: " + this.getAmount() + ",  ");
        sb.append("executed: " + this.isExecuted() + " }");

        return sb.toString();
    }

    //Note Etudiants: pour une question de simplicité, on ne vérifie pas ici le format de la date
    public boolean repOk() {
        if(this.txDate == null)
            return false;

        if(this.fromIBAN == null)
            return false;

        if(this.toIBAN == null)
            return false;

        if(this.amount <= 0)
            return false;

        return true;
    }
}

