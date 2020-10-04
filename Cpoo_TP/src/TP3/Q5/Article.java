package TP3.Q5;

import java.sql.PreparedStatement;
import java.util.Objects;

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
     * FA(c): <c.name, c.serialNumber>
     */

    /**
     * IR(c): name != null && serialNumber > 0
     */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return serialNumber == article.serialNumber &&
                Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + serialNumber;

        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
