package Examens.Juin2017;

/**
 * @overview Un EStock représente une action (au sens instance)
 * d'un cours coté en bourse.
 * Un EStock est immutable.
 * De manière générale, un EStock est défini comme <code, id>
 * @specfield code: String //le code du cours en bourse
 * @specfield id: String // l'identifiant de l'action (au sens instance)
 */
public class EStock {

    private final String codeCours;
    private final String idAction;

    /**
     * @throws NullPointerException, si codeCours == null ou idAction == null
     * @effects crée un EStock tel que this.code = codeCours et this.id = idAction
     */
    public EStock(String codeCours, String idAction) throws NullPointerException{
        this.codeCours = codeCours;
        this.idAction = idAction;
    }


    /**
     * @return this.code
     */
    public String donneCode() {
        return codeCours;
    }


    /**
     * @return this.id
     */
    public String donneID() {
        return idAction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EStock)) return false;
        EStock eStock = (EStock) o;
        return codeCours.equals(eStock.donneCode()) &&
                idAction.equals(eStock.donneID());
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + codeCours.hashCode();
        result = 31 * result + idAction.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "EStock{" +
                "codeCours='" + codeCours + '\'' +
                ", idAction='" + idAction + '\'' +
                '}';
    }
}

