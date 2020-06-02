package TP3.Q4;

import java.util.Objects;

/**
 * @overview Un bloc représente 1 des 4 blocs constituant une pièce de Tetris.
 * Il est de type immutable.
 * Il a des coordonnées (x et y) sous la forme {x, y}.
 * @specfield x: position du bloc en largeur.
 * @specfield y: position du bloc en hauteur.
 * @invariant 0 <= x,y <= 3
 */
public class Bloc {

    /**
     * FA(c): <c.x, c.y>
     */

    /**
     * IR(c): 0 <= x <= 3 &&
     *        0 <= y <= 3
     */

    private int x, y;

    /**
     * @effects Initializes this with this.x = x and this.y = y
     */
    public Bloc(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return x value of this (width)
     */
    public int getX(){
        return x;
    }

    /**
     * @return y value of this (height)
     */
    public int getY(){
        return y;
    }

    public boolean repOK(){
        if (x < 0 || x > 3) return false;
        if (y < 0 || y > 3) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bloc{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bloc bloc = (Bloc) o;
        return x == bloc.x &&
                y == bloc.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;

        return result;
    }
}
