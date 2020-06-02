import exceptions.NegativeAmountException;
import exceptions.TransactionNotFoundException;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        //Initialisation de 3 transactions
        Transaction tx1 = null;
        Transaction tx2 = null;
        Transaction tx3 = null;

        //Création des 3 transactions
        try {
            tx1 = new Transaction("2019-01-03", "BE54 6788 7655 7644", "BE53 8756 3245 0987",  100.0f);
            tx2 = new Transaction("2019-01-01",  "BE76 5433 8766 9800",  "BE76 4323 5674 6575", 250.0f);
            tx3 = new Transaction("2018-02-01", "BE76 5433 7688 9845", "BE87 5622 8750 8764", 10.0f);
        } catch(NegativeAmountException e) {
            throw new NegativeAmountException("Main first try");
        }

        //Création d'un TransactionSet et ajout des 3 transactions
        TransactionSet txSet = new TransactionSet();
        txSet.addTransaction(tx1);
        txSet.addTransaction(tx2);
        txSet.addTransaction(tx3);

        //Exécution des transactions tx1 et tx2
        try {
            txSet.executeTransaction(tx1);
            txSet.executeTransaction(tx2);
        } catch(TransactionNotFoundException e) {
            System.out.println(e);
        }

        //Afficher, en utilisant une boucle for-each, la liste des transactions contenues dans txSet
        System.out.println("Liste des Transactions:");
        System.out.println("---------------------- ");

        for (Transaction operation : txSet)
        {
            System.out.println(operation);
        }


        //Afficher, sans utiliser de boucle for-each mais en utilisant un itérateur, la liste des transactions exécutées contenues dans txSet
        System.out.println("\nListe des Transactions exécutées:");
        System.out.println("--------------------------------   ");

        Iterator<Transaction> element = txSet.operation();
        while (element.hasNext())
        {
            System.out.println(element.next());
        }
        System.out.println("--------------------------  ");

    }
}

