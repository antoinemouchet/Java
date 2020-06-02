package TP3.Q5;

/**
 * Un article est un objet de type immutable. Il est composé d'un nom et d'un numéro de série.
 * <x, y> tel que
 * @specfield x: String // Nom de l'article
 * @specfield y: int // Numéro de série de l'article
 * @invariant y > 0
 */
public class Article {
    private final String name;
    private final int serialNumber;

    /**
     * @effects Initializes a new article with
     * this.name = name and this.serialNumber = serialNumber
     */
    public Article(String name, int serialNumber){
        this.name = name;
        this.serialNumber = serialNumber;
    }

    /**
     * @return name of this.
     */
    public String getName(){
        return name;
    }

    /**
     * @return serialNumber of this.
     */
    public int getSerialNumber() {
        return serialNumber;
    }
}
