import java.util.Objects;

/**
* @overview Un bloc représente un des 4 blocs constituant une pièce de Tetr'is
* Composé d'une coordonnée en x et y : {X, Y}
* Type immutable
* @invariant 0<= X, Y <= 3
*/
public class Bloc {

    private int x,y;

    /**
     * FA(C) : {c.x, c.y}
     */

    /**
     * IR : 0<= x <= 3 &&
     *      0 <= y <= 3
     */

    /* Constructeur */
    /**
    * @effects Initialise this avec X et Y valant respectivement x et y.
    */
    public Bloc(int x, int y){
        this.x = x;
        this.y = y;
    }

    /* Méthode */
    /**
    * @return position en largeur
    */
    public int getX() {
        return x;
    }

    /**
    * @return position en hauteur du bloc
    */
    public int getY() {
        return y;
    }

    /* Méthodes à implémenter à nouveau parce que type immutable */
    @Override
    public String toString() {
        return "Bloc{" + this.x + "," + this.y + '}';
    }

    public boolean equals(Bloc q){
        if(q == null || x != q.x || y != q.y){
            return false;
        }
        return true;
    }

    public boolean repOK(){
        if (x < 0 || x > 3){
            return false;
        }
        if (y < 0 || y > 3) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        return equals((Bloc) o);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;

        return result;
    }
}
