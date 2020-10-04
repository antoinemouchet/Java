package Examens.Aout2019;

import java.util.Objects;

/**
 * @overview Un article est défini par un libellé et un prix.
 * Il est de type immutable.
 * @specfield libellé: String
 * @specfield prix: float, un rationnel positif non null
 */
public class Article{
    private String name;
    private float price;

    public Article(String name, float price){
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Float.compare(article.price, price) == 0 &&
                Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + name.hashCode();
        result = 31 * result + Float.floatToIntBits(price);

        return result;
    }
}
