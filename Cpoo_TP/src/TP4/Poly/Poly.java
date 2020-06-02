package TP4.Poly;

import Exceptions.NegativeExponentException;

/**
 * @overview Les poly sont des polynomes à coefficients entiers
 * Ils sont immutables.
 * De manière générale, un Poly est défini comme c0 + c1 * x + c2 * x^2 ... + cn * x^n
 * Où chaque ci est un int (pour 0 <= i <= n)
 */
public class Poly {
    private int[] trms;
    private int deg;


    /**
     * FA(c): c0 + c1 * x + c2 * x^2 + ...
     * où ci = c.trms[i] si 0 <= i < c.trms.length
     *       = 0         sinon
     */

    /**
     * IR(c): c.trms != null && c.trms.length >= 1 &&
     * c.deg = c.trms.length - 1 &&  c.deg > 0 => c.trms[deg] != 0
     */

    /**
     * @effects initialise this au polynôme nul
     */
    public Poly() {
        trms = new int[1];
        deg = 0;
    }

    /**
     * @requires n positive integer
     * @effects initialises this au polynôme c * x^n
     * @throws NegativeExponentException si n < 0
     */
    public Poly(int c, int n) throws NegativeExponentException {
        if(n < 0){
            throw new NegativeExponentException("Poly(int, int) Constructor");
        }
        if(c == 0){
            trms = new int[1];
            deg = 0;
            return;
        }
        trms = new int[n + 1];
        for (int i = 0; i < n; i++) {
            trms[i] = 0;
        }
        trms[n] =c;
        deg = n;
    }

    private Poly(int n){
        trms = new int[n + 1];
        deg = n;
    }

    /**
     * @return this.deg (plus grand exposant)
     */
    public int degree(){
        return deg;
    }

    /**
     * @return coefficient of term with degree d
     */
    public int coeff(int d){
        if(d < 0 || d > deg){
            return 0;
        }
        else {
            return trms[d];
        }
    }

    /**
     * @return a new poly ( This - q)
     * @throws NullPointerException si q == null
     */
    public Poly sub(Poly q) throws NullPointerException{
        return add(q.minus());
    }

    /**
     * @return Poly - this
     */
    public Poly minus(){
        Poly r = new Poly(deg);
        for (int i = 0; i < deg; i++) {
            r.trms[i] = - trms[i];
        }
        return r;
    }

    /**
     * @return a new poly this + q
     * @throws NullPointerException si q == null
     */
    public Poly add(Poly q) throws NullPointerException{
        Poly la, sm;
        if(deg > q.deg){
            la = this;
            sm = q;
        }
        else{
            la = q;
            sm = this;
        }

        int newDeg = la.deg;
        if(deg == q.deg){
            for (int i = deg; i > 0; i--) {
                if(trms[i] + trms[i] != 0){
                    break;
                }
                else {
                    newDeg--;
                }
            }
        }

        Poly r = new Poly(newDeg);
        int j = 0;
        for (j = 0; j < sm.deg; j++) {
            r.trms[j] = sm.trms[j] + la.trms[j];
        }
        for (int k = j; k <= newDeg ; k++) {
            r.trms[k] = la.trms[k];
        }
        return r;
    }

    /**
     * @return a new poly (this * q)
     * @throws NullPointerException si q == nul
     */
    public Poly mul(Poly q) throws NullPointerException{
        if((q.deg == 0 && q.trms[0] == 0) || (deg == 0 && trms[0] == 0)){
            return new Poly();
        }
        Poly r = new Poly(deg + q.deg);
        r.trms[deg + q.deg] = 0;
        for (int i = 0; i <= deg; i++) {
            for (int j = 0; j <= q.deg ; j++) {
                r.trms[i + j] = r.trms[i + j] + trms[i] * q.trms[j];
            }
        }
        return r;
    }

    /** Poly est immutable, l'implémentation d'equals (égalité référentielle)
     *  ne suffit pas, on ré-implémente donc
     */
    // spécification de equals est standard, donc pas de spe
    private boolean equals(Poly q){
        if (q == null || deg != q.deg) return false;
        for (int i=0; i<=deg; i++) {
            if (trms[i]!=q.trms[i]) return false;
        }
        return true; }

    // spécification de equals est standard, donc pas de spe
    @Override
    public boolean equals(Object o){
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        return equals((Poly) o);
    }

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

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + trms.hashCode();
        result = 31 * result + deg;
        return result;
    }

}

