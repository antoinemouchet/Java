package ClasseInverseeIterateur.Classe;

import Exceptions.TransactionNotFoundException;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * @overview Un TransactionSet représente un ensemble de transactions sans doublons.
 * Les TransactionSets sont mutables.
 */
public class TransactionSet implements Iterable<Transaction> {
    private ArrayList<Transaction> transactions;
    /**
     * FA(c) = { transactions.get(i) | 0 <= i < transactions.size() }
     *
     * IR(c) = c.transactions != null &&
     *         pour tout i, j tels que: 0 <= i, j < size, i != j => c.transactions.get(i).equals(c.transactions.get(j)) = false (i.e. pas de doublons)
     */

    /**
     * @effects Crée un nouveau TransactionSet vide
     */
    public TransactionSet() {
        this.transactions = new ArrayList<Transaction>();
    }

    /**
     * @modifies this
     * @effects this_post = this U { tx }
     */
    public void addTransaction(Transaction tx) {
        if (!this.contains(tx))
            this.transactions.add(tx);
    }

    /**
     * @modifies this
     * @effects si tx in this, alors this_post = this \ { tx }
     */
    public void removeTransaction(Transaction tx) {
        this.transactions.remove(tx);
    }

    /**
     * @throws TransactionNotFoundException si tx not in this
     * @modifies this
     * @effects sinon, this_post[tx].executed = true
     */
    public void executeTransaction(Transaction tx) throws TransactionNotFoundException {
        if (!this.contains(tx))
            throw new TransactionNotFoundException("TransactionSet.executeTransaction(Transaction)");

        Transaction newTx = tx.execute();

        this.transactions.set(this.transactions.indexOf(tx), newTx);
    }

    /**
     * @return true si tx in this, false sinon
     */
    public boolean contains(Transaction tx) {
        return this.transactions.contains(tx);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[TransactionSet]: \n");
        for (Transaction tx : this.transactions)
            sb.append("   " + tx.toString() + ", \n");

        sb.deleteCharAt(sb.length() - 3);
        return sb.toString();
    }

    public boolean repOk() {
        if (this.transactions == null)
            return false;

        for (Transaction tx : this.transactions) {
            for (Transaction tx2 : this.transactions) {
                if (tx == tx2)
                    continue;

                if (tx.equals(tx2))
                    return false;
            }
        }

        return true;
    }


    @Override
    public Iterator<Transaction> iterator() {
        return new GenerateOperation(false);
    }

    public Iterator<Transaction> operation() {
        return new GenerateOperation(true);
    }

    private class GenerateOperation implements Iterator<Transaction>
    {
        private Transaction operationRunning;
        private int currentIndex;
        private boolean isRunning;

        GenerateOperation(boolean isRunning)
        {
            operationRunning = null;
            currentIndex = 0;
            this.isRunning = isRunning;

        }


        @Override
        public Transaction next() {
            if (operationRunning != null)
            {
                Transaction temporary = operationRunning;
                operationRunning = null;
                return temporary;
            }
            if( currentIndex > transactions.size() -1 || transactions.size() == 0)
            {
                throw new TransactionNotFoundException();
            }
            Transaction operation;
            operation = transactions.get(currentIndex);
            currentIndex++;
            return operation;
        }
        @Override
        public boolean hasNext() {
            boolean hasNext = true;
            if(operationRunning == null)
            {
                try{
                    operationRunning = next();
                }
                catch (TransactionNotFoundException e){
                    hasNext = false;
                }

            }
            if(isRunning && operationRunning !=null && !operationRunning.isExecuted())
            {
                operationRunning = null;
                hasNext = hasNext();
            }
            return hasNext;
        }
    }
}