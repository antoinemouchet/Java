package ClasseInverseeTest.Classe;

public class NumeroDeCompte {
    private String nom;

    public NumeroDeCompte(String s){
        this.nom = s;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
