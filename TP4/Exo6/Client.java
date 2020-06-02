import exceptions.InvalidNameException;
        import java.util.ArrayList;

/**
 * @overview Un Client possède différentes informations le concernant sous la forme d'un
 * uplet <nom, prenom, comptes titulaires, comptes procuration>
 * Client est immutable.
 * @specfield nom // nom du client
 * @specfield prenom // prenom du client
 * @specfield comptes titulaires // liste des comptes dont Client est titulaire
 * @specfield comptes procuration // liste des comptes dont Client a procuration
 * @derivedField montant total : réel // la somme des valeurs des comptes titulaires
 */
public class Client{
    private String nom, prenom;
    private ArrayList<BankAccount> titulaire, procuration;

    /**
     * FA(c) < c.nom, c.prenom, c.titulaire[i].get(), c.procuration[j].get()>
     *     avec 0 <= i < titulaire.size et  0 <= j < procuration.size
     */

    /**
     * IR : nom is not null &&
     *      prenom is not null &&
     *      nom.length > 2 &&
     *      prenom.length > 2 &&
     *      titulaire is not null &&
     *      titulaire ne contient que des BankAccount &&
     *      titulaire ne contient pas de doublons &&
     *      procuration is not null &&
     *      procuration ne contient que des BankAccount &&
     *      procuration en contient pas de doublons &&
     *      un BankAccount ne peut être à la fois dans titulaire et procuration
     */

    /* Constructeurs */

    /**
     * @throws InvalidNameException si nom.size ou prenom.size < 3; sinon,
     * @effects initialise un nouveau Client avec this.nom = n, this.prenom = p
     * et titulaire et procuration sont des listes de comptes titulaire et comptes procurations vides
     */
    public Client(String p, String n) throws InvalidNameException {
        if(n.length() <3 || p.length() <3 ){
            throw new InvalidNameException();
        }
        nom = n;
        prenom = p;
        titulaire = new ArrayList<>();
        procuration = new ArrayList<>();
    }

    /**
     * @effects crée une copie de c
     */
    public Client(Client c){
        nom = c.nom; //si setters, vous pouvez l'utilisez
        prenom = c.prenom;
        titulaire = new ArrayList<>();
        procuration = new ArrayList<>();
        titulaire.addAll(c.titulaire);
        procuration.addAll(c.procuration);
    }

    /* Méthodes */

    /**
     * @requires n not null et n.size > 2
     * @return un nouveau Client copie de this avec this.nom = n
     */
    public Client setNom(String n){
        Client nc = new Client(this);
        nc.nom = n;
        return nc;
    }

    /**
     * @return le montant total de this
     */
    public float getAmount(){
        float amount=0;
        for(BankAccount ba : titulaire){
            amount = amount + ba.getSolde();
        }
        return amount;
    }

    /** Pour que le type soit adéquat, on permet l'ajout et le retrait de comptes à un client **/

    /**
     * @return  si ba n'appartient pas déjà à this.comptes titulaire,
     *          un nouveau Client copie de this avec this_post.comptes titulaires = this.comptes titulaires + ba;
     *          sinon this
     */
    public Client addTitulaire(BankAccount ba){
        if(!this.titulaire.contains(ba)){
            Client nc =new Client(this);
            nc.titulaire.add(ba);
            return nc;
        }
        return this;
    }

    /**
     * @return  un nouveau Client this avec this_post.comptes titulaires = this.comptes titulaires - ba
     *          si ba appartient à this;
     *          sinon this
     */
    public Client removeTitulaire(BankAccount ba){
        if(this.titulaire.contains(ba)) {
            Client nc = new Client(this);
            nc.titulaire.remove(ba);
            return nc;
        }
        return this;
    }

    /**
     * @return  si ba n'appartient pas déjà à this.comptes procuration,
     *          un nouveau Client copie de this avec this_post.comptes titulaires = this.comptes titulaires + ba;
     *          sinon this
     */
    public Client addProcuration(BankAccount ba){
        if(!this.procuration.contains(ba)){
            Client nc= new Client(this);
            nc.procuration.add(ba);
            return nc;
        }
        return this;
    }

    /**
     * @return  un nouveau CLient avec this_post.comptes procuration = this.comptes procuration - ba
     *          si ba appartient à this;
     *          sinon this
     */
    public Client removeProcuration(BankAccount ba){
        if(this.procuration.contains(ba)) {
            Client nc= new Client(this);
            nc.procuration.remove(ba);
            return nc;}
        return this;
    }

    /**
     * Client est immutable, il faut ré-implémenter equals et hashCode
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        return equals((Client) o);
    }

    public boolean equals(Client c) {
        if(this.nom!=c.nom)return false;
        if(this.prenom!=c.prenom)return false;
        for(int i=0;i<titulaire.size();i++)
        {
            if(!titulaire.get(i).equals(c.titulaire.get(i)))return false;
        }
        for(int i=0;i<procuration.size();i++)
        {
            if(!procuration.get(i).equals(c.procuration.get(i)))return false;
        }
        return true;
    }

    public int hashCode(){
        int result = 17; // rappel, les grains de sel...
        result = 31 * result + prenom.hashCode(); // ... et basé sur chaque variable de la rep
        result = 31 * result + nom.hashCode();
        result = 31 * result + titulaire.hashCode();
        result = 31 * result + procuration.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("client : "+prenom+ " "+ nom+"\n");
        sb.append("Comptes titulaires :\n");
        for(BankAccount ba : titulaire){
            sb.append(ba.toString()+"\n");
        }
        sb.append("Comptes avec procuration :\n");
        for(BankAccount ba : procuration){
            sb.append(ba.toString()+"\n");
        }
        return sb.toString();
        // On se restreint à la FA
    }
    /**
     * IR : nom is not null &&
     *      prenom is not null &&
     *      nom.length > 2 &&
     *      prenom.length > 2 &&
     *      titulaire is not null &&
     *      titulaire ne contient que des BankAccount &&
     *      titulaire ne contient pas de doublons &&
     *      procuration is not null &&
     *      procuration ne contient que des BankAccount &&
     *      procuration en contient pas de doublons &&
     *      un BankAccount ne peut être à la fois dans titulaire et procuration
     */
    public boolean repOk(){
        if(nom == null || prenom == null){
            return false;
        }
        if(nom.length()<=2 || prenom.length()<=2){
            return false;
        }
        if (titulaire == null || procuration == null) return false;

        // On récupère tous les types
        for(Object ba : titulaire){
            // Vérification qu'il n'y a que des BankAccount
            if(!(ba instanceof BankAccount)){
                return false;
            }
            //vérification doublons
            if(titulaire.lastIndexOf((BankAccount)ba) != titulaire.indexOf((BankAccount) ba)) {
                return false;
            }
        }
        // Vérification pour les procurations
        for(Object ba : procuration){
            if(!(ba instanceof BankAccount)){
                return false;
            }
            if(procuration.lastIndexOf((BankAccount)ba) != procuration.indexOf((BankAccount) ba)){
                return false;
            }
            // un élément ne peut se trouver dans les 2 listes
            if(titulaire.indexOf((BankAccount)ba)!=-1){
                return false;
            }
        }
        return true;
    }
}
