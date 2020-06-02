import java.util.Arrays;

/**
* @overview Les pieces sont des ensembles de 4 blocs adjacents de coordonées (x,y)
 * {(x1,y1), (x2,y2), (x3,y3), (x4,y4)}
 * {bloc, bloc, bloc, bloc}
 * Une piece est immutable
* @invariant Une pièce est toujours composée de 4 blocs
 * @invariant  Un bloc d'une pièce est toujours adjacent à au moins 1 côté d'un autre bloc de la pièce
*/

public class Piece {
    // Initialize arrray of 4 blocs
    private Bloc[] blocs = new Bloc[4];

    /**
     * FA(c) : {FA'(c.blocs[i]) | 0 < i < c.blocs.size}
     * => L'ensemble des blocs composant c
     *
     * où FA'(b) = (b.x, b.y)
     * => coordonnées du bloc dans le référentiel c
     */

    /**
     * IR:  c.blocs != null &&
     *      c.blocs.size = 4 &&
     *      for all b in c.blocs, b != null &&
     *      not exists 0 <=i, j < 4 tq i!=j && c.blocs[i] == c.blocs[j] &&
     *      l'ensemble des blocs est adjacent
     *      */

    /**
    * @effects Initialise this avec les 4 blocs a, b, c et d.
    */
    public Piece(Bloc a, Bloc b, Bloc c, Bloc d){
        blocs[0] = a;
        blocs[1] = b;
        blocs[2] = c;
        blocs[3] = d;
    }

    /**
     * @return la largeur de la pièce, càd x tq
     * pour tous les autres xi de la pièce x > xi.
     */
    public int getLargeur() {
        int tmpLargeur = 0;
        // Loop on all blocs to find the one at the rightest place
        for (Bloc e : blocs) {
            if (tmpLargeur < e.getX()) {
                tmpLargeur = e.getX();
            }
        }
        return tmpLargeur;
    }

    /**
    * @return la hauteur de la pièce, càd y tq
     * pour tous les autres yi de la pièce y > yi.
    */
    public int getHauteur(){
        int tmpHauteur = 0;
        // Loop on all blocs to find the highest one
        for (Bloc e: blocs){
            if(tmpHauteur < e.getY()){
                tmpHauteur = e.getY();
            }
        }
        return  tmpHauteur;
    }

    /**
     * @return un int[] tab de taille égale à la largeur de la Piece
     * tel que pour tout b appartenant à this.blocs,
     * et pour tout b' appartenant à this.blocs tel que b'.x = b.x, alors tab[x] = min(b.y, b'.y)
     */
    public int[] getJupe() {
        int[] a = {this.getLargeur()};

        for(int i=0; i<a.length; i++){
            a[i]=3;
        }

        // Boucle pour trouver la position la plus basse occupée sur chaque colonne par la pièce
        for(Bloc b : blocs)
        {
            if(b.getY() < a[b.getX()]) {
                a[b.getX()] = b.getY();
            }
        }
        return a;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Piece ~ bloc1:" + blocs[0].toString()+
                "bloc 2:" + blocs[1].toString() +
                "bloc 3:" + blocs[2].toString()+
                "bloc 4:" + blocs[3].toString());

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        return equals((Piece) o);
    }

    public boolean equals(Piece p){
        for (int i = 0; i < blocs.length; i++) {
            // Vérifie que les coordonnées de chaque bloc sont identiques entre les pièces.
            if (!(blocs[i].getX() == p.blocs[i].getX() && blocs[i].getY() == p.blocs[i].getY())){
                return false;
            }
        }
        return  true;
    }

    private boolean duplication(){
        for(int i=0;i<blocs.length;i++)
        {
            for(int j=i+1;j<blocs.length;j++){
                if(blocs[i].equals(blocs[j])){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean adjacence(){

        if (this.equals(new Piece(new Bloc(0,0),new Bloc(0,1),new Bloc(1,0),new Bloc(1,1)))){
            return true;
            // carre
        }
        if (this.equals(new Piece(new Bloc(0,0),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3)))) {
            return true;
            // Barre verticale
        }
        if (this.equals(new Piece(new Bloc(0,0),new Bloc(0,1),new Bloc(0,2),new Bloc(0,3)))) {
            return true;
            // Barre horizontale
        }

        // TO DO autres pièces.
        return false;
    }

    /**
     * IR:  c.blocs != null &&
     *      c.blocs.size = 4 &&
     *      for all b in c.blocs, b != null &&
     *      not exists 0 <=i, j < 4 tq i!=j && c.blocs[i] == c.blocs[j] &&
     *      l'ensemble des blocs est adjacent
     */
    public boolean repOK(){
        if(blocs == null){
            return  false;
        }
        if(blocs.length != 4){
            return  false;
        }
        for(Bloc b : blocs) {
            if (b == null) {
                return false;
            }
            if (!b.repOK()) {
                return false;
            }
        }
        if(!adjacence() || duplication()){
            return false;
        }
        return true;
    }
}
