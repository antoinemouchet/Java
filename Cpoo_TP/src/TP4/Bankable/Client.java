package TP4.Bankable;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @overview Un client représente un client de banque. Un client a un nom, un prénom, un ensemble
 * de comptes dont il est titulaire et un ensemble de comptes bancaires dont il a procuration.
 * C'est un type immutable.
 * Il est défini tel que <Nom, Prénom, comptes titulaires, comptes procuration> tel que:
 * @specfield Nom: String // Nom de famille du client
 * @specfield Prénom: String // Prénom du client
 * @specfield Comptes titulaires // Liste de comptes dont le client est propriétaire
 * @specfield Comptes Procuration // Liste de comptes dont le client a procuration
 * @derivedfield Montant total: réel // Total des montants de comptes
 */
public class Client {
    private String lastName, firstName;
    private ArrayList<BankAccount> holder, proxy;

    /**
     * FA(c): <c.lastName, c.firstName, c.holder[i].get(), c.proxy[j].get()>
     *     avec 0 <= i < c.holder.size() et 0 <= j < c.proxy.size()
     */

    /**
     * IR(c): lastName != null && firstName != null &&
     * holder != null && holder ne contient que des BankAccount &&
     * proxy != null && proxy ne contient que des BankAccount &&
     * holder et proxy ne contiennent pas de doublons &&
     * un BankAccount fait partie uniquement de proxy ou de holder.
     */

    /**
     * @effects initialise un nouveau client avec
     * this.lastName = lastName && this.firstName &&
     * this.holder et this.proxy sont initialisés comme des ensembles vides.
     */
    public Client(String lastName, String firstName){
        this.firstName = firstName;
        this.lastName = lastName;

        holder = new ArrayList<>();
        proxy = new ArrayList<>();
    }

    /**
     * Constructeur par copie
     */
    public Client(Client c){
        firstName = c.getFirstName();
        lastName = c.getLastName();
        holder = new ArrayList<>();
        proxy = new ArrayList<>();

        holder.addAll(c.getHolder());
        proxy.addAll(c.getProxy());
    }

    /** Getters */

    /**
     * @return this.firstName (prénom du Client)
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return this.lastName (nom du Client)
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return this.holder (liste des comptes dont il est titulaire)
     */
    public ArrayList<BankAccount> getHolder() {
        return holder;
    }

    /**
     * @return this.proxy (liste des comptes dont il a procuration)
     */
    public ArrayList<BankAccount> getProxy() {
        return proxy;
    }

    /**
     * @return montant total des comptes gérés par le client
     */
    public float getAmount(){
        float total = 0f;
        // Comptes titulaires
        for (BankAccount b: holder) {
            total += b.getBalance();
        }

        // Comptes par procuration
        for (BankAccount b: proxy) {
            total += b.getBalance();
        }

        return total;
    }

    /**
     * @return un nouveau client (copie de this) avec lastName comme nom de famille.
     */
    public Client setLastName(String lastName) {
        Client c = new Client(this);
        c.lastName = lastName;

        return c;
    }

    /**
     * @return si b n'appartient pas déjà à this.Comptes titulaires,
     * un nouveau Client copie de this avec
     * this_post.Comptes titulaires = this.Comptes titulaires U {b} sinon this
     */
    public Client addHolderAccount(BankAccount b){
        if(!this.getHolder().contains(b)) {
            Client nc = new Client(this);
            nc.holder.add(b);
            return nc;
        }
        return this;
    }

    /**
     * @return si b appartient  déjà à this.Comptes titulaires,
     * un nouveau Client copie de this avec
     * this_post.Comptes titulaires = this.Comptes titulaires \ {b} sinon this
     */
    public Client removeHolderAccount(BankAccount b){
        if(this.getHolder().contains(b)) {
            Client nc = new Client(this);
            nc.holder.remove(b);
            return nc;
        }
        return this;
    }

    /**
     * @return si b n'appartient pas déjà à this.Comptes titulaires,
     * un nouveau Client copie de this avec
     * this_post.Comptes procuration = this.Comptes procuration U {b} sinon this
     */
    public Client addProxyAccount(BankAccount b){
        if(!this.getProxy().contains(b)) {
            Client nc = new Client(this);
            nc.proxy.add(b);
            return nc;
        }
        return this;
    }

    /**
     * @return si b appartient  déjà à this.Comptes procuration,
     * un nouveau Client copie de this avec
     * this_post.Comptes procuration = this.Comptes procuration \ {b} sinon this
     */
    public Client removeProxyAccount(BankAccount b){
        if(this.getProxy().contains(b)) {
            Client nc = new Client(this);
            nc.proxy.remove(b);
            return nc;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;

        for (int i = 0; i < holder.size(); i++) {
            if(!holder.get(i).equals(client.getHolder().get(i))) return false;
        }

        for (int i = 0; i < proxy.size(); i++) {
            if(!proxy.get(i).equals(client.getProxy().get(i))) return false;
        }
        
        return Objects.equals(lastName, client.lastName) &&
                Objects.equals(firstName, client.firstName);
    }

    @Override
    public int hashCode() {
       int result = 17;
       result = 31 * result + lastName.hashCode();
       result = 31 * result + firstName.hashCode();
       result = 31 * result + holder.hashCode();
       result = 31 * result + proxy.hashCode();

       return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: " + firstName + " " + lastName + "\n");
        sb.append("Comptes titulaires: \n");
        for (BankAccount b: holder) {
            sb.append(b.toString() + "\n");
        }
        sb.append("Comptes avec procurations: \n");
        for (BankAccount b: proxy) {
            sb.append(b.toString() + "\n");
        }

        return sb.toString();
    }

    public boolean repOK(){
        if (lastName == null || firstName == null) return false;
        if (holder == null || proxy == null) return false;

        for (Object o:holder) {
            // Check only BankAccount
            if(!(o instanceof BankAccount)) return false;
            // Check doublons
            if(holder.lastIndexOf((BankAccount) o) != holder.indexOf((BankAccount) o)) return false;
            // Check that element is only in 1 list
            if(proxy.contains((BankAccount) o)) return false;
        }

        for (Object o:proxy) {
            // Check only BankAccount
            if (!(o instanceof BankAccount)) return false;
            // Check doublons
            if (proxy.lastIndexOf((BankAccount) o) != proxy.indexOf((BankAccount) o)) return false;
        }

        return true;
    }
}
