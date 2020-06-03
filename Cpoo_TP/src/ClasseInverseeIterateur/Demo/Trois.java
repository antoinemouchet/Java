package ClasseInverseeIterateur.Demo;

import java.util.Iterator;

public class Trois  {


    /**
     * @return un générateur d'entier, appartenant à la table de 3,
     * chaque entier exactement une fois et par ordre croissant
     */
    public Iterator<Integer> getTableTrois(){
        return new TableTrois();
    }

    private  class TableTrois implements Iterator<Integer> {
        private int p=0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            Integer integer = new Integer(p);
            p = p+3;
            return integer;
        }
    }
}

