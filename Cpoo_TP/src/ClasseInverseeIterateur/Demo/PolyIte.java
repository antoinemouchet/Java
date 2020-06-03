package ClasseInverseeIterateur.Demo;

import Exceptions.FailureException;
import Exceptions.NegativeExponentException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @overview Les Poly sont des polynomes à coefficients entiers.
 * Ils sont immutables.
 * De manière générale, un Poly est défini comme c0 + c1 x + c2 x^2 ... + cn x^n
 * où chaque ci est un int (pour 0 <= i <= n)
 */
public class PolyIte implements Iterable<PolyIte> {

    // la représentation
    private int[] trms;
    private int deg;


    // Constructeurs
    /**
     * @effects initialise this au polynome nul
     */
    public PolyIte() {
        trms = new int[1];
        deg = 0;
    }

    /**
     * @throws NegativeExponentException si n < 0
     * @effects sinon, initialise this au polynome c.x^n
     */
    public PolyIte(int c, int n) throws NegativeExponentException {
        if (n<0)
            throw new NegativeExponentException("Poly.Poly(int,int)");
        if (c==0) {
            trms=new int[1];
            deg=0;
            return;
        }
        trms = new int[n+1];
        for (int i=0; i<n; i++) trms[i]=0;
        trms[n]=c;
        deg = n;
    }

    private PolyIte(int n) {
        trms = new int[n+1];
        deg = n;
    }


    // Méthodes
    /**
     * @return renvoie le degré de this, càd son plus grand
     * exposant à coefficient non nul. Si this est le polynome
     * nul, renvoie 0.
     */
    public int degree () { return deg; }

    /**
     * @return renvoie le coefficient du terme de this d’exposant d.
     */
    public int coeff (int d) { if (d < 0 || d > deg) return 0; else return trms[d]; }

    /**
     * @throws NullPointerException si q == null
     * @return le polynome this + q sinon
     */
    public PolyIte add(PolyIte q) throws NullPointerException {
        PolyIte la, sm;
        if (deg > q.deg) {la = this; sm = q;} else {la = q; sm = this;}
        int newdeg = la.deg; // le nouveau degré est le plus grand des 2
        if (deg == q.deg) {  // sauf si les coeff des derniers deg sont 0
            for (int k = deg; k > 0; k--) {
                if (trms[k] + q.trms[k] != 0) { break; } else { newdeg--; }
            }
        }
        PolyIte r = new PolyIte(newdeg); //crée un nouveau Poly
        int i;
        for (i=0; i<= sm.deg && i<= newdeg; i++) {
            r.trms[i]= sm.trms[i] + la.trms[i];
        }
        for (int j=i; j<= newdeg; j++) {
            r.trms[j]= la.trms[j];
        }
        return r;
    }


    /**
     * @throws NullPointerException si q == null
     * @return le polynome this * q sinon
     */
    public PolyIte mul(PolyIte q) throws NullPointerException {
        if ((q.deg==0 && q.trms[0]==0) || (deg==0 && trms[0]==0)) {
            return new PolyIte();
        }
        PolyIte r = new PolyIte(deg+q.deg);
        r.trms[deg+q.deg] = 0; // prepare le calcul des coeff
        for (int i = 0; i <= deg; i++) {
            for (int j = 0; j <= q.deg; j++) {
                r.trms[i+j] = r.trms[i+j] + trms[i]* q.trms[j];
            }
        }
        return r;
    }

    /**
     * @throws NullPointerException si q == null
     * @return le polynome this - q sinon
     */
    public PolyIte sub(PolyIte q) throws NullPointerException { return add (q.minus()); }

    /**
     * @return le polynome -this
     */
    public PolyIte minus() {
        PolyIte r = new PolyIte(deg);
        for (int i=0; i<=deg; i++) { r.trms[i]= - trms[i]; }
        return r;
    }

    public boolean equals(PolyIte q){
        if (q == null || deg != q.deg) return false;
        for (int i=0; i<=deg; i++) {
            if (trms[i]!=q.trms[i]) return false;
        }
        return true; }

    @Override
    public boolean equals(Object o){
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        return equals((PolyIte) o);
    }

    /**
     * @return true si l’IR est satisfait pour this;
     *  	   sinon, renvoie false.
     */
    public boolean repOK() {
        if (trms  == null) return false;
        if (deg != trms.length-1) return false;
        if (trms.length == 0) return false;

        if (deg==0) return true;
        return (trms[deg] != 0);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Poly : ");
        for (int i=0; i < trms.length; i++) {
            if (trms[i] == 0) continue;
            sb.append(trms[i] + "x^" + i + " + ");
        }
        sb.delete(sb.length()-3, sb.length());
        return sb.toString();
    }

    // surcharge d'iterator issu de l'interface Iterable => for-each accessible pour Poly
    // L'itération sera celle sélectionnée dans la méthode surchargée
    /**
     * @return un générateur produisant chaque monome de this
     *         en ordre croissant de degré, une et une seule fois
     */
    @Override
    public Iterator<PolyIte> iterator(){
        return new GenMonomes(false);
    }

    /**
     * @return un générateur produisant chaque monome de this
     *         en ordre décroissant de degré, une et une seule fois
     */
    public Iterator<PolyIte> monomes(){
        return new GenMonomes(true);
    }

    // Inner class, on implémente l'interface Iterator
    // Générateur
    private class GenMonomes implements Iterator<PolyIte> {
        private int currentDeg;
        private PolyIte monomeEnCache;
        private boolean reversed;

        GenMonomes(boolean reversed){
            if (reversed) {
                currentDeg = deg;
            }
            else {
                currentDeg=0;
            }
            monomeEnCache = null;
            this.reversed = reversed;
        }

        @Override
        public boolean hasNext() {
            if(reversed && currentDeg==-1)return false;
            if(monomeEnCache== null) {
                monomeEnCache = next();

            }
            if(monomeEnCache != null) return true;
            else return false;
        }

        @Override
        public PolyIte next() {
            if(monomeEnCache != null) {
                PolyIte tmp = monomeEnCache;
                monomeEnCache = null;
                return tmp;
            }

            if(!reversed) {
                if(currentDeg > deg) {
                     throw new NoSuchElementException("Poly.GenMonomes.next()");
                }
                else {
                    if (currentDeg < 0) {
                        throw new NoSuchElementException("Poly.genMonomes.next()");
                    }
                }
            }
            if(deg == 0) {
                updateCurrentDeg();
                System.out.println("CurrentDeg "+currentDeg);
                try {
                    return new PolyIte(trms[0],0);
                }
                catch (NegativeExponentException e) {
                    // on construit nous même le Poly,
                    // on est donc certain que le degré n'est pas négatif
                    throw new FailureException("Poly.monomes()");
                }
            }

            if (trms[currentDeg] != 0) {
                PolyIte returnedMonome;
                try {
                    returnedMonome = new PolyIte(trms[currentDeg],currentDeg);
                }
                catch(NegativeExponentException e) {
                    // on construit nous même le Poly,
                    // on est donc certain que le degré n'est pas négatif
                    throw new FailureException("Poly.monomes()");
                }
                updateCurrentDeg();
                return returnedMonome;
            }
            else
            {
                updateCurrentDeg();
                return next();
            }
        }

        private void updateCurrentDeg() {
            if (reversed) currentDeg --;
            else currentDeg++;
        }
    }
}

