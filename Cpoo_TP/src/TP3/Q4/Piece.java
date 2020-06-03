package TP3.Q4;

import java.util.Arrays;

/**
 * @overview Une pièce est immutable. Elle est composée de 4 blocs adjacents.
 * Chaque bloc a un système de coordonnées {x,y}. Ainsi, une pièce typique est:
 * {{x1,y1},{x2,y2},{x3,y3},{x4,y4}} ou {bloc, bloc, bloc, bloc}.
 * @specfield blocs: liste des 4 blocs composant une pièce.
 * @invariant une pièce est toujours composée de 4 blocs.
 * @invariant Chaque bloc de la pièce est adjacent à un autre bloc de la pièce.
*/
public class Piece {

    /**
     * FA(c): { FA'(c.blocs[i]) | 0 <= i < c.blocs.length} (ensemble des blocs d'une pièce)
     *
     * où FA'(b) = (b.x, b.y) (Coordonnées de la pièce dans le plan relatif à c.
     */

    /**
     * IR(c): c.blocs is not null && c.blocs.length > 0 && les blocs de c sont adjacents
     * && c.blocs.length == 4 && for all b in c.blocs: b != null &&
     * not exists 0 <= i,j < 4, i != j => c.blocs[i] == c.blocs[j]
     */

    private Bloc[] blocs = new Bloc[4];

    /**
     * @effects Initializes a piece with 4 given bloc
     */
    public Piece(Bloc a, Bloc b, Bloc c, Bloc d){
        blocs[0] = a;
        blocs[1] = b;
        blocs[2] = c;
        blocs[3] = d;
    }

    /**
     * @return la largeur de la pièce (càd, le plus grand x parmi ses blocs)
     */
    public int getLargeur(){
        int largeur = -1;
        for (int i = 0; i < 4; i++) {
            if(blocs[i].getX() > largeur){
                largeur = blocs[i].getX();
            }
        }
        return largeur;
    }

    /**
     * @return la hauteur de la pièce (càd, le plus grand y parmi ses blocs)
     */
    public int getHauteur(){
        int hauteur = -1;
        for (int i = 0; i < 4; i++) {
            if(blocs[i].getY() > hauteur){
                hauteur = blocs[i].getY();
            }
        }
        return hauteur;
    }

    /**
     * @return la jupe de la pièce (càd le plus petit y pour chaque colonne de la pièce)
     * On a donc un tableau d'entiers de la largeur de la pièce.
     */
    public int[] getJupe(){
        int[] jupe = new int[this.getLargeur()];

        for (int i = 0; i < jupe.length; i++) {
            jupe[i] = 3;
        }

        for (Bloc b: blocs) {
            // Si le y du bloc est inférieur au y de la colonne correspondante
            // Update y de la colonne dans la jupe
            if(b.getY() < jupe[b.getX() % jupe.length]){
                jupe[b.getX()] = b.getY();
            }
        }
        return jupe;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "blocs=" + Arrays.toString(blocs) +
                '}';
    }

    public boolean repOK(){
        if (blocs == null)return false;
        if (blocs.length != 4) return false;
        for (int i = 0; i < 4; i++){
            if (blocs[i] == null) return false;
            if (!blocs[i].repOK()) return false;
            for (int j = i + 1; j < 4; j++)
                if(blocs[i].equals(blocs[j])) return false;
        }
        // Test adjacence
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Arrays.equals(blocs, piece.blocs);
    }
}
